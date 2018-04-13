package algorithm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args){
		try(ServerSocket sever = new ServerSocket(8888)) {
			while(true){
				try(Socket socket = sever.accept()) {
					InputStream in = new BufferedInputStream(socket.getInputStream());
					PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			        StringBuilder request = new StringBuilder(80);
			        while (true) {
			          int c = in.read();
			          if (c == '\r' || c == '\n' || c == -1) break;
			          request.append((char) c);
			        }
					out.println(request.toString()+">>>>");
					out.close();
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
