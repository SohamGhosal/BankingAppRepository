package com.BankingApp.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Proxy(lazy=false)
@Data
public class BankAdmin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7121055691570123861L;
	@Id
	private String adminId;
	@NotBlank
	private String adminPassword;
}
