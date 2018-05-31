package com.xxh.Test;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxh.fang.Service.CstcustormerService;
import com.xxh.fang.ServiceImpl.PayAccountServiceImpl;
import com.xxh.fang.Util.ResVo;
import com.xxh.fang.entity.ChangeAvailableBalanceVo;
import com.xxh.fang.entity.ChangeCustomerStatusVo;
import com.xxh.fang.entity.ChangeLoginPasswordVo;
import com.xxh.fang.entity.CstcustormerVo;
import com.xxh.fang.entity.ModifyUserProfileReqVo;
import com.xxh.fang.entity.PayAccountVo;
import com.xxh.fang.entity.RetrievePasswordVo;
import com.xxh.fang.entity.UserAuthenticationVo;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" }) // 加载配置文件
public class CstcustomerServiceTest {

	@Resource
	CstcustormerService cstcustormerService;

	@Resource
	PayAccountServiceImpl payserviceImpl;

	@Test
	public void addCstcustormerPo() {
		CstcustormerVo cstcustormerVo = new CstcustormerVo();
		cstcustormerVo.setMobilePhone("19932894111");
		cstcustormerVo.setMobilePhoneLocation("广东");
		cstcustormerVo.setLoginPassword("xiexionghui");
		cstcustormerVo.setHeaderIconUrl(null);
		cstcustormerVo.setBirthday(null);
		cstcustormerVo.setGender(10);
		cstcustormerVo.setRegisterTime(null);
		cstcustormerVo.setRegisterClientType(null);
		cstcustormerVo.setRegisterClientIp(null);
		cstcustormerVo.setAuthentic(10);
		cstcustormerVo.setAuthenticTime(null);

		ResVo a = cstcustormerService.addCstcustormerVo(cstcustormerVo);
		System.out.println(a);

	}

	@Test
	public void ChangeAvailableBalance() {
		ChangeAvailableBalanceVo account = new ChangeAvailableBalanceVo();
		account.setIn_accountId(2010000023806L);
		account.setOut_accountId(2010000023807L);
		account.setUsableBalance(new BigDecimal(30));
		account.setBizType(12);
		account.setBizTypeName("付费阅读");
		ResVo resVo = payserviceImpl.changeAvailableBalance(account);
		System.out.println(resVo);
	}

	@Test
	public void ChangeLoginPassword() {
		ChangeLoginPasswordVo changeLoginPasswordVo = new ChangeLoginPasswordVo();

		changeLoginPasswordVo.setLoginPassword("123456789");
		changeLoginPasswordVo.setCustomerId(1010000023811L);
		changeLoginPasswordVo.setNewloginPassword("xxxxxx");
		ResVo ChangeLoginPassword = cstcustormerService.changeLoginPassword(changeLoginPasswordVo);
		System.out.println(ChangeLoginPassword);
	}

	@Test
	public void ChangeCustomerStatus() {
		ChangeCustomerStatusVo changeCustomerStatusVo = new ChangeCustomerStatusVo();
		changeCustomerStatusVo.setNewCustomerStatus(30);
		changeCustomerStatusVo.setCustomerId(1010000023811L);
		ResVo ChangeCustomerStatus = cstcustormerService.changeCustomerStatus(changeCustomerStatusVo);
		System.out.println(ChangeCustomerStatus);
	}

	@Test
	public void login() {
		CstcustormerVo cstcustormervo = new CstcustormerVo();
		cstcustormervo.setMobilePhone("15012847960");
		cstcustormervo.setLoginPassword("xiexionghui");
		ResVo b = cstcustormerService.cstCustomerLogin(cstcustormervo);
		System.out.println(b);

	}

	@Test
	public void ModifyUserProfile() {
		ModifyUserProfileReqVo modifyUserProfileReqVo = new ModifyUserProfileReqVo();
		modifyUserProfileReqVo.setCustomerId(101000023811L);
		modifyUserProfileReqVo.setHeaderIconUrl("https://www.baidu.com");
		ResVo modifyUserProfile = cstcustormerService.modifyUserProfile(modifyUserProfileReqVo);
		System.out.println(modifyUserProfile);
	}

	@Test
	public void UserAuthentication() {
		UserAuthenticationVo userAuthenticationVo = new UserAuthenticationVo();
		userAuthenticationVo.setAuthentic(20);
		userAuthenticationVo.setCustomerId(1010000023813L);
		ResVo b = cstcustormerService.userAuthentication(userAuthenticationVo);
		System.out.println(b);
	}

	@Test
	public void RetrievePassword() {
		RetrievePasswordVo retrievePassword = new RetrievePasswordVo();
		retrievePassword.setVerificationCode(123456);
		retrievePassword.setMobilePhone("15012847960");
		retrievePassword.setNewLoginPassword("xiexieni");
		ResVo b = cstcustormerService.retrievePassword(retrievePassword);
		System.out.println(b);
	}

	/****** 禁用账户 *******/
	@Test
	public void ModifyTheStateOf() {
		PayAccountVo account = new PayAccountVo();
		account.setAccountId(2010000023807L);
		account.setAccountStatus(20);
		ResVo b = payserviceImpl.modifyTheStateOf(account);
		System.out.println(b);
	}
}
