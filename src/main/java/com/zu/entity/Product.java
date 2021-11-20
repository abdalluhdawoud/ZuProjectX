package com.zu.entity;

public class Product {

	private String productId;
	private String productName;
	private String companyName;
	private String operatingSystem;
	private String battery;
	private String processor;
	private String description;
	
	
	public Product() {
		
	}	
	
	
	public Product(String productId, String productName, String companyName, String operatingSystem, String battery,
			String processor, String description) {
		
		this.productId = productId;
		this.productName = productName;
		this.companyName = companyName;
		this.operatingSystem = operatingSystem;
		this.battery = battery;
		this.processor = processor;
		this.description = description;
	}
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
