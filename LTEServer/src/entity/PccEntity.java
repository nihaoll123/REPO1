package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Entity 表示当前为实体类
@Table(name = "xdr_pcc")
// 映射数据库表名称
public class PccEntity {

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

	@Column(name = "PCRF_ID")
	private int pcrfId;

	@Column(name = "GGSN_PGW_ID")
	private int ggsnPgwId;

	@Column(name = "SGSN_SGW_SIG_IP")
	private String sgsnSgwSigIp;

	@Column(name = "GGSN_PGW_SIG_Ip")
	private String ggsnPgwSigIp;

	@Column(name = "AF_ID")
	private int afId;

	@Column(name = "AF_IP")
	private String afIp;

	@Column(name = "AAA_CLIENT_IP")
	private String aaaClientIp;

	@Column(name = "AAA_SERVER_IP")
	private String aaaServerIp;

	@Column(name = "TRANS_TYPE")
	private String transType;

	@Column(name = "TRANS_REQ_TIME_SEC")
	private String transReqTimeSec;

	@Column(name = "TRANS_REQ_TIME_MSEC")
	private String transReqTimeMsec;

	@Column(name = "TRANS_RSP_TIME_SEC")
	private String transRspTimeSec;

	@Column(name = "TRANS_RSP_TIME_MSEC")
	private String transRspTimeMsec;

	@Column(name = "TRANS_SUCCED_FLAG")
	private int transSuccedFlag;

	@Column(name = "TRANS_CAUSE_TYPE")
	private int transCauseType;

	@Column(name = "TRANS_CAUSE")
	private int transCause;

	@Column(name = "ABORT_TYPE")
	private int abortType;

	@Column(name = "ABORT_CAUSE")
	private int abortCause;

	@Column(name = "MEDIA_TYPE")
	private String mediaType;

	@Column(name = "RESULT_CODE")
	private int resultCode;

	@Column(name = "EXPERIMENTAL_RESULT_CODE")
	private int experimentalResultCode;

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

	public int getPcrfId() {
		return pcrfId;
	}

	public void setPcrfId(int pcrfId) {
		this.pcrfId = pcrfId;
	}

	public int getGgsnPgwId() {
		return ggsnPgwId;
	}

	public void setGgsnPgwId(int ggsnPgwId) {
		this.ggsnPgwId = ggsnPgwId;
	}

	public String getSgsnSgwSigIp() {
		return sgsnSgwSigIp;
	}

	public void setSgsnSgwSigIp(String sgsnSgwSigIp) {
		this.sgsnSgwSigIp = sgsnSgwSigIp;
	}

	public String getGgsnPgwSigIp() {
		return ggsnPgwSigIp;
	}

	public void setGgsnPgwSigIp(String ggsnPgwSigIp) {
		this.ggsnPgwSigIp = ggsnPgwSigIp;
	}

	public int getAfId() {
		return afId;
	}

	public void setAfId(int afId) {
		this.afId = afId;
	}

	public String getAfIp() {
		return afIp;
	}

	public void setAfIp(String afIp) {
		this.afIp = afIp;
	}

	public String getAaaClientIp() {
		return aaaClientIp;
	}

	public void setAaaClientIp(String aaaClientIp) {
		this.aaaClientIp = aaaClientIp;
	}

	public String getAaaServerIp() {
		return aaaServerIp;
	}

	public void setAaaServerIp(String aaaServerIp) {
		this.aaaServerIp = aaaServerIp;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransReqTimeSec() {
		return transReqTimeSec;
	}

	public void setTransReqTimeSec(String transReqTimeSec) {
		this.transReqTimeSec = transReqTimeSec;
	}

	public String getTransReqTimeMsec() {
		return transReqTimeMsec;
	}

	public void setTransReqTimeMsec(String transReqTimeMsec) {
		this.transReqTimeMsec = transReqTimeMsec;
	}

	public String getTransRspTimeSec() {
		return transRspTimeSec;
	}

	public void setTransRspTimeSec(String transRspTimeSec) {
		this.transRspTimeSec = transRspTimeSec;
	}

	public String getTransRspTimeMsec() {
		return transRspTimeMsec;
	}

	public void setTransRspTimeMsec(String transRspTimeMsec) {
		this.transRspTimeMsec = transRspTimeMsec;
	}

	public int getTransSuccedFlag() {
		return transSuccedFlag;
	}

	public void setTransSuccedFlag(int transSuccedFlag) {
		this.transSuccedFlag = transSuccedFlag;
	}

	public int getTransCauseType() {
		return transCauseType;
	}

	public void setTransCauseType(int transCauseType) {
		this.transCauseType = transCauseType;
	}

	public int getTransCause() {
		return transCause;
	}

	public void setTransCause(int transCause) {
		this.transCause = transCause;
	}

	public int getAbortType() {
		return abortType;
	}

	public void setAbortType(int abortType) {
		this.abortType = abortType;
	}

	public int getAbortCause() {
		return abortCause;
	}

	public void setAbortCause(int abortCause) {
		this.abortCause = abortCause;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public int getExperimentalResultCode() {
		return experimentalResultCode;
	}

	public void setExperimentalResultCode(int experimentalResultCode) {
		this.experimentalResultCode = experimentalResultCode;
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
		return "PccEntity [id=" + id + ", length=" + length + ", city=" + city
				+ ", interFace=" + interFace + ", xdrId=" + xdrId + ", rat="
				+ rat + ", imsi=" + imsi + ", imei=" + imei + ", msisdn="
				+ msisdn + ", procedureType=" + procedureType
				+ ", procedureStartTime=" + procedureStartTime
				+ ", procedureEndTime=" + procedureEndTime + ", icid=" + icid
				+ ", sourceNeType=" + sourceNeType + ", sourceNeIp="
				+ sourceNeIp + ", sourceNePort=" + sourceNePort
				+ ", destNeType=" + destNeType + ", destNeIp=" + destNeIp
				+ ", destNePort=" + destNePort + ", pcrfId=" + pcrfId
				+ ", ggsnPgwId=" + ggsnPgwId + ", sgsnSgwSigIp=" + sgsnSgwSigIp
				+ ", ggsnPgwSigIp=" + ggsnPgwSigIp + ", afId=" + afId
				+ ", afIp=" + afIp + ", aaaClientIp=" + aaaClientIp
				+ ", aaaServerIp=" + aaaServerIp + ", transType=" + transType
				+ ", transReqTimeSec=" + transReqTimeSec
				+ ", transReqTimeMsec=" + transReqTimeMsec
				+ ", transRspTimeSec=" + transRspTimeSec
				+ ", transRspTimeMsec=" + transRspTimeMsec
				+ ", transSuccedFlag=" + transSuccedFlag + ", transCauseType="
				+ transCauseType + ", transCause=" + transCause
				+ ", abortType=" + abortType + ", abortCause=" + abortCause
				+ ", mediaType=" + mediaType + ", resultCode=" + resultCode
				+ ", experimentalResultCode=" + experimentalResultCode
				+ ", insertDate=" + insertDate + ", extend1=" + extend1
				+ ", extend2=" + extend2 + ", extend3=" + extend3
				+ ", extend4=" + extend4 + ", extend5=" + extend5 + "]";
	}

}