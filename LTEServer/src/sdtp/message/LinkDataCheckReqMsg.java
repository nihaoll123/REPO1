/**
 * 
 */
package sdtp.message;

/**
 * @author Administrator
 *
 */
public class LinkDataCheckReqMsg extends MessageBody {
	
	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 8;
	
	/**
	 * 4	Int	
	 * 检测包顺序标签，1小时内不重复即可。本参数目的是为发现校验包的丢失情况发生。
	 */
	private int sendFlag;
	
	/**
	 * 4	int	
	 * 距离上次发送间发送的数据包数量。
	 * （仅仅包含notifyXDRData_Req和XDRRawDataSend_Req包的数量）
	 */
	private int sendDataInfo;
	

	public LinkDataCheckReqMsg() {
		super();
	}

	public LinkDataCheckReqMsg(SDTPMessage message) {
		super(message);
		sendFlag = message.loadInt(4);
		sendDataInfo = message.loadInt(4);
	}

	@Override
	public int getLength() {
		return BODY_LENGTH;
	}

	@Override
	public void encode() {
		message.writeInt(sendFlag, 4);
		message.writeInt(sendDataInfo, 4);
	}

	public int getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(int sendFlag) {
		this.sendFlag = sendFlag;
	}

	public int getSendDataInfo() {
		return sendDataInfo;
	}

	public void setSendDataInfo(int sendDataInfo) {
		this.sendDataInfo = sendDataInfo;
	}

	@Override
	public String toString() {
		return "LinkDataCheckReqMsg [sendFlag=" + sendFlag + ", sendDataInfo=" + sendDataInfo + "]";
	}

}
