package com.estoquito.estoquitoapi.security.jwt;

import com.estoquito.estoquitoapi.entity.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class TokenService {

	@Value("${jwt.expiration}")
	private String expiration;

	@Value("${jwt.secret}")
	private String secret;

	public Usuario getUserFromToken() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return ((Usuario)authentication.getPrincipal());
	}

	public String generateToken(Authentication authentication) {

		Usuario usuario = (Usuario) authentication.getPrincipal();

		Date now = new Date();
		Date exp = new Date(now.getTime() + Long.parseLong(expiration));

		SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));

		return Jwts.builder().setIssuer("FE_TOKEN")
                             .setSubject(usuario.getId().toString())
                             .setIssuedAt(new Date())
				             .setExpiration(exp)
                             .signWith(secretKey).compact();
	}

	public String generateToken(JwtToken jwtToken) {
		Map<String, Object> claims = new HashMap<>(); //create a hashmap

		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Object> customerData = oMapper.convertValue(jwtToken, Map.class);

		claims.putAll(customerData);

		Date now = new Date();
		Date exp = new Date(now.getTime() + Long.parseLong(expiration));

		SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));

		return Jwts.builder()
				.setIssuer("FE_TOKEN")
				.setClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(exp)
				.signWith(secretKey).compact();
	}

	public Long getExpirationSecondsFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration).getTime() / 1000;
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	//para retornar qualquer informação do token nos iremos precisar da secret key
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
	}
}