package com.bankingapp.dto;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String serviceDesc;
	private Integer accId;
	private LocalDate serviceRaiseDate;
	private String serviceStatus;
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public LocalDate getServiceRaiseDate() {
		return serviceRaiseDate;
	}
	public void setServiceRaiseDate(LocalDate serviceRaiseDate) {
		this.serviceRaiseDate = serviceRaiseDate;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
}
