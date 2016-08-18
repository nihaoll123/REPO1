/**
 * 
 */
package sdtp.message;

/**
 * 连接释放请求
 * 
 * @author Administrator
 * 
 */
public class LinkRelReqMsg extends MessageBody {


	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 1;
	
	/**
	 * 1 Unsigned Integer 
	 * 连接释放的原因，各个值代表意义如下：
	 *  1: 用户正常释放。 
	 *  2: 数据类型错误。 
	 *  3: 超出机器处理能力。
	 */
	private int reason;

	public LinkRelReqMsg() {
		super();
	}

	public LinkRelReqMsg(SDTPMessage message) {
		super(message);
		reason = message.loadInt(1);
	}

	
	public int getReason() {
		return reason;
	}

	@Override
	public int getLength() {
		return BODY_LENGTH;
	}

	@Override
	public void encode() {
		message.writeInt(reason, 1);
	}

	public void setReason(int reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "LinkRelReqMsg [reason=" + reason + "]";
	}

}
