package by.epam.training.threads;

import java.util.Random;

public class Player {
    private Auctioneer auction;
    private final Integer playerId;

    public Player(Integer playerId) {
        this.playerId = playerId;
    }

    public void setAuction(Auctioneer auction) {
        this.auction = auction;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    /**
     * Calculate chance of taking part in lot.
     * Calculate and place the very first bid on lot.
     */
    public void onNewLot(String lotName, double initialPrice) {
        Random random = new Random();
        if (random.nextInt(100) > 50) {
            double price = initialPrice * (random.nextInt(10) + 1.1);
            auction.processBid(lotName, price, playerId);
            System.out.printf("Player %d placed bid %.2f\n", playerId, price);
        }
    }

    /**
     * Calculate chance of making another bid on lot.
     * Calculate and place further bids.
     */
    public void onNewBidRound(String lotName, double currentMaxBid) {
        Random random = new Random();
        if (random.nextInt(100) > 90) {
            double price = currentMaxBid * (random.nextInt(10) + 1.1);
            auction.processBid(lotName, price, playerId);
            System.out.printf("Player %d placed bid %.2f\n", playerId, price);
        }
    }

    /**
     * Calculate chance of paying on lot. Initialize payment.
     */
    public void onWin(String lotName, double price) {
        Random random = new Random();
        if (random.nextInt(100) > 50) {
            auction.payPrice(lotName, playerId);
        }
    }

}
