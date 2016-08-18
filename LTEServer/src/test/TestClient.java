package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Random;

import sdtp.message.LinkAuthReqMsg;
import sdtp.message.LinkAuthRespMsg;
import sdtp.message.LinkCheckReqMsg;
import sdtp.message.LinkCheckRespMsg;
import sdtp.message.LinkDataCheckReqMsg;
import sdtp.message.LinkDataCheckRespMsg;
import sdtp.message.LinkRelReqMsg;
import sdtp.message.LinkRelRespMsg;
import sdtp.message.MessageType;
import sdtp.message.SDTPMessage;
import sdtp.message.VerNegoReqMsg;
import sdtp.message.VerNegoRespMsg;
import sdtp.message.XDRDataNotifyReqMsg;
import sdtp.message.XDRDataNotifyRespMsg;
import sdtp.message.XDRRawDataSendReqMsg;
import sdtp.message.XDRRawDataSendRespMsg;
import sdtp.util.AuthUtil;
import sdtp.util.MessageUtil;
import Server.SDTPServer;

public class TestClient {
	private Socket socket;
	private InputStream in;
	private OutputStream out;
	
	/**
	 * 交互的流水号
	 */
	private static int sequenceId = 1;
	
	private static int sendFlag = 1;
	
	private static int sendDataInfo =0;
	
	private static final int majorVersion = 2;
	private static final int minorVersion = 2;
	
	private static final String loginID = "123456789012";
	private static final String SHARD_SECRET = "987654321021";
	
	
	public static void main(String[] args) {
		TestClient client = new TestClient();
		try {
			client.initSocket();
			int reason = 2;
			VerNegoRespMsg verNegoResp = client.testVerNegoReq();
			if(verNegoResp.getResult() == 1){	//版本验证通过
				LinkAuthRespMsg linkAuthResp = client.testlinkAuth();
				
				if(linkAuthResp.getResult() == 1){	//鉴权通过
					LinkCheckRespMsg linkCheckRespMsg = client.testLinkCheck();
					XDRRawDataSendRespMsg rawDataResp1 = client.testXDRRawDataSend();
					XDRRawDataSendRespMsg rawDataResp2 = client.testXDRRawDataSend();
					XDRDataNotifyRespMsg dataNoifyResp1 = client.testXDRDataNoify();
					LinkDataCheckRespMsg linkDataCheckResp = client.testLinkDataCheck();
					reason = 1;
				}
			}
			client.testLinkRelReq(reason);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			client.release();
		}
		
	}
	
	/**
	 * 初始化连接
	 * @throws IOException
	 */
	private void initSocket() throws IOException {
		socket = new Socket("127.0.0.1", SDTPServer.SERVER_PORT);
		in = socket.getInputStream();
		out = socket.getOutputStream();
		
	}
	
	/**
	 * 获取流水号，每次加1
	 * @return
	 */
	private static int getSequenceId(){
		return sequenceId++;
	}
	
	/**
	 * 检测包顺序标签，1小时内不重复即可。本参数目的是为发现校验包的丢失情况发生。
	 * @return
	 */
	public static int getSendFlag() {
		return sendFlag++;
	}
	
	private VerNegoRespMsg testVerNegoReq() throws IOException{
		//构造消息头
		SDTPMessage reqMsg = new SDTPMessage();
		reqMsg.setMessageType(MessageType.verNego_Req);
		reqMsg.setSequenceId(getSequenceId());
		//构造消息体
		VerNegoReqMsg reqBody = new VerNegoReqMsg();
		reqBody.setMessage(reqMsg);
		reqBody.setVersion(majorVersion);
		reqBody.setSubVersion(minorVersion);

		//发送请求包
		writeRequest(reqMsg);
		
		SDTPMessage respMsg = readRespMsg();
		VerNegoRespMsg respBody = (VerNegoRespMsg) respMsg.getMsgBody();
		return respBody;
	}
	


	private LinkAuthRespMsg testlinkAuth() throws IOException {
		//构造消息头
		SDTPMessage reqMsg = new SDTPMessage();
		reqMsg.setMessageType(MessageType.linkAuth_Req);
		reqMsg.setSequenceId(getSequenceId());
		//构造消息体
		LinkAuthReqMsg reqBody = new LinkAuthReqMsg();
		reqBody.setMessage(reqMsg);
		long timestamp = System.currentTimeMillis()/1000;
		Random random = new Random(timestamp);
		int rand = random.nextInt(Short.MAX_VALUE);
		String secretHash = AuthUtil.hashStr(SHARD_SECRET);
		String digest = AuthUtil.hashStr(loginID + secretHash
				+ timestamp + "rand=" + rand);

		reqBody.setLoginID(loginID);
		reqBody.setTimestamp(timestamp);
		reqBody.setRand(rand);
		reqBody.setDigest(digest);
		
		//发送请求包
		writeRequest(reqMsg);
		
		SDTPMessage respMsg = readRespMsg();
		LinkAuthRespMsg respBody = (LinkAuthRespMsg) respMsg.getMsgBody();
		return respBody;
	}


