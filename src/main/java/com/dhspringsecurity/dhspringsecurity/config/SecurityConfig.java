package com.dhspringsecurity.dhspringsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private DataSource dataSource;

	@Autowired
	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}		

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {	
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("SELECT email, senha, 'true' "   
				+"FROM funcionario WHERE email = ?")
		.authoritiesByUsernameQuery("SELECT email, autoridade " 
				+ "FROM autorizacao WHERE email = ?" );

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers("/clientes").hasAnyRole("FUNCIONARIO", "GERENTE")
		.and()
			.httpBasic();
		
	}

}
