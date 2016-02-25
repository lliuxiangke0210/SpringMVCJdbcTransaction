package com.springmvcjdbc.model;

public class BaseInfo {
	private String name;
	private String address;
	private String zipCode;
	private String recordCode;
	private String phone;
	private String email;
	private String domainName;
	private Integer indexPicWidth;
	private Integer indexPicHeight;
	private Integer indexPicNumber;

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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Integer getIndexPicWidth() {
		return indexPicWidth;
	}

	public void setIndexPicWidth(Integer indexPicWidth) {
		this.indexPicWidth = indexPicWidth;
	}

	public Integer getIndexPicHeight() {
		return indexPicHeight;
	}

	public void setIndexPicHeight(Integer indexPicHeight) {
		this.indexPicHeight = indexPicHeight;
	}

	public Integer getIndexPicNumber() {
		return indexPicNumber;
	}

	public void setIndexPicNumber(Integer indexPicNumber) {
		this.indexPicNumber = indexPicNumber;
	}

	@Override
	public String toString() {
		return "BaseInfo [name=" + name + ", address=" + address + ", zipCode=" + zipCode + ", recordCode=" + recordCode
				+ ", phone=" + phone + ", email=" + email + ", indexPicWidth=" + indexPicWidth + ", indexPicHeight="
				+ indexPicHeight + "]";
	}
}
