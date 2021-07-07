package com.yogguru.utilities;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class EncryptDecryptUtilityImpl implements EncryptDecryptUtility{

	//encode string to base 64
	public String encodeBase64(String input){
		String ans = null;
		
			//encode the string
			try {
				ans = Base64.getEncoder().encodeToString(input.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				return ans;
			}
		
	}

	//decode base 64 string
	public String decodeBase64(String input) {
		String ans = null;
//		System.out.println(arg);
		
		try {
			//decode the string
			byte[] decode = Base64.getDecoder().decode(input);
			
			ans = new String(decode);
			
		}catch (Exception e) {
			System.out.println("Exception at decodeMethod : "+e);
		}finally {
			return ans;
		}
	}


	//to get SHA 256 hash
	public String getSHA256(String input) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        byte[] temp =  md.digest(input.getBytes(StandardCharsets.UTF_8)); 
        
     // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, temp);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
	}

	
}
