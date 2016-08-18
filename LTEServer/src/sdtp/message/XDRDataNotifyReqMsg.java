package sdtp.message;

public class XDRDataNotifyReqMsg extends MessageBody {

	private byte[] data;

	public XDRDataNotifyReqMsg() {
		super();
	}

	public XDRDataNotifyReqMsg(SDTPMessage message) {
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
