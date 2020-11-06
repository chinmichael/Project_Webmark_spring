package com.webmark.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.AccountRegVO;
import com.webmark.model.AccountVO;

@Service
public class AccountImpl implements Account {

	@Autowired
	private WebmarkDAO dao;
	@Autowired
	private HandlingSalt salt;

	public AccountVO login(AccountVO vo) {

		AccountVO account = new AccountVO();
		
		Integer check = salt.checkSalt(vo);
		if(check == 1) {
			account = dao.getLogin(vo.getUserid());
		} else {
			account = null;
		}
		return account;
	}

	public Integer checkIdAndEmail(AccountRegVO vo) {
		Integer result = 0;
		String checkId = dao.checkId(vo.getUserid());
		String checkMail = dao.checkEmail(vo.getEmail());
		if(checkId != null && checkMail != null) {
			result = 3; 
		} else if (checkId != null) {
			result = 1;
		} else if (checkMail != null) {
			result = 2;
		}
		return result;
	}

	public Integer joinNewAccount(AccountRegVO vo) {	
		Integer result = 0;
		vo = salt.inputSalt(vo);
		result = dao.joinAccount(vo);
		if(result == 1) {
			result = dao.addSalt(vo);
		}
		return result;
	}

	public Integer checkEmail(AccountRegVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer changeAccount(AccountRegVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer checkRight(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer deleteUser(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
