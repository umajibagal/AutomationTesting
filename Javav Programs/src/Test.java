interface Abc {
	public int add();
}

public class Test {

	public static void main(String[] args) {

		Abc x1 = () -> {int a=10;return a * a;};
		System.out.println(x1.add());
	}

}
