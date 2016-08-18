package sdtp.message;

/**
 * 链路检测请求
 * @author Administrator
 *
 */
public class LinkCheckReqMsg extends MessageBody {

	public LinkCheckReqMsg(SDTPMessage message) {
		super(message);
	}

	public LinkCheckReqMsg() {
		super();
	}

	@Override
	public int getLength() {
		return 0;
	}

	@Override
	public void encode() {
	}

	@Override
	public String toString() {
		return "LinkCheckReqMsg []";
	}

}
