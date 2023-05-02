import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) {

		try {
			
			ServerSocket ss = new ServerSocket(1709);
			System.out.println("Server is Starting and waiting for client request ......");
			Socket s = ss.accept();
//			System.out.println(s);
			
			while (true) {
				InputStream input = s.getInputStream();
				DataInputStream data = new DataInputStream(input);
				String string = (String)data.readUTF();
				System.out.println(string);
				
				Scanner sc = new Scanner(System.in);
				OutputStream output = s.getOutputStream();
				DataOutputStream outdata = new DataOutputStream(output);
				
				if (!outdata.equals("")) {
					String writeline = sc.nextLine();
					outdata.writeUTF(writeline);
				}
				else
				{
					outdata.flush();
					outdata.close();
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
