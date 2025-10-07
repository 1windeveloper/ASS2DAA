package metrics;

public class Tracker {
    private long comp;
    private long swap;
    private long acc;

    public void reset() { comp = 0; swap = 0; acc = 0; }

    public void addComp() { comp++; }
    public void addSwap() { swap++; }
    public void addAccess(int n) { acc += n; }

    public long getComp() { return comp; }
    public long getSwap() { return swap; }
    public long getAcc() { return acc; }

    public String toCSV() {
        return comp + "," + swap + "," + acc;
    }
}