package www.demo;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/hello",
		initParams = {
				@WebInitParam(name = "greeting", value = "Hello, World from ServletConfig!")
		}
	)
public class HelloServlet extends HttpServlet {
	private String greeting = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		greeting = config.getInitParameter("greeting");
		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("HelloServlet");  
		String html = """
				<html>  
				<head></head>  
				<body>  
				""" + greeting + """  
				<body>  
				<html>  
				""";  
		resp.getWriter().println(html);
	}

	@Override
	public void destroy() {
		log("Hello was destory");
		super.destroy();
	}
	
	
}
