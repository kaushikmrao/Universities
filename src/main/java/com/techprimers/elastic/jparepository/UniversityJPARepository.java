package com.techprimers.elastic.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techprimers.elastic.model.University;
@Repository
public interface UniversityJPARepository extends JpaRepository<University, Long>{
}
