import java.util.*;
public class BFS_Shortest_Path {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int e=sc.nextInt();
            List<List<Integer>> l=new ArrayList<>();
            for(int i=0;i<=n;i++)l.add(new ArrayList<>());
            for(int i=0;i<e;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                l.get(a).add(b);
                l.get(b).add(a);
            }
            int src=sc.nextInt();
            int d[]=new int[n+1];
            Arrays.fill(d,-1);
            d[src]=0;
            Queue<Integer> q=new LinkedList<>();
            q.add(src);
            while(!q.isEmpty()){
                int f=q.poll();
                for(int nb:l.get(f)){
                    if(d[nb]==-1){
                        d[nb]=d[f]+6;
                        q.add(nb);
                    }
                }
            }
            for(int i=1;i<=n;i++){
                if(i==src)continue;
                System.out.print(d[i]+" ");
            }
            System.out.println();
        }
    }
}
