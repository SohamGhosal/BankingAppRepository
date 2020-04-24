package com.BankingApp.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Proxy(lazy=false)
@Data
public class ServiceTracker implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8397036782220677743L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String serviceId;
	private String serviceDesc;
	private String accountId;
	private LocalDate serviceRaiseDate;
	private String serviceStatus;
}
