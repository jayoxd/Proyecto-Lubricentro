package com.lubriweb.pe;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LubriCenterMApplication implements CommandLineRunner {
	
	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */

	public static void main(String[] args) {
		SpringApplication.run(LubriCenterMApplication.class, args);
	}

	@Override //Metodo ejecutar y mostrar en consola
	public void run(String... args) throws Exception {
		
		/*
		System.out.println("x123: " +passwordEncoder.encode("x123"));
		System.out.println("l345: " +passwordEncoder.encode("l345"));
		System.out.println("c345: " +passwordEncoder.encode("c345"));
		*/
		
	}

}
