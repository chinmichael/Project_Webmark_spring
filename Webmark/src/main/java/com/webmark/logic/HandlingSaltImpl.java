//https://gofnrk.tistory.com/79

package com.webmark.logic;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.AccountRegVO;
import com.webmark.model.AccountVO;

@Service
public class HandlingSaltImpl implements HandlingSalt {
	
	@Autowired
	WebmarkDAO dao;
	
	public AccountRegVO inputSalt(AccountRegVO vo) {
		
		String userpw = vo.getUserpw(); 
		
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte[] bytes = new byte[16];
			random.nextBytes(bytes);
			String salt = new String(Base64.getEncoder().encode(bytes));
			
			vo.setSalt(salt);
			
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes());
			md.update(userpw.getBytes());
			String hex = String.format("%0128x", new BigInteger(1, md.digest()));
			
			vo.setUserpw(hex);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public Integer checkSalt(AccountVO vo) {
		String userid = vo.getUserid();
		String userpw = vo.getUserpw();
		Integer result = 0;
		
		String checkPw = dao.findPass(userid);
		if(checkPw != null) {
			try {
				String salt = dao.findSalt(userid);
				MessageDigest md = MessageDigest.getInstance("SHA-512");
				md.update(salt.getBytes());
				md.update(userpw.getBytes());
				String saltedPass = String.format("%0128x", new BigInteger(1, md.digest()));
				
				if(saltedPass.equals(checkPw)) {
					result = 1;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return result;
	}
}
