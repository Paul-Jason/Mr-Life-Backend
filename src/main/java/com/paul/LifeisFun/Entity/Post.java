package com.paul.LifeisFun.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id")
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Interest interest;
	
	protected Post() {

	}

	public Post(String name, String content, Interest interest) {
		super();
		this.name = name;
		this.content = content;
		this.interest = interest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", content=" + content + "]";
	}
	
}
