package threads;

class MySum {
	public int sum = 0;

//	public synchronized void increaseSum() {
	public void increaseSum() {
		try {
			Thread.sleep(100);
			synchronized (MySum.class) {
				System.out.printf("%s's sum is : %d\n", Thread.currentThread().getName(), ++sum);
			}
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}

	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MySum sum = new MySum();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(() -> {
				sum.increaseSum();
			});
			t.start();
		}
	}
}