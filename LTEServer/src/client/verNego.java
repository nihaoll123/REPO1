package client;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @className：版本校验
 * @author B
 * @date:
 * @version : 1.0
 */
public class verNego {
	public static final int verNego_Req = 0x0001; // 版本协商请求
	public static final int verNego_Resp = 0x8001; // 版本协商应答
	public static final int[] verNego = { 1, 1 };

	/**
	 * @comment 版本协商
	 * @return
	 * @version: 1.0
	 * @return
	 */
	public static byte[] verNego_Req() {
		System.out.println("版本协商请求封装");
		List<byte[]> list = new ArrayList<byte[]>();
		// 获取信息头
		list.add(Messagedispose.createMessageHeader(verNego_Req));
		// 主版本号
		int Version = 2;// 字节数1
		// 子版本号
		int SubVersion = 2;// 字节数1
		String[] m = { Version + "", SubVersion + "" };
		list.add(util.encodeToSendbytes(m, verNego));
		return util.bulidByteArr(list);
	}

	/**
	 * @comment 版本协商响应
	 * @return
	 * @version: 1.0
	 * @param buffer
	 * @return
	 */
	public static boolean verNego_Resp(ByteBuffer buffer) {
		System.out.println("版本协商响应解析");
		// int result = 0;字节数1 返回原因值。
		// 协议协商的结果，各个值代表意义如下：
		// 1: 版本协商通过。
		// 2: 版本过高。
		// 3: 版本过低。
		byte[] result = new byte[1];
		buffer.get(result);
		switch (util.unbuildNumericWithSpace(result, 1)) {
		case 1:
			System.out.println("版本协商通过");
			return true;
		case 2:
			System.out.println("版本协商未通过，版本过高");
			return false;
		case 3:
			System.out.println("版本协商未通过，版本过低");
			return false;
		default:
			System.out.println("返回信息意义不明");
			return false;
		}
	}

}