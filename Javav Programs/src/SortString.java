import java.util.Arrays;

public class SortString {

	public static void main(String[] args) {
		String[] inputList = { "aaa","AAA","bbb","ZZZZ"};
		
		//consider case
		Arrays.sort(inputList);
		
		for (int i = 0; i < inputList.length; i++) {
			System.out.println(inputList[i]);
		}
		
		//case insensitive order
		System.out.println("*******************");
		Arrays.sort(inputList,String.CASE_INSENSITIVE_ORDER);
		for (int i = 0; i < inputList.length; i++) {
			System.out.println(inputList[i]);
		}
		

	}

}
