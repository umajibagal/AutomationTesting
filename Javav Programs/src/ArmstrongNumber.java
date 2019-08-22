import java.util.Scanner;

public class ArmstrongNumber {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		num = sc.nextInt();
		int digitCount = (num+"").toString().length();
		System.out.println("Total digit count : "+digitCount);
		int sum=0;
		int num1 = num;
	
		while(num!=0) {
			int t = num % 10;
			num = num / 10;
			sum = (int) (sum + Math.pow(t, digitCount));
		}
		
		System.out.println(sum);
		if(num1 == sum)
			System.out.println(num1+" is armstrong number");
		else
			System.out.println(num1+" is not armstrong number");
	}
}
