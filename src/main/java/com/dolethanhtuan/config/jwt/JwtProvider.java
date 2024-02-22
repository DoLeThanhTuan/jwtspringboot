package com.dolethanhtuan.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SecretKeyAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtProvider {
	private final String keyString = "dolethanhtuan123@";
	private SecretKey secretKey;
	private final long exprirationTime = 86400000;
	public JwtProvider(){
		secretKey = new SecretKeySpec(keyString.getBytes(StandardCharsets.UTF_8),"HmacSHA512");
	}
	public String generateToken(UserDetails userDetails){
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+exprirationTime))
				.signWith(secretKey)
				.compact();
	}
	public String extractUsername(String token){
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
	}
}
