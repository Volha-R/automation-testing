package by.epam.training.threads;

public class LotEntry {
    private boolean isPaid;
    private double currentBid;
    private Integer highestBidderId;

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public Integer getHighestBidderId() {
        return highestBidderId;
    }

    public void setHighestBidderId(Integer highestBidderId) {
        this.highestBidderId = highestBidderId;
    }
}
