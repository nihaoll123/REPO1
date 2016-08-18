package sdtp.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.DigestException;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import sdtp.message.LinkAuthReqMsg;
import sdtp.message.LinkAuthRespMsg;
import sdtp.message.LinkCheckRespMsg;
import sdtp.message.LinkDataCheckReqMsg;
import sdtp.message.LinkDataCheckRespMsg;
import sdtp.message.LinkRelRespMsg;
import sdtp.message.MessageType;
import sdtp.message.SDTPMessage;
import sdtp.message.VerNegoReqMsg;
import sdtp.message.VerNegoRespMsg;
import sdtp.message.XDRDataNotifyRespMsg;
import sdtp.message.XDRRawDataSendRespMsg;
import entity.AuthenEntity;
import entity.PccEntity;
import entity.SipCallEntity;
import entity.SrvccEntity;

public class MessageUtil {

	private static final int majorVersion = 2;
	private static final int minorVersion = 2;

	private static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");

	/**
	 * 将BigInteger转换为无符号数字的byte数据
	 * 
	 * @param data
	 * @param length
	 * @return
	 */
	public static byte[] int2ByteArray(BigInteger bigInt, int length) {
		long data = bigInt.longValue();
		byte[] bufParam = new byte[length];
		bufParam[length - 1] = (byte) data;
		for (int i = 1; i < bufParam.length; i++) {
			bufParam[length - 1 - i] = (byte) (data >>> (8 * i));
		}
		return bufParam;
	}

	/**
	 * 将BigInteger转换为无符号数字的byte数据
	 * 
	 * @param data
	 * @param length
	 * @return
	 */
	public static byte[] str2ByteArray(String data, int length) {
		byte[] tempBuf = null;
		try {
			tempBuf = data.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] bufParam = new byte[length];
		int offset = bufParam.length - tempBuf.length;
		if (offset < 0) {
			throw new IllegalArgumentException("数据超出规定长度,数据内容:" + data);
		} else if (offset > 0) {// 数据不足以填充byte[]需要补空白字符
			Arrays.fill(bufParam, 0, offset, (byte) 32);
		}
		System.arraycopy(tempBuf, 0, bufParam, offset, tempBuf.length);
		return bufParam;
	}

	/**
	 * 将无符号数字的byte数据转换为BigInteger
	 * 
	 * @param arr
	 * @return
	 */
	public static BigInteger byteArray2Int(byte[] arr) {
		// 在原数组前插入一字节作为符号位
		byte[] result = new byte[arr.length + 1];
		for (int i = arr.length; i > 0; i--) {
			result[i] = arr[i - 1];
		}
		return new BigInteger(result);

	}

	/**
	 * 处理版本协商请求
	 * 
	 * @param msgBody
	 * @return
	 */
	public static SDTPMessage dealVerNego(SDTPMessage reqMsg) {
		VerNegoReqMsg reqBody = (VerNegoReqMsg) reqMsg.getMsgBody();

		SDTPMessage respMsg = new SDTPMessage();
		respMsg.setMessageType(MessageType.verNego_Resp);
		respMsg.setSequenceId(reqMsg.getSequenceId());

		VerNegoRespMsg respbody = new VerNegoRespMsg();
		respbody.setMessage(respMsg);
		int result = Integer.compare(reqBody.getVersion(), majorVersion); // 比较主版本号
		if (result == 0) {
			result = Integer.compare(reqBody.getSubVersion(), minorVersion); // 比较字版本号
		}

		if (result == 0) { // 版本协商通过
			result = 1;
		} else if (result > 0) { // 版本过高。
			result = 2;
		} else { // 版本过低
			result = 3;
		}

		respbody.setResult(result);
		respMsg.encodeMessage();
		return respMsg;
	}

	/**
	 * 处理鉴权请求
	 * 
	 * @param reqMsg
	 * @return
	 */
	public static SDTPMessage dealLinkAuth(SDTPMessage reqMsg) {
		LinkAuthReqMsg reqBody = (LinkAuthReqMsg) reqMsg.getMsgBody();
		// 构造响应包消息头
		SDTPMessage respMsg = new SDTPMessage();
		respMsg.setMessageType(MessageType.linkAuth_Resp);
		respMsg.setSequenceId(reqMsg.getSequenceId());

		LinkAuthRespMsg respBody = new LinkAuthRespMsg();
		respBody.setMessage(respMsg);
		int result = 1;
		// loginID不存在我怎么做SHA256运算,你在逗我么？
		// 校验失败我还把真实校验结果发回去么？
		String resultDigest = "";
		try {
			resultDigest = AuthUtil.linkAuth(reqBody);
		} catch (SignatureException e) { // LoginID不存在
			result = 2;
		} catch (DigestException e) { // SHA256加密结果出错。
			result = 3;
		}
		respBody.setResult(result);
		respBody.setDigest(resultDigest);
		respMsg.encodeMessage();
		return respMsg;
	}

