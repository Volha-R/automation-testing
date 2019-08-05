package by.epam.training.threads;

import java.util.ArrayList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1));
        players.add(new Player(2));
        players.add(new Player(3));
        players.add(new Player(4));
        players.add(new Player(5));

        List<Lot> lots = new ArrayList<>();
        Lot lotOne = new Lot("Lot1", 100);
        Lot lotTwo = new Lot("Lot2", 200);
        Lot lotThree = new Lot("Lot3", 50);
        Lot lotFour = new Lot("Lot4", 1000);
        Lot lotFive = new Lot("Lot5", 300);

        lots.add(lotOne);
        lots.add(lotTwo);
        lots.add(lotThree);
        lots.add(lotFour);
        lots.add(lotFive);

        Auctioneer auction = new Auctioneer(players, lots);

        for (Player player : players) {
            player.setAuction(auction);
        }

        auction.startAuction();
    }
}
