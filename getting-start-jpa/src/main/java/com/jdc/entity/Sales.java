package com.jdc.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
public class Sales implements Serializable {

	public SalesPK getSpk() {
		return spk;
	}

	public void setSpk(SalesPK spk) {
		this.spk = spk;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private SalesPK spk;
	private int sales;
	@Basic(optional = false)
	private String description;
	@Transient
	private boolean deleted;
	@Temporal(TemporalType.DATE)
	private Date date;

}
