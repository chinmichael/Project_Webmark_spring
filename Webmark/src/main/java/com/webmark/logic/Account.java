package com.webmark.logic;

import com.webmark.model.AccountRegVO;
import com.webmark.model.AccountVO;

public interface Account {
	public AccountVO login(AccountVO vo);
	public Integer checkIdAndEmail(AccountRegVO vo);
	public Integer joinNewAccount(AccountRegVO vo);
	public Integer checkEmail(AccountRegVO vo);
	public Integer changeAccount(AccountRegVO vo);
	public Integer checkRight(String userid);
	public Integer deleteUser(String userid);
	public String readyFindMail(String email);
}
