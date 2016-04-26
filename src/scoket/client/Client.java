package scoket.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 
 * @author Administrator 2016-4-26 13:39:33
 */
public class Client {
	private String serverName;
	private int prot;
	private Socket socket;

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getProt() {
		return prot;
	}

	public void setProt(int prot) {
		this.prot = prot;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Client(String serverName, int prot) {
		super();
		this.serverName = serverName;
		this.prot = prot;
		try {
			socket = new Socket(serverName, prot);
		} catch (UnknownHostException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	public String sendMsg(String msg) throws Exception {
		String receiveMsg;
		System.out.println("CLIENT连接到：" + socket.getRemoteSocketAddress());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		msg = "发送者：" + socket.getLocalSocketAddress() + "[" + msg + "]";
		out.writeUTF(msg);
		System.out.println("CLIENT已发送~");
		System.out.println("CLIENT开始接收SERVER返回的信息~");
		DataInputStream in = new DataInputStream(socket.getInputStream());
		receiveMsg = in.readUTF();
		System.out.println("CLIENT接收的消息内容：" + receiveMsg);
		System.out.println("CLIENT关闭流~");
		out.close();
		in.close();
		return receiveMsg;
	}

	public void close() throws Exception {
		socket.close();
	}
}
