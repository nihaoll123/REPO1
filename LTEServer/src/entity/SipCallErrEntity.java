package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Entity 表示当前为实体类
@Table(name = "xdr_sipcallerr")
// 映射数据库表名称
public class SipCallErrEntity {

	private static final long serialVersionUID = -8463666468357526126L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Length")
	private int length;

	@Column(name = "City")
	private String city;

	@Column(name = "Interface")
	private int interFace;

	@Column(name = "XDR_ID")
	private String xdrId;

	@Column(name = "RAT")
	private int rat;

	@Column(name = "IMSI")
	private String imsi;

	@Column(name = "IMEI")
	private String imei;

	@Column(name = "MSISDN")
	private String msisdn;

	@Column(name = "Procedure_Type")
	private int procedureType;

	@Column(name = "Procedure_Start_Time")
	private String procedureStartTime;

	@Column(name = "Procedure_End_Time")
	private String procedureEndTime;

	@Column(name = "Service_Type")
	private int serviceType;

	@Column(name = "Procedure_Status")
	private int procedureStatus;

	@Column(name = "USER_IPv4")
	private String userIpv4;

	@Column(name = "USER_IPv6")
	private String userIpv6;

	@Column(name = "CALLID")
	private String callid;

	@Column(name = "ICID")
	private String icid;

	@Column(name = "SOURCE_NE_TYPE")
	private int sourceNeType;

	@Column(name = "SOURCE_NE_IP")
	private String sourceNeIp;

	@Column(name = "SOURCE_NE_PORT")
	private int sourceNePort;

	@Column(name = "DEST_NE_TYPE")
	private int destNeType;

	@Column(name = "DEST_NE_IP")
	private String destNeIp;

	@Column(name = "DEST_NE_PORT")
	private int destNePort;

	@Column(name = "CALL_SIDE")
	private int callSide;

	@Column(name = "IMPI_URI")
	private String impiUri;

	@Column(name = "IMPU_TEL_URI1")
	private String impuTelUri1;

	@Column(name = "IMPU_SIP_URI1")
	private String impuSipUri1;

	@Column(name = "IMPU1_TYPE")
	private int impu1Type;

	@Column(name = "IMPU_TEL_URI2")
	private String impuTelUri2;

	@Column(name = "IMPU_SIP_URI2")
	private String impuSipUri2;

	@Column(name = "IMPU2_TYPE")
	private int impu2Type;

	@Column(name = "IMPU_TEL_URI3")
	private String impuTelUri3;

	@Column(name = "IMPU_SIP_URI3")
	private String impuSipUri3;

	@Column(name = "IMPU3_TYPE")
	private int impu3Type;

	@Column(name = "IMPU_TEL_URI4")
	private String impuTelUri4;

	@Column(name = "IMPU_SIP_URI4")
	private String impuSipUri4;

	@Column(name = "IMPU4_TYPE")
	private int impu4Type;

	@Column(name = "IMPU_TEL_URI5")
	private String impuTelUri5;

	@Column(name = "IMPU_SIP_URI5")
	private String impuSipUri5;

	@Column(name = "IMPU5_TYPE")
	private int impu5Type;

	@Column(name = "TERM_UNTRUST_IP_ADDR")
	private String termUntrustIpAddr;

	@Column(name = "TERM_UNTRUST_PORT")
	private int termUntrustPort;

	@Column(name = "TERM_TRUST_IP_ADDR")
	private String termTrustIpAddr;

	@Column(name = "TERM_TRUST_PORT")
	private int termTrustPort;

	@Column(name = "DEVICE_TYPE")
	private String deviceType;

	@Column(name = "ACCESS_TYPE")
	private int accessType;

	@Column(name = "ACCESS_INFO")
	private String accessInfo;

	@Column(name = "VISIT_DOMAIN")
	private String visitDomain;

	@Column(name = "HOME_DOMAIN")
	private String homeDomain;

	@Column(name = "AUTH_TYPE")
	private int authType;

	@Column(name = "EXPIRES_TIME_REQ")
	private String expiresTimeReq;

	@Column(name = "EXPIRES_TIME_RSP")
	private String expiresTimeRsp;

	@Column(name = "CALLING_PARTY_TEL_URI")
	private String callingPartyTelUrl;

	@Column(name = "CALLING_PARTY_SIP_URI")
	private String callingPartySipUrl;

	@Column(name = "REQUEST_TEL_URI")
	private String requestTelUrl;

