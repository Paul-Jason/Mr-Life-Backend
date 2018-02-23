package com.paul.LifeisFun.Controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.paul.LifeisFun.GenericDaoService;
import com.paul.LifeisFun.PostBean;
import com.paul.LifeisFun.Dao.InterestRepository;
import com.paul.LifeisFun.Entity.Interest;
import com.paul.LifeisFun.Entity.Post;
import com.paul.LifeisFun.Exception.InterestNotFound;

@RestController
public class UserController {

	@Autowired
	private InterestRepository interestRepository;
	
	//GET
	//URI - /hello-world
	//method - "Hello World"
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello world!!";
	}
	
	@GetMapping(path = "/user/interests")
	public List<Interest> listInterests(){
		return interestRepository.findAll();
	}
	
	@GetMapping(path = "/user/interests/{interest_id}/posts")
	public List<Post> listPostOfAInterest(@PathVariable int interest_id){
		Optional<Interest> interestOptional = interestRepository.findById(interest_id);
		if(!interestOptional.isPresent()) {
			System.out.println("Interest Not found");
			throw new InterestNotFound("Interest not found with id: "+ interest_id);
		}
		return interestOptional.get().getPosts();
	}

	//Not Done: getting the post from list of posts.
//	@GetMapping(path = "/interests/{interest_id}/posts/post/{post_id}")
//	public Post getAPostOfListOfPostsOfInterest(@PathVariable int interest_id, @PathVariable int post_id){
//		Optional<Interest> interestOptional = interestRepository.findById(interest_id);
//		if(!interestOptional.isPresent()) {
//			System.out.println("User Not found");
//			return null;
//		}
//		return interestOptional.get().getPosts().get(post_id);
//	}
}
