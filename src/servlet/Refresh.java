package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自动刷新的servlet， Servlet implementation class Refresh
 */
@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Refresh() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置刷新自动加载的事件间隔为 5 秒
		response.setIntHeader("Refresh", 5);

		// 设置响应内容类型
		response.setContentType("text/html");
		// 获取客户端的区域设置
		Locale locale = request.getLocale();
		String language = locale.getLanguage();
		String country = locale.getCountry();

		// 设置语言代码
		response.setHeader("Content-Language", language);

		// 获取当前的时间
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";

		String CT = hour + ":" + minute + ":" + second + " " + am_pm;
		//设置编码方式，防止客户端出现乱码情况
		response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
		String title = "使用 Servlet 自动刷新页面";
		//String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//EN\">\n";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head>\n<meta charset=\"utf-8\">\n<title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" + "<p>当前时间是：" + CT
				+ "</p>\n</body>\n</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
