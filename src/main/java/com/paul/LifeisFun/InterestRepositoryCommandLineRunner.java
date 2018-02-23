package com.paul.LifeisFun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.paul.LifeisFun.Dao.InterestRepository;
import com.paul.LifeisFun.Dao.PostRepository;
import com.paul.LifeisFun.Entity.Interest;
import com.paul.LifeisFun.Entity.Post;

@Component
public class InterestRepositoryCommandLineRunner implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(InterestRepositoryCommandLineRunner.class);
	
	@Autowired
	private InterestRepository interestRepository; 
	
	@Autowired
	private PostRepository postRepository; 
	
	@Override
	public void run(String... arg0) throws Exception{
		Interest interest = new Interest("Travel","Travel vlogs, Meeting new people, Getting new experiences, Connected with nature!!");
		interestRepository.save(interest);
		
		Post post1 = new Post("Bangalore to hogge nakkal", "Just do it!!!", interest);
		postRepository.save(post1);
		
		Post post2 = new Post("Bangalore to Hyderabad", "Will do it someday!!!", interest);
		postRepository.save(post2);
	}
}
