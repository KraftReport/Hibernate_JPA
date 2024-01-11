package com.jdc.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SalesPK implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private int seq;
	@Column(nullable = false)
	private int tran;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getTran() {
		return tran;
	}

	public void setTran(int tran) {
		this.tran = tran;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seq, tran);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesPK other = (SalesPK) obj;
		return seq == other.seq && tran == other.tran;
	}

}
