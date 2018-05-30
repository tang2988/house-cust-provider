package com.xxh.fang.api;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxh.fang.Service.CstcustormerService;
import com.xxh.fang.Util.ResVo;
import com.xxh.fang.entity.ChangeCustomerStatusVo;
import com.xxh.fang.entity.ChangeLoginPasswordVo;
import com.xxh.fang.entity.CstcustormerVo;
import com.xxh.fang.entity.ModifyUserProfileReqVo;
import com.xxh.fang.entity.RetrievePasswordVo;
import com.xxh.fang.entity.UserAuthenticationVo;

@Service
public class CstcustormerApiImpl implements CstcustormerApi {

	@Resource
	CstcustormerService cstcustormerService;

	public ResVo addCstcustormerVo(CstcustormerVo cstcustormervo) {
		return cstcustormerService.addCstcustormerVo(cstcustormervo);
	}

	public ResVo changeLoginPassword(ChangeLoginPasswordVo changeLoginPasswordVo) {
		return cstcustormerService.changeLoginPassword(changeLoginPasswordVo);
	}

	public ResVo changeCustomerStatus(ChangeCustomerStatusVo changeCustomerStatusVo) {
		return cstcustormerService.changeCustomerStatus(changeCustomerStatusVo);
	}

	public ResVo cstCustomerLogin(CstcustormerVo Cstcustormervo) {
		return cstcustormerService.cstCustomerLogin(Cstcustormervo);
	}

	public ResVo modifyUserProfile(ModifyUserProfileReqVo modifyUserProfileReqVo) {
		return cstcustormerService.modifyUserProfile(modifyUserProfileReqVo);
	}

	public ResVo userAuthentication(UserAuthenticationVo userAuthenticationVo) {
		return cstcustormerService.userAuthentication(userAuthenticationVo);
	}

	public ResVo retrievePassword(RetrievePasswordVo retrievePasswordVo) {
		return cstcustormerService.retrievePassword(retrievePasswordVo);
	}

	

}
