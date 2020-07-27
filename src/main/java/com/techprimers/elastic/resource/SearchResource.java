package com.techprimers.elastic.resource;

import com.techprimers.elastic.model.University;

import com.techprimers.elastic.service.universityservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SearchResource {

    @Autowired
 private universityservice universityservices;

    @GetMapping(value = "/details/{text}")
    public List<University> searchByll(@PathVariable  String text) {
        return universityservices.DisplayAlltheDetails(text);
    }


    @PostMapping("university")
    public Iterable<University> save(@RequestBody University university) {
    	return universityservices.save(university);
    }
    
    
    @GetMapping( "uns/{universityName}")
    public List<University> findBYUniversityName(@PathVariable String universityName) {
        return universityservices.ListByUniversityName(universityName);
    }


    @GetMapping("ranking/{ranking}")
  public List<University> findByRanking(@PathVariable int  ranking){
    	return universityservices.ListByRanking(ranking);
    }

    @GetMapping("Location/{Location}")
  public List<University> findByRanking(@PathVariable String Location){
    	return universityservices.ListByLocation(Location);
}
@DeleteMapping("/D")
public void delete() {
universityservices.delete();
}
}