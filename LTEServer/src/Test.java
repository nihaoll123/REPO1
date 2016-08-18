import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

import sdtp.util.MessageUtil;
import sdtp.util.TBCDUtil;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.common.primitives.Primitives;
import com.google.common.primitives.Shorts;
import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedInts;
import com.google.common.primitives.UnsignedLongs;


public class Test {

	private static final String SHARD_SECRET = "987654321021";
	
	public static void main(String[] args) {
//		byte[] arr2 = new byte[]{0,0,0,0,0,-128,1};
//		long int2 = new BigInteger(arr2).longValue();
//		Shorts.fromByteArray(arr);
		
//		byte[] arr1 = new byte[]{-128,1};
//		byte[] arr2 = new byte[]{-128,112,1};
//		byte[] res = testM(arr1);
//		byte[] res2 = testM(arr2);
//
//		byte[] arr1 = MessageUtil.int2ByteArray(BigInteger.valueOf(0x8001), 2);
//		byte[] arr2 = MessageUtil.int2ByteArray(BigInteger.valueOf(0x8001), 4);;
//		
//		int ver = 0x8001;
//		byte[] arrVer = buildNumericWithSpace(ver, 2);
//		System.out.println(arrVer);
					
//		String str = "abc";
//		byte[] data = MessageUtil.str2ByteArray(str, 2);
//		System.out.println(data);
		
		//翻了下文档好像TBCD编码的项默认值都是全F，测试下来没啥问题
//		String str = "1";
//		byte[] data = TBCDUtil.parseTBCD(str);
//		System.out.println(data);
//		
//		byte[] test = {123,0,120};
//		Arrays.toString(test);
//		System.out.println(Arrays.toString(test));
//		
//		System.out.println(Charset.defaultCharset().name());
		
		
		System.out.println(SHARD_SECRET);
	}
	
}
