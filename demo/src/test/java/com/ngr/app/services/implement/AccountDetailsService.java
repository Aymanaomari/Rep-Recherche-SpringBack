package com.ngr.app.services.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ngr.app.entity.Account;
import com.ngr.app.entity.AccountDetails;
import com.ngr.app.repostories.AccountRepository;

@Service
public class AccountDetailsService implements UserDetailsService{
	
	@Autowired
	AccountRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account=repo.findByEmail(email);
		if(account==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new AccountDetails(account);
	}

}
