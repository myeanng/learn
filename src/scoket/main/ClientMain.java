package scoket.main;

import scoket.client.Client;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		Client c1 = new Client("192.168.56.1", 6066);
		c1.sendMsg("aaa");

	}

}
