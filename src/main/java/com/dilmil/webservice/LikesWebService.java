package com.dilmil.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilmil.model.Like;
import com.dilmil.service.LikesService;

/*
 * REST API's for likes service
 */

@RestController
@RequestMapping("/likes")
public class LikesWebService {

	@Autowired
	LikesService likesService;
	
	/*
	 * NOT IMPLEMENTED: All API's should validate authorization header to allow or disallow access to api
	 */

	@GetMapping("/all/{userId}")
	public List<Like> getAllLikedUsers(@PathVariable String userId) {
		return likesService.getAllLikes(userId);
	}

	@PostMapping("/save")
	public void saveLike(@RequestBody Like like) {
		likesService.saveLike(like);
	}
}
