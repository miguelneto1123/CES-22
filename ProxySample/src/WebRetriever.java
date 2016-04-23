import java.io.*;
import java.net.*;

class WebRetriever {
	private Socket soc;
	private OutputStream os;
	private InputStream is;
	
	WebRetriever(String server, int port)
			throws IOException, UnknownHostException {
			soc = new Socket(server, port);
			os = soc.getOutputStream();
			is = soc.getInputStream();
	}

	public void request(String path) {
		try {
			String message = "GET " + path + "\n\n";
			os.write(message.getBytes());
			os.flush();
		} catch (IOException e) {
			System.err.println("Error in HTTP request");
		}
	}
	public void getResponse() {
		int c;
		try {
			while ((c = is.read()) != -1)
				System.out.print((char) c) ;
		} catch (IOException e) {
			System.err.println("IOException in reading from " +
					"Web server");
		}
	}
	public void close() {
		try {
			is.close(); os.close(); soc.close();
		} catch (IOException e) {
			System.err.println("IOException in closing connection");
		}
	}
	
	public static void main(String[] args) {
		try {
			WebRetriever w = new WebRetriever("www.nus.edu.sg", 80);
			w.request("/NUSinfo/UG/ug.html");
			w.getResponse();
			w.close();
		} catch (UnknownHostException h) {
			System.err.println("Hostname Unknown");
		} catch (IOException i) {
			System.err.println("IOException in connecting to Host");
		}
	}
}