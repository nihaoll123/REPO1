package clent;

import java.util.ArrayList;
import java.util.List;

/**
 * @className：XDR对应原始码流传输
 * @author B
 * @date:
 * @version : 1.0
 */
public class XDRRawDataSend {
	public static final int XDRRawDataSend_Req = 0x0006;// XDR对应原始数据传输请求
	public static final int XDRRawDataSend_Resp = 0x8006;// XDR对应原始数据传输应答

	public static byte[] saaa() {
		List<byte[]> list = new ArrayList<byte[]>();
		byte[] temp = svrcc.svrccMessage();

		System.out.println(temp.length);
		list.add(Messagedispose.createMessageHeader(XDRRawDataSend_Req));
		list.add(common.commonMessage(temp.length));
		list.add(temp);
		return util.bulidByteArr(list);
	}
}