import java.util.*;
public class Monu_bhaiya_and_spams {
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<TreeSet<Integer>> m=new ArrayList<>();
        for(int i=0;i<n;i++){
            m.add(new TreeSet<>());
        }
        int mm=sc.nextInt();
        for(int i=0;i<mm;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            m.get(a).add(b);
            m.get(b).add(a);
        }
        TreeSet<Integer> unv=new TreeSet<>();
        for(int i=0;i<n;i++)unv.add(i);
        int c=0;
        for(int i=0;i<n;i++){
            if(unv.contains(i)){
                c++;
                unv.remove(i);
                dfs(i,unv,m);
            }
        }
        System.out.println(c);
    }
    static void dfs(int s,TreeSet<Integer> un,List<TreeSet<Integer>> m){
        TreeSet<Integer> nb=m.get(s);
        List<Integer> nn=new ArrayList<>();
        for(int i:un){
            if(!nb.contains(i)){
                nn.add(i);
            }
        }
        for(int i:nn)un.remove(i);
        for(int i:nn)dfs(i,un,m);

    }
}
