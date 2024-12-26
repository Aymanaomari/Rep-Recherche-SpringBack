package com.ngr.app.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngr.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

}
