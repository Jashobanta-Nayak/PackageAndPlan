package org.packageandplan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="vegcattering")
public class VegCatteringOrder {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	@Column(name="size")
	private String size;
	@Column(name="price")
	private int price;

	//No-argument Constructor
	public VegCatteringOrder() {
		super();
	}
	
	//Parameterized Constructor
	public VegCatteringOrder(long id, String size, int price) {
		super();
		this.id = id;
		this.size = size;
		this.price = price;
	}
	
	//Setter & Getter Methods
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	

}