	/**
	 * 处理链路数据发送校验请求
	 * 
	 * @param reqMsg
	 * @param recDataInfo
	 * @return
	 */
	public static SDTPMessage dealLinkDataCheck(SDTPMessage reqMsg,
			int recDataInfo) {

		LinkDataCheckReqMsg reqBody = (LinkDataCheckReqMsg) reqMsg.getMsgBody();

		SDTPMessage respMsg = new SDTPMessage();
		respMsg.setMessageType(MessageType.linkDataCheck_Resp);
		respMsg.setSequenceId(reqMsg.getSequenceId());

		LinkDataCheckRespMsg respBody = new LinkDataCheckRespMsg();
		respBody.setMessage(respMsg);
		int sendDataInfo = reqBody.getSendDataInfo();
		int result = sendDataInfo - recDataInfo;
		if (result < 0) { // 接收方数据大于发送方数据
			result = 2;
		} else if (result > 0) { // 接收方数据小于发送方数据
			result = 1;
		}
		respBody.setResult(result);
		respBody.setSendFlag(reqBody.getSendFlag());
		respBody.setSendDataInfo(reqBody.getSendDataInfo());
		respBody.setRecDataInfo(recDataInfo);

		respMsg.encodeMessage();
		return respMsg;
	}

	/**
	 * 处理链路检测请求
	 * 
	 * @param reqMsg
	 * @return
	 */
	public static SDTPMessage dealLinkCheck(SDTPMessage reqMsg) {
		SDTPMessage respMsg = new SDTPMessage();
		respMsg.setMessageType(MessageType.linkCheck_Resp);
		respMsg.setSequenceId(reqMsg.getSequenceId());

		LinkCheckRespMsg respBody = new LinkCheckRespMsg();
		respBody.setMessage(respMsg);

		respMsg.encodeMessage();
		return respMsg;
	}

	/**
	 * 处理链接释放请求
	 * 
	 * @param reqMsg
	 * @return
	 */
	public static SDTPMessage dealLinkRel(SDTPMessage reqMsg) {
		int sequenceId = 0;
		if (Util.checkNotNull(reqMsg)) {
			sequenceId = reqMsg.getSequenceId();
		}

		SDTPMessage respMsg = new SDTPMessage();
		respMsg.setMessageType(MessageType.linkRel_Resp);
		respMsg.setSequenceId(sequenceId);

		LinkRelRespMsg respBody = new LinkRelRespMsg();
		respBody.setMessage(respMsg);
		// 真是莫名其妙，服务器有没有释放成功在给客户端发消息时候怎么会知道。。人家全释放了怎么发消息。。
		respBody.setResult(1);

		respMsg.encodeMessage();
		return respMsg;
	}

	/**
	 * 处理XDR数据包
	 * 
	 * @param message
	 * @return
	 */
	public static SDTPMessage dealXDRDataNoify(SDTPMessage reqMsg) {
		int result = 1;
		try {
			getEntity(reqMsg);
		} catch (IllegalArgumentException e) {
			result = 0;
		}

		SDTPMessage respMsg = new SDTPMessage();
		respMsg.setMessageType(MessageType.notifyXDRData_Resp);
		respMsg.setSequenceId(reqMsg.getSequenceId());

		XDRDataNotifyRespMsg respBody = new XDRDataNotifyRespMsg();
		respBody.setMessage(respMsg);

		// 接收成功
		respBody.setResult(result);

		respMsg.encodeMessage();
		return respMsg;
	}

	/**
	 * 处理XDR数据包
	 * 
	 * @param message
	 * @return
	 */
	public static SDTPMessage dealXDRDataSend(SDTPMessage reqMsg) {
		int result = 1;
		try {
			getEntity(reqMsg);
		} catch (IllegalArgumentException e) {
			result = 0;
		}
		SDTPMessage respMsg = new SDTPMessage();
		respMsg.setMessageType(MessageType.XDRRawDataSend_Resp);
		respMsg.setSequenceId(reqMsg.getSequenceId());
		XDRRawDataSendRespMsg respBody = new XDRRawDataSendRespMsg();
		respBody.setMessage(respMsg);
		respBody.setResult(result);
		respMsg.encodeMessage();
		return respMsg;
	}

	public static Object getEntity(SDTPMessage msg) {
		int length = msg.loadInt(2);
		byte[] city = msg.loadByte(2);
		int interfaceType = msg.loadInt(1);
		switch (interfaceType) {
		case 13:
		case 14:
		case 15:
		case 16:
			return sipCall(length, city, msg);
		case 17:
			return svrcc(length, city, msg);
		case 18:
		case 19:
		case 20:
		case 21:
			return authen(length, city, msg);
		case 22:
		case 23:
			return pcc(length, city, msg);
		default:
			throw new IllegalArgumentException("不支持的消息类型");
		}
	}

