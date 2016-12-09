package com.future.partymember.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 党费交纳记录类
 * @author 丁赵雷
 *
 */
@Entity
@Table(name="due_payment_recodes", catalog="partymember")
public class DuePaymentRecords {
	private int dpr_id;
	private int pm_id;//党员id
	private Date payDate;//缴费日期
	private String shouldPay;//应缴费用
	private String realPay;//实缴费用
	
	
	
	public DuePaymentRecords() {
	}
	
	
	public DuePaymentRecords(int pm_id, Date payDate, String shouldPay, String realPay) {
		this.pm_id = pm_id;
		this.payDate = payDate;
		this.shouldPay = shouldPay;
		this.realPay = realPay;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "dpr_id", unique = true, nullable = false)
	public int getDpr_id() {
		return dpr_id;
	}
	public void setDpr_id(int dpr_id) {
		this.dpr_id = dpr_id;
	}
	public int getPm_id() {
		return pm_id;
	}
	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}
	
	
	@Temporal(TemporalType.DATE)
	@Column(columnDefinition="DATE")
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getShouldPay() {
		return shouldPay;
	}
	public void setShouldPay(String shouldPay) {
		this.shouldPay = shouldPay;
	}
	public String getRealPay() {
		return realPay;
	}
	public void setRealPay(String realPay) {
		this.realPay = realPay;
	}
	
	
	
}
