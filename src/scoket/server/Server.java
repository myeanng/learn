package scoket.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * 
 * @author Administrator 2016-4-26 14:04:10
 */
public class Server{

	private int prot;

	private ServerSocket server;

	public int getProt() {
		return prot;
	}

	public void setProt(int prot) {
		this.prot = prot;
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public Server(int prot) {
		super();
		this.prot = prot;
		try {
			server = new ServerSocket(prot);
			// 设置超时
			//server.setSoTimeout(1000);
		} catch (IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	public Socket accept() throws Exception {
		return server.accept();
	}

	public void sendMsg(Socket socket, String msg) throws Exception {
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(msg);
		System.out.println("SERVER SEND MSG:" + msg);
		out.close();
	}

	public String receiveMsg(Socket socket) throws Exception {
		String receiveMsg;
		DataInputStream in = new DataInputStream(socket.getInputStream());
		receiveMsg = in.readUTF();
		System.out.println("SERVER已接受客户端发送的信息：" + receiveMsg);
		return receiveMsg;
	}
}
