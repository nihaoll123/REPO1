package test;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @className：测试
 * @author B
 * @date:
 * @version :
 */
public class test {
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.nextInt());
	}

	private static byte[] buildNumericWithSpace(String numeric, int length) {
		int a = Integer.valueOf(numeric);
		byte[] bufParam = new byte[length];
		bufParam[length - 1] = (byte) (a);
		for (int i = 1; i < bufParam.length; i++) {
			bufParam[length - 1 - i] = (byte) (a >>> (8 * i));
		}
		return bufParam;
	}

	private static int unbuildNumericWithSpace(byte[] b, int length) {
		int result = 0;
		for (int i = 0; i < b.length; i++) {
			result += (b[i] & 0xff) << ((b.length - i - 1) * 8);
		}
		return result;
	}

	public static byte[] bulidByteArr(List<byte[]> byteArrList) {
		int l = 0;
		for (byte[] bs : byteArrList) {
			l += bs.length;
		}
		byte[] byteArr = new byte[l];

		return byteArr;
	}
}