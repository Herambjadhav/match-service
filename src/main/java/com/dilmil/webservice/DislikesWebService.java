package com.dilmil.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilmil.model.Dislike;
import com.dilmil.service.DislikesService;

/*
 * REST API's for dislike service
 */

@RestController
@RequestMapping("/dislikes")
public class DislikesWebService {

	@Autowired
	DislikesService dislikesService;
	
	/*
	 * NOT IMPLEMENTED: All API's should validate authorization header to allow or disallow access to api
	 */
	
	@GetMapping("/all/{userId}")
	public List<Dislike> getAllDislikedUsers(@PathVariable String userId) {
		
		return dislikesService.getAllDislikes(userId);
	}

	@PostMapping("/save")
	public void saveDislike(@RequestBody Dislike dislike) {
		dislikesService.saveDislike(dislike);
	}
}
