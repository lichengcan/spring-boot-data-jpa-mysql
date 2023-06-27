package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lichengcan
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.age=0")
    User getUser();

    @Transactional
    @Modifying
    @Query("update User u set u.age=?1")
    int updateUser(Integer age);



}
