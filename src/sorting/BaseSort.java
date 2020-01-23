package sorting;

public class BaseSort implements ISort {

    public void Sort(int[] perf, int[] cost) {
        for (int i = 0; i < perf.length - 1; i++) {
            boolean flg = false;
            for (int j = perf.length - 1; j > i; j--) {
                if ((double) cost[j] / (double) perf[j] >= (double) cost[j - 1] / (double) perf[j - 1]) {

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
