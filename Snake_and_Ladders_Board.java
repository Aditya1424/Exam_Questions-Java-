import java.util.*;
public class Snake_and_Ladders_Board{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int ld=sc.nextInt();
            int s=sc.nextInt();
            List<List<Integer>> l=new ArrayList<>();
            for(int i=0;i<=n;i++)l.add(new ArrayList<>());
            int bd[]=new int[200];
            for(int i=0;i<ld+s;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                bd[a]=b-a;
            }
            for(int i=1;i<=n;i++){
                for(int j=1;j<=6&&i+j+bd[i+j]<=n;j++)l.get(i).add(i+j+bd[i+j]);
            }

            int v[]=new int[n+1];
            Arrays.fill(v,-1);
            Queue<Integer> q=new LinkedList<>();
            v[1]=0;
            q.add(1);
            while(!q.isEmpty()){
                int f=q.poll();
                for(int nb:l.get(f)){
                    if(v[nb]==-1){
                        v[nb]=v[f]+1;
                        q.add(nb);
                    }
                }
            }
            System.out.println(v[n]);
        }
    }
}
