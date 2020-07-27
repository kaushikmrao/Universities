package com.techprimers.elastic.repository;

import com.techprimers.elastic.model.University;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends ElasticsearchRepository<University, Long> {
   
}
