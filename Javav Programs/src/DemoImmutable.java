final class TestImmutable {
	private int i;

	TestImmutable(int i) {
		this.i = i;
	}

	public TestImmutable modify(int i) {

		if (this.i == i)
			return this;
		else
			return new TestImmutable(i);
	}
}

public class DemoImmutable {
	public static void main(String[] args) {
			
		TestImmutable t1 = new TestImmutable(10);
		TestImmutable t2 = t1.modify(100);
		TestImmutable t3 = t1.modify(10);
		System.out.println(t1 == t2);
		System.out.println(t1 == t3);
	}
}
