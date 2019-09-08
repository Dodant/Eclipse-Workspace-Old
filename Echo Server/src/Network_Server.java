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

public class Network_Server {
	public static void main(String[] args) {

		ServerSocket 	server = null;
		Socket 			socket = null;
		InetAddress 	inetAddr = null;
		InputStream 	in = null;
		OutputStream 	out = null;
		BufferedReader 	reader = null;
		PrintWriter 	writer = null;

		try {
			server = new ServerSocket(6767);

			System.out.println("Client Access Waiting (port:" + server.getLocalPort() + ")");
			socket = server.accept();

			inetAddr = server.getInetAddress();
			System.out.println("Client(" + inetAddr.getHostAddress() + ") Access");

			in = socket.getInputStream();
			out = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(new OutputStreamWriter(out));
			String msg = null;

			while ((msg = reader.readLine()) != null) {
				System.out.println("\tCLIENT>" + msg);
				writer.println(msg);
				writer.flush();
			}
		} catch (IOException ie) {
			System.out.println(ie);
		} finally {
			try {
				reader.close();
				writer.close();
				in.close();
				out.close();
				socket.close();
				server.close();
				System.out.println("End");
			} catch (IOException ie) {
				System.out.println(ie);
			}
		}
	}
}