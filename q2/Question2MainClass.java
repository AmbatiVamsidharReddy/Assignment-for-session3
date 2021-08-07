package assignment1.questions.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Question2MainClass {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("C:\\\\Users\\\\vamsi\\\\eclipse-workspace\\\\cancelledperiodfortask\\\\Assignment\\\\src\\\\assignment1\\\\test.txt");
        for (int i = 1; i <= 10000; i++) { // modify the value to change how many lines you need to write to the file.
            fw.write("This is line"+i+"\n");
        }
        fw.close();

        File file = new File("C:\\Users\\vamsi\\eclipse-workspace\\cancelledperiodfortask\\Assignment\\src\\assignment1\\test.txt");
        BufferedReader bufReader = new BufferedReader(new FileReader(file));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while(line!=null)
        {
            listOfLines.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();

        int m=1000; // modify for number of threads
        ArrayList<Question2Class1> thr=new ArrayList<>();
        int start,end;
        long start1 = System.currentTimeMillis();
        start=0;
        end=(listOfLines.size())/m;

        for(int i=0;i<m;i++) {
            Question2Class1 t=new Question2Class1(start, end,listOfLines);
            thr.add(t);
            start=end;
            end=end+(listOfLines.size()/m);
        }
        for(Question2Class1 th:thr){
            th.start();
        }
        for(Question2Class1 th:thr){
            th.join();
        }
        int count=0;
        for(Question2Class1 th:thr){
            count=count+th.getCount();
        }
        long end1 = System.currentTimeMillis();

        System.out.println("Word Count of the file - "+ count);
        System.out.println("Total time taken :- "+(end1-start1));

    }

}
