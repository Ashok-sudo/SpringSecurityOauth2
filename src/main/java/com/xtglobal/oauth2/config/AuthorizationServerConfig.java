package com.xtglobal.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	   @Autowired private AuthenticationManager authenticationManager; 
	   @Override 
	   public void configure(ClientDetailsServiceConfigurer clients) throws Exception { 
	      clients.inMemory() .withClient("oauthclient1") .secret("oauthsecret1") .scopes("read") .authorizedGrantTypes("password");
	      } 
	   @Override 
	   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception { 
	      endpoints.authenticationManager(authenticationManager); 
	   } 
	}