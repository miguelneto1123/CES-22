import java.io.*;

public class Writer extends Thread{
	private Buffer b;
	private FileInputStream fs;
	public void run() {
		int x;
		try {
			while ((x = fs.read()) != -1){
				b.put((char) x);
			}
			b.put('\032');
		} catch (Exception e) {
			System.err.println("Cannot read");
			System.exit(1);
		}
	}
	public Writer (String fname, Buffer b) {
		this.b = b;
		try {
			fs = new FileInputStream(fname);
		} catch (Exception e) {
			fs = null;
			System.err.println("Can't open " + fname);
			System.exit(1);
		}
	}
}
