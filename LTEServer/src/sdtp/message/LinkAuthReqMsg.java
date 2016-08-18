package sdtp.message;

/**
 * 鉴权请求
 * 
 * @author Administrator
 * 
 */
public class LinkAuthReqMsg extends MessageBody {

	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 82;
	
	/**
	 * 账户ID 由连接的服务端给连接的客户端分配的连接帐号。 12 String
	 */
	private String loginID;
	/**
	 * 用于鉴别源用户。其值通过SHA256计算得出。当对端用相同方式加密之后与接收的值比较，如果计算出来的值相同，则通过校验，否则出错。
	 * Digest=SHA256(LoginID+SHA256(Sharedsecret)+Timestamp+"rand=”+RAND)
	 * 其中Shared secret为与LoginID对应的账户密码，由认证双方实体事先商定；
	 * LoginID为本消息带的LoginID字段，12字节，不足12字节以空格“”补齐；
	 * Timestamp为本消息带的Timestamp字段数值，单位为秒（1970年1月1日0时0分0秒起至当前的偏移总秒数）；
	 * 计算后结果为32位，后32位补零（二进制0）； 64 String
	 */
	private String digest;

	/**
	 * 由客户端产生,单位为秒（1970年1月1日0时0分0秒起至当前的偏移总秒数） 4 Unsigned Integer
	 */
	private long timestamp;

	/**
	 * 由客户端产生的随机数 2 Unsigned Integer
	 */
	private int rand;

	public LinkAuthReqMsg() {
		super();
	}

	public LinkAuthReqMsg(SDTPMessage message) {
		super(message);
		loginID = message.loadStr(12);
		digest = message.loadStr(64);
		timestamp = message.loadLong(4);
		rand = message.loadInt(2);
	}

	public String getLoginID() {
		return loginID;
	}

	public String getDigest() {
		return digest;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public int getRand() {
		return rand;
	}

	@Override
	public int getLength() {
		return BODY_LENGTH;
	}

	@Override
	public void encode() {
		message.writeStr(loginID, 12);
		message.writeStr(digest, 64);
		message.writeLong(timestamp, 4);
		message.writeInt(rand, 2);
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public void setRand(int rand) {
		this.rand = rand;
	}

	@Override
	public String toString() {
		return "LinkAuthReqMsg [loginID=" + loginID + ", digest=" + digest + ", timestamp=" + timestamp + ", rand="
				+ rand + "]";
	}

}
