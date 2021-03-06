package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class myFilter
 */
@WebFilter("/myFilter")
public class myFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public myFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 该方法由 Web 容器调用，指示一个过滤器被取出服务。
	 * 
	 * @see Filter#destroy()
	 */
	public void destroy() {
		/* 在 Filter 实例被 Web 容器从服务移除之前调用 */
	}

	/**
	 * 该方法在每次一个请求/响应对因客户端在链的末端请求资源而通过链传递时由容器调用。
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获取客户机的 IP 地址
		String ipAddress = request.getRemoteAddr();
		// 记录 IP 地址和当前时间戳
		System.out.println("IP " + ipAddress + ", Time " + new Date().toString());

		// 把请求传回过滤链
		chain.doFilter(request, response);
	}

	/**
	 * 该方法由 Web 容器调用，指示一个过滤器被放入服务。
	 * 
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 获取初始化参数
		String testParam = fConfig.getInitParameter("test-param");
		// 输出初始化参数
		System.out.println("Test Param: " + testParam);
	}

}