	@Column(name = "REQUEST_SIP_URI")
	private String requestSipUrl;

	@Column(name = "CALLING_AUDIO_SDP_IP_ADDR")
	private String callingAudioSdpIpAddr;

	@Column(name = "CALLING_AUDIO_SDP_PORT")
	private int callingAudioSdpPort;

	@Column(name = "CALLED_AUDIO_SDP_IP_ADDR")
	private String calledAudioSdpIpAddr;

	@Column(name = "CALLED_AUDIO_SDP_PORT")
	private int calledAudioSdpPort;

	@Column(name = "AUDIO_CODEC")
	private int audioCodec;

	@Column(name = "CALLING_VIDEO_SDP_IP_ADDR")
	private String callingVideoSdpIpAddr;

	@Column(name = "CALLING_VIDEO_SDP_PORT")
	private int callingVideoSdpPort;

	@Column(name = "CALLED_VIDEO_IP_ADDR")
	private String calledVideoIpAddr;

	@Column(name = "CALLED_VIDEO_PORT")
	private int calledVideoPort;

	@Column(name = "VIDEO_CODEC")
	private int videoCodec;

	@Column(name = "CALLING_ADDR_IDENTITY")
	private String callingAddrIdentity;

	@Column(name = "CALLED_ADDR_IDENTITY")
	private String calledAddrIdentity;

	@Column(name = "REDIRECTING_PARTY_ADDRESS")
	private String redirectingPartyAddress;

	@Column(name = "ORIGINAL_PARTY_ADDRESS")
	private String originalPartyAddress;

	@Column(name = "REDIRECT_REASON")
	private int redirectReason;

	@Column(name = "CALL_DIRECT_NUMBER")
	private String callDirectNumber;

	@Column(name = "ONLY_MAIN_NUMBER")
	private String onlyMainNumber;

	@Column(name = "CONF_URI")
	private String confUri;

	@Column(name = "SESSION_TERMINATE_FLAG")
	private int sessionTerminateFlag;

	@Column(name = "RELEASE_EARLY")
	private int releaseEarly;

	@Column(name = "RESPONSE_CODE")
	private int responseCode;

	@Column(name = "FINISH_WARNING")
	private String finishWarning;

	@Column(name = "FINISH_REASON")
	private String finishReason;

	@Column(name = "FIRFAILTIME")
	private String firfailtime;

	@Column(name = "FIRST_FAIL_NE_TYPE")
	private int firstFailNeType;

	@Column(name = "FIRST_FAIL_NE_IP")
	private String firstFailNeIp;

	@Column(name = "ALERTING_TIME")
	private String alertineTime;

	@Column(name = "ANSWER_TIME")
	private String answerTime;

	@Column(name = "RELEASE_TIME")
	private String releaseTime;

	@Column(name = "CALL_DURATION")
	private String callDuration;

	@Column(name = "AUTH_REQ_TIME")
	private String authReqTime;

	@Column(name = "AUTH_RSP_TIME")
	private String authRspTime;

	@Column(name = "INSERT_DATE")
	private String insertDate;

	@Column(name = "Extend1")
	private String extend1;

	@Column(name = "Extend2")
	private String extend2;

	@Column(name = "Extend3")
	private String extend3;

	@Column(name = "Extend4")
	private String extend4;

	@Column(name = "Extend5")
	private String extend5;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getInterFace() {
		return interFace;
	}

	public void setInterFace(int interFace) {
		this.interFace = interFace;
	}

	public String getXdrId() {
		return xdrId;
	}

	public void setXdrId(String xdrId) {
		this.xdrId = xdrId;
	}

	public int getRat() {
		return rat;
	}

