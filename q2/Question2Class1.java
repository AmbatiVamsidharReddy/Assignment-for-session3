package assignment1.questions.q2;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question2Class1 extends Thread{
    private int start,end;
    private int count=0;

    ArrayList<String> listOfLines = new ArrayList<>();
    public Question2Class1() {

    }
    public Question2Class1(int start, int end, ArrayList<String> l) {
        this.start=start;
        this.end=end;
        this.listOfLines=l;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public  int getCount() {
        return count;
    }

    public void run() {
            for(int i=start;i<end;i++) {
                count=count+countwords( listOfLines.get(i));
            }
    }

    public static int countwords(String str) {
        if (str == null || str.isEmpty())
            return 0;
        StringTokenizer tokens = new StringTokenizer(str);
        return tokens.countTokens();
    }
}
