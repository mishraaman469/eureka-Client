package com.mindtree.school.service;

import com.mindtree.school.entity.School;

public interface SchoolService {

	School getSchool(String schoolName);

	void saveSchool(School school);

}
