package sdtp.message;


/**
 * 先拿这两个类凑活，等后面再看怎么重构吧
 * 
 * @author Administrator
 * 
 */
public class XDRRawDataSendReqMsg extends MessageBody {

	private byte[] data;

	public XDRRawDataSendReqMsg() {
		super();
	}

	public XDRRawDataSendReqMsg(SDTPMessage message) {
		super(message);
//		data = message.loadByte(message.getTotalLength() - SDTPMessage.HEADER_LENGTH);
	}

	@Override
	public int getLength() {
		return data.length;
	}

	@Override
	public void encode() {
		message.writeByte(data, data.length);
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
