package com.lubriweb.pe.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	// Objeto redireccionador
	private RedirectStrategy rs = new DefaultRedirectStrategy();

	@Override // Metodo que controla el exito de logueo para ir a una URL especifico
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		String targetURL = determineTargetUrl(authentication);
		
		
		// Redireccionar manualmente la url (http://localhost:8085/LubriCenter/dba)
		rs.sendRedirect(request, response, targetURL);

	}

	protected String determineTargetUrl(Authentication authentication) {

		String url = null;

		Collection<String> roles = new ArrayList<>();

		for (GrantedAuthority authority : authentication.getAuthorities()) {

			roles.add(authority.getAuthority());

		}

		if (roles.contains("ROLE_DBA"))
			url = "/dba";
		else if (roles.contains("ROLE_ADMIN"))
			url = "/admin";
		else if (roles.contains("ROLE_USER"))
			url = "/user";
		else
			url = "/access_denied";

		return url;
	}

}
