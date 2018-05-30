package com.xxh.fang.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class PayAccountPo implements Serializable {

	public  static final long serialVersionUID = -8562238554349498335L;

	/**
	 * 账户ID
	 */
	public Long accountId;
	/**
	 * 客户ID
	 */
	public Long customerId;
	/**
	 * 账户状态：10-正常；20-限制
	 */
	public Integer accountStatus;
	/**
	 * 可用余额
	 */
	public BigDecimal usableBalance;
	/**
	 * 冻结余额
	 */
	public BigDecimal freezeBalance;
	/**
	 * 备注
	 */
	public String remark;
	/**
	 * 版本号
	 */
	public Integer versionNo;

	/**
	 * 插入时间
	 */
	public PayAccountPo() {
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	public BigDecimal getUsableBalance() {
		return usableBalance;
	}

	public void setUsableBalance(BigDecimal usableBalance) {
		this.usableBalance = usableBalance;
	}

	public BigDecimal getFreezeBalance() {
		return freezeBalance;
	}

	public void setFreezeBalance(BigDecimal freezeBalance) {
		this.freezeBalance = freezeBalance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}

	public String toString() {
		return "PayAccount [accountId=" + accountId + ", customerId=" + customerId + ", accountStatus=" + accountStatus
				+ ", usableBalance=" + usableBalance + ", freezeBalance=" + freezeBalance + ", remark=" + remark
				+ ", versionNo=" + versionNo + "]";
	}

}
