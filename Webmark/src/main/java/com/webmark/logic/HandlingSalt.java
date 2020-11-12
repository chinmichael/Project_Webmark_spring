package com.webmark.logic;

import com.webmark.model.AccountVO;

public interface HandlingSalt {
	public AccountVO inputSalt(AccountVO vo);
	public Integer checkSalt(AccountVO vo);
	public String makeUUID();
}
