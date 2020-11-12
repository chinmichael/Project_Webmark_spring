package com.webmark.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.AccountLoginVO;
import com.webmark.model.AccountPassVO;
import com.webmark.model.AccountRegVO;
import com.webmark.model.AccountVO;

@Service
public class AccountImpl implements Account {

	@Autowired
	private WebmarkDAO dao;
	@Autowired
	private HandlingSalt salt;
	
	// 로그인 및 회원관

	public AccountLoginVO login(AccountLoginVO vo) {

		AccountLoginVO account = new AccountLoginVO();
		
		Integer check = salt.checkSalt(vo);
		if(check == 1) {
			account = dao.getLogin(vo.getUserid());
			dao.loginTime(vo.getUserid());
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
		vo = (AccountRegVO) salt.inputSalt(vo);
		result = dao.joinAccount(vo);
		if(result == 1) {
			result = dao.addSalt(vo);
		}
		return result;
	}

	public Integer checkEmail(AccountRegVO vo) {
		String checkId = dao.checkEmail(vo.getEmail());
		Integer result = 0;
		if(checkId != null) {
			if(checkId.equals(vo.getUserid())) {
				result = 1;
			}
		} else {
			result = 1;
		}
		return result;
	}
	
	// 계정 관리
	
	public Integer changeAccount(AccountRegVO vo) {
		Integer result = 0;
		vo = (AccountRegVO)salt.inputSalt(vo);
		result = dao.changeAccountInfo(vo);
		if(result == 1) {
			result = dao.changeSalt(vo);
		}
		return result;
	}
	
	public AccountVO getChangedInfo(String userid) {
		AccountVO vo = dao.getLogin(userid);
		return vo;
	}
	
	public Integer checkPermissionId(String userid) {
		Integer result = 0;
		String check = dao.checkPermissionId(userid);
		if(check != null) {
			result = 1;
		}
		return result;
	}

	public Integer changeRight(String userid) {
		Integer result = 0;
		result = dao.changeToAdmin(userid);
		return result;
	}

	public Integer deleteUser(AccountVO vo) {
		Integer result = 0;
		Integer checkPw = salt.checkSalt(vo);
		if(checkPw != 1) {
			return result;
		}
		result = dao.deleteAccount(vo.getUserid());
		return result;
	}
	
	public Integer[] countActivity(String userid) {
		Integer countCat = dao.countCategory(userid);
		if(countCat == null) countCat = 0;
		Integer countUrl = dao.countUrl(userid);
		if(countUrl == null) countUrl = 0;
		
		Integer[] result = new Integer[2];
		result[0] = countCat;
		result[1] = countUrl;
		return result;
	}
	
	//비밀번호 찾기 및 변경 관련

	public String readyFindMail(String email) {
		String result = "0";
		String check = dao.checkEmail(email);
		if(check == null) {
			return result;
		}
		String getSalt = salt.makeUUID();
		AccountLoginVO vo = new AccountLoginVO();
		vo.setEmail(email);
		vo.setSalt(getSalt);
		Integer updateCheck = dao.readyChangePass(vo);
		if(updateCheck == 1) {
			result = getSalt;
		}
		return result;
	}

	public Integer checkPassKeyTime(String key) {
		String check = dao.checkKeyTime(key);
		Integer result = 0;
		if(check != null) {
			result = 1;
		}
		return result;
	}

	public Integer checkKeyAndId(AccountPassVO vo) {
		String check = dao.checkPassKey(vo);
		Integer result = 0;
		if(check != null) {
			result = 1;
		}
		return result;
	}

	public Integer changePass(AccountPassVO vo) {
		Integer result = 0;
		vo = (AccountPassVO) salt.inputSalt(vo);
		result = dao.changePass(vo);
		if(result == 1) {
			result = dao.changeSalt(vo);
		}
		return result;
	}
}
