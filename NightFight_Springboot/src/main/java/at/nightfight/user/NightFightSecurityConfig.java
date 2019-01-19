package at.nightfight.user;

import java.util.ArrayList;
import java.util.List;

import at.nightfight.model.User;
import at.nightfight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled=true)
@SuppressWarnings("serial")
public class NightFightSecurityConfig { //extends WebSecurityConfigurerAdapter implements ApplicationListener<ApplicationReadyEvent>, AuthenticationProvider, WebMvcConfigurer
/*
	@Autowired
	private UserRepository userRepository;
	
	//==== WebSecurityConfigurerAdapter ====
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.httpBasic()
				.and()
			.authorizeRequests()
			.anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
	}

	//==== ApplicationListener<ApplicationReadyEvent> ====
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {}
	
	//==== AuthenticationProvider ====
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();		
		
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		User user = userRepository.findByName(username);
		
		if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
			throw new AuthenticationException("access denied: invalid username or password \n eingegebenes Passwort encrypted == "+ passwordEncoder.encode(password)) {};
		}
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	//==== WebMvcConfigurer ====
	
	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {
		corsRegistry.addMapping("/**");
	}
*/
}