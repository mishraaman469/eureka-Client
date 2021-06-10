package com.mindtree.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.mindtree.school.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

	Optional<School> findBySchoolName(String schoolName);





	//Optional<School> findBySchoolName(String schoolName);

}
