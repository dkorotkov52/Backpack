import algorithms.IAlgorithm;
import algorithms.RecAlg;
import algorithms.TableAlg;
import base.Data;
import base.Parser;
import base.Solution;
import sorting.BaseSort;
import sorting.Hybrid;

import java.io.Console;
import java.io.IOException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws IOException {
        //list strings fnames
        Data data = Parser.getData("/Users/Apple1111/Documents/labs/3/Backpack/Task3/task_3_06_n50.txt");
        IAlgorithm ta = new TableAlg();
        IAlgorithm ra = new RecAlg();


//        Date strt = new Date();

        data.Sort(new BaseSort());
        Solution s1 = ta.solve(data);
        System.in.read();

//        Date fnsh = new Date();

        data.Sort(new Hybrid());
        s1 = ta.solve(data);

//        System.out.println(fnsh - strt);
//        s1.print();

//        strt = new Date();
//        Solution s2 = ra.solve(data);
//        fnsh = new Date();
//        System.out.println(fnsh - strt);
//        s2.print();

//        for (int i = 0; i < fnames.Length; i++)
//        {
//            data = base.Parser.getData(fnames[i]);
//            data.Sort(new BaseSort());
//            Solution s1 = ta.solve(data);
//            data.Sort(new Hybrid());
//            s1 = ta.solve(data);
//            s1.print();
//        }
        //

        System.in.read();
    }
}
