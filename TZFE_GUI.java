import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Print
{
	 JFrame f;
	 Label[][] l=new Label[4][4];
	void print(int a[][])
	{
		//ImageIcon im = new ImageIcon("klulogo2.jpg");
		 f=new JFrame("***2048***");
		 int i,j;
		 for(i=0;i<4;i++)
		 {
			 for(j=0;j<4;j++)
			 {
				 l[i][j]=new Label(String.valueOf(a[i][j]));
				 l[i][j].setAlignment(Label.CENTER);
				 l[i][j].setFont(new Font("Serif", Font.BOLD, 24));
				 l[i][j].setBackground(Color.LIGHT_GRAY);
				 f.add(l[i][j]);
			 }
		 }
		
		    f.setSize(400,400);  
		    f.setLayout(new GridLayout(4,4,4,4));  
		    f.setVisible(true);  
	}
	
	void setval(int a[][])
	{
		int i,j;
		for(i=0;i<4;i++)
		{
			for(j=0;j<4;j++)
			{
				l[i][j].setText(String.valueOf(a[i][j]));
				if(a[i][j]==0)
					l[i][j].setBackground(Color.LIGHT_GRAY);
				if(a[i][j]==2)
					l[i][j].setBackground(Color.GRAY);
				if(a[i][j]==4)
					l[i][j].setBackground(Color.YELLOW);
				if(a[i][j]==8)
					l[i][j].setBackground(Color.ORANGE);
				if(a[i][j]==16)
					l[i][j].setBackground(Color.PINK);
				if(a[i][j]==32)
					l[i][j].setBackground(Color.MAGENTA);
				if(a[i][j]==64)
					l[i][j].setBackground(Color.CYAN);
				if(a[i][j]==128)
					l[i][j].setBackground(Color.BLUE);
				if(a[i][j]==256)
					l[i][j].setBackground(Color.GREEN);
				if(a[i][j]==512)
					l[i][j].setBackground(Color.RED);
				if(a[i][j]==1024)
					l[i][j].setBackground(Color.DARK_GRAY);
				if(a[i][j]==2048)
					l[i][j].setBackground(Color.BLACK);
			}
		}
		
		
		}
}

