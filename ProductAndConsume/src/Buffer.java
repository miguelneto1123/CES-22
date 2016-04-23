
public class Buffer {
	private final int MAXSIZE = 512;
	private char keep[];
	private int count, front, rear;

	public synchronized char get() {
		try {
			while (count == 0)
				wait();
			char x = keep[rear];
			rear = (rear+1) % MAXSIZE;
			count--;
			notify(); // that a space is now available
			return x;
		} catch (InterruptedException i) {
			i.printStackTrace();
			return '\032';
		}
	}

	public synchronized void put(char x) {
		try {
			while (count == MAXSIZE)
				wait();
			keep[front] = x;
			front = (front+1) % MAXSIZE;
			count++;
			notify(); // that an item is now available
		} catch (InterruptedException i) {
			i.printStackTrace();
		}
	}
}