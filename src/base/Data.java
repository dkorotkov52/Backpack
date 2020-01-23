package base;

import sorting.ISort;

public class Data {
    private int n;
    private int[] perf;
    private int[] cost;
    private int maxPerf;

    public Data(int n, int[] perf, int[] cost, int maxPerf)
    {
        this.n = n;
        this.perf = perf;
        this.cost = cost;
        this.maxPerf = maxPerf;
    }

    public int getN() {
        return n;
    }

    public int[] getPerf() {
        return perf;
    }

    public int[] getCost() {
        return cost;
    }

    public int getMaxPerf() {
        return maxPerf;
    }

    public void Sort(ISort sort)
    {
        sort.Sort(perf, cost);
    }
}