public class TZFE_GUI 
{
	public static void main(String []deep) throws Exception
	{
		Print p = new Print();
		Scanner sc=new Scanner(System.in);
		Random rand = new Random(); 
		int a[][]=new int[4][4];
		int flag=0,i,j,c=0,randi,randj,flag1=0;
		char ch;
		randi= rand.nextInt(4);
		randj= rand.nextInt(4);
		a[randi][randj]=2;
		randi= rand.nextInt(4);
		randj= rand.nextInt(4);
		a[randi][randj]=2;
		p.print(a);
		while(flag==0)
		{
			ch=sc.next().charAt(0);
			//KeyEvent e;
			//e.getKeyChar() 
			c=0;
			//System.out.flush();
			for(i=0;i<4;i++)    //to check weather there is any empty space to continue or end game
			{
				for(j=0;j<4;j++)
				{
					if(a[i][j]!=0)
						c++;
					if(a[i][j]==2048)
					{
						System.out.println("you win");
					}
				}
			}
			//========================
			if(ch=='a')
			{
				for(i=0;i<4;i++)
				{
					if (a[i][0]==a[i][1])
						{a[i][0]+=a[i][1];
						a[i][1]=0;}
					if (a[i][0]==a[i][2] && a[i][1]==0)
						{a[i][0]+=a[i][2];
						a[i][2]=0;}					
					if (a[i][0]==a[i][3] && a[i][1]==0 && a[i][2]==0)
						{a[i][0]+=a[i][3];
						a[i][3]=0;}
					if (a[i][1]==a[i][2])
						{a[i][1]+=a[i][2];
						a[i][2]=0;}
					if (a[i][1]==a[i][3] && a[i][2]==0)
						{a[i][1]+=a[i][3];
						a[i][3]=0;}
					if (a[i][2]==a[i][3])
						{a[i][2]+=a[i][3];
						a[i][3]=0;}
				}
				for(i=0;i<4;i++)
				{
					if(a[i][0]==0&&a[i][1]!=0)
						{a[i][0]=a[i][1];
					    a[i][1]=0;}
					if(a[i][0]==0&&a[i][2]!=0&&a[i][1]==0)
						{a[i][0]=a[i][2];
						a[i][2]=0;}
					if(a[i][0]==0&&a[i][3]!=0&&a[i][1]==0&&a[i][2]==0)
						{a[i][0]=a[i][3];
						a[i][3]=0;}
					if(a[i][1]==0&&a[i][2]!=0)
					    {a[i][1]=a[i][2];
				        a[i][2]=0;}
					if(a[i][1]==0&&a[i][3]!=0&&a[i][2]==0)
						{a[i][1]=a[i][3];
						a[i][3]=0;}
					if(a[i][2]==0&&a[i][3]!=0)
						{a[i][2]=a[i][3];
						a[i][3]=0;}
				}
			}
				if(ch=='d')
				{
					for(i=0;i<4;i++)
					{
						if (a[i][3]==a[i][2])
							{a[i][3]+=a[i][2];
							a[i][2]=0;}
						if (a[i][3]==a[i][1] && a[i][2]==0)
							{a[i][3]+=a[i][1];
							a[i][1]=0;	}				
						if (a[i][3]==a[i][0] && a[i][1]==0 && a[i][2]==0)
							{a[i][3]+=a[i][0];
							a[i][3]=0;}
						if (a[i][2]==a[i][1])
							{a[i][2]+=a[i][1];
							a[i][1]=0;}
						if (a[i][2]==a[i][0] && a[i][1]==0)
							{a[i][2]+=a[i][0];
							a[i][0]=0;}
						if (a[i][1]==a[i][0])
							{a[i][1]+=a[i][0];
							a[i][0]=0;}
					}
					for(i=0;i<4;i++)
					{
						if(a[i][3]==0&&a[i][2]!=0)
							{a[i][3]+=a[i][2];
						    a[i][2]=0;}
						if(a[i][3]==0&&a[i][1]!=0&&a[i][2]==0)
							{a[i][3]+=a[i][1];
							a[i][1]=0;}
						if(a[i][3]==0&&a[i][0]!=0&&a[i][1]==0&&a[i][2]==0)
							{a[i][3]+=a[i][0];
							a[i][0]=0;}
						if(a[i][2]==0&&a[i][1]!=0)
						    {a[i][2]+=a[i][1];
					        a[i][1]=0;}
						if(a[i][2]==0&&a[i][0]!=0&&a[i][1]==0)
							{a[i][2]+=a[i][0];
							a[i][0]=0;}
						if(a[i][1]==0&&a[i][0]!=0)
							{a[i][1]+=a[i][0];
							a[i][0]=0;}
					}
				}
				if(ch=='w')
				{
					for(i=0;i<4;i++)
					{
						if (a[0][i]==a[1][i])
							{a[1][i]+=a[0][i];
							a[0][i]=0;}
						if (a[0][i]==a[2][i] && a[1][i]==0)
							{a[2][i]+=a[0][i];
							a[0][i]=0;}					
						if (a[0][i]==a[3][i] && a[2][i]==0 && a[1][i]==0)
							{a[3][i]+=a[0][i];
							a[0][i]=0;}
						if (a[1][i]==a[2][i])
							{a[2][i]+=a[1][i];
							a[1][i]=0;}
						if (a[1][i]==a[3][i] && a[2][i]==0)
							{a[3][i]+=a[1][i];
							a[1][i]=0;}
						if (a[2][i]==a[3][i])
							{a[3][i]+=a[2][i];
							a[2][i]=0;}
					}
					for(i=0;i<4;i++)
					{
						if(a[0][i]==0&&a[1][0]!=0)
							{a[0][i]=a[1][i];
						    a[1][i]=0;}
						if(a[0][i]==0&&a[2][i]!=0&&a[1][i]==0)
							{a[0][i]=a[2][i];
							a[2][i]=0;}
						if(a[0][i]==0&&a[3][i]!=0&&a[1][i]==0&&a[2][i]==0)
							{a[0][i]=a[3][i];
							a[3][i]=0;}
						if(a[1][i]==0&&a[2][i]!=0)
						    {a[1][i]=a[2][i];
					        a[2][i]=0;}
						if(a[1][i]==0&&a[3][i]!=0&&a[2][i]==0)
							{a[1][i]=a[3][i];
							a[3][i]=0;}
						if(a[2][i]==0&&a[3][i]!=0)
							{a[2][i]=a[3][i];
							a[3][i]=0;}
					}
					
				}
				if(ch=='s')
				{
					for(i=0;i<4;i++)
					{
						if (a[3][i]==a[2][i])
							{a[2][i]+=a[3][i];
							a[3][i]=0;}
						if (a[3][i]==a[1][i] && a[2][i]==0)
							{a[1][i]+=a[3][i];
							a[3][i]=0;}					
						if (a[0][i]==a[3][i] && a[2][i]==0 && a[1][i]==0)
							{a[3][i]+=a[0][i];
							a[0][i]=0;}
						if (a[1][i]==a[2][i])
							{a[2][i]+=a[1][i];
							a[1][i]=0;}
						if (a[2][i]==a[0][i] && a[1][i]==0)
							{a[2][i]+=a[0][i];
							a[0][i]=0;}
						if (a[1][i]==a[0][i])
							{a[1][i]+=a[0][i];
							a[0][i]=0;}
					}
					for(i=0;i<4;i++)
					{
						if(a[3][i]==0&&a[2][i]!=0)
							{a[3][i]+=a[2][i];
						    a[2][i]=0;}
						if(a[3][i]==0&&a[1][i]!=0&&a[2][i]==0)
							{a[3][i]+=a[1][i];
							a[1][i]=0;}
						if(a[3][i]==0&&a[0][i]!=0&&a[1][i]==0&&a[2][i]==0)
							{a[3][i]+=a[0][i];
							a[0][i]=0;}
						if(a[2][i]==0&&a[1][i]!=0)
						    {a[2][i]+=a[1][i];
					        a[1][i]=0;}
						if(a[2][i]==0&&a[0][i]!=0&&a[1][i]==0)
							{a[2][i]+=a[0][i];
							a[0][i]=0;}
						if(a[1][i]==0&&a[0][i]!=0)
							{a[1][i]+=a[0][i];
							a[0][i]=0;}
					}
				}
				
			//=========================
			if(c==16)
				{flag=1;
				System.out.println("game over");}
			flag1=0; 
			while(flag1==0)//to check weather random position is empty or not
			{
			randi= rand.nextInt(4);
			randj= rand.nextInt(4);
			if(a[randi][randj]==0)
			{
			   a[randi][randj]=2;
			   flag1=1;
			}
			}

			//printing the table
		p.setval(a);
		
		}
		
		}
}