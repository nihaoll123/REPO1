package clent;
import java.io.IOException;
import java.nio.ByteBuffer;
import entity.SrvccEntity;

/**
 * @className：信息驱动
 * @author B
 * @date:
 * @version : 1.0
 */
public class Messagedispose {

	static clent clent = new clent();
	private ByteBuffer buffer;

	// 消息名 MessageType值 说明
	public static final int verNego_Req = 0x0001; // 版本协商请求
	public static final int verNego_Resp = 0x8001; // 版本协商应答
	public static final int linkAuth_Req = 0x0002; // 鉴权请求
	public static final int linkAuth_Resp = 0x8002;// 鉴权响应
	public static final int linkCheck_Req = 0x0003; // 链路检测请求
	public static final int linkCheck_Resp = 0x8003; // 链路检测应答
	public static final int linkRel_Req = 0x0004;// 连接释放请求
	public static final int linkRel_Resp = 0x8004; // 连接释放应答
	public static final int notifyXDRData_Req = 0x0005;// XDR数据通知请求
	public static final int notifyXDRData_Resp = 0x8005;// XDR数据通知应答
	public static final int XDRRawDataSend_Req = 0x0006;// XDR对应原始数据传输请求
	public static final int XDRRawDataSend_Resp = 0x8006;// XDR对应原始数据传输应答
	public static final int linkDataCheck_Req = 0x0007;// 链路数据发送校验请求
	public static final int linkDataCheck_Resp = 0x8007;// 链路数据发送校验应答
	public static final int[] MessageHeader = { 2, 2, 4, 1 };
	public static final int[] Header = { 2, 2, 16, 1, 8, 8, 16 };// 公共接口头文件
	public static final int[] GmHeader = { 1, 8, 8, 1, 1, 4, 16, 64, 64, 1, 16,
			2, 1, 16, 2, 1, 64, 64, 64, 64, 1, 64, 64, 1, 64, 64, 1, 64, 64, 1,
			64, 64, 1, 16, 2, 16, 2, 64, 1, 64, 64, 64, 1, 4, 4, 32, 64, 32,
			64, 16, 2, 16, 2, 1, 16, 2, 16, 2, 1, 32, 32, 32, 32, 1, 32, 32,
			64, 1, 1, 2, 128, 128, 4, 1, 16, 4, 4, 4, 4, 4, 4 };// Gm接口/Mw接口/Mg接口/ISC接口XDR数据结构

	/**
	 * @comment 核心控制塔
	 * @author B
	 * @version: 1.0
	 * @return
	 */
	public void controller() {
		// 进行版本校验
		if (!clent.verNego_Req()) {
			clent.linkRel_Req();
			return;
		}
		// 进行链路鉴权
		if (!clent.linkAuth_Req()) {
			clent.linkRel_Req();
			return;
		}
		// 数据发送
		if (!clent.XDRRawDataSend_Req()) {
			clent.linkRel_Req();
			return;
		}
		// 链路检测请求
		if (!clent.linkCheck_Req()) {
			clent.linkRel_Req();
			return;
		}
		// 链路数据发送校验
		if (!clent.linkDataCheck_Req()) {
			clent.linkRel_Req();
			return;
		}
		// 链路释放请求
		if (!clent.linkRel_Req()) {
			return;
		}
	}

	/**
	 * @comment 解包
	 * @author B
	 * @version: 1.0
	 * @return
	 */
	public boolean unpack(byte[] byteArray) {
		this.buffer = ByteBuffer.wrap(byteArray);
		// 解析信息头，从类型开始长度分别为 2、4、1
		byte[] header = new byte[7];
		buffer.get(header);
		// 根据类型选择解析方式
		switch (unpackMessageHeader(header)) {
		case verNego_Resp:
			System.out.println("版本校验响应处理");
			return verNego.verNego_Resp(buffer);
		case linkAuth_Resp:
			System.out.println("鉴权响应处理");
			return linkAuth.linkAuth_Resp(buffer);
		case linkCheck_Resp:
			// 链路检测就是看你活着没。所以不需要处理
			System.out.println("链路检测响应处理");
			return true;
		case linkRel_Resp:
			System.out.println("链接释放响应处理");
			return linkRel.linkRel_Resp(buffer);
		case XDRRawDataSend_Resp:
			System.out.println("数据响应处理");
			return true;
		case linkDataCheck_Resp:
			System.out.println("链路数据发送校验响应处理");
			return linkDataCheck.linkDataCheck_Resp(buffer);
		default:
			System.out.println("意义不明");
			return false;
		}
	}

