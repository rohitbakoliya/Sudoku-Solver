import java.io.*;
class p2
{
    public static void main()throws IOException
    {
        BufferedReader ps=new BufferedReader(new InputStreamReader(System.in));
        int a[][]=new int[9][9];
        System.out.println("ENTER NUMBER OF ENTRIES YOU WANT TO GIVE");
        int n=Integer.parseInt(ps.readLine());
        for(int m1=1;m1<=9;m1++)
        {
            if((m1-1)%3==0)
            System.out.println();
            for(int m2=1;m2<=9;m2++)
            {
                if((m2-1)%3==0 && m2!=1)
                System.out.print("  ");
                System.out.print(m1+","+m2+"  ");
                a[m1-1][m2-1]=0;
            }
            System.out.println();
        }
        System.out.println("ENTER THE NUMBERS IN THE SUDOKU ACCORDING TO THE GIVEN FORMAT : ROW,COLUMN=NUMBER.EXAMPLE : 2,5=8");
        for(int m3=1;m3<=n;m3++)
        {
            String s=ps.readLine();
            a[(Integer.parseInt(s.substring(0,1)))-1][(Integer.parseInt(s.substring(2,3)))-1]=Integer.parseInt(s.substring(4,5));
        }
        int v3=n,v4=0;
        for(int p=1;p>0;p++)
        {
            int v=0,v2=v3;
            for(int x=0;x<9;x++)
            {
                for(int y=0;y<9;y++)
                {
                    if(a[x][y]==0)
                    {
                        int k=0,l=0;
                        for(int n2=1;n2<=9;n2++)
                        {
                            int c=0;
                            for(int rc=0;rc<9;rc++)
                            {
                                if(a[x][rc]==n2 || a[rc][y]==n2)
                                c=c+1;
                            }
                            if(c==0)
                            {
                                int x1=0,y1=0;
                                x1=x>2?(x>5?6:3):0;
                                y1=y>2?(y>5?6:3):0;
                                for(int g2=x1;g2<(x1+3);g2++)
                                {
                                    for(int h2=y1;h2<(y1+3);h2++)
                                    {
                                        if(a[g2][h2]==n2)
                                        c=c+1;
                                    }
                                }
                                if(c==0)
                                {
                                    k=k+1;
                                    l=n2;
                                }
                            }
                        }
                        if(k==1)
                        {
                        a[x][y]=l;
                        v2=v2+1;
                    }
                    }
                    else
                    v=v+1;
                }
            }
            if(v==81)
            break;
            if(v2==v3)
            {
                v4=1;
                System.out.println("THE SOLUTION IS DIFFICULT"+" YOUR PARTIALLY SOLVED SUDOKU IS ");
                for(int h1=0;h1<9;h1++)
                {
                    if(h1%3==0)
                    System.out.println();
                    for(int h2=0;h2<9;h2++)
                    {
                        if(h2%3==0 && h2!=0)
                        System.out.print("  ");
                        String s4=String.valueOf(a[h1][h2]);
                        if(a[h1][h2]==0)
                        System.out.print(" ");
                        else
                        System.out.print(s4);
                    }
                }
                break;
            }
            v3=v2;
        }
        if(v4!=1)
        {
        for(int x3=0;x3<9;x3++)
        {
            if(x3%3==0)
            System.out.println();
            for(int y3=0;y3<9;y3++)
            {
            if(y3%3==0 && y3!=0)
            System.out.print("  ");
            System.out.print(a[x3][y3]+" ");
        }
            System.out.println();
        }
    }
    }
}