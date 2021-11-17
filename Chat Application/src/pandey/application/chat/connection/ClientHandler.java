package pandey.application.chat.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private BufferedReader keyinp;
	public ClientHandler(Socket clientsocket) throws IOException {
		client=clientsocket;
		in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		keyinp=new BufferedReader(new InputStreamReader(System.in));
		out=new PrintWriter(client.getOutputStream(),true);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				String clientsays=in.readLine();
				System.out.println("Client Says: "+clientsays);
				System.out.print(">>");
				String cmd=keyinp.readLine();
				if(cmd=="quit") break;
				out.println(cmd);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			out.close();
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
