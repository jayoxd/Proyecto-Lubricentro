package com.lubriweb.pe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lubriweb.pe.service.UsuarioServiceImpl;

@Configuration // Se indica que esta clase es de config
@EnableWebSecurity // Con esto habilito spring Security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioServiceImpl userServImpl;
	
	@Autowired
	private CustomSuccessHandler csh;
	
	
	

	@Override // Metodo de Auntenticacion: Construccion o lectura de usuarios ya sea en
				// memoria o en la BD
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*// Usuarios en memoria
		auth.inMemoryAuthentication().withUser("xavier").password("{noop}x123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("lucia").password("{noop}l123").roles("USER");
		auth.inMemoryAuthentication().withUser("charlotte").password("{noop}c123").roles("DBA","ADMIN");*/
		
		//Spring Security verifica si el usuario se encuentra en la BD
		auth.userDetailsService(userServImpl);
		
		//Spring Security Comprueba si el password coincide con el cifrado de la BD
		auth.authenticationProvider(authenticationProvider());

	}

	@Override // Metodo de Autorizacion
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		      .antMatchers("/", "/index").permitAll() // Todos los usuarios anonimos o autenticados // pueden ver "/", "index"
			  .antMatchers("/user/**").access("hasRole('USER')")															
              .antMatchers("/admin/**").access("hasRole('ADMIN')")
              .antMatchers("/dba/**").access("hasRole('DBA') and hasRole('ADMIN')");
		
		http.authorizeRequests().and()
		      .formLogin()
		      .loginPage("/login")
		      .successHandler(csh); 
		
		//Intercepta solicitudes sin permiso por su rol
		//Se va rediriguir a la URL http:localhost:8085/LubriCenter/access_denied
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/access_denied"); 
	}
	
	@Bean //Bean Cifrado
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userServImpl);
		
		return provider;
	}

}
