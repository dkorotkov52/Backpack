package base;

public class Solution {
    private boolean[] x;
    private int cost;

    public Solution(int cost, boolean[] x)
    {
        this.x = x;
        this.cost = cost;
    }

    public boolean[] getX() {
        return x;
    }

    public int getCost() {
        return cost;
    }

    public void print()
    {
        System.out.println(cost);
    }
}
