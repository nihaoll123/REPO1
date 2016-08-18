package sdtp.message;


public abstract class MessageBody {
	protected SDTPMessage message;

	/**
	 * 解析byte数据时使用构造方法
	 * @param message
	 */
	public MessageBody(SDTPMessage message) {
		this.message = message;
	}

	/**
	 * 新生成时使用构造方法
	 */
	//XXX 回头重构掉这玩意
	public MessageBody() {
	}

	/**
	 *  获取消息体所占字节数
	 * @return
	 */
	public abstract int getLength();
	
	/**
	 * 将消息内容写入buffer
	 * @param params
	 */
	public abstract void encode();

	
	public SDTPMessage getMessage() {
		return message;
	}

	public void setMessage(SDTPMessage message) {
		this.message = message;
		this.message.setMsgBody(this);
	}
}
