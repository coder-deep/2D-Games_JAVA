import java.util.*;

import javax.swing.JFrame;

import java.lang.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.io.*;

class Sukoban
{
	JFrame f;
	 Label[][] l=new Label[10][10];
void initi(int a[][])
{
	f=new JFrame("***Sukoban***");
	 int i,j;
	 for(i=0;i<10;i++)
	 {
		 for(j=0;j<10;j++)
		 {
			 l[i][j]=new Label();
			 //l[i][j]=new Label(String.valueOf(a[i][j]));
			 if(a[i][j]==0)
				 l[i][j].setBackground(Color.LIGHT_GRAY);
			 if(a[i][j]==1)
				 l[i][j].setBackground(Color.RED);
			 if(a[i][j]==2)
				 l[i][j].setBackground(Color.BLUE);
			 if(a[i][j]==3)
				 l[i][j].setBackground(Color.BLACK);
			 if(a[i][j]==4)
				 l[i][j].setBackground(Color.GREEN);
			 //l[i][j].setAlignment(Label.CENTER);
			 //l[i][j].setFont(new Font("Serif", Font.BOLD, 24));
			 //l[i][j].setBackground(Color.LIGHT_GRAY);
			 f.add(l[i][j]);
		 }
	 }
	
	    f.setSize(1000,1000);  
	    f.setLayout(new GridLayout(10,10,1,1));  
	    f.setVisible(true);  
}

void setval(int a[][])
{
	int i,j;
	for(i=0;i<10;i++)
	 {
		 for(j=0;j<10;j++)
		 {
			 //l[i][j]=new Label(String.valueOf(a[i][j]));
			 if(a[i][j]==0)
				 l[i][j].setBackground(Color.LIGHT_GRAY);
			 if(a[i][j]==1)
				 l[i][j].setBackground(Color.RED);
			 if(a[i][j]==2)
				 l[i][j].setBackground(Color.BLUE);
			 if(a[i][j]==3)
				 l[i][j].setBackground(Color.BLACK);
			 if(a[i][j]==4)
				 l[i][j].setBackground(Color.GREEN);
		 }
	 }
}

public static void main(String [] deep) throws Exception
{
	Scanner sc=new Scanner(System.in);
//	time_t start,end;
	int penalty=0;
//	int sukoi=2,sukoj=0,boxi=3,boxj=1,desti=9,destj=9,i,j,z,flag=0,step=0;
	int sukoi=1,sukoj=3,boxi=2,boxj=3,desti=0,destj=9,i,j,z,flag=0,step=0;
//	int sukoi=1,sukoj=0,boxi=1,boxj=1,desti=9,destj=9,i,j,z,flag=0,step=0;
	char move;
//	int a[][]={{1,1,0,0,0,0,0,0,0,0,0},{0,0,1,1,1,1,1,1,1,0,0},{2,3,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,1,0,0},{1,0,1,1,1,1,1,0,1,0,0},{1,0,1,1,1,1,1,0,1,0,0},{1,0,0,0,1,0,0,0,1,0,0},{0,0,0,0,1,0,0,0,1,0,0},{0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,0,4,0}};
	int a[][]={{1,1,1,1,0,0,0,0,0,4},{1,1,1,2,0,0,0,1,1,0},{1,1,1,3,0,1,0,1,1,0},{1,1,0,0,0,1,0,1,1,0},{1,1,0,0,0,1,0,1,1,0},{1,0,0,0,1,1,0,1,1,0},{1,0,0,0,1,1,0,0,0,0},{0,0,1,1,1,1,0,1,0,0},{0,0,0,0,0,0,0,0,0,0},{1,1,0,0,0,0,1,0,0,1}};
//  int a[][]={{0,0,0,0,0,0,0,0,0,1},{2,3,0,0,0,0,0,0,0,1},{0,1,1,1,1,0,1,1,0,0},{0,1,0,0,1,0,0,1,0,0},{0,1,0,0,1,0,1,1,0,1},{0,0,0,0,0,0,0,1,0,1},{0,0,0,0,0,0,0,0,0,0},{1,1,1,0,1,0,0,1,0,0},{1,1,1,0,1,1,0,1,0,0},{0,0,0,0,0,0,0,0,0,4}};
       Sukoban s=new Sukoban();
       
       s.initi(a);
        String player=sc.next();
        z=sc.nextInt();
	if(z==1)
	{    
	      //start=time(NULL);
		while(flag==0)
		{
                
           s.setval(a);
		    move=sc.next().charAt(0);
			if(move=='a'&&sukoj>0)
			{
				if(a[sukoi][sukoj-1]==0)
				{
					a[sukoi][sukoj]=0;
					sukoj--;
					a[sukoi][sukoj]=2;
				}
				else if(a[sukoi][sukoj-1]==3&&a[sukoi][sukoj-2]==0&&sukoj>1)
				{
					a[sukoi][sukoj]=0;
					sukoj--;
					a[sukoi][sukoj]=2;
					a[sukoi][sukoj-1]=3;
				}
				else if(a[sukoi][sukoj-1]==3&&a[sukoi][sukoj-2]==4)
				{
					s.l[sukoi][sukoj].setBackground(Color.LIGHT_GRAY);
					s.l[sukoi][sukoj-1].setBackground(Color.BLUE);
					s.l[sukoi][sukoj-2].setBackground(Color.BLACK);
					flag=1;
					//end=time(null);
				}
				else
				{
					System.out.println("\tinvalid move");
					penalty++;
				}
			}
			if(move=='d'&&sukoj<9)
			{
				if(a[sukoi][sukoj+1]==0)
				{
					a[sukoi][sukoj]=0;
					sukoj++;
					a[sukoi][sukoj]=2;
				}
				else if(a[sukoi][sukoj+1]==3&&a[sukoi][sukoj+2]==0&&sukoj<8)
				{
					a[sukoi][sukoj]=0;
					sukoj++;
					a[sukoi][sukoj]=2;
					a[sukoi][sukoj+1]=3;
				}
				else if(a[sukoi][sukoj+1]==3&&a[sukoi][sukoj+2]==4)
				{
					s.l[sukoi][sukoj].setBackground(Color.LIGHT_GRAY);
					s.l[sukoi][sukoj+1].setBackground(Color.BLUE);
					s.l[sukoi][sukoj+2].setBackground(Color.BLACK);
					flag=1;
					//end=time(null);
				}
				else
				{
					System.out.println("\tinvalid move");
					penalty++;
				}
			}
			if(move=='w'&&sukoi>0)
			{
				if(a[sukoi-1][sukoj]==0)
				{
					a[sukoi][sukoj]=0;
					sukoi--;
					a[sukoi][sukoj]=2;
				}
				else if(a[sukoi-1][sukoj]==3&&a[sukoi-2][sukoj]==0&&sukoi>1)
				{
					a[sukoi][sukoj]=0;
					sukoi--;
					a[sukoi][sukoj]=2;
					a[sukoi-1][sukoj]=3;
				}
				else if(a[sukoi-1][sukoj]==3&&a[sukoi-2][sukoj]==4)
				{
					s.l[sukoi][sukoj].setBackground(Color.LIGHT_GRAY);
					s.l[sukoi-1][sukoj].setBackground(Color.BLUE);
					s.l[sukoi-2][sukoj].setBackground(Color.BLACK);
					flag=1;
					//end=time(null);
				}
				else
				{
					System.out.println("\tinvalid move");
					penalty++;
				}
			}
			if(move=='s'&&sukoi<9)
			{
				if(a[sukoi+1][sukoj]==0)
				{
					a[sukoi][sukoj]=0;
					sukoi++;
					a[sukoi][sukoj]=2;
				}
				else if(a[sukoi+1][sukoj]==3&&a[sukoi+2][sukoj]==0&&sukoi<8)
				{
					a[sukoi][sukoj]=0;
					sukoi++;
					a[sukoi][sukoj]=2;
					a[sukoi+1][sukoj]=3;
				}
				else if(a[sukoi+1][sukoj]==3&&a[sukoi+2][sukoj]==4)
				{
					s.l[sukoi][sukoj].setBackground(Color.LIGHT_GRAY);
					s.l[sukoi+1][sukoj].setBackground(Color.BLUE);
					s.l[sukoi+2][sukoj].setBackground(Color.BLACK);
					flag=1;
					//end=time(null);
				}
				else
				{
					System.out.println("\tinvalid move");
					penalty++;
				}
			}
			step++;
		
	   }
	}
	     if(flag==1)
	     { 
	     	System.out.println("\tcongratulations "+player+"!... you won. ");
	     	System.out.println("\tyou completed d puzzle in "+step+" steps.");
	     	//System.out.println("\ttime taken to complete:%f seconds\tNo Of penaltys : %d .",penalty);
	     }
}
}