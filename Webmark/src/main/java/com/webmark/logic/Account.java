package com.webmark.logic;

import com.webmark.model.AccountLoginVO;
import com.webmark.model.AccountPassVO;
import com.webmark.model.AccountRegVO;
import com.webmark.model.AccountVO;

public interface Account {
	
	// 로그인, 회원 가입
	public AccountLoginVO login(AccountLoginVO vo);
	public Integer checkIdAndEmail(AccountRegVO vo);
	public Integer joinNewAccount(AccountRegVO vo);
	public Integer checkEmail(AccountRegVO vo);
	
	// 계정 관리
	public Integer changeAccount(AccountRegVO vo);
	public AccountVO getChangedInfo(String userid);
	public Integer checkPermissionId(String userid);
	public Integer changeRight(String userid);
	public Integer deleteUser(AccountVO vo);
	public Integer[] countActivity (String userid);
	// 계정 비번 찾기 변경
	public String readyFindMail(String email);
	public Integer checkPassKeyTime(String key);
	public Integer checkKeyAndId (AccountPassVO vo);
	public Integer changePass (AccountPassVO vo);
}
