package client;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @className：链路数据发送校验
 * @author B
 * @date:
 * @version : 1.0
 */
public class linkDataCheck {
	public static final int linkDataCheck_Req = 0x0007;// 链路数据发送校验请求
	public static final int linkDataCheck_Resp = 0x8007;// 链路数据发送校验应答
	public static final int[] linkDataCheck = { 4, 4 };

	/**
	 * @comment 链路数据发送校验
	 * @return
	 * @version: 1.0
	 * @return
	 */
	public static byte[] linkDataCheck_Req() {
		System.out.println("链路数据发送校验请求封装");
		List<byte[]> list = new ArrayList<byte[]>();
		// 获取信息头
		list.add(Messagedispose.createMessageHeader(linkDataCheck_Req));
		// 检测包顺序标签，1小时内不重复即可。本参数目的是为发现校验包的丢失情况发生。
		int Sendflag = 0;// 距离上次发送间发送的数据包数量。（仅仅包含notifyXDRData_Req和XDRRawDataSend_Req包的数量）
		// 子版本号
		int SendDataInfo = 0;// 字节数4
		String[] m = { Sendflag + "", SendDataInfo + "" };
		list.add(util.encodeToSendbytes(m, linkDataCheck));
		return util.bulidByteArr(list);
	}

	/**
	 * @comment 链路数据监测解析
	 * @return
	 * @version: 1.0
	 * @param buffer2
	 * @return
	 */
	public static boolean linkDataCheck_Resp(ByteBuffer buffer) {
		System.out.println("链路数据监测解析");
		byte[] temp = new byte[4];
		byte[] result = new byte[1];
		buffer.get(temp);
		int Sendflag = util.unbuildNumericWithSpace(temp, 4);
		buffer.get(result);
		int SendDataInfo = util.unbuildNumericWithSpace(temp, 4);
		int RecDataInfo = util.unbuildNumericWithSpace(temp, 4);
		System.out.println("检测包顺序标签:" + Sendflag + "距离上次发送间发送的数据包数量:"
				+ SendDataInfo + "距离上次发送间接收的数据包数量:" + RecDataInfo);
		switch (util.unbuildNumericWithSpace(result, 1)) {
		case 0:
			System.out.println("数据量正确");
			return true;
			// TODO 我全true了
		case 1:
			System.out.println("接收方数据小于发送方数据");
			return true;
		case 2:
			System.out.println("数据大于发送方数据");
			return true;
		default:
			System.out.println("意义不明");
			return false;
		}
	}
}