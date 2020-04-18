package com.BankingApp.dto;

import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Proxy(lazy=false)
@Data
public class SecurityQuest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9109254310476418472L;
	@Id
	private Integer securityQid;
	@NotBlank
	private String securityQuest;
}
