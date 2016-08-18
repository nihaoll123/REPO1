package sdtp.message;

import java.util.HashMap;
import java.util.Map;

public enum MessageType {
	verNego_Req(0x0001, "版本协商请求"), 
	verNego_Resp(0x8001, "版本协商应答"), 
	linkAuth_Req(0x0002, "鉴权请求"),
	linkAuth_Resp(0x8002,"鉴权响应"), 
	linkCheck_Req(0x0003, "链路检测请求"), 
	linkCheck_Resp(0x8003, "链路检测应答"), 
	linkRel_Req(0x0004, "连接释放请求"), 
	linkRel_Resp(0x8004, "连接释放应答"), 
	linkDataCheck_Req(0x0007, "链路数据发送校验请求"), 
	linkDataCheck_Resp(0x8007, "链路数据发送校验应答"), 
	notifyXDRData_Req(0x0005, "XDR数据通知请求"),
	notifyXDRData_Resp(0x8005, "XDR数据通知应答"), 
	XDRRawDataSend_Req(0x0006, "XDR对应原始数据传输请求"), 
	XDRRawDataSend_Resp(0x8006, "XDR对应原始数据传输应答");

	// 消息值
	private int value;
	// 描述
	private String desc;

	private MessageType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public String getDesc() {
		return desc;
	}

	private static final Map<Integer, MessageType> strValMap;
	public static MessageType getEnum(int value) {
		if (!strValMap.containsKey(value)) {
			throw new IllegalArgumentException("Unknown Enum Value: " + value);
		}
		return strValMap.get(value);
	}

	static {
		final Map<Integer, MessageType> tmpMap = new HashMap<Integer, MessageType>();
		for (final MessageType en : MessageType.values()) {
			tmpMap.put(en.value, en);
		}
		strValMap = tmpMap;
	}
}
