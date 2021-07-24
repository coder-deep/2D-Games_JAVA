import java.util.*;

public class Guess 
{
	public static void main(String []deep)
	{
		Scanner sc=new Scanner(System.in);
		Random rand = new Random();
		int flag=0,score=1000,i,g;
		int n=Math.abs(rand.nextInt())%100;
		System.out.println("guess btwn 1 to 100");
		while(flag<1)
		{
			g=sc.nextInt();
			if(g<n) {
				System.out.println("ur guess is low");
			    score-=10;}
			else if(g>n) {
				System.out.println("ur guess is high");
			    score-=10;}
			else if(g==n) {
				System.out.println("ur guess is correct");
				System.out.println(score);
			    flag=1;}
		}
		
	}
}
