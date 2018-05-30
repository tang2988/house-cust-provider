package com.xxh.fang.ServiceImpl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xxh.fang.Dao.PayAccountDao;
import com.xxh.fang.Dao.PayAccountFlowDao;
import com.xxh.fang.Service.PayAccountService;
import com.xxh.fang.Util.CustomerStatus;
import com.xxh.fang.Util.ResVo;
import com.xxh.fang.entity.ChangeAvailableBalanceVo;
import com.xxh.fang.entity.PayAccountFlowPo;
import com.xxh.fang.entity.PayAccountVo;

@Service
public class PayAccountServiceImpl implements PayAccountService {

	@Resource
	PayAccountDao payAccountDao;

	@Resource
	PayAccountFlowDao payAccountFlowDao;

	/*********************** 禁用用户 **************/
	public ResVo modifyTheStateOf(PayAccountVo account) {
		ResVo resVo = new ResVo();
		// 使用账户ID查询账户信息
		PayAccountVo payAccountVo = payAccountDao.findByAccountId(account.getAccountId());

		if (payAccountVo.getAccountStatus().equals(account.getAccountStatus())) {
			resVo.setMsg("目前状态一致,无法更改");
			resVo.setSuccess(false);
			return resVo;
		}

		// 判断状态 只能传入 10 20
		if (!account.getAccountStatus().equals(CustomerStatus.AccountStatusten)
				&& !account.getAccountStatus().equals(CustomerStatus.AccountStatustwenty)) {
			resVo.setMsg("状态无法识别");
			resVo.setSuccess(false);
			return resVo;
		}

		// 如果状态传入是10 启用账户
		if (account.getAccountStatus().equals(CustomerStatus.AccountStatusten)) {

			int ten = payAccountDao.modifyTheStateOf(account);
			if (ten > 0) {
				resVo.setMsg("账户已启用");
				resVo.setSuccess(true);
			} else {
				resVo.setMsg("账户启用失败");
				resVo.setSuccess(false);
			}

		}
		// 如果状态传入是20 禁用账户
		if (account.getAccountStatus().equals(CustomerStatus.AccountStatustwenty)) {

			int modifyTheStateOf = payAccountDao.modifyTheStateOf(account);
			if (modifyTheStateOf > 0) {
				resVo.setMsg("限制账户成功");
				resVo.setSuccess(true);
				resVo.setData(account);
			}
		}
		return resVo;
	}

