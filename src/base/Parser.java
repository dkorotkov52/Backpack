package base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    public static Data getData(String fname) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fname));
        String str;

        ArrayList<String> list = new ArrayList<>();
        while((str = reader.readLine()) != null ){
            if(!str.isEmpty()){
                list.add(str);
                System.out.println(str);
            }}
        String[] strs = list.toArray(new String[0]);


        int maxPerf = Integer.parseInt(strs[0]);
        int N = Integer.parseInt(strs[1]);
        int[] perf = new int[N];
        int[] cost = new int[N];

        String[] tmp = " ".split(strs[2]);
        for (int i = 0; i < N; i++)
        {
            perf[i] = Integer.parseInt(tmp[i]);
        }

        tmp = " ".split(strs[3]);
        for (int i = 0; i < N; i++)
        {
            cost[i] = Integer.parseInt(tmp[i]);
        }

        return new Data(N, perf, cost, maxPerf);
    }
}
