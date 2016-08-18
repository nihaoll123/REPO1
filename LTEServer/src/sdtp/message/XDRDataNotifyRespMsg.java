package sdtp.message;

public class XDRDataNotifyRespMsg extends MessageBody {

	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 1;

	/**
	 * 1	Unsigned Integer	
	 * 请求的返回结果：
	 * 1 代表成功
	 * 其它代表失败
	 */
	private int result;
	
	public XDRDataNotifyRespMsg() {
		super();
	}

	public XDRDataNotifyRespMsg(SDTPMessage message) {
		super(message);
		message.loadInt(1);
	}

	@Override
	public int getLength() {
		return BODY_LENGTH;
	}

	@Override
	public void encode() {
		message.writeInt(result, 1);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
