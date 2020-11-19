package lanzador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import service.UsersService;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsersService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder () {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	//Definicion roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// para securizar sin acceso a DDBB
		System.out.println("### SecurityConfig");
		auth.userDetailsService(userDetailsService);
		
	}
	
	// Definición de politicas de seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		//solo los miembros del rol admin podran realizar altas
		// y para buscar cuentas tendran que estar autorizados
		.antMatchers(HttpMethod.POST, "/cuenta").hasAuthority("ADMIN")
		.antMatchers("/cuenta/*").authenticated()
		.antMatchers("/cuentas").authenticated()
		.and()
		.httpBasic();
	}
}
