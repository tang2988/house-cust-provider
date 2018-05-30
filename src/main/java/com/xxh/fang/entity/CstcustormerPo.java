package com.xxh.fang.entity;

import java.io.Serializable;
import java.util.Date;

public class CstcustormerPo implements Serializable {
	

	/**
	 * 
	 */
	public static final long serialVersionUID = -1908694262812751410L;
	/**
	 * 客户ID(业务标识101+10位自增数)
	 */
	public Long customerId;
	/**
	 * '账户状态：10-正常; 20-禁用'
	 */
	public Integer customerStatus;

	/**
	 * '手机号码'
	 */
	public String mobilePhone;
	/**
	 * 手机归属地
	 */
	public String mobilePhoneLocation;

	/**
	 * 登录密码
	 */
	public String loginPassword;
	/**
	 * 用户头像
	 */
	public String headerIconUrl;
	/**
	 * 出生日期
	 */
	public Date birthday;
	/**
	 * 性别：10-男；20-女
	 */
	public Integer gender;
	/**
	 * 注册时间
	 */
	public Date registerTime;

	/**
	 * 注册客户端类型
	 */
	public Integer registerClientType;
	/**
	 * 注册客户端Ip
	 */
	public String registerClientIp;
	/**
	 * 认证：10-未认证；20-已认证
	 */
	public Integer authentic;
	/**
	 * 认证时间
	 */
	public Date authenticTime;
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
	/**
	 * 个人简介
	 */
	public String describee;
	/**
	 * 昵称
	 */
	public String nickName;

	public CstcustormerPo() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Integer getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMobilePhoneLocation() {
		return mobilePhoneLocation;
	}

	public void setMobilePhoneLocation(String mobilePhoneLocation) {
		this.mobilePhoneLocation = mobilePhoneLocation;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getHeaderIconUrl() {
		return headerIconUrl;
	}

	public void setHeaderIconUrl(String headerIconUrl) {
		this.headerIconUrl = headerIconUrl;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Integer getRegisterClientType() {
		return registerClientType;
	}

	public void setRegisterClientType(Integer registerClientType) {
		this.registerClientType = registerClientType;
	}

	public String getRegisterClientIp() {
		return registerClientIp;
	}

	public void setRegisterClientIp(String registerClientIp) {
		this.registerClientIp = registerClientIp;
	}

	public Integer getAuthentic() {
		return authentic;
	}

	public void setAuthentic(Integer authentic) {
		this.authentic = authentic;
	}

	public Date getAuthenticTime() {
		return authenticTime;
	}

	public void setAuthenticTime(Date authenticTime) {
		this.authenticTime = authenticTime;
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

	public String getDescribe() {
		return describee;
	}

	public void setDescribe(String describe) {
		this.describee = describe;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String toString() {
		return "CstcustormerPo [customerId=" + customerId + ", customerStatus=" + customerStatus + ", mobilePhone="
				+ mobilePhone + ", mobilePhoneLocation=" + mobilePhoneLocation + ", loginPassword=" + loginPassword
				+ ", headerIconUrl=" + headerIconUrl + ", birthday=" + birthday + ", gender=" + gender
				+ ", registerTime=" + registerTime + ", registerClientType=" + registerClientType
				+ ", registerClientIp=" + registerClientIp + ", authentic=" + authentic + ", authenticTime="
				+ authenticTime + ", remark=" + remark + ", versionNo=" + versionNo + ", createTime=" + createTime
				+ "]";
	}

}
