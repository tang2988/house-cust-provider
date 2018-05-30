package com.xxh.fang.Service;

import com.xxh.fang.Util.ResVo;
import com.xxh.fang.entity.ChangeAvailableBalanceVo;
import com.xxh.fang.entity.PayAccountVo;

public interface PayAccountService {

	/**
	 * 修改账户状态：10-正常；20-限制
	 * 
	 * @param account
	 * @return
	 */
	public ResVo modifyTheStateOf(PayAccountVo account);

	/**
	 * 修改可用余额
	 * 
	 * @param account
	 * @return
	 */
	public ResVo changeAvailableBalance(ChangeAvailableBalanceVo changeAvailableBalanceVo);
	


	/**
	 * #修改可用余额 冻结余额
	 * 
	 * @param account
	 * @return
	 */
	public ResVo changeAvailableBalanceAndFreezeTheBalance(PayAccountVo account);
}
