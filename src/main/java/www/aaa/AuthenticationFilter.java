package www.aaa;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(
		urlPatterns = {"/jsp/user/*", "jsp/admin/*", "/logout"},
		initParams = {
				@WebInitParam(name = "valve", value = "on")
		}
)
public class AuthenticationFilter extends BaseFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		
		String sValue = filterConfig.getInitParameter("valve");
		
		if (sValue != null) {
			if (sValue.equals("on"))  = true;
		}
	}

}
