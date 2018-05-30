package com.xxh.fang.Dao;

import org.springframework.stereotype.Repository;

import com.xxh.fang.entity.PayAccountVo;

@Repository
public interface PayAccountDao {

	/**
	 * 根据账户ID 查询
	 * 
	 * @param accountId
	 * @return
	 */
	public PayAccountVo findByAccountId(Long accountId);

	/**
	 * 修改账户状态：10-正常；20-限制
	 * 
	 * @param account
	 * @return
	 */
	public int modifyTheStateOf(PayAccountVo account);

	/**
	 * 修改可用余额
	 * 
	 * @param account
	 * @return
	 */
	public int changeAvailableBalance(PayAccountVo account);
	/**
	 * 减钱
	 * @param account
	 * @return
	 */
	public int loseMoney(PayAccountVo account);

	/**
	 * #修改可用余额 冻结余额
	 * 
	 * @param account
	 * @return
	 */
	
	
	public int changeAvailableBalanceAndFreezeTheBalance(PayAccountVo account);

	/**
	 * 添加账户表记录
	 * 
	 * @param account
	 * @return
	 */
	public int addPayAccount(PayAccountVo account);

}
