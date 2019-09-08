import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Network_Client {
	public static void main(String[] args) {
		
		Socket 			socket = null;
		BufferedReader 	stdin = null;
		InputStream 	in = null;
		OutputStream 	out = null;
		BufferedReader 	reader = null;
		PrintWriter 	writer = null;
		
		try {
			socket = new Socket("127.0.0.1", 6767);
			System.out.println("Access Approved");

			in = socket.getInputStream();
			out = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(new OutputStreamWriter(out));
			stdin = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			String echo = null;

			while ((msg = stdin.readLine()) != null) {
				writer.println(msg);
				writer.flush();
				echo = reader.readLine();
				System.out.println("\tServer>" + echo);
			}
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			try {
				stdin.close();
				reader.close();
				writer.close();
				in.close();
				out.close();
				socket.close();
				System.out.println("End");
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}
	}

}