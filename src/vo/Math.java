package vo;

public class Math {
	private int a;
	private int b;
	
	public Math() {}
	
	/**
	 * 运算
	 * @return
	 */
	public int add() {
		return a+b;
	}
	public int jian() {
		return a-b;
	}
	public int cheng() {
		return a*b;
	}
	public int chu() {
		return a/b;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
}
