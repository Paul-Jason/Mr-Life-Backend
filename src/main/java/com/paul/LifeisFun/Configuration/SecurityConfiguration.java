package com.paul.LifeisFun.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery(usersQuery)
			.authoritiesByUsernameQuery(rolesQuery)
			.dataSource(dataSource)
			.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
							.antMatchers("/user").permitAll()
							.antMatchers("/admin/**").hasAuthority("ADMIN")
							.anyRequest()
							.authenticated()
							.and()
							.httpBasic();
		httpSecurity.csrf().disable();
		
		
//		httpSecurity.csrf().disable();
//		httpSecurity.authorizeRequests()
//		.antMatchers("/admin/**").fullyAuthenticated()
//		.anyRequest().permitAll()
//		.and()
//		.formLogin().permitAll();
		
//		httpSecurity.authorizeRequests()
//		.antMatchers("/").permitAll()
//		.antMatchers("/user/**").permitAll()
//		.antMatchers("/admin/**").hasAuthority("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.csrf().disable();
		
//		httpSecurity.authorizeRequests()
//			.anyRequest().fullyAuthenticated()
//			.and().httpBasic();
//		httpSecurity.csrf().disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}