	private LinkCheckRespMsg testLinkCheck() throws IOException {
		//构造消息头
		SDTPMessage reqMsg = new SDTPMessage();
		reqMsg.setMessageType(MessageType.linkCheck_Req);
		reqMsg.setSequenceId(getSequenceId());
		
		//构造消息体
		LinkCheckReqMsg reqBody = new LinkCheckReqMsg();
		reqBody.setMessage(reqMsg);

		//发送请求包
		writeRequest(reqMsg);
		
		SDTPMessage respMsg = readRespMsg();
		LinkCheckRespMsg respBody = (LinkCheckRespMsg) respMsg.getMsgBody();
		
		return respBody;
	}
	
	private XDRDataNotifyRespMsg testXDRDataNoify() throws IOException {
		//构造消息头
		SDTPMessage reqMsg = new SDTPMessage();
		reqMsg.setMessageType(MessageType.notifyXDRData_Req);
		reqMsg.setSequenceId(getSequenceId());
		
		//构造消息体
		XDRDataNotifyReqMsg reqBody = new XDRDataNotifyReqMsg();
		reqBody.setMessage(reqMsg);
		
		// TODO 这里塞entity
		byte[] xdrData = {123};
		reqBody.setData(xdrData);
		
		//发送请求包
		writeRequest(reqMsg);
		sendDataInfo++;
		SDTPMessage respMsg = readRespMsg();
		XDRDataNotifyRespMsg respBody = (XDRDataNotifyRespMsg) respMsg.getMsgBody();
		return respBody;
		
	}

	private XDRRawDataSendRespMsg testXDRRawDataSend() throws IOException {
		//构造消息头
		SDTPMessage reqMsg = new SDTPMessage();
		reqMsg.setMessageType(MessageType.XDRRawDataSend_Req);
		reqMsg.setSequenceId(getSequenceId());
		
		//构造消息体
		XDRRawDataSendReqMsg reqBody = new XDRRawDataSendReqMsg();
		reqBody.setMessage(reqMsg);
		
		// TODO 这里塞entity
		byte[] xdrData = {123};
		reqBody.setData(xdrData);
		
		//发送请求包
		writeRequest(reqMsg);
		sendDataInfo++;
		SDTPMessage respMsg = readRespMsg();
		XDRRawDataSendRespMsg respBody = (XDRRawDataSendRespMsg) respMsg.getMsgBody();
		return respBody;
	}

	
	private LinkDataCheckRespMsg testLinkDataCheck() throws IOException {
		//构造消息头
		SDTPMessage reqMsg = new SDTPMessage();
		reqMsg.setMessageType(MessageType.linkDataCheck_Req);
		reqMsg.setSequenceId(getSequenceId());
		
		//构造消息体
		LinkDataCheckReqMsg reqBody = new LinkDataCheckReqMsg();
		reqBody.setMessage(reqMsg);
		
		reqBody.setSendFlag(getSendFlag());
		reqBody.setSendDataInfo(sendDataInfo);
		
		//发送请求包
		writeRequest(reqMsg);
		SDTPMessage respMsg = readRespMsg();
		LinkDataCheckRespMsg respBody = (LinkDataCheckRespMsg) respMsg.getMsgBody();
		return respBody;
	}

	private LinkRelRespMsg testLinkRelReq(int reason) throws IOException {
		//构造消息头
		SDTPMessage reqMsg = new SDTPMessage();
		reqMsg.setMessageType(MessageType.linkRel_Req);
		reqMsg.setSequenceId(getSequenceId());
		
		//构造消息体
		LinkRelReqMsg reqBody = new LinkRelReqMsg();
		reqBody.setMessage(reqMsg);
		
		reqBody.setReason(reason);

		//发送请求包
		writeRequest(reqMsg);
		
		SDTPMessage respMsg = readRespMsg();
		LinkRelRespMsg respBody = (LinkRelRespMsg) respMsg.getMsgBody();
		
		return respBody;
		
	}

	
	/**
	 * 读取响应包
	 * TODO 如果服务器端数据无法实时返回，应将响应包存入map再根据流水号提取
	 * @return
	 * @throws IOException
	 */
	private SDTPMessage readRespMsg() throws IOException {
		SDTPMessage message = null;
		byte[] temp = new byte[2];
		int length = in.read(temp);
		if (length == -1) {
			throw new IOException("连接异常中断,未从输出流中读取到数据");
		}
		// 获取数据包总长度并构造缓冲区
		int totalLength = MessageUtil.byteArray2Int(temp).intValue();
		
		byte[] byteArray = new byte[totalLength - 2];
		length = in.read(byteArray);

		System.out.println("\n数据包长度:" + totalLength+",字节内容:\n"+Arrays.toString(byteArray));
		message = new SDTPMessage(totalLength, byteArray);
		System.out.println("接收到响应包,数据类型:" + message.getMessageType().getDesc() +"\n"+message.toString());
		return message;
	}
	

	/**
	 * 发送请求包,该方法会调用SDTPMessage.encodeMessage()方法，请不要重复调用
	 * @param reqMsg
	 * @throws IOException
	 */
	private void writeRequest(SDTPMessage reqMsg) throws IOException {
		reqMsg.encodeMessage();
		System.out.println("\n准备发送请求包,数据类型:" + reqMsg.getMessageType().getDesc() +",数据包长度:" + reqMsg.getTotalLength()+",字节内容:\n"+Arrays.toString(reqMsg.getBuffer().array())+"\n"+reqMsg.toString());
		out.write(reqMsg.getBuffer().array());
	}

	/**
	 * 关闭流
	 */
	private void release() {
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
