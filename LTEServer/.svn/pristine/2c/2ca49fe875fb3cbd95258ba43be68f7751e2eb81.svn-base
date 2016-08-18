package clent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import sdtp.util.MessageUtil;

/**
 * @comments
 * @author B
 * @date 2015-04-10
 * @version 1.0
 */
public class clent {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 26575;
	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private Messagedispose dispose = new Messagedispose();

	public void initSocket() throws IOException {
		System.out.println("初始化clent");
		socket = new Socket(SERVER_IP, SERVER_PORT);
		// 获取请求后服务器返回的数据流
		in = socket.getInputStream();
		// 获取向服务器发送请求的输入流
		out = socket.getOutputStream();
	}

	/**
	 * @Comments 版本验证请求
	 * @Vsersion: 1.0
	 */
	public boolean verNego_Req() {
		try {
			System.out.println("发起版本验证请求");
			out.write(verNego.verNego_Req());
			byte[] temp = new byte[2];
			int length = in.read(temp);
			if (length == -1) {
				throw new IOException("连接异常中断,未从输出流中读取到数据");
				// TODO数据异常
			}
			// 获取数据包总长度并构造缓冲区
			int totalLength = MessageUtil.byteArray2Int(temp).intValue();
			System.out.println("接收信息总长度" + totalLength);
			byte[] byteArray = new byte[totalLength - 2];
			length = in.read(byteArray);
			return dispose.unpack(byteArray);
		} catch (IOException e) {
		}
		return false;
	}

	/**
	 * @Comments 鉴权请求
	 * @Vsersion: 1.0
	 */
	public boolean linkAuth_Req() {
		try {
			System.out.println("发起鉴权请求");
			out.write(linkAuth.linkAuth_Req());
			byte[] temp = new byte[2];
			int length = in.read(temp);
			if (length == -1) {
				throw new IOException("连接异常中断,未从输出流中读取到数据");
				// TODO数据异常
			}
			// 获取数据包总长度并构造缓冲区
			int totalLength = MessageUtil.byteArray2Int(temp).intValue();
			System.out.println("接收信息总长度" + totalLength);
			byte[] byteArray = new byte[totalLength - 2];
			length = in.read(byteArray);
			return dispose.unpack(byteArray);
		} catch (IOException e) {
		}
		return false;
	}

	/**
	 * @Comments 链路检测
	 * @Vsersion: 1.0
	 */
	public boolean linkCheck_Req() {
		try {
			System.out.println("发起链路检测请求");
			out.write(linkCheck.linkCheck_Req());
			byte[] temp = new byte[2];
			int length = in.read(temp);
			if (length == -1) {
				throw new IOException("连接异常中断,未从输出流中读取到数据");
				// TODO数据异常
			}
			// 获取数据包总长度并构造缓冲区
			int totalLength = MessageUtil.byteArray2Int(temp).intValue();
			System.out.println("接收信息总长度" + totalLength);
			byte[] byteArray = new byte[totalLength - 2];
			length = in.read(byteArray);
			return dispose.unpack(byteArray);
		} catch (IOException e) {
		}
		return false;
	}

	/**
	 * @Comments 链路释放请求
	 * @Vsersion: 1.0
	 */
	public boolean linkRel_Req() {
		try {
			System.out.println("链路释放请求");
			out.write(linkRel.linkRel_Req());
			byte[] temp = new byte[2];
			int length = in.read(temp);
			if (length == -1) {
				throw new IOException("连接异常中断,未从输出流中读取到数据");
				// TODO数据异常
			}
			// 获取数据包总长度并构造缓冲区
			int totalLength = MessageUtil.byteArray2Int(temp).intValue();
			System.out.println("接收信息总长度" + totalLength);
			byte[] byteArray = new byte[totalLength - 2];
			length = in.read(byteArray);
			return dispose.unpack(byteArray);
		} catch (IOException e) {
		}
		return false;
	}

	/**
	 * @Comments 链路数据检测请求
	 * @Vsersion: 1.0
	 */
	public boolean linkDataCheck_Req() {
		try {
			System.out.println("链路数据检测请求");
			out.write(linkDataCheck.linkDataCheck_Req());
			byte[] temp = new byte[2];
			int length = in.read(temp);
			if (length == -1) {
				throw new IOException("连接异常中断,未从输出流中读取到数据");
				// TODO数据异常
			}
			// 获取数据包总长度并构造缓冲区
			int totalLength = MessageUtil.byteArray2Int(temp).intValue();
			System.out.println("接收信息总长度" + totalLength);
			byte[] byteArray = new byte[totalLength - 2];
			length = in.read(byteArray);
			return dispose.unpack(byteArray);
		} catch (IOException e) {
		}
		return false;
	}

	/**
	 * @Comments 链路数据检测请求
	 * @Vsersion: 1.0
	 */
	public boolean XDRRawDataSend_Req() {
		try {
			System.out.println("XDR对应原始数据传输请求");
			out.write(XDRRawDataSend.saaa());
			byte[] temp = new byte[2];
			int length = in.read(temp);
			if (length == -1) {
				throw new IOException("连接异常中断,未从输出流中读取到数据");
				// TODO数据异常
			}
			// 获取数据包总长度并构造缓冲区
			int totalLength = MessageUtil.byteArray2Int(temp).intValue();
			System.out.println("接收信息总长度" + totalLength);
			byte[] byteArray = new byte[totalLength - 2];
			length = in.read(byteArray);
			return dispose.unpack(byteArray);
		} catch (IOException e) {
		}
		return false;
	}

}