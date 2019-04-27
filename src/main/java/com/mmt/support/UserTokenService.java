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
	private static final long EXPIRE_TIME = 15 * 60 * 1000;
	//token密钥
	private static final String TOKEN_SECRET = "hep1baij2maxsh3";
	// 私钥和加密算法
    private static Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
    
	public static String generateToken(String _email, String _pass)
	{
		// 设置过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        
        
        //设置头部信息
        Map<String, Object> header = new HashMap<String, Object>(2);
        header.put("Type", "Jwt");
        header.put("alg", "HS256");
        
		return  JWT.create()
                .withHeader(header)
                .withClaim("user", _email)
                .withClaim("pass", _pass)
                .withExpiresAt(date)
                .sign(algorithm);
	}
	
	public static boolean verifyToken(String _token)
	{
		System.out.println(_token);
		try 
		{
	        JWTVerifier verifier = JWT.require(algorithm).build();
	        DecodedJWT jwt = verifier.verify(_token);
	        System.out.println(jwt);
	        return true;
	    } 
		catch (Exception e)
		{
	    	e.printStackTrace();
	        return false;
	    }
	}
	
	
	
}
