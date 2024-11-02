package test;

import java.io.Serializable;

public class AddCartBean implements Serializable{

	public AddCartBean() {}
	
	private String code,name,author;
	private Float price;
	private Integer qty;
	private Integer noOfBooks;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code.trim();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author.trim();
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Integer getNoOfBooks() {
		return noOfBooks;
	}
	public void setNoOfBooks(Integer noOfBooks) {
		this.noOfBooks = noOfBooks;
	}
	
	
	
}
