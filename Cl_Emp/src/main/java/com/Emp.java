package com;

public class Emp {
	Integer id;
	String name;
	String address;
	Float sal;

	public Emp(Integer id, String name, String address, Float sal) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.sal = sal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getSal() {
		return sal;
	}

	public void setSal(Float sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", address=" + address + ", sal=" + sal + "]";
	}

	public Emp() {
		super();

	}

}
