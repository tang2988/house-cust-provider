package com.xxh.fang.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PayAccountFlowPo implements Serializable{
	
	/**
	 * 
	 */
	public static final long serialVersionUID = 8708055828467730022L;
	/**
	 * 流水ID(业务标识202+10位自增数)
	 */
	public Long flowId;
	/**
	 * 账户ID
	 */
	public Long accountId;
	/**
	 * 客户ID
	 */
	public Long customerId;
	/**
	 * 流水类型：10-冻结；20-解冻；30-收入；40-支出
	 */
	public Integer flowType;
	/**
	 * 交易金额
	 */
	public BigDecimal tradeAmount;

	/**
	 * 交易日期
	 */
	public Date tradeDate;
	/**
	 * 交易时间
	 */
	public Date tradeTime;
	/**
	 * 冻结金额
	 */
	public BigDecimal freezeAmount;
	/**
	 * 解冻金额
	 */
	public BigDecimal unfreezeAmount;
	/**
	 * 存入金额
	 */
	public BigDecimal inAmount;
	/**
	 * 支出金额
	 */
	public BigDecimal outAmount;
	/**
	 * 可用余额
	 */
	public BigDecimal usableBalance;
	/**
	 * 冻结余额
	 */
	public BigDecimal freezeBalance;
	/**
	 * 业务类型:10转账充值;11点赞，12付费阅读
	 */
	public Integer bizType;

	/**
	 * 业务类型名称
	 */
	public String bizTypeName;
	/**
	 * 业务ID
	 */
	public Long bizId;
	/**
	 * 业务描述
	 */
	public String bizDesc;
	/**
	 * 交易对方账户ID
	 */
	public Long tradeAccountId;
	/**
	 * 交易对方客户ID
	 */
	public Long tradeCustomerId;
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
	public Date createTime;

	public PayAccountFlowPo() {
	}

	public PayAccountFlowPo(Long flowId, Long accountId, Long customerId, Integer flowType, BigDecimal tradeAmount,
			Date tradeDate, Date tradeTime, BigDecimal freezeAmount, BigDecimal unfreezeAmount, BigDecimal inAmount,
			BigDecimal outAmount, BigDecimal usableBalance, BigDecimal freezeBalance, Integer bizType,
			String bizTypeName, Long bizId, String bizDesc, Long tradeAccountId, Long tradeCustomerId, String remark,
			Integer versionNo, Date createTime) {
		super();
		this.flowId = flowId;
		this.accountId = accountId;
		this.customerId = customerId;
		this.flowType = flowType;
		this.tradeAmount = tradeAmount;
		this.tradeDate = tradeDate;
		this.tradeTime = tradeTime;
		this.freezeAmount = freezeAmount;
		this.unfreezeAmount = unfreezeAmount;
		this.inAmount = inAmount;
		this.outAmount = outAmount;
		this.usableBalance = usableBalance;
		this.freezeBalance = freezeBalance;
		this.bizType = bizType;
		this.bizTypeName = bizTypeName;
		this.bizId = bizId;
		this.bizDesc = bizDesc;
		this.tradeAccountId = tradeAccountId;
		this.tradeCustomerId = tradeCustomerId;
		this.remark = remark;
		this.versionNo = versionNo;
		this.createTime = createTime;
	}

	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
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

	public Integer getFlowType() {
		return flowType;
	}

	public void setFlowType(Integer flowType) {
		this.flowType = flowType;
	}

	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public BigDecimal getFreezeAmount() {
		return freezeAmount;
	}

	public void setFreezeAmount(BigDecimal freezeAmount) {
		this.freezeAmount = freezeAmount;
	}

	public BigDecimal getUnfreezeAmount() {
		return unfreezeAmount;
	}

	public void setUnfreezeAmount(BigDecimal unfreezeAmount) {
		this.unfreezeAmount = unfreezeAmount;
	}

	public BigDecimal getInAmount() {
		return inAmount;
	}

	public void setInAmount(BigDecimal inAmount) {
		this.inAmount = inAmount;
	}

	public BigDecimal getOutAmount() {
		return outAmount;
	}

	public void setOutAmount(BigDecimal outAmount) {
		this.outAmount = outAmount;
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

	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	public String getBizTypeName() {
		return bizTypeName;
	}

	public void setBizTypeName(String bizTypeName) {
		this.bizTypeName = bizTypeName;
	}

	public Long getBizId() {
		return bizId;
	}

	public void setBizId(Long bizId) {
		this.bizId = bizId;
	}

	public String getBizDesc() {
		return bizDesc;
	}

	public void setBizDesc(String bizDesc) {
		this.bizDesc = bizDesc;
	}

	public Long getTradeAccountId() {
		return tradeAccountId;
	}

	public void setTradeAccountId(Long tradeAccountId) {
		this.tradeAccountId = tradeAccountId;
	}

	public Long getTradeCustomerId() {
		return tradeCustomerId;
	}

	public void setTradeCustomerId(Long tradeCustomerId) {
		this.tradeCustomerId = tradeCustomerId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String toString() {
		return "PayAccountFlowPo [flowId=" + flowId + ", accountId=" + accountId + ", customerId=" + customerId
				+ ", flowType=" + flowType + ", tradeAmount=" + tradeAmount + ", tradeDate=" + tradeDate
				+ ", tradeTime=" + tradeTime + ", freezeAmount=" + freezeAmount + ", unfreezeAmount=" + unfreezeAmount
				+ ", inAmount=" + inAmount + ", outAmount=" + outAmount + ", usableBalance=" + usableBalance
				+ ", freezeBalance=" + freezeBalance + ", bizType=" + bizType + ", bizTypeName=" + bizTypeName
				+ ", bizId=" + bizId + ", bizDesc=" + bizDesc + ", tradeAccountId=" + tradeAccountId
				+ ", tradeCustomerId=" + tradeCustomerId + ", remark=" + remark + ", versionNo=" + versionNo
				+ ", createTime=" + createTime + "]";
	}

}
