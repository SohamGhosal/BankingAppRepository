package com.BankingApp.dto;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class TransactionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117755968510462488L;
	private Integer transId;
	private String transType;
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(!(obj instanceof TransactionId))
			return false;
		TransactionId that=(TransactionId) obj;
		return Objects.equals(getTransId(), that.getTransId()) &&
				Objects.equals(getTransType(), that.getTransType());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTransId(), getTransType());
	}
}