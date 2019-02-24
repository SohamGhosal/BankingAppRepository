package com.BankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Proxy(lazy=false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
