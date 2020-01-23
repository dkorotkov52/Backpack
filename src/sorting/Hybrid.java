package sorting;

public class Hybrid implements ISort {
    public void Sort(int[] perf, int[] cost)
    {
        new BaseSort().Sort(perf, cost);
        int n = perf.length;
        int start = n / 4, finish = (n * 6) / 10;

        for (int i = start; i < finish; i++)
        {
            boolean flg = false;
            for (int j = finish; j > i; j--)
            {
                if (cost[j] >= cost[j - 1])
                {
                    int temp = perf[j - 1];
                    perf[j - 1] = perf[j];
                    perf[j] = temp;
                    flg = true;
                    temp = cost[j - 1];
                    cost[j - 1] = cost[j];
                    cost[j] = temp;
                }
            }
            if (!flg) break;
        }
    }
}
