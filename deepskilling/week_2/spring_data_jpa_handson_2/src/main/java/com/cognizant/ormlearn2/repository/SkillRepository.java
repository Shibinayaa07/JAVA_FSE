package com.cognizant.ormlearn2.repository;

import com.cognizant.ormlearn2.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
