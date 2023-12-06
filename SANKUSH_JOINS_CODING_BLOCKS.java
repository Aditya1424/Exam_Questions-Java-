import java.util.*;
public class SANKUSH_JOINS_CODING_BLOCKS {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        int m=0,d=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='d')m++;
            else d++;
        }
        if(m>d)System.out.println(Math.abs(m-d)/2-1);
        else
            System.out.println(Math.abs(m-d)/2);
    }
}