	private static SipCallEntity sipCall(int length, byte[] city,
			SDTPMessage msg) {
		SipCallEntity entity = new SipCallEntity();
		entity.setProcedureType(msg.loadInt(1));
		entity.setProcedureStartTime(msg.loadStr(8));
		entity.setProcedureEndTime(msg.loadStr(8));
		entity.setServiceType(msg.loadInt(1));
		entity.setProcedureStatus(msg.loadInt(1));

		entity.setUserIpv4(msg.loadStr(4));
		entity.setUserIpv6(msg.loadStr(16));
		entity.setCallid(msg.loadStr(64));
		entity.setIcid(msg.loadStr(64));
		entity.setSourceNeIp(msg.loadStr(1));
		entity.setSourceNeIp(msg.loadStr(16));
		entity.setSourceNePort(msg.loadInt(2));
		entity.setDestNeType(msg.loadInt(1));
		entity.setDestNeIp(msg.loadStr(16));
		entity.setDestNePort(msg.loadInt(2));
		entity.setCallSide(msg.loadInt(1));
		
		entity.setImpiUri(msg.loadStr(64));
		entity.setImpiUri(msg.loadStr(64));
		
		entity.setImpuTelUri1(msg.loadStr(64));
		entity.setImpuSipUri1(msg.loadStr(64));
		entity.setImpu1Type(msg.loadInt(1));
		
		entity.setImpuTelUri2(msg.loadStr(64));
		entity.setImpuSipUri2(msg.loadStr(64));
		entity.setImpu2Type(msg.loadInt(1));
		
		entity.setImpuTelUri3(msg.loadStr(64));
		entity.setImpuSipUri3(msg.loadStr(64));
		entity.setImpu3Type(msg.loadInt(1));
		
		entity.setImpuTelUri4(msg.loadStr(64));
		entity.setImpuSipUri4(msg.loadStr(64));
		entity.setImpu4Type(msg.loadInt(1));
		
		entity.setImpuTelUri5(msg.loadStr(64));
		entity.setImpuSipUri5(msg.loadStr(64));
		entity.setImpu5Type(msg.loadInt(1));

		entity.setTermUntrustIpAddr(msg.loadStr(16));
		entity.setTermUntrustPort(msg.loadInt(2));
		entity.setTermTrustIpAddr(msg.loadStr(16));
		entity.setTermTrustPort(msg.loadInt(2));
		entity.setDeviceType(msg.loadStr(64));
		entity.setAccessType(msg.loadInt(1));
		entity.setAccessInfo(msg.loadStr(64));
		entity.setVisitDomain(msg.loadStr(64));
		entity.setHomeDomain(msg.loadStr(64));
		entity.setAuthType(msg.loadInt(1));
		
		entity.setExpiresTimeReq(msg.loadStr(4));
		entity.setExpiresTimeRsp(msg.loadStr(4));
		entity.setCallingPartyTelUrl(msg.loadStr(32));
		entity.setCallingPartySipUrl(msg.loadStr(64));
		entity.setRequestTelUrl(msg.loadStr(32));
		entity.setRequestSipUrl(msg.loadStr(64));
		entity.setCallingAudioSdpIpAddr(msg.loadStr(16));
		entity.setCalledAudioSdpPort(msg.loadInt(2));
		entity.setCalledAudioSdpIpAddr(msg.loadStr(16));
		entity.setCalledAudioSdpPort(msg.loadInt(2));
		entity.setAudioCodec(msg.loadInt(1));
		
		entity.setCallingVideoSdpIpAddr(msg.loadStr(16));
		entity.setCallingVideoSdpPort(msg.loadInt(2));
		entity.setCalledVideoIpAddr(msg.loadStr(16));
		entity.setCalledVideoPort(msg.loadInt(2));
		entity.setVideoCodec(msg.loadInt(1));
		entity.setCallingAddrIdentity(msg.loadStr(32));
		entity.setCalledAddrIdentity(msg.loadStr(32));
		entity.setRedirectingPartyAddress(msg.loadStr(32));
		entity.setOriginalPartyAddress(msg.loadStr(32));
		entity.setRedirectReason(msg.loadInt(1));
		entity.setCallDirectNumber(msg.loadStr(32));
		entity.setOnlyMainNumber(msg.loadStr(32));
		entity.setConfUri(msg.loadStr(64));
		entity.setSessionTerminateFlag(msg.loadInt(1));
		entity.setReleaseEarly(msg.loadInt(1));
		entity.setResponseCode(msg.loadInt(2));
		entity.setFinishWarning(msg.loadStr(128));
		entity.setFinishReason(msg.loadStr(128));
		// FIRFAILTIME time 4 全F 第一拆线时间
		entity.set
		// FIRST_FAIL_NE_TYPE unsigendint 1 全F 第一拆线网元类型
		entity.set
		// 0: 终端
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
		// 17: VIG Server
		// 18: PCRF
		// 19: S-GW
		// 20: P-GW
		// 21: HSS
		// 255: 未知/Unknow
		// FIRST_FAIL_NE_IP byte 16 全F 第一拆线网元IP
		entity.set
		// ALERTING_TIME time 4 全F
		entity.set
		// 呼叫接通时间。本字段为相对时间，以先收到的无P-Early-Media头域的180响应消息或带有P-Early-Media头域、且无Reason头域的183响应消息时间为准
		// ANSWER_TIME time 4 全F 呼叫应答时间。本字段为相对时间
		entity.set
		// RELEASE_TIME time 4 全F 呼叫释放时间。本字段为相对时间
		entity.set
		// CALL_DURATION byte 4 全F 通话时长
		entity.set
		// AUTH_REQ_TIME time 4 全F 鉴权请求时间
		entity.set
		// AUTH_RSP_TIME time 4 全F 鉴权响应时间。本字段为相对时间
		entity.set

		System.out.println(entity);
		return entity;
	}

