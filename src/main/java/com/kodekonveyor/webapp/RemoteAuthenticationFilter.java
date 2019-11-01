package com.kodekonveyor.webapp;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.kodekonveyor.authentication.UserEntity;
import com.kodekonveyor.authentication.UserEntityRepository;

@InterfaceClass
public class RemoteAuthenticationFilter implements Filter {

	@Autowired
	private UserEntityRepository userRepository;

	@Autowired
	private LoggerService loggerService;

	@Override
	public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain filterChain)
			throws IOException, ServletException {
		final SecurityContext context = SecurityContextHolder.getContext();
		if (context.getAuthentication() == null || !context.getAuthentication().isAuthenticated()) {
			final HttpServletRequest httpRequest = (HttpServletRequest) req;
			final String auth0id = httpRequest.getRemoteUser();
			final List<UserEntity> users = userRepository.findByAuth0id(auth0id);
			if (users.isEmpty())
				return;
			loggerService.call("authenticated:" + auth0id);
			final Authentication auth = new RemoteAuthentication(users.get(0));
			SecurityContextHolder.getContext().setAuthentication(auth);
		}

		filterChain.doFilter(req, res);
	}

}