	public static byte[] createMessageHeader(int MessageType) {
		// MessageType 消息类型
		int TotalLength = 9;// 消息总长度(含消息头及消息体)
		switch (MessageType) {
		case verNego_Req:
			TotalLength += 2;
			break;
		case linkAuth_Req:
			TotalLength += 82;
			break;
		case linkCheck_Req:
			break;
		case linkRel_Req:
			TotalLength += 1;
			break;
		case linkDataCheck_Req:
			TotalLength += 8;
			break;
		case XDRRawDataSend_Req:
			TotalLength += 681 + 48;
			break;
		default:
			break;
		}
		System.out.println("请求信息总长度" + TotalLength);
		// TODO 这里数据应进行修正
		int SequenceId = 1;// 交互的流水号，顺序累加，步长为1，循环使用（一个交互的一对请求和应答消息的流水号必须相同）
		int TotalContents = 1;// 消息体中的事件数量（最多40条） 若考虑实时性要求，可每次只填一个事件
		String[] m = { TotalLength + "", MessageType + "", SequenceId + "",
				TotalContents + "" };
		return util.encodeToSendbytes(m, MessageHeader);
	}

	/**
	 * @comment 解析头文件，仅返回信息类型
	 * @author B
	 * @version: 1.0
	 * @return
	 */
	public static int unpackMessageHeader(byte[] header) {
		return util.unbuildNumericWithSpace(header, 2);
	}

	/**
	 * @comment Cx/Dx/Sh/Dh接口XDR数据结构
	 * @return
	 * @version: 1.0
	 */
	private void Authen() {
		// TODO Auto-generated method stub
	}

