package com.techprimers.elastic.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.techprimers.elastic.model.University;
@Service
public interface universityservice {
public Iterable<University> save(University university);
public List<University>DisplayAlltheDetails(String text);
public List<University>ListByRanking(int ranking);
public List<University>ListByLocation(String location);
public List<University>ListByUniversityName(String universityName);
public void delete();

}
