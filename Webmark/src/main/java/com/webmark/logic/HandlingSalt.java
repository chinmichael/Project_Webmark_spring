package com.webmark.logic;

import com.webmark.model.AccountRegVO;
import com.webmark.model.AccountVO;

public interface HandlingSalt {
	public AccountRegVO inputSalt(AccountRegVO vo);
	public Integer checkSalt(AccountVO vo);
	public String makeSalt();
}
