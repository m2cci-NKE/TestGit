package com.pluralsight.bookstore.model;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity

public class Book {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

@Column(length = 200)
@NotNull
@Size(min = 1, max = 200)
    private String title;

 @Column(length = 10000)

    private String description;

 @Column(name = "unit_cost")
@Min(1)
    private Float unitCost;

 @NotNull
 @Size(min = 1, max = 50)
    private String isbn;

   @Column(name = "publication_date")
   @Temporal(TemporalType.DATE)
//   @Past
    private Date publicationDate;

   @Column(name = "nb_of_pages")
    private Integer nbOfPages;

   @Column(name = "image_url")
    private String imageURL;

  
    private Language language;

    public Book() {
    }

 
	public Book(String isbn,String title, String description, float unitCost, int nbOfPages, Language language, Date publicationDate, String imageURL) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.unitCost = unitCost;
		this.publicationDate = publicationDate;
		this.nbOfPages = nbOfPages;
		this.imageURL = imageURL;
		this.language = language;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Float getUnitCost() {
		return unitCost;
	}


	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Date getPublicationDate() {
		return publicationDate;
	}


	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}


	public Integer getNbOfPages() {
		return nbOfPages;
	}


	public void setNbOfPages(Integer nbOfPages) {
		this.nbOfPages = nbOfPages;
	}


	public String getImageURL() {
		return imageURL;
	}


	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	public Language getLanguage() {
		return language;
	}


	public void setLanguage(Language language) {
		this.language = language;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", description=" + description + ", unitCost=" + unitCost
				+ ", isbn=" + isbn + ", publicationDate=" + publicationDate + ", nbOfPages=" + nbOfPages + ", imageURL="
				+ imageURL + ", language=" + language + "]";
	}
    
    
   
}
