package com.cognizant.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ramesh
 *
 */
@Entity
@Table(name = "muser")
@Data
@NoArgsConstructor
@AllArgsConstructor


/*
 * insert into muser(us_id,us_name) values(1,"Ramesh");
 */
public class User {
	@Id
	@Column(name = "us_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "us_name")
	private String name;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Favorites> favorites;
}
