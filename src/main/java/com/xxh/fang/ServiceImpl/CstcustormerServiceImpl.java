package com.xxh.fang.ServiceImpl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.xxh.fang.Dao.CstcustomerDao;
import com.xxh.fang.Dao.PayAccountDao;
import com.xxh.fang.Service.CstcustormerService;
import com.xxh.fang.Util.CustomerStatus;
import com.xxh.fang.Util.ResVo;
import com.xxh.fang.entity.ChangeCustomerStatusVo;
import com.xxh.fang.entity.ChangeLoginPasswordVo;
import com.xxh.fang.entity.CstcustormerPo;
import com.xxh.fang.entity.CstcustormerVo;
import com.xxh.fang.entity.ModifyUserProfileReqVo;
import com.xxh.fang.entity.PayAccountVo;
import com.xxh.fang.entity.RetrievePasswordVo;
import com.xxh.fang.entity.UserAuthenticationVo;

@Service("cstcustormerService")
public class CstcustormerServiceImpl implements CstcustormerService {

	@Resource
	CstcustomerDao cstcustomerDao;
	@Resource
	PayAccountDao accountDao;

	/**
	 * 用户注册
	 */
	public ResVo addCstcustormerVo(CstcustormerVo cstcustormervo) {

		ResVo resVo = new ResVo();

		if (cstcustormervo.getMobilePhone() == null) {
			resVo.setSuccess(false);
			resVo.setMsg("手机号码不能为空");
			return resVo;
		}
		if (cstcustormervo.getLoginPassword() == null) {
			resVo.setSuccess(false);
			resVo.setMsg("登录密码不能为空");
			return resVo;
		}
		
		CstcustormerPo cstcustormerpo = new CstcustormerPo();
		BeanUtils.copyProperties(cstcustormervo, cstcustormerpo);
		
		int addCstcustormerPo = cstcustomerDao.addCstcustormerPo(cstcustormerpo);
		if (addCstcustormerPo < 1) {
			resVo.setSuccess(false);
			resVo.setMsg("注册失败");
			return resVo;
		}
		// 增加账户表
		PayAccountVo account = new PayAccountVo();
		account.setCustomerId(cstcustormerpo.getCustomerId());
		account.setAccountStatus(CustomerStatus.AccountStatusten);
		account.setFreezeBalance(new BigDecimal(0.00));
		account.setUsableBalance(new BigDecimal(0.00));
		int addPayAccount = accountDao.addPayAccount(account);
		if (addPayAccount > 0) {
			resVo.setSuccess(true);
			resVo.setMsg("注册成功");
			return resVo;
		} else {
			resVo.setSuccess(false);
			resVo.setMsg("增加账户记录失败");
		}

		return resVo;

	}

	/**
	 * 修改登陆密码
	 */
	public ResVo changeLoginPassword(ChangeLoginPasswordVo changeLoginPasswordVo) {
		ResVo resVo = new ResVo();
		// 根据客户id查询客户信息
		CstcustormerPo cstcustormer = cstcustomerDao.findByCstcustormerId(changeLoginPasswordVo.getCustomerId());
		if (cstcustormer == null) {
			resVo.setMsg("用户不存在");
			return resVo;
		}
		// 判断密码是否与原密码一致

		if (!cstcustormer.getLoginPassword().equals(changeLoginPasswordVo.getLoginPassword())) {
			resVo.setMsg("密码不一致,无法修改");
			resVo.setSuccess(false);
			return resVo;
		}
		// 设置密码
		cstcustormer.setLoginPassword(changeLoginPasswordVo.getNewloginPassword());
		// 修改登陆密码
		CstcustormerVo cstcustormervo = new CstcustormerVo();
		BeanUtils.copyProperties(cstcustormer, cstcustormervo);
		int ChangeLoginPassword = cstcustomerDao.changeLoginPassword(cstcustormervo);
		if (ChangeLoginPassword > 0) {
			resVo.setMsg("修改密码成功");
			resVo.setSuccess(true);
			return resVo;
		} else {
			resVo.setMsg("修改密码失败");
			resVo.setSuccess(false);
		}

		return resVo;
	}

	/**
	 * 修改账户状态
	 */
	public ResVo changeCustomerStatus(ChangeCustomerStatusVo changeCustomerStatusVo) {
		ResVo resVo = new ResVo();

		// 根据客户id查询客户信息
		CstcustormerPo cstcustormer = cstcustomerDao.findByCstcustormerId(changeCustomerStatusVo.getCustomerId());
		if (cstcustormer == null) {
			resVo.setMsg("用户不存在");
			return resVo;
		}
		// 状态一致
		if (cstcustormer.getCustomerStatus().equals(changeCustomerStatusVo.getNewCustomerStatus())) {
			resVo.setMsg("账户状态无法更改");
			resVo.setSuccess(true);
			return resVo;
		}
		// 状体不是10 或者不是20
		if (!changeCustomerStatusVo.getNewCustomerStatus().equals(CustomerStatus.customerStatusten)
				& !changeCustomerStatusVo.getNewCustomerStatus().equals(CustomerStatus.customerStatustwenty)) {
			resVo.setMsg("状态无法识别");
			resVo.setSuccess(false);
			return resVo;
		}
		// 设置新状态
		cstcustormer.setCustomerStatus(changeCustomerStatusVo.getNewCustomerStatus());

		CstcustormerVo cstcustormerVo = new CstcustormerVo();
		BeanUtils.copyProperties(cstcustormer, cstcustormerVo);
		int ChangeCustomerStatus = cstcustomerDao.changeCustomerStatus(cstcustormerVo);
		if (ChangeCustomerStatus > 0) {
			resVo.setMsg("账户状态更改成功");
			resVo.setSuccess(true);
			return resVo;
		} else {
			resVo.setMsg("账户状态更改失败");
			resVo.setSuccess(false);
		}
		return resVo;

	}

