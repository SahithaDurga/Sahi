package com.sahitha.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "typeofshop")
	private String typeOfShop;

	public Shop() {
		super();
	}

	public Shop(int id, String name, String typeOfShop) {
		super();
		this.id = id;
		this.name = name;
		this.typeOfShop = typeOfShop;
	}

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

	public String getTypeOfShop() {
		return typeOfShop;
	}

	public void setTypeOfShop(String typeOfShop) {
		this.typeOfShop = typeOfShop;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + ", typeOfShop=" + typeOfShop + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((typeOfShop == null) ? 0 : typeOfShop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (typeOfShop == null) {
			if (other.typeOfShop != null)
				return false;
		} else if (!typeOfShop.equals(other.typeOfShop))
			return false;
		return true;
	}

}
