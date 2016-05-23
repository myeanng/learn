package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myFirstServlet
 */
@WebServlet("/myFirstServlet")
public class myFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String message;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置响应内容类型
		resp.setContentType("text/html");
		// 实际的逻辑是在这里
		PrintWriter out = resp.getWriter();
		out.println("<h2>" + message + "</h2>");
		resp.sendRedirect("myRedirectServlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 调用doGet方法
		this.doGet(req, resp);
	}

	/**
	 * 服务，调用指定的doGet、doPost方法
	 * 
	 * service() 方法是执行实际任务的主要方法。Servlet 容器（即 Web 服务器）调用 service()
	 * 方法来处理来自客户端（浏览器）的请求，并把格式化的响应写回给客户端。 每次服务器接收到一个 Servlet
	 * 请求时，服务器会产生一个新的线程并调用服务。service() 方法检查 HTTP 请求类型（GET、POST、PUT、DELETE
	 * 等），并在适当的时候调用 doGet、doPost、doPut，doDelete 等方法。 service() 方法由容器调用，service
	 * 方法在适当的时候调用 doGet、doPost、doPut、doDelete 等方法。所以，您不用对 service()
	 * 方法做任何动作，您只需要根据来自客户端的请求类型来重载 doGet() 或 doPost() 即可。
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	/**
	 * destroy() 方法只会被调用一次，在 Servlet 生命周期结束时被调用。destroy() 方法可以让您的 Servlet
	 * 关闭数据库连接、停止后台线程、把 Cookie 列表或点击计数器写入到磁盘，并执行其他类似的清理活动。 在调用 destroy()
	 * 方法之后，servlet 对象被标记为垃圾回收。
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	/**
	 * Servlet 通过调用 init () 方法进行初始化 init 方法被设计成只调用一次。它在第一次创建 Servlet
	 * 时被调用，在后续每次用户请求时不再调用。因此，它是用于一次性初始化，就像 Applet 的 init 方法一样。 Servlet
	 * 创建于用户第一次调用对应于该 Servlet 的 URL 时，但是您也可以指定 Servlet 在服务器第一次启动时被加载。 当用户调用一个
	 * Servlet 时，就会创建一个 Servlet 实例，每一个用户请求都会产生一个新的线程，适当的时候移交给 doGet 或 doPost
	 * 方法。init() 方法简单地创建或加载一些数据，这些数据将被用于 Servlet 的整个生命周期。
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 执行必需的初始化
		message = "Hello World";
	}

}
