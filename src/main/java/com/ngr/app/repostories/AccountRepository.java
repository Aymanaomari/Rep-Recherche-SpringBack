package com.ngr.app.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ngr.app.entity.Account;
import com.ngr.app.entity.User;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);

	void deleteById(Integer accountId);

	Optional<Account> findById(Integer accountId);
	}
