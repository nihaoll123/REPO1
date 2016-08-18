/**
 * 
 */
package sdtp.message;

/**
 * 链路认证应答
 * 
 * @author Administrator
 * 
 */
public class LinkAuthRespMsg extends MessageBody {
	
	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 65;

	/**
	 * 1 Unsigned Integer 鉴权的返回结果。各个值的含义如下定义： 1 代表鉴权通过。 2 代表LoginID不存在。 3
	 * 代表SHA256加密结果出错。
	 */
	private int result;

	/**
	 * 64 String
	 * 用于对端对本端进行鉴权，其值通过SHA256计算得出。当对端使用相同方式加密之后与接收的值比较，如果计算出来的值相同，则通过校验，否则出错。
	 */
	private String digest;


	
	public LinkAuthRespMsg(SDTPMessage message) {
		super(message);
		result = message.loadInt(1);
		digest = message.loadStr(64);
	}

	public LinkAuthRespMsg() {
		super();
	}
	
	public int getResult() {
		return result;
	}

	public String getDigest() {
		return digest;
	}

	@Override
	public int getLength() {
		return BODY_LENGTH;
	}

	@Override
	public void encode() {
		message.writeInt(result, 1);
		message.writeStr(digest, 64);
	}

	public void setResult(int result) {
		this.result = result;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	@Override
	public String toString() {
		return "LinkAuthRespMsg [result=" + result + ", digest=" + digest + "]";
	}

}
