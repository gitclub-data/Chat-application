package pandey.application.chat.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerHandler implements Runnable{
	
	private Socket server;
	private BufferedReader in;
	
	public ServerHandler(Socket s) throws IOException {
		server =s;
		in=new BufferedReader(new InputStreamReader(server.getInputStream()));
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
			String serverResponse;
			try {
				while(true) {
				serverResponse = in.readLine();
				if(serverResponse==null) break;
				System.out.println(serverResponse);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	}

}
