package sdtp.message;


/**
 * 版本协商应答
 * 
 * @author Administrator
 * 
 */
public class VerNegoRespMsg extends MessageBody {

	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 1;

	public VerNegoRespMsg(SDTPMessage message) {
		super(message);
		result = message.loadInt(1);
	}

	public VerNegoRespMsg() {
		super();
	}

	/**
	 * 1 Unsigned Integer <br/>
	 * 返回原因值。 <br/>
	 * 协议协商的结果，各个值代表意义如下： <br/>
	 * 1: 版本协商通过。 <br/>
	 * 2: 版本过高。 <br/>
	 * 3: 版本过低。<br/>
	 */
	private int result;

	public int getResult() {
		return result;
	}

	@Override
	public int getLength() {
		return BODY_LENGTH;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public void encode() {
		message.writeInt(result, 1);
	}

	@Override
	public String toString() {
		return "VerNegoRespMsg [result=" + result + "]";
	}

}