	public void setRat(int rat) {
		this.rat = rat;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public int getProcedureType() {
		return procedureType;
	}

	public void setProcedureType(int procedureType) {
		this.procedureType = procedureType;
	}

	public String getProcedureStartTime() {
		return procedureStartTime;
	}

	public void setProcedureStartTime(String procedureStartTime) {
		this.procedureStartTime = procedureStartTime;
	}

	public String getProcedureEndTime() {
		return procedureEndTime;
	}

	public void setProcedureEndTime(String procedureEndTime) {
		this.procedureEndTime = procedureEndTime;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public int getProcedureStatus() {
		return procedureStatus;
	}

	public void setProcedureStatus(int procedureStatus) {
		this.procedureStatus = procedureStatus;
	}

	public String getUserIpv4() {
		return userIpv4;
	}

	public void setUserIpv4(String userIpv4) {
		this.userIpv4 = userIpv4;
	}

	public String getUserIpv6() {
		return userIpv6;
	}

	public void setUserIpv6(String userIpv6) {
		this.userIpv6 = userIpv6;
	}

	public String getCallid() {
		return callid;
	}

	public void setCallid(String callid) {
		this.callid = callid;
	}

	public String getIcid() {
		return icid;
	}

	public void setIcid(String icid) {
		this.icid = icid;
	}

	public int getSourceNeType() {
		return sourceNeType;
	}

	public void setSourceNeType(int sourceNeType) {
		this.sourceNeType = sourceNeType;
	}

	public String getSourceNeIp() {
		return sourceNeIp;
	}

	public void setSourceNeIp(String sourceNeIp) {
		this.sourceNeIp = sourceNeIp;
	}

	public int getSourceNePort() {
		return sourceNePort;
	}

	public void setSourceNePort(int sourceNePort) {
		this.sourceNePort = sourceNePort;
	}

	public int getDestNeType() {
		return destNeType;
	}

	public void setDestNeType(int destNeType) {
		this.destNeType = destNeType;
	}

	public String getDestNeIp() {
		return destNeIp;
	}

	public void setDestNeIp(String destNeIp) {
		this.destNeIp = destNeIp;
	}

	public int getDestNePort() {
		return destNePort;
	}

	public void setDestNePort(int destNePort) {
		this.destNePort = destNePort;
	}

	public int getCallSide() {
		return callSide;
	}

	public void setCallSide(int callSide) {
		this.callSide = callSide;
	}

	public String getImpiUri() {
		return impiUri;
	}

	public void setImpiUri(String impiUri) {
		this.impiUri = impiUri;
	}

	public String getImpuTelUri1() {
		return impuTelUri1;
	}

	public void setImpuTelUri1(String impuTelUri1) {
		this.impuTelUri1 = impuTelUri1;
	}

	public String getImpuSipUri1() {
		return impuSipUri1;
	}

	public void setImpuSipUri1(String impuSipUri1) {
		this.impuSipUri1 = impuSipUri1;
	}

	public int getImpu1Type() {
		return impu1Type;
	}

	public void setImpu1Type(int impu1Type) {
		this.impu1Type = impu1Type;
	}

	public String getImpuTelUri2() {
		return impuTelUri2;
	}

	public void setImpuTelUri2(String impuTelUri2) {
		this.impuTelUri2 = impuTelUri2;
	}

	public String getImpuSipUri2() {
		return impuSipUri2;
	}

	public void setImpuSipUri2(String impuSipUri2) {
		this.impuSipUri2 = impuSipUri2;
	}

	public int getImpu2Type() {
		return impu2Type;
	}

	public void setImpu2Type(int impu2Type) {
		this.impu2Type = impu2Type;
	}

	public String getImpuTelUri3() {
		return impuTelUri3;
	}

	public void setImpuTelUri3(String impuTelUri3) {
		this.impuTelUri3 = impuTelUri3;
	}

	public String getImpuSipUri3() {
		return impuSipUri3;
	}

	public void setImpuSipUri3(String impuSipUri3) {
		this.impuSipUri3 = impuSipUri3;
	}

	public int getImpu3Type() {
		return impu3Type;
	}

	public void setImpu3Type(int impu3Type) {
		this.impu3Type = impu3Type;
	}

	public String getImpuTelUri4() {
		return impuTelUri4;
	}

	public void setImpuTelUri4(String impuTelUri4) {
		this.impuTelUri4 = impuTelUri4;
	}

	public String getImpuSipUri4() {
		return impuSipUri4;
	}

	public void setImpuSipUri4(String impuSipUri4) {
		this.impuSipUri4 = impuSipUri4;
	}

	public int getImpu4Type() {
		return impu4Type;
	}

	public void setImpu4Type(int impu4Type) {
		this.impu4Type = impu4Type;
	}

	public String getImpuTelUri5() {
		return impuTelUri5;
	}

	public void setImpuTelUri5(String impuTelUri5) {
		this.impuTelUri5 = impuTelUri5;
	}

	public String getImpuSipUri5() {
		return impuSipUri5;
	}

	public void setImpuSipUri5(String impuSipUri5) {
		this.impuSipUri5 = impuSipUri5;
	}

	public int getImpu5Type() {
		return impu5Type;
	}

	public void setImpu5Type(int impu5Type) {
		this.impu5Type = impu5Type;
	}

	public String getTermUntrustIpAddr() {
		return termUntrustIpAddr;
	}

	public void setTermUntrustIpAddr(String termUntrustIpAddr) {
		this.termUntrustIpAddr = termUntrustIpAddr;
	}

	public int getTermUntrustPort() {
		return termUntrustPort;
	}

	public void setTermUntrustPort(int termUntrustPort) {
		this.termUntrustPort = termUntrustPort;
	}

	public String getTermTrustIpAddr() {
		return termTrustIpAddr;
	}

	public void setTermTrustIpAddr(String termTrustIpAddr) {
		this.termTrustIpAddr = termTrustIpAddr;
	}

	public int getTermTrustPort() {
		return termTrustPort;
	}

	public void setTermTrustPort(int termTrustPort) {
		this.termTrustPort = termTrustPort;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public int getAccessType() {
		return accessType;
	}

	public void setAccessType(int accessType) {
		this.accessType = accessType;
	}

	public String getAccessInfo() {
		return accessInfo;
	}

	public void setAccessInfo(String accessInfo) {
		this.accessInfo = accessInfo;
	}

	public String getVisitDomain() {
		return visitDomain;
	}

	public void setVisitDomain(String visitDomain) {
		this.visitDomain = visitDomain;
	}

	public String getHomeDomain() {
		return homeDomain;
	}

	public void setHomeDomain(String homeDomain) {
		this.homeDomain = homeDomain;
	}

	public int getAuthType() {
		return authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}

	public String getExpiresTimeReq() {
		return expiresTimeReq;
	}

	public void setExpiresTimeReq(String expiresTimeReq) {
		this.expiresTimeReq = expiresTimeReq;
	}

	public String getExpiresTimeRsp() {
		return expiresTimeRsp;
	}

	public void setExpiresTimeRsp(String expiresTimeRsp) {
		this.expiresTimeRsp = expiresTimeRsp;
	}

	public String getCallingPartyTelUrl() {
		return callingPartyTelUrl;
	}

	public void setCallingPartyTelUrl(String callingPartyTelUrl) {
		this.callingPartyTelUrl = callingPartyTelUrl;
	}

	public String getCallingPartySipUrl() {
		return callingPartySipUrl;
	}

	public void setCallingPartySipUrl(String callingPartySipUrl) {
		this.callingPartySipUrl = callingPartySipUrl;
	}

	public String getRequestTelUrl() {
		return requestTelUrl;
	}

	public void setRequestTelUrl(String requestTelUrl) {
		this.requestTelUrl = requestTelUrl;
	}

	public String getRequestSipUrl() {
		return requestSipUrl;
	}

	public void setRequestSipUrl(String requestSipUrl) {
		this.requestSipUrl = requestSipUrl;
	}

	public String getCallingAudioSdpIpAddr() {
		return callingAudioSdpIpAddr;
	}

	public void setCallingAudioSdpIpAddr(String callingAudioSdpIpAddr) {
		this.callingAudioSdpIpAddr = callingAudioSdpIpAddr;
	}

	public int getCallingAudioSdpPort() {
		return callingAudioSdpPort;
	}

	public void setCallingAudioSdpPort(int callingAudioSdpPort) {
		this.callingAudioSdpPort = callingAudioSdpPort;
	}

	public String getCalledAudioSdpIpAddr() {
		return calledAudioSdpIpAddr;
	}

	public void setCalledAudioSdpIpAddr(String calledAudioSdpIpAddr) {
		this.calledAudioSdpIpAddr = calledAudioSdpIpAddr;
	}

	public int getCalledAudioSdpPort() {
		return calledAudioSdpPort;
	}

	public void setCalledAudioSdpPort(int calledAudioSdpPort) {
		this.calledAudioSdpPort = calledAudioSdpPort;
	}

	public int getAudioCodec() {
		return audioCodec;
	}

	public void setAudioCodec(int audioCodec) {
		this.audioCodec = audioCodec;
	}

	public String getCallingVideoSdpIpAddr() {
		return callingVideoSdpIpAddr;
	}

	public void setCallingVideoSdpIpAddr(String callingVideoSdpIpAddr) {
		this.callingVideoSdpIpAddr = callingVideoSdpIpAddr;
	}

	public int getCallingVideoSdpPort() {
		return callingVideoSdpPort;
	}

	public void setCallingVideoSdpPort(int callingVideoSdpPort) {
		this.callingVideoSdpPort = callingVideoSdpPort;
	}

	public String getCalledVideoIpAddr() {
		return calledVideoIpAddr;
	}

	public void setCalledVideoIpAddr(String calledVideoIpAddr) {
		this.calledVideoIpAddr = calledVideoIpAddr;
	}

	public int getCalledVideoPort() {
		return calledVideoPort;
	}

	public void setCalledVideoPort(int calledVideoPort) {
		this.calledVideoPort = calledVideoPort;
	}

	public int getVideoCodec() {
		return videoCodec;
	}

	public void setVideoCodec(int videoCodec) {
		this.videoCodec = videoCodec;
	}

	public String getCallingAddrIdentity() {
		return callingAddrIdentity;
	}

	public void setCallingAddrIdentity(String callingAddrIdentity) {
		this.callingAddrIdentity = callingAddrIdentity;
	}

	public String getCalledAddrIdentity() {
		return calledAddrIdentity;
	}

	public void setCalledAddrIdentity(String calledAddrIdentity) {
		this.calledAddrIdentity = calledAddrIdentity;
	}

	public String getRedirectingPartyAddress() {
		return redirectingPartyAddress;
	}

	public void setRedirectingPartyAddress(String redirectingPartyAddress) {
		this.redirectingPartyAddress = redirectingPartyAddress;
	}

	public String getOriginalPartyAddress() {
		return originalPartyAddress;
	}

	public void setOriginalPartyAddress(String originalPartyAddress) {
		this.originalPartyAddress = originalPartyAddress;
	}

	public int getRedirectReason() {
		return redirectReason;
	}

	public void setRedirectReason(int redirectReason) {
		this.redirectReason = redirectReason;
	}

	public String getCallDirectNumber() {
		return callDirectNumber;
	}

	public void setCallDirectNumber(String callDirectNumber) {
		this.callDirectNumber = callDirectNumber;
	}

	public String getOnlyMainNumber() {
		return onlyMainNumber;
	}

	public void setOnlyMainNumber(String onlyMainNumber) {
		this.onlyMainNumber = onlyMainNumber;
	}

	public String getConfUri() {
		return confUri;
	}

	public void setConfUri(String confUri) {
		this.confUri = confUri;
	}

	public int getSessionTerminateFlag() {
		return sessionTerminateFlag;
	}

	public void setSessionTerminateFlag(int sessionTerminateFlag) {
		this.sessionTerminateFlag = sessionTerminateFlag;
	}

	public int getReleaseEarly() {
		return releaseEarly;
	}

	public void setReleaseEarly(int releaseEarly) {
		this.releaseEarly = releaseEarly;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getFinishWarning() {
		return finishWarning;
	}

	public void setFinishWarning(String finishWarning) {
		this.finishWarning = finishWarning;
	}

	public String getFinishReason() {
		return finishReason;
	}

	public void setFinishReason(String finishReason) {
		this.finishReason = finishReason;
	}

	public String getFirfailtime() {
		return firfailtime;
	}

	public void setFirfailtime(String firfailtime) {
		this.firfailtime = firfailtime;
	}

	public int getFirstFailNeType() {
		return firstFailNeType;
	}

	public void setFirstFailNeType(int firstFailNeType) {
		this.firstFailNeType = firstFailNeType;
	}

	public String getFirstFailNeIp() {
		return firstFailNeIp;
	}

	public void setFirstFailNeIp(String firstFailNeIp) {
		this.firstFailNeIp = firstFailNeIp;
	}

	public String getAlertineTime() {
		return alertineTime;
	}

	public void setAlertineTime(String alertineTime) {
		this.alertineTime = alertineTime;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(String callDuration) {
		this.callDuration = callDuration;
	}

	public String getAuthReqTime() {
		return authReqTime;
	}

	public void setAuthReqTime(String authReqTime) {
		this.authReqTime = authReqTime;
	}

	public String getAuthRspTime() {
		return authRspTime;
	}

	public void setAuthRspTime(String authRspTime) {
		this.authRspTime = authRspTime;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	public String getExtend4() {
		return extend4;
	}

	public void setExtend4(String extend4) {
		this.extend4 = extend4;
	}

	public String getExtend5() {
		return extend5;
	}

	public void setExtend5(String extend5) {
		this.extend5 = extend5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SipCallErrEntity [id=" + id + ", length=" + length + ", city="
				+ city + ", interFace=" + interFace + ", xdrId=" + xdrId
				+ ", rat=" + rat + ", imsi=" + imsi + ", imei=" + imei
				+ ", msisdn=" + msisdn + ", procedureType=" + procedureType
				+ ", procedureStartTime=" + procedureStartTime
				+ ", procedureEndTime=" + procedureEndTime + ", serviceType="
				+ serviceType + ", procedureStatus=" + procedureStatus
				+ ", userIpv4=" + userIpv4 + ", userIpv6=" + userIpv6
				+ ", callid=" + callid + ", icid=" + icid + ", sourceNeType="
				+ sourceNeType + ", sourceNeIp=" + sourceNeIp
				+ ", sourceNePort=" + sourceNePort + ", destNeType="
				+ destNeType + ", destNeIp=" + destNeIp + ", destNePort="
				+ destNePort + ", callSide=" + callSide + ", impiUri="
				+ impiUri + ", impuTelUri1=" + impuTelUri1 + ", impuSipUri1="
				+ impuSipUri1 + ", impu1Type=" + impu1Type + ", impuTelUri2="
				+ impuTelUri2 + ", impuSipUri2=" + impuSipUri2 + ", impu2Type="
				+ impu2Type + ", impuTelUri3=" + impuTelUri3 + ", impuSipUri3="
				+ impuSipUri3 + ", impu3Type=" + impu3Type + ", impuTelUri4="
				+ impuTelUri4 + ", impuSipUri4=" + impuSipUri4 + ", impu4Type="
				+ impu4Type + ", impuTelUri5=" + impuTelUri5 + ", impuSipUri5="
				+ impuSipUri5 + ", impu5Type=" + impu5Type
				+ ", termUntrustIpAddr=" + termUntrustIpAddr
				+ ", termUntrustPort=" + termUntrustPort + ", termTrustIpAddr="
				+ termTrustIpAddr + ", termTrustPort=" + termTrustPort
				+ ", deviceType=" + deviceType + ", accessType=" + accessType
				+ ", accessInfo=" + accessInfo + ", visitDomain=" + visitDomain
				+ ", homeDomain=" + homeDomain + ", authType=" + authType
				+ ", expiresTimeReq=" + expiresTimeReq + ", expiresTimeRsp="
				+ expiresTimeRsp + ", callingPartyTelUrl=" + callingPartyTelUrl
				+ ", callingPartySipUrl=" + callingPartySipUrl
				+ ", requestTelUrl=" + requestTelUrl + ", requestSipUrl="
				+ requestSipUrl + ", callingAudioSdpIpAddr="
				+ callingAudioSdpIpAddr + ", callingAudioSdpPort="
				+ callingAudioSdpPort + ", calledAudioSdpIpAddr="
				+ calledAudioSdpIpAddr + ", calledAudioSdpPort="
				+ calledAudioSdpPort + ", audioCodec=" + audioCodec
				+ ", callingVideoSdpIpAddr=" + callingVideoSdpIpAddr
				+ ", callingVideoSdpPort=" + callingVideoSdpPort
				+ ", calledVideoIpAddr=" + calledVideoIpAddr
				+ ", calledVideoPort=" + calledVideoPort + ", videoCodec="
				+ videoCodec + ", callingAddrIdentity=" + callingAddrIdentity
				+ ", calledAddrIdentity=" + calledAddrIdentity
				+ ", redirectingPartyAddress=" + redirectingPartyAddress
				+ ", originalPartyAddress=" + originalPartyAddress
				+ ", redirectReason=" + redirectReason + ", callDirectNumber="
				+ callDirectNumber + ", onlyMainNumber=" + onlyMainNumber
				+ ", confUri=" + confUri + ", sessionTerminateFlag="
				+ sessionTerminateFlag + ", releaseEarly=" + releaseEarly
				+ ", responseCode=" + responseCode + ", finishWarning="
				+ finishWarning + ", finishReason=" + finishReason
				+ ", firfailtime=" + firfailtime + ", firstFailNeType="
				+ firstFailNeType + ", firstFailNeIp=" + firstFailNeIp
				+ ", alertineTime=" + alertineTime + ", answerTime="
				+ answerTime + ", releaseTime=" + releaseTime
				+ ", callDuration=" + callDuration + ", authReqTime="
				+ authReqTime + ", authRspTime=" + authRspTime
				+ ", insertDate=" + insertDate + ", extend1=" + extend1
				+ ", extend2=" + extend2 + ", extend3=" + extend3
				+ ", extend4=" + extend4 + ", extend5=" + extend5 + "]";
	}

}