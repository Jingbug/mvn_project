package www.aaa;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public abstract class BaseFilter implements Filter {
	
	private String fileName = null;
	private ServletContext servletContext;
	
	protected void log(String msg) {
		String sm = fileName + " : " + msg;
		servletContext.log(msg);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		fileName = filterConfig.getFilterName();
		servletContext = filterConfig.getServletContext();
	}
}
