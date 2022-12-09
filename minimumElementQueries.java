import java.util.Scanner;

public class minimumElementQueries {
    static int log2(int a){
        int i=(int)(Math.log(a)/Math.log(2));
        return i;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int min[][]=new int[n][log2(n)+1];
        for(int i=0;i<n;i++)min[i][0]=a[i];
        for(int i=1;i<=log2(n);i++){
            for(int j=0;j<=n-(1<<i);j++){
                min[j][i]=Math.min(min[j+(1<<(i-1))][i-1],min[j][i-1]);
                
                // System.out.print(min[j][i]+" ");
            }
            // System.out.println();
        }
        int q=sc.nextInt();
        StringBuilder out=new StringBuilder("");
        for(int i=0;i<q;i++){
           int inA=sc.nextInt();
           int inB=sc.nextInt();
           int pow=log2(inB-inA+1);
           int outfunc=Math.min(min[inA][pow],min[inB-(1<<pow)+1][pow]);
           out.append(outfunc+"\n");
        }
        System.out.print(out);
        

    }
}
