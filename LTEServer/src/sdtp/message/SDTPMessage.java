package sdtp.message;

import java.math.BigInteger;
import java.nio.ByteBuffer;

import sdtp.util.MessageUtil;

/**
 * 
 * @author Administrator
 * 
 */
public class SDTPMessage {

	/**
	 * SDTP协议消息头长度 *
	 */
	static final int HEADER_LENGTH = 9;

	/**
	 * 2 Unsigned Integer 消息总长度(含消息头及消息体)
	 */
	private int totalLength;

	/**
	 * 2 Unsigned Integer 消息类型
	 */
	private MessageType messageType;

	/**
	 * 4 Unsigned Integer 交互的流水号，顺序累加，步长为1，循环使用（一个交互的一对请求和应答消息的流水号必须相同）
	 */
	private int sequenceId;

	/**
	 * 1 Unsigned Integer 消息体中的事件数量（最多40条） 若考虑实时性要求，可每次只填一个事件
	 */
	private int totalContents;

	private MessageBody msgBody;

	private ByteBuffer buffer;

	public SDTPMessage() {
	}

	/**
	 * 根据字节数据构造消息
	 * TODO 这种方式生成的类buffer中不包含totalLength的字节数据，如后期需要修改要修改这个方法
	 * @param totalLength
	 *            消息总长度
	 * @param data
	 *            消息数据(不包括totalLength)
	 */
	public SDTPMessage(int totalLength, byte[] data) {
		this.totalLength = totalLength;
		this.buffer = ByteBuffer.wrap(data);
		// 消息类型
		int iMessageType = loadInt(2);
		messageType = MessageType.getEnum(iMessageType);
		// 流水号
		sequenceId = loadInt(4);
		// 事件数量
		totalContents = loadInt(1);

		decodeMsgBody();
	}

	/**
	 * 根据消息类型解析消息体
	 */
	private void decodeMsgBody() {
		switch (messageType) {
		case verNego_Req:
			msgBody = new VerNegoReqMsg(this);
			break;
		case verNego_Resp:
			msgBody = new VerNegoRespMsg(this);
			break;
		case linkAuth_Req:
			msgBody = new LinkAuthReqMsg(this);
			break;
		case linkAuth_Resp:
			msgBody = new LinkAuthRespMsg(this);
			break;
		case linkCheck_Req:
			msgBody = new LinkCheckReqMsg(this);
			break;
		case linkCheck_Resp:
			msgBody = new LinkCheckRespMsg(this);
			break;
		case XDRRawDataSend_Req:
			msgBody = new XDRRawDataSendReqMsg(this);
			break;
		case XDRRawDataSend_Resp:
			msgBody = new XDRRawDataSendRespMsg(this);
			break;
		case notifyXDRData_Req:
			msgBody = new XDRDataNotifyReqMsg(this);
			break;
		case notifyXDRData_Resp:
			msgBody = new XDRDataNotifyRespMsg(this);
			break;	
		case linkDataCheck_Req:
			msgBody = new LinkDataCheckReqMsg(this);
			break;
		case linkDataCheck_Resp:
			msgBody = new LinkDataCheckRespMsg(this);
			break;
		case linkRel_Req:
			msgBody = new LinkRelReqMsg(this);
			break;
		case linkRel_Resp:
			msgBody = new LinkRelRespMsg(this);
			break;
		default:
			throw new IllegalArgumentException("错误的消息类型");
		}
	}

	/**
	 * 根据消息内容构造消息和字节数据
	 * 
	 * @param messageType
	 * @param sequenceId
	 * @param totalContents
	 * @param messageBody
	 * @return
	 */
	public void encodeMessage() {
		this.totalLength = HEADER_LENGTH + msgBody.getLength();
		this.totalContents =1;
		
		buffer = ByteBuffer.allocate(totalLength);
		writeInt(totalLength, 2);
		writeInt(messageType.getValue(), 2);
		writeInt(sequenceId, 4);
		writeInt(totalContents, 1);
		msgBody.encode();
	}

	// 从byteBuffer中读数据
	// TODO 边界检查
	/**
	 * 从buff中读取指定长度的数据并转换为int buffer的pos会改变所以需要按顺序读取
	 * 
	 * @param length
	 * @return
	 */
	public int loadInt(int length) {
		return MessageUtil.byteArray2Int(loadByte(length)).intValue();
	}

	/**
	 * 从buff中读取指定长度的数据并转换为string buffer的pos会改变所以需要按顺序读取
	 * 
	 * @param length
	 * @return
	 */
	public String loadStr(int length) {
		return new String(loadByte(length));

	}
	
	/**
	 * 从buff中读取指定长度的数据,buffer的pos会改变所以需要按顺序读取
	 * 
	 * @param length
	 * @return
	 */
	public byte[] loadByte(int length) {
		byte[] temp = new byte[length];
		buffer.get(temp);
		return temp;

	}
	

	/**
	 * 从buff中读取指定长度的数据并转换为long buffer的pos会改变所以需要按顺序读取
	 * 
	 * @param length
	 * @return
	 */
	public long loadLong(int length) {
		byte[] temp = new byte[length];
		buffer.get(temp);
		return MessageUtil.byteArray2Int(temp).longValue();

	}

	// 向bytebuffer中写数据

	protected void writeInt(int data, int length) {
		byte[] arr = MessageUtil.int2ByteArray(BigInteger.valueOf(data),length);
		buffer.put(arr);
	}
	
	protected void writeLong(long data, int length) {
		byte[] arr = MessageUtil.int2ByteArray(BigInteger.valueOf(data),length);
		buffer.put(arr);
	}
	
	protected void writeStr(String data, int length) {
		byte[] arr = MessageUtil.str2ByteArray(data, length);
		buffer.put(arr);
	}
	
	protected void writeByte(byte[] data, int length) {
		buffer.put(data);
	}
	

	public ByteBuffer getBuffer() {
		return buffer;
	}

	public int getTotalLength() {
		return totalLength;
	}

	public int getSequenceId() {
		return sequenceId;
	}

	public int getTotalContents() {
		return totalContents;
	}

	public MessageBody getMsgBody() {
		return msgBody;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public void setTotalLength(int totalLength) {
		this.totalLength = totalLength;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}

	public void setTotalContents(int totalContents) {
		this.totalContents = totalContents;
	}

	public void setMsgBody(MessageBody msgBody) {
		this.msgBody = msgBody;
	}

	public void setBuffer(ByteBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public String toString() {
		return "SDTPMessage [totalLength=" + totalLength + ", messageType=" + messageType + ", sequenceId="
				+ sequenceId + ", totalContents=" + totalContents + "]\n"+"msgBody=" + msgBody;
	}

}
