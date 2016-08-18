package clent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @className：svrcc数据封装
 * @author B
 * @date:
 * @version : 1.0
 */
public class svrcc {
	/**
	 * @comment svrcc信息封装
	 * @return
	 * @version: 1.0
	 */
	public static byte[] svrccMessage() {
		System.out.println("版本协商请求封装");
		List<byte[]> list = new ArrayList<byte[]>();
		// 1 全F
		// 流程类型编码，具体取值如下：
		// 1：SRVCC(PS to CS)；
		int ProcedureType = 1;
		list.add(util.buildNumericWithSpace(ProcedureType + "", 1));
		// 8 全0 采集第一条消息的时间，UTC时间，从1970/1/1
		// 00:00:00开始到当前的毫秒数。
		// TODO 时间等等再算
		String ProcedureStartTime = (new Date()).getTime() + "";
		list.add(util.buildStringWithSpace(ProcedureStartTime, 16));
		// 8 全0 业务流程结束时间，UTC时间，从1970/1/1
		// 00:00:00开始到当前的毫秒数。
		String ProcedureEndTime = (new Date()).getTime() + "";
		list.add(util.buildStringWithSpace(ProcedureEndTime, 16));
		// 4 全F 终端用户的IPv4地址，如无则填全F
		byte[] USER_IPv4 = util.buildStringWithSpace("FFFF", 4);
		list.add(USER_IPv4);
		// byte 16 全F 终端用户的IPv6地址，如无则填全F
		byte[] USER_IPv6 = util.buildStringWithSpace("FFFFFFFFFFFFFFFF", 16);
		list.add(USER_IPv6);
		// 64 全F IMS会话Call ID
		byte[] CALLID = util
				.buildStringWithSpace(
						"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
						64);
		list.add(CALLID);
		// 64 全F IMS计费ID
		byte[] ICID = util
				.buildStringWithSpace(
						"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
						64);
		list.add(ICID);
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
		int SOURCE_NE_TYPE = 1;
		list.add(util.buildNumericWithSpace(SOURCE_NE_TYPE + "", 1));
		// 16 全F 源网元IP地址。
		// IPv4：4字节，此时前12个字节填全F；
		// IPv6：16字节。
		byte[] SOURCE_NE_IP = util.buildStringWithSpace("FFFFFFFFFFFFFFFF", 16);
		list.add(SOURCE_NE_IP);
		// 2 全F 源网元端口号。
		int SOURCE_NE_PORT = 0;
		list.add(util.buildNumericWithSpace(SOURCE_NE_PORT + "", 2));
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
		int DEST_NE_TYPE = 1;
		list.add(util.buildNumericWithSpace(DEST_NE_TYPE + "", 1));
		// byte 16 全F 目的网元IP地址。
		// IPv4：4字节，此时前12个字节填全F；
		// IPv6：16字节。
		byte[] DEST_NE_IP = util.buildStringWithSpace("FFFFFFFFFFFFFFFF", 16);
		list.add(DEST_NE_IP);
		// 2 全F 目的网元端口号。
		int DEST_NE_PORT = 0;
		list.add(util.buildNumericWithSpace(DEST_NE_PORT + "", 2));
		// 1 全F 0: 4G to 2G
		// 1: 2G to 4G
		int ROAM_DIRECTION = 1;
		list.add(util.buildNumericWithSpace(ROAM_DIRECTION + "", 1));
		// 64 全F TEL URI格式私有身份
		byte[] IMPI_TEL_URI = util
				.buildStringWithSpace(
						"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
						64);
		list.add(IMPI_TEL_URI);
		// 64 全F SIP URI私有身份
		byte[] IMPI_SIP_URI = util
				.buildStringWithSpace(
						"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
						64);
		list.add(IMPI_SIP_URI);
		// 64 全F TEL URI格式公有身份
		byte[] IMPU_TEL_URI = util
				.buildStringWithSpace(
						"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
						64);
		list.add(IMPU_TEL_URI);
		// 64 全F SIP URI公有身份
		byte[] IMPU_SIP_URI = util
				.buildStringWithSpace(
						"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
						64);
		list.add(IMPU_SIP_URI);
		// 2 全F 归属运营商移动国家码
		int HOME_MCC = 0;
		list.add(util.buildNumericWithSpace(HOME_MCC + "", 2));
		// 2 全F 归属运营商移动网络码
		int HOME_MNC = 0;
		list.add(util.buildNumericWithSpace(HOME_MNC + "", 2));
		// 2 全F 移动国家代码
		int MCC = 0;
		list.add(util.buildNumericWithSpace(MCC + "", 2));
		// 2 全F 移动网络代码
		int MNC = 0;
		list.add(util.buildNumericWithSpace(MNC + "", 2));
		// 8 全F 位置区标识
		byte[] LAI = util.buildStringWithSpace("FFFFFFFF", 8);
		list.add(LAI);
		// 8 全F 路由区标识或者跟踪区标识
		byte[] RAI_TAI = util.buildStringWithSpace("FFFFFFFF", 8);
		list.add(RAI_TAI);
		// 28 全F 服务区编码
		byte[] SAI_CGI_ECGI = util.buildStringWithSpace(
				"FFFFFFFFFFFFFFFFFFFFFFFFFFFF", 28);
		list.add(SAI_CGI_ECGI);
		// 64 全F 接入点名称
		byte[] APN = util
				.buildStringWithSpace(
						"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF",
						64);
		list.add(APN);
		// 1 全F SRVCC PS to CS Request 中IE: Sv Flags取得
		// 0：IMS紧急电话
		// 1：支持ICS
		int SV_FLAGS = 0;
		list.add(util.buildNumericWithSpace(SV_FLAGS + "", 1));
		// 16 全F MSC接受切换请时，分配的控制面的IP，在SRVCC PS to CS
		// Response中IE: IP Address 中取得,提取其中只取IPV4，暂不支持IPV6
		byte[] UL_C_MSC_IP = util.buildStringWithSpace("FFFFFFFFFFFFFFFF", 16);
		list.add(UL_C_MSC_IP);
		// 16 全F MME/SGSN分配给Control-plane的IP, 在SRVCC PS to CS
		// Request 中IE: IP-Address取得,只取IPV4，暂不支持IPV6
		byte[] DL_C_MME_IP = util.buildStringWithSpace("FFFFFFFFFFFFFFFF", 16);
		list.add(DL_C_MME_IP);
		// 4 全F MSC接受切换请时，分配的控制面的上行TEID,在SRVCC PS to CS
		// Response中IE: TEID-C 中取得。
		byte[] UL_C_MSC_TEID = util.buildStringWithSpace("FFFF", 4);
		list.add(UL_C_MSC_TEID);
		// 4 全F MME/SGSN分配的控制面下行的TEID, 在SRVCC PS to CS
		// Request 中IE: TEID-C取得
		byte[] DL_C_MME_TEID = util.buildStringWithSpace("FFFF", 4);
		list.add(DL_C_MME_TEID);
		// 24 全F 在SRVCC PS to CS Request 中IE: STN-SR 取得
		byte[] STR_SR = util.buildStringWithSpace("FFFFFFFFFFFFFFFFFFFFFFFF",
				24);
		list.add(STR_SR);
		// 4 全F 切换目的RNC ID，在SRVCC PS to CS Request 中IE:
		// Target RNC ID取得
		byte[] TARGET_RNC_ID = util.buildStringWithSpace("FFFF", 4);
		list.add(TARGET_RNC_ID);
		// 4 全F 切换目的CELL ID，在SRVCC PS to CS Request 中IE:
		// Target CELL ID取得
		byte[] TARGET_CELL_ID = util.buildStringWithSpace("FFFF", 4);
		list.add(TARGET_CELL_ID);
		// 1 全F 分配保留优先级，在SRVCC PS to CS Request 中IE: ARP 取得
		int ARP = 0;
		list.add(util.buildNumericWithSpace(ARP + "", 1));
		// 4 全F 在SRVCC PS to CS Request 中IE: PLMN ID 取得
		byte[] PLMN_ID = util.buildStringWithSpace("FFFF", 4);
		list.add(PLMN_ID);
		// 1 全F Result为不接受时的拒绝原因,在 SRVCC PS to CS
		// Response中IE: SRVCC Cause 中取得
		byte[] REJECTED_CAUSE = util.buildStringWithSpace("F", 1);
		list.add(REJECTED_CAUSE);
		// 1 全F 切换请求是否接受，在 SRVCC PS to CS
		// Response中IE:Cause中取得
		byte[] REQUEST_RESULT = util.buildStringWithSpace("F", 1);
		list.add(REQUEST_RESULT);
		// 1 全F 切换结果
		// 0：成功，收到 SRVCC PS to CS Complete Notification 消息，且无 srvcc_cause 时；
		// 1：切换失败，收到 SRVCC PS to CS Complete Notification 或 SRVCC PS to CS
		// Cancel Notification消息，且 srvcc_cause 为2/3/4/5/6/7/8时；
		// 2：MSC会话释放，收到 SRVCC PS to CS Complete Notification 消息，且 srvcc_cause
		// 为9/10时。
		int RESULT = 0;
		list.add(util.buildNumericWithSpace(RESULT + "", 1));
		// 1 全F result 不为0时的拒绝原因,包括result为1，2的原因，在 SRVCC PS
		// to CS Response或 SRVCC PS to CS Complete Notification中IE: SRVCC Cause
		// 中取得（暂时有值就填，填最后一次的），单位0.1ms
		// TODO time是个什么鬼
		// RESP_DELAY time 4 全F 切换请响应时延， SRVCC PS to CS Request到 SRVCC PS to CS
		// Response的时间
		// SV_DELAY time 4 全F 切换完成时延，result=0时，SRVCC PS to CS Request 到SRVCC PS
		// to CS Complete Notification的时间
		int SV_CAUSE = 0;
		list.add(util.buildNumericWithSpace(SV_CAUSE + "", 1));
		// 1 全F
		// 使用c_msisdn查询UTRACE维护的SRVCC关系表，回填msisdn_capability
		byte[] MSISDN_CAPABILITY = util.buildStringWithSpace("F", 1);
		list.add(MSISDN_CAPABILITY);
		// 4 全F 使用c_msisdn查询UTRACE维护的LTE位置关系表，回填位置信息cur_eci
		byte[] CUR_ECI = util.buildStringWithSpace("FFFF", 4);
		list.add(CUR_ECI);
		// 2 全F 使用c_msisdn查询UTRACE维护的LTE位置关系表，回填位置信息cur_tac
		byte[] CUR_TAC = util.buildStringWithSpace("FF", 2);
		list.add(CUR_TAC);
		return util.bulidByteArr(list);
	}
}