	/**
	 * @comment Sv接口XDR数据结构
	 * @return
	 * @version: 1.0
	 */
	public void Srvcc() {
		byte[] one = new byte[1];
		byte[] four = new byte[4];
		byte[] eight = new byte[8];
		SrvccEntity srvcc = new SrvccEntity();
		buffer.get(one);
		// 1 全F
		// 流程类型编码，具体取值如下：
		// 1：SRVCC(PS to CS)；
		int ProcedureType = util.unbuildNumericWithSpace(one, 1);
		srvcc.setProcedureType(ProcedureType);
		// 8 全0 采集第一条消息的时间，UTC时间，从1970/1/1
		// 00:00:00开始到当前的毫秒数。
		buffer.get(eight);
		// TODO 时间等等再算
		String ProcedureStartTime = null;
		srvcc.setProcedureStartTime(ProcedureStartTime);
		// 8 全0 业务流程结束时间，UTC时间，从1970/1/1
		// 00:00:00开始到当前的毫秒数。
		buffer.get(eight);
		String ProcedureEndTime = null;
		srvcc.setProcedureEndTime(ProcedureEndTime);
		// 4 全F 终端用户的IPv4地址，如无则填全F
		byte[] USER_IPv4 = new byte[4];
		buffer.get(USER_IPv4);
		srvcc.setUserIpv4(USER_IPv4.toString());
		// byte 16 全F 终端用户的IPv6地址，如无则填全F
		byte[] USER_IPv6 = new byte[16];
		buffer.get(USER_IPv6);
		srvcc.setUserIpv6(USER_IPv6.toString());
		// 64 全F IMS会话Call ID
		byte[] CALLID = new byte[64];
		buffer.get(CALLID);
		srvcc.setCallid(CALLID.toString());
		// 64 全F IMS计费ID
		byte[] ICID = new byte[64];
		buffer.get(ICID);
		srvcc.setIcid(ICID.toString());
		buffer.get(one);
		// 1 全F 0: 终端
		// 1: A-SBC
		// 2: AGCF
		// 3: IP-PBX
		// 4: P-CSCF
		// 5: I-CSCF
		// 8: S-CSCF
		// 9: AS
		// 10: MGCF
		// 11: BGCF
		// 12: IBCF
		// 13: MRFC
		// 14: ENUM Server
		// 15: SLF
		// 16: IP-SM-GW
		// 17: ATCF
		// 18: PCRF
		// 19: S-GW
		// 20: P-GW
		// 21: HSS
		// 22: MME
		// 23: eMSC
		// 255: 未知/Unknow
		int SOURCE_NE_TYPE = util.unbuildNumericWithSpace(one, 1);
		srvcc.setSourceNeType(SOURCE_NE_TYPE);
		// 16 全F 源网元IP地址。
		// IPv4：4字节，此时前12个字节填全F；
		// IPv6：16字节。
		byte[] SOURCE_NE_IP = new byte[16];
		buffer.get(SOURCE_NE_IP);
		srvcc.setSourceNeIp(SOURCE_NE_IP.toString());
		int SOURCE_NE_PORT = 0;// 2 全F 源网元端口号。
		int DEST_NE_TYPE = 0;// 1 全F 0: 终端
		// 1: A-SBC
		// 2: AGCF
		// 3: IP-PBX
		// 4: P-CSCF
		// 5: I-CSCF
		// 8: S-CSCF
		// 9: AS
		// 10: MGCF
		// 11: BGCF
		// 12: IBCF
		// 13: MRFC
		// 14: ENUM Server
		// 15: SLF
		// 16: IP-SM-GW
		// 17: ATCF
		// 18: PCRF
		// 19: S-GW
		// 20: P-GW
		// 21: HSS
		// 22: MME
		// 23: eMSC
		// 255: 未知/Unknow
		byte DEST_NE_IP = 0;// byte 16 全F 目的网元IP地址。
		// IPv4：4字节，此时前12个字节填全F；
		// IPv6：16字节。
		int DEST_NE_PORT = 0;// 2 全F 目的网元端口号。
		int ROAM_DIRECTION = 0;// 1 全F 0: 4G to 2G
		// 1: 2G to 4G
		byte IMPI_TEL_URI = 0;// 64 全F TEL URI格式私有身份
		byte IMPI_SIP_URI = 0;// 64 全F SIP URI私有身份
		byte IMPU_TEL_URI = 0;// 64 全F TEL URI格式公有身份
		byte IMPU_SIP_URI = 0;// 64 全F SIP URI公有身份
		int HOME_MCC = 0;// 2 全F 归属运营商移动国家码
		int HOME_MNC = 0;// 2 全F 归属运营商移动网络码
		int MCC = 0;// 2 全F 移动国家代码
		int MNC = 0;// 2 全F 移动网络代码
		byte LAI = 0;// 8 全F 位置区标识
		byte RAI_TAI = 0;// 8 全F 路由区标识或者跟踪区标识
		byte SAI_CGI_ECGI = 0;// 28 全F 服务区编码
		byte APN = 0;// 64 全F 接入点名称
		int SV_FLAGS = 0;// 1 全F SRVCC PS to CS Request 中IE: Sv Flags取得
		// 0：IMS紧急电话
		// 1：支持ICS
		byte UL_C_MSC_IP = 0;// 16 全F MSC接受切换请时，分配的控制面的IP，在SRVCC PS to CS
		// Response中IE: IP Address 中取得,提取其中只取IPV4，暂不支持IPV6
		byte DL_C_MME_IP = 0;// 16 全F MME/SGSN分配给Control-plane的IP, 在SRVCC PS to
								// CS
		// Request 中IE: IP-Address取得,只取IPV4，暂不支持IPV6
		byte UL_C_MSC_TEID = 0;// 4 全F MSC接受切换请时，分配的控制面的上行TEID,在SRVCC PS to CS
		// Response中IE: TEID-C 中取得。
		byte DL_C_MME_TEID = 0;// 4 全F MME/SGSN分配的控制面下行的TEID, 在SRVCC PS to CS
		// Request 中IE: TEID-C取得
		byte STR_SR = 0;// 24 全F 在SRVCC PS to CS Request 中IE: STN-SR 取得
		byte TARGET_RNC_ID = 0;// 4 全F 切换目的RNC ID，在SRVCC PS to CS Request 中IE:
		// Target RNC ID取得
		byte TARGET_CELL_ID = 0;// 4 全F 切换目的CELL ID，在SRVCC PS to CS Request 中IE:
		// Target CELL ID取得
		int ARP = 0;// 1 全F 分配保留优先级，在SRVCC PS to CS Request 中IE: ARP 取得
		byte PLMN_ID = 0;// 4 全F 在SRVCC PS to CS Request 中IE: PLMN ID 取得
		byte REJECTED_CAUSE = 0;// 1 全F Result为不接受时的拒绝原因,在 SRVCC PS to CS
		// Response中IE: SRVCC Cause 中取得
		byte REQUEST_RESULT = 0;// 1 全F 切换请求是否接受，在 SRVCC PS to CS
		// Response中IE:Cause中取得
		int RESULT = 0;// 1 全F 切换结果
		// 0：成功，收到 SRVCC PS to CS Complete Notification 消息，且无 srvcc_cause 时；
		// 1：切换失败，收到 SRVCC PS to CS Complete Notification 或 SRVCC PS to CS
		// Cancel Notification消息，且 srvcc_cause 为2/3/4/5/6/7/8时；
		// 2：MSC会话释放，收到 SRVCC PS to CS Complete Notification 消息，且 srvcc_cause
		// 为9/10时。
		int SV_CAUSE = 0;// 1 全F result 不为0时的拒绝原因,包括result为1，2的原因，在 SRVCC PS
		// to CS Response或 SRVCC PS to CS Complete Notification中IE: SRVCC Cause
		// 中取得（暂时有值就填，填最后一次的），单位0.1ms
		// TODO time是个什么鬼
		// RESP_DELAY time 4 全F 切换请响应时延， SRVCC PS to CS Request到 SRVCC PS to CS
		// Response的时间
		// SV_DELAY time 4 全F 切换完成时延，result=0时，SRVCC PS to CS Request 到SRVCC PS
		// to CS Complete Notification的时间
		byte MSISDN_CAPABILITY = 0;// 1 全F
		// 使用c_msisdn查询UTRACE维护的SRVCC关系表，回填msisdn_capability
		byte CUR_ECI = 0;// 4 全F 使用c_msisdn查询UTRACE维护的LTE位置关系表，回填位置信息cur_eci
		byte CUR_TAC = 0;// 2 全F 使用c_msisdn查询UTRACE维护的LTE位置关系表，回填位置信息cur_tac
	}

	/**
	 * @comment Gx接口/Rx接口信息
	 * @return
	 * @version: 1.0
	 */
	private void Pcc() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		try {
			clent.initSocket();
			Messagedispose m = new Messagedispose();
			m.controller();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}