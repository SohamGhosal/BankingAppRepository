package com.bankingapp.dto;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.Proxy;
@Entity
@Proxy(lazy=false)
public class ServiceTracker implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8397036782220677743L;
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
