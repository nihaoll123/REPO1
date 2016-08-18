package client;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @className：链接释放
 * @author B
 * @date:
 * @version : 1.0
 */
public class linkRel {
	public static final int linkRel_Req = 0x0004;// 连接释放请求
	public static final int linkRel_Resp = 0x8004; // 连接释放应答
	public static final int[] linkRel = { 1 };

	/**
	 * @comment 链路释放
	 * @param
	 * @version: 1.0
	 */
	public static byte[] linkRel_Req() {
		// 连接释放的原因，各个值代表意义如下：
		// 1: 用户正常释放。
		// 2: 数据类型错误。
		// 3: 超出机器处理能力。
		System.out.println("链路释放请求封装");
		List<byte[]> list = new ArrayList<byte[]>();
		// 获取信息头
		list.add(Messagedispose.createMessageHeader(linkRel_Req));
		int Reason = 1;
		String[] m = { Reason + "" };
		list.add(util.encodeToSendbytes(m, linkRel));
		return util.bulidByteArr(list);
	}

	/**
	 * @comment 链路释放解析
	 * @return
	 * @version: 1.0
	 * @param buffer
	 * @return
	 */
	public static boolean linkRel_Resp(ByteBuffer buffer) {
		System.out.println("链路释放解析");
		// int result = 0;字节数1 返回原因值。
		// 连接释放的完成状态
		// 1：释放完成。
		// 其它：释放失败。
		byte[] result = new byte[1];
		buffer.get(result);
		switch (util.unbuildNumericWithSpace(result, 1)) {
		case 1:
			System.out.println("释放完成");
			return true;
		default:
			System.out.println("释放失败");
			return false;
		}
	}
}