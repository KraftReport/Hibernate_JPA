package com.home.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.persistence.OrderBy;
import jakarta.persistence.OrderColumn;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<type, Integer> getPrice() {
		return price;
	}

	public void setPrice(Map<type, Integer> price) {
		this.price = price;
	}

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	@CollectionTable(joinColumns = @JoinColumn(name = "price->product"))
	@MapKeyEnumerated(EnumType.STRING)
	@OrderBy("price desc")
	@ElementCollection
	private Map<type, Integer> price;
	@ElementCollection
	@OrderColumn(name = "feature")
	private List<String> tag;
	@ElementCollection
	@Embedded
	private Set<Feature> feature;
	public enum type {
		customer, seller, special
	}
}
