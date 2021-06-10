package com.mindtree.school.service.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.school.entity.School;
import com.mindtree.school.exception.NullCheckException;
import com.mindtree.school.repository.SchoolRepository;
import com.mindtree.school.service.SchoolService;

@Service
public class SchoolServiceImpl  implements SchoolService{

		@Autowired
		private SchoolRepository schoolRepository;

		@Override
		public School getSchool(String schoolName) {
			Optional<School> school=this.schoolRepository.findBySchoolName(schoolName);
			if(school.isPresent()) {
				School schoolPresent=school.get();
				return schoolPresent;
			}else {
				throw new NullCheckException("School name not found "+schoolName);
			}
			
		}

		@Override
		public void saveSchool(School school) {
			this.schoolRepository.save(school);	
		}
		
		
		
}
