package clent;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @className：工具类
 * @author B
 * @date:
 * @version : 1.0
 */
public class util {

	/**
	 * @Comments 按照顺序解析为List列表。
	 * @param buffer
	 * @param lengths
	 * @return
	 * @Vsersion: 1.0
	 */
	public static List<String> parseToList(byte[] buffer, int[] lengths) {
		List<String> params = new ArrayList<String>();
		int offSet = 0;// 每次截断起始位置
		String temp = null;
		for (int ix = 0; ix < lengths.length; ix++) {
			// 未指定编码集默认为utf-8
			temp = new String(buffer, offSet, lengths[ix]);
			if (checkNotNull(temp)) {
				temp = temp.trim();
			}
			params.add(temp);
			offSet += lengths[ix];
		}
		return params;
	}

	/**
	 * @Comments 将信息发送返回值编码为数组
	 * @param sendResult
	 * @return
	 * @Vsersion: 1.0
	 */
	public static byte[] encodeToSendbytes(String[] s, int[] lengths) {
		List<byte[]> list = new ArrayList<byte[]>();
		for (int i = 0; i < s.length; i++) {
			if (checkNotNull(s[i]) && isNumeric(s[i])) {
				list.add(buildNumericWithSpace(s[i], lengths[i]));
			} else {
				list.add(buildStringWithSpace(s[i], lengths[i]));
			}
		}
		return bulidByteArr(list);
	}

	/**
	 * @Comments int转byte数组
	 * @param numeric
	 * @param length
	 * @return
	 * @Vsersion: 1.0
	 */
	public static byte[] buildNumericWithSpace(String numeric, int length) {
		int a = Integer.valueOf(numeric);
		byte[] bufParam = new byte[length];
		bufParam[length - 1] = (byte) (a);
		for (int i = 1; i < bufParam.length; i++) {
			bufParam[length - 1 - i] = (byte) (a >>> (8 * i));
		}
		return bufParam;
	}

	/**
	 * @Comments byte数组转int
	 * @param numeric
	 * @param length
	 * @return
	 * @Vsersion: 1.0
	 */
	public static int unbuildNumericWithSpace(byte[] b, int length) {
		int result = 0;
		for (int i = 0; i < length; i++) {
			result += (b[i] & 0xff) << ((length - i - 1) * 8);
		}
		return result;
	}

	/**
	 * @Comments 判断参数是不是数字。数字有特殊的解析方式
	 * @param str
	 * @return
	 * @Vsersion: 1.0
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * @Comments 拼接字符串。若传入参数生成的byte[]小于传入长度，则左补空格，若长度大于等于，则截断。
	 * @param param
	 *            传入的参数
	 * @param length
	 *            此参数长度。
	 * @return
	 * @Vsersion: 1.0
	 */
	public static byte[] buildStringWithSpace(String param, int length) {
		byte[] bufTemp = null;
		// 这里可以转换编码集
		if (checkNotNull(param)) {
			bufTemp = param.getBytes();
		}
		byte[] bufParam = new byte[length];
		if (checkNotNull(bufTemp)) {
			// 参数过长。
			if (bufTemp.length > length) {
				System.out.println(param);
				new Exception("传入的字符串生成的byte[] 比传入的数组长度长").printStackTrace();
			} else {
				// 参数合法
				int offset = length - bufTemp.length;// 偏移量(补空格量。)
				for (int ix = 0; ix < offset; ix++) {
					byte bS = 32;// 32在ascii是空格
					bufParam[ix] = bS;
				}
				for (int ix = 0; ix < bufTemp.length; ix++) {
					bufParam[offset + ix] = bufTemp[ix];
				}
			}
		}
		return bufParam;
	}

	/**
	 * @Comments 将传入的byte数组组装为一个数组
	 * @param byteArrList
	 * @return
	 * @Vsersion: 1.0
	 */
	public static byte[] bulidByteArr(List<byte[]> byteArrList) {
		int arrLenth = 0;
		for (byte[] bs : byteArrList) {
			arrLenth += bs.length;
		}
		byte[] byteArr = new byte[arrLenth];
		int begin = 0;// 起始位置
		for (int ix = 0; ix < byteArrList.size(); ix++) {
			byte[] bArrTemp = byteArrList.get(ix);
			for (int jx = 0; jx < bArrTemp.length; jx++) {
				byteArr[begin++] = bArrTemp[jx];
			}
		}
		return byteArr;
	}

	/**
	 * @Comments 检验空不空
	 * @param buffer
	 * @param lengths
	 * @return
	 * @Vsersion: 1.0
	 */
	public static boolean checkNotNull(final Object value) {
		if (value == null) {
			return false;
		}
		return (value.toString().length() > 0);
	}

	/**
	 * @Comments 检验空不空
	 * @param buffer
	 * @param lengths
	 * @return
	 * @Vsersion: 1.0
	 */
	public static boolean checkNull(final Object value) {
		if (value == null) {
			return true;
		}
		return (value.toString().length() == 0);
	}

}