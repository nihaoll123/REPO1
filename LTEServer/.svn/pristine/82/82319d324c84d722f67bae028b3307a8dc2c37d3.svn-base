package sdtp.message.xdr;

import sdtp.message.MessageBody;

/**
 * 
 * UU/Gm/Sv 等接口公共信息抽象类
 * @author Administrator
 *
 */
public abstract class XdrGlobalInterfaceMsg extends MessageBody {
	/**
	 * unsigned int	2	全F
	 * 指示整个XDR所占用字节数
	 */
	private int length;
	
	/**
	 * byte	2	全F	
	 * 城市区号，如010代表北京采用TBCD编码，每4个比特表示一个十进制数字
	 */
	private byte[] city;
	
	/**
	 * unsigned int	1	全F
	 * 接口类型
	 */
	private InterfaceType interfaceType;
	
	/**
	 * unsigned int	16	全F	
	 * 采集解析服务器内唯一的XDR编号，16进制编码。
	 * 一个信令流程或业务传输过程生成一个XDR ID。
	 * 对于信令面XDR，一个XDR ID可能对应同一信令流程中的多条原始消息记录。
	 * 对于MR XDR，一个XDR ID对应一个MR上报。
	 */
	private int xdrID;
	
	/**
	 * unsigned int	1	全F	
	 * RAT类型：
	 * 1.	UTRAN          
	 * 2.	GERAN         
	 * 3.	WLAN          
	 * 4.	GAN           
	 * 5.	HSPA Evolution
	 * 6.	EUTRAN 
	 */
	private int rat;
	
	/**
	 * byte	8	全F	
	 * 用户IMSI（TBCD编码），通过采集核心网信令获取；
	 * 针对软采接口，该字段填全F，待数据合成服务器进行回填；
	 * 对于Cell_MR XDR，该字段为全F。
	 */
	private byte[] imsi;

	/**
	 * byte	8	全F	
	 * 终端IMEI（TBCD编码），通过采集核心网信令获取；
	 * 针对软采接口，该字段填全F，待数据合成服务器进行回填；
	 * 对于Cell_MR XDR，该字段为全F。
	 */
	private byte[] imei;
	
	/**
	 * byte	16	全F	
	 * 用户号码（TBCD编码），通过采集核心网信令获取；
	 * 针对软采接口，该字段填全F，待数据合成服务器进行回填；
	 * 对于Cell_MR XDR，该字段为全F。
	 */
	private byte[] msisdn;
}
