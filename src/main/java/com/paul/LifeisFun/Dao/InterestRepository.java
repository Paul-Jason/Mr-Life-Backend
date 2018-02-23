package com.paul.LifeisFun.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paul.LifeisFun.Entity.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Integer> {

}
