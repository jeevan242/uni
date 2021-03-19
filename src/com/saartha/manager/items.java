package com.saartha.manager;

public class items {
	private String name;
	private String unit;
	private int quantity;
	private String cat;
	public items(String name, String unit, int quantity,String cat) {
		super();
		this.name = name;
		this.unit = unit;
		this.quantity = quantity;
		this.cat=cat;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
