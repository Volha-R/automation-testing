package by.epam.training.threads;

import java.util.*;
import java.util.concurrent.*;

public class Auctioneer {
    private final Deque<Lot> lots;
    private final List<Player> players;
    private final CyclicBarrier barrier;
    private final Map<Integer, Integer> banList;
    private final Map<String, LotEntry> lotEntries;
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    public Auctioneer(List<Player> players, List<Lot> lots) {
        this.players = players;
        this.banList = new HashMap<>();
        this.lots = new ArrayDeque<>(lots);
        this.lotEntries = new ConcurrentHashMap<>();
        this.barrier = new CyclicBarrier(players.size());
    }

    public void startAuction() {
        System.out.println("Auction started");
        startLot();
    }

    /**
     * Provide all necessary actions at the beginning of each lot:
     * get next lot, notify all players lot started, start lot finishing timer.
     */
    private void startLot() {
        decreaseBanTerms();
        Lot nextLot = lots.poll();
        if (nextLot != null) {
            LotEntry currentLot = new LotEntry();
            lotEntries.put(nextLot.getName(), currentLot);
            System.out.println("-----------------------------");
            System.out.println(nextLot.getName() + " started");
            executor.schedule(new FinishLot(nextLot.getName()), 3, TimeUnit.SECONDS);
            barrier.reset();
            System.out.println(nextLot.getName() + " waiting for bids");
            for (Player player : players) {
                executor.execute(new NewLot(nextLot, player));
            }
        } else {
            executor.shutdown();
        }
    }

    /**
     * Check if player is not banned, if lot is not paid and whether new bid is higher than current one.
     * Notify players about new highest bid.
     */
    public synchronized void processBid(String lotName, double bid, int playerId) {
        if (banList.containsKey(playerId) && banList.get(playerId) > 0) {
            System.out.println("Player is not allowed to place bids");
            return;
        }

        LotEntry currentLot = lotEntries.get(lotName);
        if (!currentLot.isPaid()) {
            if (bid > currentLot.getCurrentBid()) {
                currentLot.setCurrentBid(bid);
                currentLot.setHighestBidderId(playerId);
                for (Player player : players) {
                    executor.execute(new NewBid(player, lotName, bid));
                }
            } else {
                System.out.printf("Bid %.2f by player %d is lower than current bid %.2f\n", bid, playerId, currentLot.getCurrentBid());
            }
        }
    }

    /**
     * Check if lot is already paid, null or wrong player trying to pay.
     * Pay for lot.
     */
    public void payPrice(String lotName, int playerId) {
        LotEntry entry = lotEntries.get(lotName);
        if (entry.isPaid()) {
            System.out.println("Already paid");
            return;
        }

        if (entry.getHighestBidderId() == null || entry.getHighestBidderId() != playerId) {
            System.out.println("Wrong player trying to pay for " + lotName);
            return;
        }

        entry.setPaid(true);
        System.out.println(lotName + " is payed" + " by player" + playerId);
    }

    /**
     * Reduce ban counter
     */
    private void decreaseBanTerms() {
        for (Map.Entry<Integer, Integer> entry : banList.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
            }
        }
    }

    /**
     * Identify, notify winner and starts lot paying timer.
     * Initialize next lot start.
     */
    private void finishLot(String lotName) {
        boolean isWinnerFound = false;
        for (Player player : players) {
            if (player.getPlayerId().equals(lotEntries.get(lotName).getHighestBidderId())) {
                player.onWin(lotName, lotEntries.get(lotName).getCurrentBid());
                isWinnerFound = true;
                System.out.println("Winner of " + lotName + " is player " + player.getPlayerId());
                executor.schedule(new PaymentTimeExpired(lotName, player), 4, TimeUnit.SECONDS);
                break;
            }
        }
        if (!isWinnerFound) {
            lotEntries.remove(lotName);
            System.out.println("No winner on " + lotName);
        }
        startLot();
    }

    /**
     * Check whether lot was paid. Ban player if not paid.
     */
    private void checkPayment(String lotName, Player player) {
        if (lotEntries.get(lotName).isPaid()) {
            System.out.println("Lot " + lotName + " is payed");
        } else {
            Integer currentBan = banList.get(player.getPlayerId());
            banList.put(player.getPlayerId(), currentBan == null ? 2 : currentBan + 2);
            System.out.println(lotName + " payment failed. Player " + player.getPlayerId() + " is banned for next two lots");
        }
        lotEntries.remove(lotName);
    }

    private class FinishLot implements Runnable {
        private String lotName;

        public FinishLot(String lotName) {
            this.lotName = lotName;
        }

        @Override
        public void run() {
            System.out.println("Lot " + lotName + " is finished");
            finishLot(lotName);
        }
    }

    private class NewLot implements Runnable {
        private Lot lot;
        private Player player;

        public NewLot(Lot lot, Player player) {
            this.lot = lot;
            this.player = player;
        }

        /**
         * Provides a possibility to inform players about new lot at the same time.
         */
        @Override
        public void run() {
            try {
                barrier.await();
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
            player.onNewLot(lot.getName(), lot.getInitialPrice());
        }
    }

    private class NewBid implements Runnable {
        private String lotName;
        private Player player;
        private double currentBid;

        public NewBid(Player player, String lotName, double currentBid) {
            this.lotName = lotName;
            this.player = player;
            this.currentBid = currentBid;
        }

        @Override
        public void run() {
            player.onNewBidRound(lotName, currentBid);
        }
    }

    private class PaymentTimeExpired implements Runnable {
        private String lotName;
        private Player player;

        public PaymentTimeExpired(String lotName, Player player) {
            this.lotName = lotName;
            this.player = player;
        }

        @Override
        public void run() {
            checkPayment(lotName, player);
        }
    }

}
