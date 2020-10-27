package com.webmark.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.AccountVO;

@Service
public class AccountImpl implements Account {
	
	@Autowired
	private WebmarkDAO dao;
	
	public AccountVO login(AccountVO vo) {
		
		AccountVO account = dao.loginById(vo);
		if(account.getUserid() == null || account.getUserid().isEmpty()) {
			account = dao.loginByEmail(vo);
		}
		
		return account;
	}

}
