import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class MyClient {

	public static void main(String[] args) {

		try {

			Socket s = new Socket("localhost", 1709);
//			System.out.println(s);
//			data.writeUTF("Hello Server");

			
			while (true) {
				Scanner sc = new Scanner(System.in);
				OutputStream output = s.getOutputStream();
				DataOutputStream data = new DataOutputStream(output);
				
				if (!data.equals("")) {
					String writeline = sc.nextLine();
					data.writeUTF(writeline);
				}
				else
				{
					data.flush();
					data.close();
					break;
				}
				
				InputStream input = s.getInputStream();
				DataInputStream indata = new DataInputStream(input);
				String string = (String)indata.readUTF();
				System.out.println(string);
			}


		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