	/*********************** 转账 **************/
	@Transactional
	public ResVo changeAvailableBalance(ChangeAvailableBalanceVo changeAvailableBalanceVo) {
		ResVo resVo = new ResVo();

		// 使用账户ID查询账户信息 支出账户
		PayAccountVo outPayAccount = payAccountDao.findByAccountId(changeAvailableBalanceVo.getOut_accountId());
		// 使用账户ID查询账户信息 收入账户
		PayAccountVo inPayAccount = payAccountDao.findByAccountId(changeAvailableBalanceVo.getIn_accountId());

		// 判断余额是否充足
		if (outPayAccount.getUsableBalance().compareTo(changeAvailableBalanceVo.getUsableBalance()) == -1) {
			resVo.setMsg("账户余额不足,无法转账");
			resVo.setSuccess(false);

		}

		// 支出账户 减款begin
		outPayAccount.setUsableBalance(
				outPayAccount.getUsableBalance().subtract(changeAvailableBalanceVo.getUsableBalance()));
		// 保存账户减款
		int loseMoney = payAccountDao.loseMoney(outPayAccount);
		if (loseMoney < 1) {
			throw new RuntimeException("减钱失败");
		}
		PayAccountFlowPo outAccountFlowPo = new PayAccountFlowPo();

		outAccountFlowPo.setAccountId(outPayAccount.getAccountId());

		outAccountFlowPo.setCustomerId(outPayAccount.getCustomerId());

		outAccountFlowPo.setFlowType(40);

		outAccountFlowPo.setTradeAmount(changeAvailableBalanceVo.getUsableBalance());

		outAccountFlowPo.setTradeDate(new Date());

		outAccountFlowPo.setTradeTime(new Date());

		outAccountFlowPo.setFreezeAmount(new BigDecimal(0));

		outAccountFlowPo.setUnfreezeAmount(new BigDecimal(0));

		outAccountFlowPo.setInAmount(new BigDecimal(0));

		outAccountFlowPo.setOutAmount(changeAvailableBalanceVo.getUsableBalance());

		outAccountFlowPo.setUsableBalance(outPayAccount.getUsableBalance());

		outAccountFlowPo.setFreezeBalance(outPayAccount.getFreezeBalance());

		outAccountFlowPo.setBizType(changeAvailableBalanceVo.getBizType());

		outAccountFlowPo.setBizTypeName(changeAvailableBalanceVo.getBizTypeName());

		outAccountFlowPo.setBizId(null);

		outAccountFlowPo.setBizDesc(null);

		outAccountFlowPo.setTradeAccountId(inPayAccount.getAccountId());

		outAccountFlowPo.setTradeCustomerId(inPayAccount.getCustomerId());
		// 添加账户流水记录
		int addPayAccountFlow = payAccountFlowDao.addPayAccountFlow(outAccountFlowPo);
		if (addPayAccountFlow < 1) {
			throw new RuntimeException("添加流水记录失败");
		}
		// 支出账户 减款end

		// 收入账户 加钱
		inPayAccount.setUsableBalance(inPayAccount.getUsableBalance().add(changeAvailableBalanceVo.getUsableBalance()));
		int changeAvailableBalance = payAccountDao.changeAvailableBalance(inPayAccount);

		if (changeAvailableBalance < 1) {
			throw new RuntimeException("加钱失败");
		}

		PayAccountFlowPo inAccountFlowPo = new PayAccountFlowPo();

		inAccountFlowPo.setAccountId(inPayAccount.getAccountId());

		inAccountFlowPo.setCustomerId(inPayAccount.getCustomerId());

		inAccountFlowPo.setFlowType(30);

		inAccountFlowPo.setTradeAmount(changeAvailableBalanceVo.getUsableBalance());

		inAccountFlowPo.setTradeDate(new Date());

		inAccountFlowPo.setTradeTime(new Date());

		inAccountFlowPo.setFreezeAmount(new BigDecimal(0));

		inAccountFlowPo.setUnfreezeAmount(new BigDecimal(0));

		inAccountFlowPo.setInAmount(changeAvailableBalanceVo.getUsableBalance());

		inAccountFlowPo.setOutAmount(changeAvailableBalanceVo.getUsableBalance());

		inAccountFlowPo.setUsableBalance(inPayAccount.getUsableBalance());

		inAccountFlowPo.setFreezeBalance(inPayAccount.getFreezeBalance());

		inAccountFlowPo.setBizType(changeAvailableBalanceVo.getBizType());

		inAccountFlowPo.setBizTypeName(changeAvailableBalanceVo.getBizTypeName());

		inAccountFlowPo.setBizId(null);

		inAccountFlowPo.setBizDesc(null);

		inAccountFlowPo.setTradeAccountId(outPayAccount.getAccountId());

		inAccountFlowPo.setTradeCustomerId(outPayAccount.getCustomerId());

		// 添加账户流水记录
		int addPayAccountFlowtwo = payAccountFlowDao.addPayAccountFlow(inAccountFlowPo);
		if (addPayAccountFlowtwo < 1) {
			throw new RuntimeException("添加流水记录失败");
		}
		resVo.setMsg("成功");
		// 加钱 结束
		return resVo;
	}

	/*********************** 提现 **************/
	public ResVo changeAvailableBalanceAndFreezeTheBalance(PayAccountVo account) {
		ResVo resVo = new ResVo();
		return resVo;
	}

}
