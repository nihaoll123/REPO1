package clent;

import java.util.ArrayList;
import java.util.List;

/**
 * @className：链接释放
 * @author B
 * @date:
 * @version : 1.0
 */
public class common {
	/**
	 * @comment 公共信息头
	 * @return
	 * @version: 1.0
	 * @param length
	 */
	public static byte[] commonMessage(int length) {
		List<byte[]> list = new ArrayList<byte[]>();
		// 2字节 全F
		// 指示整个XDR所占用字节数
		int Length = length + 54;
		list.add(util.buildNumericWithSpace(Length + "", 2));
		// TODO 城市这里没处理
		// 2字节 城市区号，如010代表北京 采用TBCD编码，每4个比特表示一个十进制数字
		byte[] City = new byte[2];
		list.add(City);
		// 接口 一个字节
		// 1. Uu
		// 2. X2
		// 3. UE_MR
		// 4. Cell_MR
		// 5. S1-MME
		// 6. S6a
		// 7. S11
		// 8. S10
		// 9. SGs
		// 10. S5/S8
		// 11. S1-U
		// 12. Gn-C
		// 13. Gm
		// 14. Mw
		// 15. Mg
		// 16. ISC
		// 17. Sv
		// 18. Cx
		// 19. Dx
		// 20. Sh
		// 21. Dh
		// 22. Gx
		// 23. Rx
		int Interface = 17;
		list.add(util.buildNumericWithSpace(Interface + "", 1));
		// 16个字节采集解析服务器内唯一的XDR编号，16进制编码。一个信令流程或业务传输过程生成一个XDR
		// ID。对于信令面XDR，一个XDR ID可能对应同一信令流程中的多条原始消息记录。对于MR
		// XDR，一个XDR ID对应一个MR上报。
		int XDRID = 0;
		list.add(util.buildNumericWithSpace(XDRID + "", 16));
		// 一个字节RAT类型：
		// 1. UTRAN
		// 2. GERAN
		// 3. WLAN
		// 4. GAN
		// 5. HSPA Evolution
		// 6. EUTRAN
		int RAT = 1;
		list.add(util.buildNumericWithSpace(RAT + "", 1));
		// 八个字节
		// 用户IMSI（TBCD编码），通过采集核心网信令获取；针对软采接口，该字段填全F，待数据合成服务器进行回填；对于Cell_MR
		// XDR，该字段为全F。
		byte[] IMSI = util.buildStringWithSpace("FFFFFFFF", 8);
		list.add(IMSI);
		// 八个字节
		// 终端IMEI（TBCD编码），通过采集核心网信令获取；针对软采接口，该字段填全F，待数据合成服务器进行回填；
		byte[] IMEI = util.buildStringWithSpace("FFFFFFFF", 8);
		list.add(IMEI);
		return util.bulidByteArr(list);
	}
}