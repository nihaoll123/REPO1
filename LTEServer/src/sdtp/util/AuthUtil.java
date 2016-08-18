package sdtp.util;

import java.security.DigestException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import sdtp.message.LinkAuthReqMsg;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class AuthUtil {

	private static Map<String, String> secretMap;

	static {
		secretMap = new HashMap<String, String>();
		// 测试用代码
		secretMap.put("aaaaaaaaaaaa", "987654321021");
	}

	public static String linkAuth(LinkAuthReqMsg reqBody) throws SignatureException, DigestException {
		String secretHash = AuthUtil.hashStr(AuthUtil.getAuthSecret(reqBody.getLoginID()));
		String digest = AuthUtil.hashStr(reqBody.getLoginID() + secretHash + reqBody.getTimestamp() + "rand=" + reqBody.getRand());
		if (!digest.equals(reqBody.getDigest())) {// 验证失败
//			throw new DigestException("SHA256验证未通过");
		}
		return digest;
	}

	/**
	 * 根据loginID查询对应的Shared secret
	 * 
	 * @param loginID
	 * @return
	 * @throws SignatureException
	 *             LoginID不存在。
	 */
	public static String getAuthSecret(String loginID) throws SignatureException {
		String secret = secretMap.get(loginID);
		if (Util.checkNull(secret)) {
			throw new SignatureException("LoginID不存在");
		}
		return secret;
	}

	/**
	 * sha256加密字符串
	 * google大法好！
	 * @param text
	 * @return
	 */
	public static String hashStr(String text) {
		String result = Hashing.sha256().hashString(text, Charsets.UTF_8).toString();		
		return result;
	}
}
