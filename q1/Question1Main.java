package assignment1.questions.q1;

import java.util.ArrayList;
import java.util.Scanner;
class EvenSum extends  Thread{
    int sum=0;
    ArrayList<Integer> a1=new ArrayList<>();
    EvenSum(ArrayList<Integer> a1){
        this.a1=a1;
    }
    public int getSum() {
        return sum;
    }

    public void run() {
        for(Integer a:a1){
            sum=sum+a;
        }
    }
}
class OddSum extends  Thread{
    int sum=0;
    ArrayList<Integer> a1=new ArrayList<>();
    OddSum(ArrayList<Integer> a1){
        this.a1=a1;
    }
    public int getSum() {
        return sum;
    }

    public void run() {
        for(Integer a:a1){
            sum=sum+a;
        }
    }
}
public class Question1Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the value of n :- ");
        n=sc.nextInt();
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%2==0){
                a1.add(i);
            }else{
                a2.add(i);
            }
        }
        long start1=System.currentTimeMillis();
        EvenSum e=new EvenSum(a1);
        OddSum o=new OddSum(a2);
        e.start();
        o.start();

        e.join();
        o.join();
        long end1=System.currentTimeMillis();
        System.out.println(e.getSum());
        System.out.println(o.getSum());
        System.out.println("Time taken :- "+(end1-start1));
    }
}
