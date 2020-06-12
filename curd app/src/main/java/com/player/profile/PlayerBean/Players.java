package com.player.profile.PlayerBean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name="players")
public class Players {

	/**
	 * 
	 */
	//private static final int serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "category")
	private String category;

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Players() {

	}

	public Players(String name, String image) {
		this.name = name;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", player_Name=" + name + ", image=" + image + "]";
	}
}
