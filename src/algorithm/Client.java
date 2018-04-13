package algorithm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try(Socket client = new Socket("localhost", 8888)) {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String s;
			out.println("ABCD");
			s = in.readLine();
			System.out.println(s);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
