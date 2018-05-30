package com.xxh.fang.Dao;

import org.springframework.stereotype.Repository;

import com.xxh.fang.entity.CstcustormerPo;
import com.xxh.fang.entity.CstcustormerVo;

@Repository
public interface CstcustomerDao {
	/**
	 * 注册
	 * 
	 * @param CstcustormerPo
	 * @return
	 */
	public int addCstcustormerPo(CstcustormerPo cstcustormerpo);

	/**
	 * 根据客户ID查询客户信息
	 * 
	 * @param CstcustormerId
	 * @return
	 */
	public CstcustormerPo findByCstcustormerId(Long CstcustormerId);

	/**
	 * 修改登陆密码
	 * 
	 * @param CstcustormerPo
	 * @return
	 */
	public int changeLoginPassword(CstcustormerVo Cstcustormervo);

	/**
	 * 修改账户状态：10-正常; 20-禁用',
	 * 
	 * @param CstcustormerPo
	 * @return
	 */
	public int changeCustomerStatus(CstcustormerVo Cstcustormervo);

	/**
	 * 用户登陆
	 * 
	 * @param CstcustormerPo
	 * @return
	 */
	public CstcustormerPo cstCustomerLogin(CstcustormerPo Cstcustormerpo);

	/**
	 * 修改用户头像
	 * 
	 * @param CstcustormerPo
	 * @return
	 */
	public int modifyUserProfile(CstcustormerPo cstcustormer);

	/**
	 * 用户认证
	 * 
	 * @param CstcustormerPo
	 * @return
	 */
	public int userAuthentication(CstcustormerVo cstcustormerVo);

	/**
	 * 找回登陆密码
	 * @param loginPassword
	 * @param VerificationCode
	 * @return
	 */
	int retrievePassword(CstcustormerVo cstcustormerVo);

	/**
	 * 根据手机号码查询信息
	 * @param cstcustormerVo
	 * @return
	 */
	CstcustormerPo findByMobilePhone(String mobilePhone);
}
