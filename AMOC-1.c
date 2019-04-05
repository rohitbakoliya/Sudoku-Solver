#include<stdio.h>
void main()
{
    int choice,i,j;
    int s[9][9];
    int x, y, value;
    for(i=0;i<9;i++)
    {
        for(j=0;j<9;j++)
        {
            s[i][j]=0;
        }
    }
     for(i=0;i<9;i++)
    {
        for(j=0;j<9;j++)
        {
            printf("%d \t",s[i][j]);
        }
        printf("\n");
    }
    while(1)
    {
        lable :
        printf("1. ENTER VALUE \n");
        printf("2. SOLVE GRID \n\n");

        printf("ENTER YOUR CHOICE\n");
        scanf("%d",&choice);

        switch(choice)
    case 1:
        {
            read :
            printf("ENTER THE COORDINATES X, Y \n");
            scanf("%d%d",&x,&y);
            printf("ENTER THE VALUE \n");
            scanf("%d",&value);
            if(0<=x<9 && 0<=y<9 && 1<=value<=9)
            {
                s[x][y]=value;
                for(i=0;i<9;i++)
                {
                    for(j=0;j<9;j++)
                    {
                        printf("%d\t",s[i][j]);
                    }
                    printf("\n");
                }
            }
            else( 0<!x<=!9 || 0<!y<=!9 || 1<!value<!9 )
            {
                printf("PLEASE! ENTER CORRECT COORDINATES or VALUE\n");
                goto read;
            }
        }
    case 2:
        {
            int a, b, aMAX, bMAX, p1,r=0;
        for(r=0;r<81;r++)//loop should iterate till all values are not non zero
        {
            for(a=0;a<9;a++)
            {
                for(b=0;b<9;b++)
                {
                    if(s[a][b]==0)
                    {
                        int prob=0
                        for(k=1;k<=9;k++)
                        {
                            int count=0;
                            for(j=0; j<9; j++)
                            {
                                if(s[a][j]==k)
                                    count++;
                            }
                            if(count==1)
                            {
                                for(i=0;i<9;i++)
                                {
                                    if(s[i][b]==k)
                                        count++;
                                }
                            }
                            if(count==1)
                            {
                               int p= (0<=a<=2)?(aMAX=2):(3<=a<=5)?(aMAX=5):(aMAX=8);
                               int q= (0<=b<=2)?(bMAX=2):(3<=b<=5)?(bMAX=5):(bMAX=8);
                                for(p=aMAX-2;p<=aMAX;p++)
                                {
                                    for(q=bMAX-2;q<=bMAX;q++)
                                    {
                                        if(s[a][b]==s[p][q])
                                            count++;
                                    }
                                }
                            }
                            if(count==1)
                            {
                                prob++;
                                p1=k;
                            }
                        }
                        if(prob==1)
                        {
                            s[a][b]=p1;//for which prob increases.
                        }
                        else
                            s[a][b]=0;
                    }
                    else
                        r++;
                }
            }

        }
        for(i=0;i<9;i++)
            {
                for(j=0;j<9;j++)
                {
                    printf("%d \t",s[i][j]);
                }
                printf("\n");
            }
            break;//loop terminates when user enter solve grid
    }

    default :
        {
            printf("PLEASE! CHOOSE CORRECT CHOICE \n");
            goto lable;
        }
    }
}

