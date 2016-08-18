package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Entity 表示当前为实体类
@Table(name = "xdr_authen")
// 映射数据库表名称
public class AuthenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Length", length = 5)
	private String length;

	@Column(name = "City", length = 4)
	private String city;

	@Column(name = "InterFace", length = 3)
	private String interFace;

	@Column(name = "XDR_ID", length = 32)
	private String xdr_id;

	@Column(name = "RAT", length = 3)
	private String rat;

	@Column(name = "IMSI", length = 8)
	private String imsi;

	@Column(name = "IMEI", length = 8)
	private String imei;

	@Column(name = "MSISDN", length = 16)
	private String msisdn;

	@Column(name = "START_TIME")
	private String startTime;

	@Column(name = "END_TIME")
	private String endTime;

	@Column(name = "TRANSACTION_TYPE", length = 3)
	private String transactionType;

	@Column(name = "TRANSACTION_STATUS", length = 3)
	private String transactionStatus;

	@Column(name = "SOURCE_NE_TYPE", length = 3)
	private String sourceNeType;

	@Column(name = "SOURCE_NE_IP", length = 39)
	private String sourceNeIp;

	@Column(name = "SOURCE_NE_PORT", length = 5)
	private String sourceNePort;

	@Column(name = "DESTINATION_NE_TYPE", length = 3)
	private String destinationNeType;

	@Column(name = "DESTINATION_NE_IP", length = 39)
	private String destinationNeIp;

	@Column(name = "DESTINATION_NE_PORT", length = 5)
	private String destinationNePort;

	@Column(name = "RESULT_CODE", length = 10)
	private String resultCode;

	@Column(name = "EXPERIMENTAL_RESULT_CODE", length = 10)
	private String experimentalResultCode;

	@Column(name = "ORIGIN_REALM", length = 127)
	private String originRealm;

	@Column(name = "DESTINATION_REALM", length = 127)
	private String destinationRealm;

	@Column(name = "ORIGIN_HOST", length = 127)
	private String originHost;

	@Column(name = "DESTINATION_HOST", length = 127)
	private String destinationHost;

	@Column(name = "GENERAL_ODB", length = 32)
	private String generalOdb;

	@Column(name = "HPLMN_ODB", length = 32)
	private String hplmnOdb;

	@Column(name = "INSERT_DATE")
	private String insertDate;

	@Column(name = "EXTEND1", length = 50)
	private String extend1;

	@Column(name = "EXTEND2", length = 50)
	private String extend2;

	@Column(name = "EXTEND3", length = 50)
	private String extend3;

	@Column(name = "EXTEND4", length = 50)
	private String extend4;

	@Column(name = "EXTEND5", length = 50)
	private String extend5;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getInterFace() {
		return interFace;
	}

	public void setInterFace(String interFace) {
		this.interFace = interFace;
	}

	public String getXdr_id() {
		return xdr_id;
	}

	public void setXdr_id(String xdr_id) {
		this.xdr_id = xdr_id;
	}

	public String getRat() {
		return rat;
	}

	public void setRat(String rat) {
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getSourceNeType() {
		return sourceNeType;
	}

	public void setSourceNeType(String sourceNeType) {
		this.sourceNeType = sourceNeType;
	}

	public String getSourceNeIp() {
		return sourceNeIp;
	}

	public void setSourceNeIp(String sourceNeIp) {
		this.sourceNeIp = sourceNeIp;
	}

	public String getSourceNePort() {
		return sourceNePort;
	}

	public void setSourceNePort(String sourceNePort) {
		this.sourceNePort = sourceNePort;
	}

	public String getDestinationNeType() {
		return destinationNeType;
	}

	public void setDestinationNeType(String destinationNeType) {
		this.destinationNeType = destinationNeType;
	}

	public String getDestinationNeIp() {
		return destinationNeIp;
	}

	public void setDestinationNeIp(String destinationNeIp) {
		this.destinationNeIp = destinationNeIp;
	}

	public String getDestinationNePort() {
		return destinationNePort;
	}

	public void setDestinationNePort(String destinationNePort) {
		this.destinationNePort = destinationNePort;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getExperimentalResultCode() {
		return experimentalResultCode;
	}

	public void setExperimentalResultCode(String experimentalResultCode) {
		this.experimentalResultCode = experimentalResultCode;
	}

	public String getOriginRealm() {
		return originRealm;
	}

	public void setOriginRealm(String originRealm) {
		this.originRealm = originRealm;
	}

	public String getDestinationRealm() {
		return destinationRealm;
	}

	public void setDestinationRealm(String destinationRealm) {
		this.destinationRealm = destinationRealm;
	}

	public String getOriginHost() {
		return originHost;
	}

	public void setOriginHost(String originHost) {
		this.originHost = originHost;
	}

	public String getDestinationHost() {
		return destinationHost;
	}

	public void setDestinationHost(String destinationHost) {
		this.destinationHost = destinationHost;
	}

	public String getGeneralOdb() {
		return generalOdb;
	}

	public void setGeneralOdb(String generalOdb) {
		this.generalOdb = generalOdb;
	}

	public String getHplmnOdb() {
		return hplmnOdb;
	}

	public void setHplmnOdb(String hplmnOdb) {
		this.hplmnOdb = hplmnOdb;
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

	@Override
	public String toString() {
		return "AuthenEntity [id=" + id + ", length=" + length + ", city="
				+ city + ", interFace=" + interFace + ", xdr_id=" + xdr_id
				+ ", rat=" + rat + ", imsi=" + imsi + ", imei=" + imei
				+ ", msisdn=" + msisdn + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", transactionType="
				+ transactionType + ", transactionStatus=" + transactionStatus
				+ ", sourceNeType=" + sourceNeType + ", sourceNeIp="
				+ sourceNeIp + ", sourceNePort=" + sourceNePort
				+ ", destinationNeType=" + destinationNeType
				+ ", destinationNeIp=" + destinationNeIp
				+ ", destinationNePort=" + destinationNePort + ", resultCode="
				+ resultCode + ", experimentalResultCode="
				+ experimentalResultCode + ", originRealm=" + originRealm
				+ ", destinationRealm=" + destinationRealm + ", originHost="
				+ originHost + ", destinationHost=" + destinationHost
				+ ", generalOdb=" + generalOdb + ", hplmnOdb=" + hplmnOdb
				+ ", insertDate=" + insertDate + ", extend1=" + extend1
				+ ", extend2=" + extend2 + ", extend3=" + extend3
				+ ", extend4=" + extend4 + ", extend5=" + extend5 + "]";
	}
}