package clent;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @className：鉴权
 * @author B
 * @date:
 * @version : 1.0
 */
public class linkAuth {
	public static final int linkAuth_Req = 0x0002; // 鉴权请求
	public static final int linkAuth_Resp = 0x8002;// 鉴权响应
	public static final int[] linkAuth = { 12, 64, 4, 2 };

	/**
	 * @comment 链路鉴权请求
	 * @return
	 * @version: 1.0
	 * @return
	 */
	public static byte[] linkAuth_Req() {
		List<byte[]> list = new ArrayList<byte[]>();
		// 获取信息头
		list.add(Messagedispose.createMessageHeader(linkAuth_Req));
		// TODO 链路认证 LoginID均应从配置文件中读出
		String LoginID = "aaaaaaaaaaaa";// 账户ID 12 由连接的服务端给连接的客户端分配的连接帐号
		String Digest = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";// 64
		// 用于鉴别源用户。其值通过SHA256计算得出。当对端用相同方式加密之后与接收的值比较，如果计算出来的值相同，则通过校验，否则出错。
		// Digest=
		// SHA256(LoginID+SHA256(Sharedsecret)+Timestamp+"rand=”+RAND)
		// 其中Shared secret为与LoginID对应的账户密码，由认证双方实体事先商定；
		// LoginID为本消息带的LoginID字段，12字节，不足12字节以空格“”补齐；
		// Timestamp为本消息带的Timestamp字段数值，单位为秒（1970年1月1日0时0分0秒起至当前的偏移总秒数）；
		// 计算后结果为32位，后32位补零（二进制0）；

		int Timestamp = (int) ((new Date()).getTime() / 1000);// 时间戳的明文。由客户端产生,单位为秒（1970年1月1日0时0分0秒起至当前的偏移总秒数）
		// TODO 这玩意会返回负数。等我有空再看
		int rand = (Math.abs((new Random()).nextInt()));
		String temp[] = { LoginID, Digest, Timestamp + "", rand + "" };
		list.add(util.encodeToSendbytes(temp, linkAuth));
		return util.bulidByteArr(list);
	}

	/**
	 * @comment 鉴权响应解析
	 * @return
	 * @version: 1.0
	 * @param buffer 
	 * @return
	 */
	public static boolean linkAuth_Resp(ByteBuffer buffer) {
		System.out.println("鉴权响应解析");
		// int result = 0;字节数1 返回原因值。
		// 鉴权的返回结果。各个值的含义如下定义：
		// 1 代表鉴权通过。
		// 2 代表LoginID不存在。
		// 3 代表SHA256加密结果出错。
		byte[] result = new byte[1];
		byte[] Digest = new byte[64];
		System.out.println("Digest：" + Digest);
		buffer.get(result);
		switch (util.unbuildNumericWithSpace(result, 1)) {
		case 1:
			System.out.println("鉴权通过");
			return true;
		case 2:
			System.out.println("鉴权未通过，LoginID不存在");
			return false;
		case 3:
			System.out.println("鉴权未通过，SHA256加密结果出错");
			return false;
		default:
			System.out.println("返回信息意义不明");
			return false;
		}
	}

}