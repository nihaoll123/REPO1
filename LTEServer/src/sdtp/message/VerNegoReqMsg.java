package sdtp.message;



/**
 * 版本协商请求消息
 * 
 * @author Administrator
 * 
 */
public class VerNegoReqMsg extends MessageBody {


	/**
	 * 消息体长度
	 */
	private static final int BODY_LENGTH = 2;

	/**
	 * 1	Unsigned Integer
	 * 协议的主版本号
	 */
	private int version;

	/**
	 * 1	Unsigned Integer
	 * 协议的子版本号
	 */
	private int subVersion;

	/**
	 * 新生成时使用构造方法
	 * 
	 */
	public VerNegoReqMsg(){
		super();
	}
	
	/**
	 * 解析byte数据时使用构造方法
	 * @param message
	 */
	public VerNegoReqMsg(SDTPMessage message) {
		super(message);
		version = message.loadInt(1);
		subVersion = message.loadInt(1);
	}
	
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getSubVersion() {
		return subVersion;
	}

	public void setSubVersion(int subVersion) {
		this.subVersion = subVersion;
	}


	@Override
	public int getLength() {
		return BODY_LENGTH;
	}


	@Override
	public void encode() {
		message.writeInt(version, 1);
		message.writeInt(subVersion, 1);
	}

	@Override
	public String toString() {
		return "VerNegoReqMsg [version=" + version + ", subVersion=" + subVersion + "]";
	}


}
