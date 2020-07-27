package com.techprimers.elastic.service.impl;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.elasticsearch.index.query.QueryBuilder;

import com.techprimers.elastic.jparepository.UniversityJPARepository;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import com.techprimers.elastic.model.University;
import com.techprimers.elastic.repository.UniversityRepository;
import com.techprimers.elastic.service.universityservice;

@Service
public class UniversityServiceImpl implements universityservice {

	
	
	@Autowired 
	private UniversityJPARepository universityjparepository;
	
	@Autowired
	private UniversityRepository universityrepository;
	  @Autowired
	    private ElasticsearchTemplate elasticsearchTemplate;
	@Override
	public Iterable<University> save(University university) {
		 universityjparepository.save(university); 

	        List<University> usersList = universityjparepository.findAll(); 
	       return   universityrepository.save(usersList); 
	
	}

	@Override
	public List<University> DisplayAlltheDetails(String text) {
	    QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(text)
                                .lenient(true)
                                .field("universityName")
                                .field("location")
                                .field("ranking")
                              
                ).should(QueryBuilders.queryStringQuery("*" + text + "*")
                        .lenient(true)
                        .field("universityName")
                        .field("location")
                        .field("ranking"));

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<University> userses = elasticsearchTemplate.queryForList(build, University.class);

        return userses;
	}

	@Override
	public List<University> ListByRanking(int ranking) {
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("ranking", ranking));
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
		List<University> rankings = elasticsearchTemplate.queryForList(nativeSearchQuery, University.class);
		return rankings;
	}

	@Override
	public List<University> ListByLocation(String location) {
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("location", location));
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
		List<University> Locations = elasticsearchTemplate.queryForList(nativeSearchQuery, University.class);
		return Locations;
	}
	@Override
	public List<University> ListByUniversityName(String universityName) {
		QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("universityName", universityName));
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
		List<University> customers =  elasticsearchTemplate.queryForList(nativeSearchQuery, University.class);
		return customers;
	}

	@Override
	public void delete() {
		 elasticsearchTemplate.deleteIndex(University.class);
		 universityjparepository.deleteAll();
	}
	

}
