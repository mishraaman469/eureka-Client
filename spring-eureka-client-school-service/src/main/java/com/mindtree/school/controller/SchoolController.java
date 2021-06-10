package com.mindtree.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.school.entity.School;
import com.mindtree.school.service.SchoolService;

@RestController
public class SchoolController {

		/*@Autowired
		RestTemplate restTemplate;*/
	
		@Autowired
		private SchoolService schoolService;
		
		@Autowired
		private RestTemplate restTemplate;
		
		/*@RequestMapping(value = "getSchoolDetails/{schoolName}", method = RequestMethod.GET)
		public String getStudents(@PathVariable String schoolName) {
			System.out.println("Getting School details for "+schoolName);
			String response=restTemplate.exchange(null, null, null, null)
		}*/
	
	
		/*@GetMapping("/getSchool/{schoolName}")
		public ResponseEntity<School> getSchool(@PathVariable String schoolName){
			School school=this.schoolService.getSchool(schoolName);
			return new ResponseEntity<School>(school,HttpStatus.OK);
		}
		*/
		
		@RequestMapping(value = "/getSchoolDetails/{schoolName}", method = RequestMethod.GET)
		public String getStudents(@PathVariable String schoolName) {
			School school=this.schoolService.getSchool(schoolName);
			
			String response = restTemplate.exchange("http://student-service/getStudentBySchoolName/{schoolName}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
			},schoolName).getBody();
			return  "School"+school+"Student"+response;
		}
		
		
		@PostMapping("/saveSchool")
		public ResponseEntity<String> saveSchool(@RequestBody School school){
			this.schoolService.saveSchool(school);
			return new ResponseEntity<String>("School Data is saved sucessfully "+school.getSchoolName(),HttpStatus.CREATED);
		}
		
		@Bean
		@LoadBalanced
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
	
	
		
}
