package scoket.server;

import java.net.Socket;

public class ServerService {
	public void start(int prot) throws Exception{
		Server server=new Server(prot);
		Socket socket=server.accept();
		String rmsg=server.receiveMsg(socket);
		server.sendMsg(socket, rmsg);
	}
}
