package Instagram.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	//@Autowired
	//private MyUserDetails myUserDetails;
	/*
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.UserDetailsServiceImp(myUserDetails);
	}
*/
	
	@Bean
	public UserDetailsServiceImp userDetailsService() {
		return new UserDetailsServiceImp();
	}
	
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	*/
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	 //ovo vrati!
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	

	
	/*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll().and().logout().permitAll();
	}
	*/
	
	//treba da se doda logout
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		  	//.antMatchers("/usersDto/**","/users/**","/user/{id}/**","/userDto/{id}/**","/postSave/**","/postUpdate/{id}/**","/postDelete/{id}/**","/likeSave/**","/likeDelete/{id}/**","/commentSave/**","/commentUpdate/{id}/**","/CommentRestController/**")
			.antMatchers("/users/**")
			//.antMatchers(HttpMethod.GET, "/users")
			.hasRole("ADMIN") // ako je admin i ulogujem se sa usera ovo gore je ogranicenje i nece ga otvoriti, vazi i obratno
		  	.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.permitAll();
		
	
		
	}
	
	
	/*
	AuthenticationProvider authenticationProvider() {
		
	}
	*/
}
