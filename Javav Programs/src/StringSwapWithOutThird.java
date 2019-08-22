
public class StringSwapWithOutThird {
	public static void main(String[] args) {
		String s1 = "aaa";
		String s2 = "bbbw";
		s1 = s1 + s2;
		s2 = s1.substring(0, s1.length() - s2.length());
		s1 = s1.substring(s2.length(), s1.length());
		System.out.println(s1);
		System.out.println(s2);
		
		int a=10,b=20;
		System.out.println(a+"  "+b);
		b = a ^ b ^ (a=b);
		System.out.println(a+"  "+b);

	
	}
}
