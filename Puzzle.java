import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Puzzle
{ 
	int x;
	JTextField res=new JTextField();
 int validate(JTextField t[][])
 {
	 int i,j,flag=0;
	 int ab[][]=new int[9][9];
	 for(i=0;i<9;i++)
	 {
		 for(j=0;j<9;j++)
		 {
			  ab[i][j] = Integer.parseInt(t[i][j].getText());
		 }
	 }
	 
	 for(i=0;i<9;i++)
	 {   int h[]=new int[9];
		 for(j=0;j<9;j++)
		 {
			  h[ab[i][j]]++;
		 }
		 for(j=0;j<9;j++)
		 {
			  if(h[j]==0)
			  {
				  flag=1;
			  }
		 }
	 }
	 
	 for(i=0;i<9;i++)
	 {   int h[]=new int[9];
		 for(j=0;j<9;j++)
		 {
			  h[ab[j][i]]++;
		 }
		 for(j=0;j<9;j++)
		 {
			  if(h[j]==0)
			  {
				  flag=1;
			  }
		 }
	 }
	 
	 return flag;
 }
 
 public static void main(String []deep) throws Exception
 {
	 Puzzle p=new Puzzle();
	 JFrame f=new JFrame("***Sudoku***");
	 Font font1 = new Font("SansSerif",Font.BOLD, 20);
	 int i,j;
	 int a[][]= {{4,7,9,0,1,2,0,0,0},{0,3,0,6,7,0,0,1,0},{1,0,2,9,0,0,7,0,4},{0,0,0,0,4,0,5,6,8},{6,8,0,0,0,0,0,0,2},{2,0,0,8,6,3,0,9,0},{3,4,0,0,8,0,9,0,0},{0,2,0,4,0,0,8,0,0},{8,0,1,5,2,0,4,0,0}};
	 JTextField[][] t=new JTextField[9][9];
	 JButton b=new JButton("FINISH");
	 
	 for (i=0;i<9;i++) 
	 {
		 for(j=0;j<9;j++)
		 { 
		   t[i][j]=new JTextField();
		   t[i][j].setFont(font1);
		   if(a[i][j]!=0)
		   {t[i][j].setText(String.valueOf(a[i][j]));}
		   t[i][j].setHorizontalAlignment(JTextField.CENTER);
		   if(a[i][j]!=0)
		   {t[i][j].setEditable(false);}
		   if(((j>2&&j<6)||(i>2&&i<6))&& !((i>2&&i<6)&&(j>2&&j<6)))
		   {t[i][j].setBackground(Color.LIGHT_GRAY);}
		   else
		   {t[i][j].setBackground(Color.WHITE);}
		   f.add(t[i][j]);

		 }
	}   
	    p.res.setBackground(Color.pink);
	    f.add(b);
	    f.add(p.res);
	    f.setSize(900,900);  
	    f.setLayout(new GridLayout(10,9,2,2)); 
	    f.setVisible(true);  
	    
	    
	    b.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	                  p.x=p.validate(t);
	                  if(p.x==0)
	          	    	p.res.setText("you win");
	          	    else
	          	    	p.res.setText("you lost");
	            }  
	        });     	
	    
 }
}