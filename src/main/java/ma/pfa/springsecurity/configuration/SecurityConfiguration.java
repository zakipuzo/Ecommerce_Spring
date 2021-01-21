package ma.pfa.springsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ma.pfa.springsecurity.service.IUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private IUserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().
		antMatchers("/rest/**").hasAuthority("ADMIN");
		
		http.authorizeRequests().
		antMatchers(
			"/",
			"/product/**",
			"/search/**",
			"/login"
			).permitAll().  
		antMatchers("/register").permitAll().
		antMatchers("/newregistration").permitAll().
		antMatchers("/welcome").hasAnyAuthority("ADMIN","CLIENT").
		antMatchers("/admin/**").hasAuthority("ADMIN").
		antMatchers("/client/**").hasAnyAuthority("CLIENT","ADMIN").
		anyRequest().authenticated().
		and().csrf().disable().
		formLogin().loginPage("/login").
		failureUrl("/login?error=true").
		defaultSuccessUrl("/").
		usernameParameter("username").
		passwordParameter("password").
		and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").
		and().exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