	/**
	 * 用户登陆
	 */
	public ResVo cstCustomerLogin(CstcustormerVo cstcustormervo) {
		ResVo resVo = new ResVo();

		CstcustormerPo cstcustormerpo = new CstcustormerPo();
		BeanUtils.copyProperties(cstcustormervo, cstcustormerpo);
		CstcustormerPo loginCustPo = cstcustomerDao.cstCustomerLogin(cstcustormerpo);
	
		if (loginCustPo != null) {

			if (loginCustPo.getCustomerStatus().equals(CustomerStatus.AccountStatusten)) {
				resVo.setMsg("登陆成功");
				resVo.setSuccess(true);
				resVo.setData(loginCustPo);
				return resVo;
			} else {
				resVo.setMsg("账户被禁用");
				resVo.setSuccess(false);
				return resVo;
			}

		} else {
			resVo.setMsg("用户名不存在或密码错误");
			resVo.setSuccess(false);

		}

		return resVo;
	}

	/**
	 * 修改头像
	 */
	public ResVo modifyUserProfile(ModifyUserProfileReqVo modifyUserProfileReqVo) {
		ResVo resVo = new ResVo();

		CstcustormerPo cstcustormer = cstcustomerDao.findByCstcustormerId(modifyUserProfileReqVo.getCustomerId());

		if (cstcustormer == null) {
			resVo.setMsg("用户不存在");
			return resVo;
		}
		cstcustormer.setHeaderIconUrl(modifyUserProfileReqVo.getHeaderIconUrl());
		int modifyUserProfile = cstcustomerDao.modifyUserProfile(cstcustormer);

		if (modifyUserProfile > 0) {
			CstcustormerVo cstcustormervo = new CstcustormerVo();
			BeanUtils.copyProperties(cstcustormer, cstcustormervo);
			resVo.setMsg("修改头像成功");
			resVo.setSuccess(true);
			resVo.setData(cstcustormervo);
		} else {
			resVo.setMsg("修改头像失败");
			resVo.setSuccess(false);

		}
		return resVo;
	}

	/**
	 * 用户认证
	 */
	public ResVo userAuthentication(UserAuthenticationVo userAuthenticationVo) {
		ResVo resVo = new ResVo();
		// 根据客户id查询客户信息
		CstcustormerPo cstcustormer = cstcustomerDao.findByCstcustormerId(userAuthenticationVo.getCustomerId());
		if (cstcustormer == null) {
			resVo.setMsg("用户不存在");
			return resVo;
		}

		// 10未认证 20已认证
		if (!userAuthenticationVo.getAuthentic().equals(CustomerStatus.CustomerAuthentictwenty)
				& !userAuthenticationVo.getAuthentic().equals(CustomerStatus.CustomerAuthenticten)) {
			resVo.setMsg("状态不能识别");
			resVo.setSuccess(false);
			return resVo;
		}
		cstcustormer.setAuthentic(userAuthenticationVo.getAuthentic());
		cstcustormer.setAuthenticTime(new Date());
		CstcustormerVo vo = new CstcustormerVo();
		BeanUtils.copyProperties(cstcustormer, vo);
		int userAuthentication = cstcustomerDao.userAuthentication(vo);

		if (userAuthentication > 0) {
			resVo.setMsg("认证成功");
			resVo.setSuccess(true);
			return resVo;

		} else {
			resVo.setMsg("认证失败");
			resVo.setSuccess(false);

		}

		return resVo;
	}

	/**
	 * 找回登陆密码
	 */
	public ResVo retrievePassword(RetrievePasswordVo retrievePasswordVo) {
		ResVo resVo = new ResVo();
		// VerificationCode 验证码
		if (!retrievePasswordVo.getVerificationCode().equals(123456)) {
			resVo.setMsg("验证码错误");
			resVo.setSuccess(false);
			return resVo;
		}
		CstcustormerPo cstcustormerpo = cstcustomerDao.findByMobilePhone(retrievePasswordVo.getMobilePhone());
		if (cstcustormerpo == null) {
			resVo.setMsg("用户不存在");
			resVo.setSuccess(false);
			return resVo;
		}
		cstcustormerpo.setLoginPassword(retrievePasswordVo.getNewLoginPassword());

		CstcustormerVo cstcustormervo = new CstcustormerVo();

		BeanUtils.copyProperties(cstcustormerpo, cstcustormervo);

		int retrievePassword = cstcustomerDao.retrievePassword(cstcustormervo);
		if (retrievePassword > 0) {
			resVo.setMsg("密码重置成功");
			resVo.setSuccess(true);
			return resVo;
		} else {
			resVo.setMsg("密码重置失败");
			resVo.setSuccess(false);

		}
		return resVo;
	}

}
