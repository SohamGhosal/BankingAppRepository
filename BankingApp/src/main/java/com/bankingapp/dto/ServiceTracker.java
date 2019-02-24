package com.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Proxy(lazy=false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
}
