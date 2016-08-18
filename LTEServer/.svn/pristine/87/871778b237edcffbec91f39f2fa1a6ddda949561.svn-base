package client;

import java.util.ArrayList;
import java.util.List;

/**
 * @className：链路检测
 * @author B
 * @date:
 * @version : 1.0
 */
public class linkCheck {
	public static final int linkCheck_Req = 0x0003; // 链路检测请求
	public static final int linkCheck_Resp = 0x8003; // 链路检测应答

	/**
	 * @comment 链路检测
	 * @return
	 * @version: 1.0
	 * @return
	 */
	public static byte[] linkCheck_Req() {
		List<byte[]> list = new ArrayList<byte[]>();
		// 获取信息头
		list.add(Messagedispose.createMessageHeader(linkCheck_Req));
		return util.bulidByteArr(list);
	}
}