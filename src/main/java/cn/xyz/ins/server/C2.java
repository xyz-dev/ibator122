package cn.xyz.ins.server;

public class C2 {
	public static void main(String[] args) {
		new C2().getCurrId();
	}
	
	public void getCurrId() {
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName());
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	private void setName(String name) {
		
	}
	private void setName(int i) {}
}
