package algorithms;

import base.Data;
import base.Solution;

public class TableAlg implements IAlgorithm {
    private int integral = 0;
    private int part30 = 0;
    private int part50 = 0;

    public Solution solve(Data data)
    {
        integral = 0;
        int minPerf = data.getPerf()[0];
        for (int i = 0; i < data.getPerf().length; i++) {
            if (data.getPerf()[i] < data.getPerf()[0]) {
                minPerf = data.getPerf()[i];
            }
        }
        Solution[] prev = null, cur = new Solution[data.getMaxPerf() + 1];
        for (int i = 0; i < data.getN(); i++)
        {
            if (prev == null)
            {
                for(int A = 0; A < data.getMaxPerf() + 1; A++)
                {
                    if (data.getPerf()[0] <= A)
                    {
                        boolean[] tmp = new boolean[data.getN()];
                        tmp[0] = true;
                        cur[A] = new Solution(data.getCost()[0], tmp);
                    }
                    else
                    {
                        cur[A] = new Solution(0, new boolean[data.getN()]);
                    }
                }
            }
            else
            {
                for (int A = minPerf; A < data.getMaxPerf() + 1; A++)
                {
                    if (data.getPerf()[i] <= A)
                    {
                        if ( prev[A].getCost() > (prev[A - data.getPerf()[i]].getCost() + data.getCost()[i]) )
                        {
                            cur[A] = prev[A];
                        }
                        else
                        {
                            boolean[] tmp = (boolean[])prev[A - data.getPerf()[i]].getX().clone();
                            tmp[i] = true;
                            cur[A] = new Solution(prev[A - data.getPerf()[i]].getCost() + data.getCost()[i], tmp);
                        }
                    }
                    else
                    {
                        cur[A] = prev[A];
                    }
                }
            }
            System.out.println(cur[cur.length - 1].getCost());
            //integral += cur[cur.Length - 1].Cost;
            //if (i == ((data.N * 3) / 10))
            //    part30 = cur[cur.Length - 1].Cost;
            //if ((i-1) == data.N / 2)
            //    part50 = cur[cur.Length - 1].Cost;
            prev = (Solution[])cur.clone();
        }
        //Console.Write("{0} {1} {2} ", integral, part30, part50);
        return cur[data.getMaxPerf()];
    }
}
