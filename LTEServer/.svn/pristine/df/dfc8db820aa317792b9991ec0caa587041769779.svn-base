package sdtp.message;

public class LinkDataCheckRespMsg extends MessageBody {
	
	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 13;
	
	/**
	 * 4	Int	
	 * 检测包顺序标签，1小时内不重复即可。（与请求包相同）
	 */
	private int sendFlag;
	
	/**
	 * 1	int	
	 * 0：数据量正确；
	 * 1：接收方数据小于发送方数据；
	 * 2：接收方；数据大于发送方数据。
	 */
	private int result;
	
	/**
	 * 4	int	
	 * 距离上次发送间发送的数据包数量。
	 * （仅包含notifyXDRData_Req和XDRRawDataSend_Req包的数量）（与请求包相同）
	 */
	private int sendDataInfo;
	
	/**
	 * 4	int	
	 * 距离上次发送间接收的数据包数量。
	 * （仅包含notifyXDRData_Req和XDRRawDataSend_Req包的数量）
	 */
	private int recDataInfo;

	public LinkDataCheckRespMsg() {
		super();
	}

	public LinkDataCheckRespMsg(SDTPMessage message) {
		super(message);
		sendFlag = message.loadInt(4);
		result = message.loadInt(1);
		sendDataInfo = message.loadInt(4);
		recDataInfo = message.loadInt(4);
	}

	@Override
	public int getLength() {
		return BODY_LENGTH;
	}

	@Override
	public void encode() {
		message.writeInt(sendFlag, 4);
		message.writeInt(result, 1);
		message.writeInt(sendDataInfo, 4);
		message.writeInt(recDataInfo, 4);
	}

	public int getSendFlag() {
		return sendFlag;
	}

	public void setSendFlag(int sendFlag) {
		this.sendFlag = sendFlag;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getSendDataInfo() {
		return sendDataInfo;
	}

	public void setSendDataInfo(int sendDataInfo) {
		this.sendDataInfo = sendDataInfo;
	}

	public int getRecDataInfo() {
		return recDataInfo;
	}

	public void setRecDataInfo(int recDataInfo) {
		this.recDataInfo = recDataInfo;
	}

	@Override
	public String toString() {
		return "LinkDataCheckRespMsg [sendFlag=" + sendFlag + ", result=" + result + ", sendDataInfo=" + sendDataInfo
				+ ", recDataInfo=" + recDataInfo + "]";
	}

}
