package com.paul.LifeisFun.Controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paul.LifeisFun.GenericDaoService;
import com.paul.LifeisFun.PostBean;
import com.paul.LifeisFun.Dao.InterestRepository;
import com.paul.LifeisFun.Dao.PostRepository;
import com.paul.LifeisFun.Entity.Interest;
import com.paul.LifeisFun.Entity.Post;

@RestController
public class AdminController {

	@Autowired
	private InterestRepository interestRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping(path = "/hello-world-admin")
	public String helloWorld() {
		return "Hello world!!";
	}
	
	//Input: Interest name in the form of string. (In the form of raw text)
	//Output: Status of the request sent i.e., CREATED and list of the posts that are
	// 		  present with in that interest.
	//Not Done: Validating the type sent from the request body, exception if the
	//          type is wrong.
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/admin/interests")
	public Interest createInterest(@Valid @RequestBody Interest interest) {
		Interest interestR = interestRepository.save(interest);
		return interestR;
	}
	
	//Input: Interest name in the path, post in the request body.
	//Output: Returning the entire post.
//	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping(value = "/admin/interests/{interest_id}/post")
	public Post createPostOfAInterest(@PathVariable int interest_id,@Valid @RequestBody Post post) {
		Optional<Interest> interestOptional = interestRepository.findById(interest_id);
		if(!interestOptional.isPresent()) {
			System.out.println("Interest Not found");
			return null;
		}
		Interest interest = interestOptional.get();
		post.setInterest(interest);
		Post postR = postRepository.save(post);
		return postR;
	}
	
	//Input: Interest name in the path.
	//Output: Returning the boolean status.
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/admin/interests/{interest_id}")
	public void deleteInterest(@PathVariable int interest_id) {
		interestRepository.deleteById(interest_id);
	}
	
	//Input: Interest name, post id in the path.
	//Output: Returning the boolean status.
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping(value = "/admin/interests/{interest_id}/posts/post/{post_id}")
	public void deletePostOfAInterest(@PathVariable int interest_id, @PathVariable int post_id) {
		postRepository.deleteById(post_id);
	}
	
}
