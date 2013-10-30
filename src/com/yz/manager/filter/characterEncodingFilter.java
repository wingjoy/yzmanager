
package com.yz.manager.filter;

/**
 * @author  lihaifeng
 *
 *  2012
 *  Dec 15, 2012
 *  2:18:06 PM
 */
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class characterEncodingFilter implements Filter {

	private String characterEncoding;
	private boolean enabled;

	public void init(FilterConfig config) throws ServletException {

		characterEncoding = config.getInitParameter("characterEncoding");

		enabled = "true".equalsIgnoreCase(characterEncoding.trim())
				|| "1".equalsIgnoreCase(characterEncoding.trim());
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (enabled || characterEncoding != null) {
			request.setCharacterEncoding(characterEncoding);
			response.setCharacterEncoding(characterEncoding);
		}

		chain.doFilter(request, response);
	}

	public void destroy() {
		characterEncoding = null;
	}
}

