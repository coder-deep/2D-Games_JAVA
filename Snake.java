import java.io.*;
import java.util.*;
public class Snake {
	public static void main(String []deep) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Random rand = new Random(); 
		char dir;
		int j,i,flag=0,headi=10,headj=15,foodi,foodj,score=0;
		char a[][]= new char [20][30];
		for(i=0;i<20;i++)
		{
			for(j=0;j<30;j++)
			{
		       a[i][j]=' ';
			}
		}
		for(i=0;i<20;i++)
		{
			for(j=0;j<30;j++)
			{
				if(i==0||j==0||i==19||j==29)
				{
					a[i][j]='*';
				}
			}
		}
		foodi= rand.nextInt(19)+1; 
        foodj = rand.nextInt(29)+1;
        a[foodi][foodj]='f';
        a[headi][headj]='s';
		while(flag==0)
		{
			if(headi==foodi && headj==foodj)
			{   a[foodi][foodj]=' ';
				foodi= rand.nextInt(18)+1; 
		        foodj = rand.nextInt(28)+1;
		        a[foodi][foodj]='f';
		        score+=10;
			}   
			else {
				for(i=0;i<20;i++)
				{
					for(j=0;j<30;j++)
					{
		                System.out.print(a[i][j]);
					}
					System.out.println();
				}
	        //a[foodi][foodj]='f';
		dir=sc.next().charAt(0);
		a[headi][headj]=' ';
		if(dir=='a')
		{
			headj=headj-1;
		}
		if(dir=='d')
		{
			headj=headj+1;
		}
		
		if(dir=='w')
		{
			headi=headi-1;
		}
		
		if(dir=='s')
		{
			headi=headi+1;
		}
			}
		a[headi][headj]='s';
		if(headi==0||headi==19||headj==0||headj==29)
		{
			System.out.println("game over");
			System.out.println("ur score : "+score);
			flag=1;
		}
	//	System.out.flush();
	/*print:*/	
		}
	}
}
