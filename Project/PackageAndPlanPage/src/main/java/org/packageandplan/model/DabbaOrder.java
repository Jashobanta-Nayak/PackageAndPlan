package org.packageandplan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dabbaorder")
public class DabbaOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="ordertype")
	private String type;
	@Column(name="orderprice")
	private int price;

	//No-argument Constructor
	public DabbaOrder() {
		super();
	}

	//Parameterized Constructor
	public DabbaOrder(long id, String type, int price) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
	}

	//Setter & Getter methods
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
