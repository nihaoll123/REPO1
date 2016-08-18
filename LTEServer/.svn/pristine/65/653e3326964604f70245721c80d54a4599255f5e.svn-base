package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SDTPServer implements Runnable {

	public static final int SERVER_PORT = 26575;
	private ServerSocket socket;

	@Override
	public void run() {
		try {
			socket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return;
		}
		while (true) {
			try {
				Socket socketclient = socket.accept();
				SDTPRequestThred requestThred = new SDTPRequestThred(socketclient);
				new Thread(requestThred).start();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
	}

}
