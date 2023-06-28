package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Students;
import com.bezkoder.spring.datajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lichengcan
 */
public interface StudentsRepository extends JpaRepository<Students, Integer> {


}
