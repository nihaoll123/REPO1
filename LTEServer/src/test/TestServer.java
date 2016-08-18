package test;

import Server.SDTPServer;

public class TestServer {

	public static void main(String[] args) {
		SDTPServer server = new SDTPServer();
		server.run();
	}
}