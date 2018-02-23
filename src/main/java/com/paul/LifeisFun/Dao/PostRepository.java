package com.paul.LifeisFun.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paul.LifeisFun.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
