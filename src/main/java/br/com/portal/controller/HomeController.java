package br.com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.portal.model.AuthRequest;
import br.com.portal.response.AuthResponse;
import br.com.portal.service.MyuserDetailsService;
import br.com.portal.util.JwUtil;

@RestController
@RequestMapping(value = "/api")
public class HomeController {

	@Autowired
	JwUtil jwUtil;
	
	
	AuthenticationManager authManager;
	
	@Autowired
	private MyuserDetailsService myuserDetailsService;

	private UserDetails userDetails;
	
	private AuthResponse authResponse;
	
	@GetMapping(value = "/home")
	public String home(){
		
		userDetails = myuserDetailsService.loadUserByUsername("foo");
		
		jwUtil.generateToken(userDetails);
		jwUtil.getExpirationDateFromToken(jwUtil.generateToken(userDetails));
		
		return "Home Controller";
		//return jwUtil.generateToken(userDetails) + "\n Usuario: " + jwUtil.getUsernameFromToken(jwUtil.generateToken(userDetails));
		
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<AuthResponse> autenticar(@RequestBody AuthRequest auth){
		
		userDetails = myuserDetailsService.loadUserByUsername(auth.getUsername());
		authResponse = new AuthResponse();
		
		
		//jwUtil.generateToken(userDetails);
		jwUtil.getExpirationDateFromToken(jwUtil.generateToken(userDetails));
		
		authResponse.setJwtToken(jwUtil.generateToken(userDetails));
		//return "Home Controller";
		
		return ResponseEntity.ok(authResponse);
	}
}
