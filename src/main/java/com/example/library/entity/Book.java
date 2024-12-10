package com.example.library.entity;

import javax.persistence.Transient; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity

public class Book{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message ="Title canot be empty")
	private String title;
	@NotEmpty(message="Author cannot be empty")
	private String author;
	@Min(value=1,message="Price should be atleast  1")
	private double price;
      
    @ManyToOne
    private long addedBy; 

	@Transient
	private int noOfCopies = 1; 
	
   	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getAddedBy() {
		return addedBy;
	}
	public void setAddedBy(long addedBy) {
		this.addedBy = addedBy;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}
	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
		
}

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Book {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//private int id;
//@NotEmpty(message ="Title canot be empty")
//private String title;
//@NotEmpty(message="Author cannot be empty")
//private String author;
//@Min(value=1,message="Price should be atleast  1")
//private double price;
//}
