package scoket.main;

import java.net.Socket;

import scoket.server.Server;

public class ServiceMain {

	public static void main(String[] args) throws Exception {
		Server server=new Server(6066);
		Socket socket=server.accept();
		/*String rmsg=server.receiveMsg(socket);
		server.sendMsg(socket, rmsg);
*/
	}

}
