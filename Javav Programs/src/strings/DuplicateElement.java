package strings;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElement {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
	 
		// add 0 to 9 to list
		for (int i = 0; i < 10; i++) {
			list1.add(String.valueOf(i));
		}
		
		// add again 0 to 4 in same list for duplication
		for (int i = 0; i < 5; i++) {
			list1.add(String.valueOf(i));
		}
		
		System.out.println(list1);
		System.out.println(removeDuplicate(list1));
	}
	public static Set<String> removeDuplicate(List<String> duplicate) {
		Set<String>result = new HashSet<String>();
		for (String tmp : duplicate) {
			result.add(tmp);
		}
		return result;
	}
	
}
