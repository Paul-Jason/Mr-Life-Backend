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
//	
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("paul").password("paul9848").roles("ADMIN");
		
//		auth.jdbcAuthentication()
//			.usersByUsernameQuery("select email , password from user where email = ?")
//			.authoritiesByUsernameQuery("select u.email, r.role from user u inner join user_role ur on(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.email=?")
//			.dataSource(dataSource)
//			.passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests()
			.antMatchers("/user/**").permitAll()
			.antMatchers("/admin/**").permitAll()
			.and().httpBasic();
		httpSecurity.csrf().disable();
		
//		httpSecurity.authorizeRequests().anyRequest().hasAnyRole("ADMIN")
//	    .and()
//	    .httpBasic();
		
//		httpSecurity.authorizeRequests()
//				.antMatchers("/user/**").permitAll()
//				.antMatchers("/admin/**").hasAuthority("ADMIN")
//				.anyRequest()
//				.authenticated().and().httpBasic();
//		httpSecurity.csrf().disable();
		
//		httpSecurity.authorizeRequests()
//						.antMatchers("/").permitAll()
//						.antMatchers("/login").permitAll()
//						.antMatchers("/registration").permitAll()
//						.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//						.authenticated().and().httpBasic()
//						.and().csrf().disable().formLogin()
//						.loginPage("/login").failureUrl("/login?error=true")
//						.defaultSuccessUrl("/admin/home")
//						.usernameParameter("email")
//						.passwordParameter("password")
//						.and().logout()
//						.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//						.logoutSuccessUrl("/").and().exceptionHandling()
//						.accessDeniedPage("/access-denied");
				
		
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
