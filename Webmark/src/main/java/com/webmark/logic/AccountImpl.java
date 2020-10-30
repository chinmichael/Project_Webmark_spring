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

		AccountVO account = new AccountVO();

		try {
			account = dao.loginById(vo);
			if (account != null) {

			} else {
				account = dao.loginByEmail(vo);
			}

			if (account != null) {
				if (!account.getUserpw().equals(vo.getUserpw())) {
					account = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

}
