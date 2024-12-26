package com.ngr.app.services.implement;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	private String secrteKey="";
	
	public JWTService() throws NoSuchAlgorithmException {
		KeyGenerator keyGe=KeyGenerator.getInstance("HmacSHA256");
		SecretKey sk=keyGe.generateKey();
		secrteKey=Base64.getEncoder().encodeToString(sk.getEncoded());
	}
	
	
	public String GenerateToken(String email) {
		Map<String,Object> claims=new HashMap<>();
		return Jwts.builder().claims().add(claims).subject(email)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+60*60*24))
				.and().signWith(getKey()).compact();
		
	}

	private Key getKey() {
		byte[] keyBytes=Decoders.BASE64.decode(secrteKey);
		return Keys.hmacShaKeyFor(keyBytes) ;
	}
;
}
