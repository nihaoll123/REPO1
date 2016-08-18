/**
 * 
 */
package sdtp.message;

/**
 * 连接释放应答
 * @author Administrator
 *
 */
public class LinkRelRespMsg extends MessageBody {

	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 1;
	
	/**
	 * Result	
	 * 1	Unsigned Integer	
	 * 连接释放的完成状态
	 * 1：释放完成。
	 * 其它：释放失败。
	 */
	private int result;
	
	public LinkRelRespMsg(SDTPMessage message) {
		super(message);
		result = message.loadInt(1);
	}

	public LinkRelRespMsg(){
		super();
	}

	public int getResult() {
		return result;
	}

	@Override
	public int getLength() {
		return BODY_LENGTH;
	}

	@Override
	public void encode() {
		message.writeInt(result, 1);		
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "LinkRelRespMsg [result=" + result + "]";
	}
	

}
