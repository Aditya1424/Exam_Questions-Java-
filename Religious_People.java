import java.util.*;
public class Religious_People {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int r=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            List<List<Integer>> l=new ArrayList<>();
            for(int i=0;i<=n;i++)l.add(new ArrayList<>());
            for(int i=0;i<r;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                l.get(x).add(y);
                l.get(y).add(x);
            }
            List<Integer> len=new ArrayList<>();
            boolean v[]=new boolean[n+1];
            int c=0;
            for(int i=1;i<=n;i++){
                if(!v[i]){
                    c++;
                    e=0;
                    dfs(l,i,v);
                    len.add(e-1);
                }
            }
            long ans=0;
            if(a<b){
                ans=1L*a*n;
            }
            else{
                ans+=1L*a*c;
                for(int i:len){
                    ans+=1L*b*i;
                }
            }
            System.out.println(ans);
        }
    }
    static int e;
    static void dfs(List<List<Integer>> l,int src,boolean v[]){
        v[src]=true;
        e++;
        for(int n:l.get(src)){
            if(!v[n]){
                dfs(l,n,v);
            }
        }
    }
}
