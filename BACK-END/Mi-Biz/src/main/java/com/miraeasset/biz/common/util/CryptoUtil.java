package com.miraeasset.biz.common.util;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.penta.scpdb.DamoManager;

public class CryptoUtil {

	public CryptoUtil() {

	}

	static final Logger logger = LoggerFactory.getLogger(CryptoUtil.class);

	/** Data Decryption. 복호화
	 * @param decryptionValue
	 * @return
	 * @throws
	 */
	public static String getDecryption(String decryptionValue) {
		String decrypt = decryptionValue;
		//FIXME : 개발반영시 주석해제
		if (!PropertyUtil.getProperty("SYSTEM_NAME").equals("local")) {
			if(!StringUtils.isEmpty(decryptionValue)){
				try {
					decrypt = new String(DamoManager.sDecrypt(decryptionValue.getBytes("MS949"), decryptionValue.getBytes("MS949").length),"euc-kr");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (Exception ignored) {
					// Local - Dev 서로 등록 지점이 다른 경우 등 예외 처리
					decrypt = decryptionValue;
				}
			}
		}
		return decrypt;
	}

	/** Data Decryption. 복호화
	 * @param decryptionValue
	 * @return
	 * @throws
	 */
	public static String getDecryption2(String decryptionValue) {
		String decrypt = decryptionValue;
		if (!PropertyUtil.getProperty("SYSTEM_NAME").equals("local")) {
			if(!StringUtils.isEmpty(decryptionValue)){
				try {
					decrypt = new String(DamoManager.sDecrypt(decryptionValue.getBytes("MS949"), decryptionValue.getBytes("MS949").length),"euc-kr");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if(!"".equals(StringUtils.empty(decrypt,""))){
				decrypt = decrypt.substring(0,6) + "-" + decrypt.substring(6);
			}
		}
		return decrypt;
	}

	/** Data Encryption. 암호화
	 * @param encryptionValue
	 * @return
	 * @throws
	 */
	public static String getEncryption(String encryptionValue) {
		String encrypt = encryptionValue;
		if (!PropertyUtil.getProperty("SYSTEM_NAME").equals("local")) {
			if(!StringUtils.isEmpty(encryptionValue)){
				try {
					encrypt = DamoManager.sEncrypt_B64(new String(encryptionValue.getBytes("MS949")));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		return encrypt;
	}
}
