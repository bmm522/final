package com.loginAPI.config.oauth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.loginAPI.model.Provider;

import lombok.AllArgsConstructor;
import lombok.Builder;

// SecurityContextHolder에 담을 목적
// UserDetails 객체로 만들어줘야함

/*@AllArgsConstructor
@Builder*/
public class OAuth2UserDetails implements UserDetails{
	
	private Provider provider;
	private String providerId;
	private String username;
	private Set<GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}	
	
	@Override
	public String getUsername() {
		return username;
	}
	
	public Provider getProvider() {
		return provider;
	}
	
	public String getProviderId() {
		return providerId;
	}
	
	public void setRoles(String... roles) {
		List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
		
		for(String role : roles) {
			Assert.isTrue(!role.startsWith("ROLE_"),
					()-> role+ "cannot start with ROLE_(It is automatically added)");
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
		}
		this.authorities = Set.copyOf(authorities);
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public String getPassword() {
		return null;
	}
	

	
}
