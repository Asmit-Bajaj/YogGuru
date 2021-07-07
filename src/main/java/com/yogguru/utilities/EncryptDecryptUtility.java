package com.yogguru.utilities;

public interface EncryptDecryptUtility {
	public String encodeBase64(String input);
	public String decodeBase64(String input);
	public String getSHA256(String input);
}
