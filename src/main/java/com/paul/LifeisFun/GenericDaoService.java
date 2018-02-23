package com.paul.LifeisFun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import antlr.collections.List;

@Component
public class GenericDaoService {
	
	private static Map<String, ArrayList<PostBean>> interests = new HashMap<String, ArrayList<PostBean>>();
	
	private static int interestsCount = 2;
	
	static {
		//InterestBean i1 = new InterestBean(1, "Travel", "Travel vlogs, Exploring places, Meeting new people, New experiences.");
		ArrayList<PostBean> posts1 = new ArrayList<PostBean>();
		PostBean post11 = new PostBean(1, "Bangalore to Hogge nakkal", "Just stick with it!!");
		PostBean post12 = new PostBean(2, "Bangalore to Hyderabad", "Will do it someday!!");
		posts1.add(post11);
		posts1.add(post12);
		interests.put("travel", posts1);
		
		//InterestBean i2 = new InterestBean(2, "Wellness", "Fitness for health, Self care routines.");
		ArrayList<PostBean> posts2 = new ArrayList<PostBean>();
		PostBean post21 = new PostBean(1, "Fitness", "Aim for a healthy being not fit!!");
		PostBean post22 = new PostBean(2, "Self care", "Care for your hair, skin, For youreself!!");
		posts2.add(post21);
		posts2.add(post22);
		interests.put("wellness", posts2);
	}
	
	public ArrayList<String> findAllInterests(){
		ArrayList<String> list = new ArrayList<String>(interests.keySet());
		return list;
	}
	
	public ArrayList<PostBean> findAllPostOfAInterest(String interestName){
		ArrayList<PostBean> posts = new ArrayList<PostBean>(interests.get(interestName));
		return posts;
	}
	
	public PostBean findAPostOfListOfPostsOfInterest(String interestName, int postId){
		ArrayList<PostBean> posts = new ArrayList<PostBean>(interests.get(interestName));
		PostBean thatPost = null;
		for(PostBean post: posts) {
			if (post.getId() == postId) {
				thatPost = post;
				break;
			}
		}
		return thatPost;
	}
	
	 public ArrayList<PostBean> saveInterest(String interest) {
		 interests.put(interest, null);
		 return interests.get(interest);
	 }
	 
	 //Not Done: validate whether that interest is there or not
	 public PostBean savePostOfAInterest(String interestName, PostBean post) {
		 ArrayList<PostBean> postsList = interests.get(interestName);
		 int postId = postsList.size() + 1;
		 post.setId(postId);
		 postsList.add(post);
		 interests.put(interestName, postsList);
		 postsList = interests.get(interestName);
		 PostBean thatPost = null;
			for(PostBean post1: postsList) {
				if (post1.getId() == postId) {
					thatPost = post1;
					break;
				}
			}
		return thatPost;
	 }
	 
	 public boolean deleteInterest(String interestName) {
		 interests.remove(interestName);
		 return true;
	 }
	 
	//Not Done: validate whether that interest is there or not
	public boolean deletePostOfAInterest(String interestName, int postId) {
		ArrayList<PostBean> postsList = interests.get(interestName);
	    PostBean thatPost = null;
		for(PostBean post: postsList) {
			if(post.getId() == postId) {
				thatPost = post;
				break;
			}
		}
		postsList.remove(thatPost);
		interests.put(interestName, postsList);
		return true;
	}
	 
 }
