package com.mmt.support;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class UserTokenService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	//token过期时间
	private static final long EXPIRE_TIME = 5 * 60 * 1000;
	//token密钥
	private static final String TOKEN_SECRET = "hep1baij2maxsh3chenl4";
	// 私钥和加密算法
    private static Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
    
	public static String generateToken(String _username)
	{
		// 设置过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        
        //设置头部信息
        Map<String, Object> header = new HashMap<String, Object>(2);
        header.put("Type", "Jwt");
        header.put("alg", "HS256");
        
		return  JWT.create()
                .withHeader(header)
                .withClaim("username", _username)
                .withExpiresAt(date)
                .sign(algorithm);
	}
	
	public static String verifyToken(String _token)
	{
		String username = null;
		try 
		{
	        JWTVerifier verifier = JWT.require(algorithm).build();
	        
	        String json[] = _token.split("=");
	        String token = json[1];
	        System.out.println(_token);
	        System.out.println(token);
	        
	        DecodedJWT jwt = verifier.verify(token);
	        System.out.println(jwt);
	        
	        Map<String, Claim> claims = jwt.getClaims();
	        username = claims.get("username").asString();
	    } 
		catch (Exception e)
		{
	    	e.printStackTrace();
	    }
		return username;
	}
	
	
	

	
}
