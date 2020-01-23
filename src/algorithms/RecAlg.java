package algorithms;

import base.Data;
import base.Solution;

import java.util.HashMap;

public class RecAlg implements IAlgorithm {

    private static HashMap<Integer, Solution> mem = new HashMap<>();
    private int mult = 1;

    public Solution solve(Data data) {
        while ((data.getN() - 1) / mult > 0) {
            mult *= 10;
        }
        return doSolve(data, data.getMaxPerf(), data.getN() - 1);
    }

    private Solution doSolve(Data data, int Perf, int i) {
        if (mem.containsKey(Perf * mult + i)) {
            return mem.get(Perf * mult + i);
        } else {
            if (i > 0) {
                Solution s1 = doSolve(data, Perf, i - 1), s2 = null;
                if (Perf >= data.getPerf()[i]) {
                    s2 = doSolve(data, Perf - data.getPerf()[i], i - 1);
                    if (s1.getCost() < (s2.getCost() + data.getCost()[i])) {
                        boolean[] tmp = (boolean[]) s2.getX().clone();
                        tmp[i] = true;
                        mem.put(Perf * mult + i, new Solution(s2.getCost() + data.getCost()[i], tmp));
                        return new Solution(s2.getCost() + data.getCost()[i], tmp);
                    }
                }
                mem.put(Perf * mult + i, s1);
                return s1;
            } else {
                if (Perf > data.getPerf()[0]) {
                    boolean[] tmp = new boolean[data.getN()];
                    tmp[0] = true;
                    mem.put(Perf * mult + i, new Solution(data.getCost()[0], tmp));
                    return new Solution(data.getCost()[0], tmp);
                } else {
                    mem.put(Perf * mult + i, new Solution(0, new boolean[data.getN()]));
                    return new Solution(0, new boolean[data.getN()]);
                }
            }
        }
    }
}
