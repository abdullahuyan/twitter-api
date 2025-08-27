package com.example.twitter.repository;

import com.example.twitter.entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetweetRepository extends JpaRepository<Retweet,Long> {
}
