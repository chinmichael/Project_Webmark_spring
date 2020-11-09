package com.webmark.logic;

import com.webmark.model.PassMailVO;

public interface Mail {
	public Integer sendPassMail(final PassMailVO vo);
}
