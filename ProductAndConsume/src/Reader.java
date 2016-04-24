
public class Reader extends Thread {
	private Buffer b;
	
	public void run() {
		char x;
		while ((x = b.get()) != '\032') {
			System.out.print(x);
		}
	}
	
	public Reader (Buffer b) {
		this.b = b;
	}
}
