package com.cognizant.ormlearn3.repository;

import com.cognizant.ormlearn3.model.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttemptRepository extends JpaRepository<Attempt, Integer> {
    @Query("SELECT DISTINCT a FROM Attempt a LEFT JOIN FETCH a.user LEFT JOIN FETCH a.attemptQuestions aq LEFT JOIN FETCH aq.question q LEFT JOIN FETCH q.options LEFT JOIN FETCH aq.attemptOptions ao LEFT JOIN FETCH ao.option WHERE a.user.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