	private static AuthenEntity authen(int length, byte[] city, SDTPMessage msg) {
		AuthenEntity entity = new AuthenEntity();

		System.out.println(entity);
		return entity;
	}

	private static SrvccEntity svrcc(int length, byte[] city, SDTPMessage msg) {
		SrvccEntity entity = new SrvccEntity();
		entity.setLength(length);
		entity.setCity(TBCDUtil.dumpBytes(city));
		entity.setInterFace(17);
		entity.setXdrId(msg.loadStr(16));
		entity.setRat(msg.loadInt(1));
		entity.setImsi(msg.loadStr(8));
		entity.setImei(msg.loadStr(8));
		entity.setMsisdn(msg.loadStr(16));

		entity.setProcedureType(msg.loadInt(1));
		Date startTime = new Date(msg.loadLong(8));
		entity.setProcedureStartTime(format.format(startTime));
		Date endtime = new Date(msg.loadLong(8));
		entity.setProcedureEndTime(format.format(endtime));

		entity.setUserIpv4(msg.loadStr(4));
		entity.setUserIpv6(msg.loadStr(16));
		entity.setCallid(msg.loadStr(64));
		entity.setIcid(msg.loadStr(64));

		entity.setSourceNeType(msg.loadInt(1));
		entity.setSourceNeIp(msg.loadStr(16)); // XXX
		entity.setSourceNePort(msg.loadInt(2));
		entity.setDestNeType(msg.loadInt(1));
		entity.setDestNeIp(msg.loadStr(16)); // XXX
		entity.setDestNePort(msg.loadInt(2));

		entity.setRoamDirection(msg.loadInt(1));
		String IMPI_TEL_URI = msg.loadStr(64);
		String IMPI_SIP_URI = msg.loadStr(64);
		entity.setImpuTelUri(msg.loadStr(64));
		entity.setImpuSipUri(msg.loadStr(64));

		entity.setHomeMcc(msg.loadInt(2));
		entity.setHomeMnc(msg.loadInt(2));
		entity.setMcc(msg.loadInt(2));
		entity.setMnc(msg.loadInt(2));
		entity.setLai(msg.loadStr(8));
		entity.setRaiTai(msg.loadStr(8));
		entity.setSaiCgiEcgi(msg.loadStr(28));
		entity.setApn(msg.loadStr(64));
		entity.setSvFlags(msg.loadInt(1));

		entity.setUlCMscIp(msg.loadStr(16));
		entity.setDlCMmeIp(msg.loadStr(16));
		entity.setUlCMscTeid(msg.loadStr(4));
		entity.setDlCMmeTeid(msg.loadStr(4));

		entity.setStrSr(msg.loadStr(24));
		entity.setTargetRncId(msg.loadStr(4));
		entity.setTargetCellId(msg.loadStr(4));
		entity.setArp(msg.loadInt(1));
		entity.setPlmnId(msg.loadStr(4));

		entity.setRejectedCause(msg.loadStr(1));
		entity.setRequestResult(msg.loadStr(1));
		entity.setResult(msg.loadInt(1));
		entity.setSvCause(msg.loadInt(1));
		entity.setRespDelay(String.valueOf(msg.loadLong(4)));
		entity.setSvDelay(String.valueOf(msg.loadLong(4)));
		entity.setMsisdnCapability(msg.loadStr(1));
		entity.setCurEci(msg.loadStr(4));
		entity.setCurTac(msg.loadStr(2));
		System.out.println(entity);
		return entity;
	}

	private static PccEntity pcc(int length, byte[] city, SDTPMessage msg) {
		PccEntity entity = new PccEntity();

		System.out.println(entity);
		return entity;
	}
}