package com.bankingapp.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117755968510462488L;
	private Integer transId;
	private String transType;
	public Integer getTransId() {
		return transId;
	}
	public void setTransId(Integer transId) {
		this.transId = transId;
	}
	public String gettransType() {
		return transType;
	}
	public void settransType(String transType) {
		this.transType = transType;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(!(obj instanceof TransactionId))
			return false;
		TransactionId that=(TransactionId) obj;
		return Objects.equals(getTransId(), that.getTransId()) &&
				Objects.equals(gettransType(), that.gettransType());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTransId(), gettransType());
	}
}