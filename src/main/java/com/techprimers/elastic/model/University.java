package com.techprimers.elastic.model;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Document(indexName = "sanjana", type = "sanjana", shards = 1)
@Table(name = "UniversityTable")
public class University {

    private String universityName;
   
    
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long  id;
    private int ranking;
    private  String location;
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getid() {
		return id;
	}
	public void setUnno(Long id) {
		this.id = id;
	}

	public University(String universityName, int ranking, String location) {
		super();
		this.universityName = universityName;
		this.ranking = ranking;
		this.location = location;
	}
   
public University() {
	
}
}
