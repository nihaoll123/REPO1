package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

import sdtp.message.SDTPMessage;
import sdtp.util.MessageUtil;

public class SDTPRequestThred implements Runnable {

	// private static final int BUF_SIZE = 8000;

	private Socket socket;
	private OutputStream out;
	private InputStream in;
	private boolean flag = false;

	/**
	 * 距离上次发送间接收的数据包数量。
	 */
	private int recDataInfo = 0;
	
	
	public SDTPRequestThred(Socket socket) {
		this.socket = socket;
		try {
			this.in = socket.getInputStream();
			this.out = socket.getOutputStream();
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
			release();
		}
	}

	@Override
	public void run() {
		while (flag) {
			SDTPMessage message = null;
			try {
				// 读取消息头以获取消息长度
				byte[] temp = new byte[2];
				int length = in.read(temp);
				if (length == -1) {
					throw new IOException("连接异常中断,未从输出流中读取到数据");
					// TODO数据异常
				}
				// 获取数据包总长度并构造缓冲区
				int totalLength = MessageUtil.byteArray2Int(temp).intValue();
				byte[] byteArray = new byte[totalLength - 2];
				length = in.read(byteArray);

				System.out.println("数据包长度:" + totalLength+",字节内容:\n"+Arrays.toString(byteArray));
				message = new SDTPMessage(totalLength, byteArray);
				System.out.println("接收到请求包,数据类型:" + message.getMessageType().getDesc() +"\n"+message.toString());
				SDTPMessage respMsg = dealMessage(message);
				System.out.println("准备发送响应包,数据类型:" + respMsg.getMessageType().getDesc() +",数据包长度:" + respMsg.getTotalLength()+",字节内容:\n"+Arrays.toString(respMsg.getBuffer().array())+"\n"+respMsg.toString());
				
				out.write(respMsg.getBuffer().array());
			} catch (Exception e) {
				try {
					// 按文档的意思好像不管出啥问题，只要链接没关都要尝试往客户端发个链接释放的响应来着？
					if (!socket.isClosed() && !socket.isOutputShutdown()) {
						SDTPMessage respMsg = MessageUtil.dealLinkRel(message);
						out.write(respMsg.getBuffer().array());
					}
				} catch (IOException e1) {
					//这里抛异常是正常的就不打印了
				} finally {
					e.printStackTrace();
					release();
				}
			}
		}
		System.out.println("客户端断开连接");
	}

	/**
	 * 处理消息
	 * 
	 * @param message
	 */
	// 重构
	private SDTPMessage dealMessage(SDTPMessage message) {
		SDTPMessage respMsg = null;
		switch (message.getMessageType()) {
		case verNego_Req:
			respMsg = MessageUtil.dealVerNego(message);
			break;
		case linkAuth_Req:
			respMsg = MessageUtil.dealLinkAuth(message);
			break;
		case linkCheck_Req:
			respMsg = MessageUtil.dealLinkCheck(message);
			break;
		case notifyXDRData_Req:
			recDataInfo++;
			respMsg = MessageUtil.dealXDRDataNoify(message);
			break;
		case XDRRawDataSend_Req:
			recDataInfo++;
			respMsg = MessageUtil.dealXDRDataSend(message);
			break;
		case linkDataCheck_Req:
			respMsg = MessageUtil.dealLinkDataCheck(message,recDataInfo);
			break;
		case linkRel_Req:
			respMsg = MessageUtil.dealLinkRel(message);
			flag = false;
			break;
		default:
			throw new IllegalArgumentException("错误的消息类型");
		}
		return respMsg;
	}

	/**
	 * 关闭流
	 */
	private void release() {
		flag = false;
		try {
			if (out != null) {
				out.flush();
				out.close();
			}
			if (in != null) {
				in.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
