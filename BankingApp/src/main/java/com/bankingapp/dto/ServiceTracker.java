package com.bankingapp.dto;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
public class ServiceTracker
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer serviceId;
	@Column(name="servicedescription")
	private String serviceDesc;
	@Column(name="accountid")
	private int accId;
	@Column(name="serviceraiseddate")
	private Date serviceRaiseDate;
	private String serviceStatus;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public Date getServiceRaiseDate() {
		return serviceRaiseDate;
	}
	public void setServiceRaiseDate(Date serviceRaiseDate) {
		this.serviceRaiseDate = serviceRaiseDate;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
}
