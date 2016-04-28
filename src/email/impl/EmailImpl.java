package email.impl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailImpl {

	// 收件邮箱
	private String to = "myeanng@sian.com";
	// 发送邮箱
	private String form = "myeanng@sian.com";
	// 发送机
	private String host = "localhost";

	private MimeMessage message;
	private Session session;

	public String sendEmail(String subject, String text) throws Exception {
		// set Subject
		message.setSubject(subject);
		// set text
		message.setText(text);
		Transport.send(message);
		/*InternetAddress toAdd = new InternetAddress(to);
		InternetAddress[] adds={toAdd};
		Transport.send(message, adds);*/
		/*Transport transport = session.getTransport("smtp");  
        transport.connect("smtp.sina.com",  "myeanng@sina.com", "meng2720036"); 
        InternetAddress toAdd = new InternetAddress(to);
		InternetAddress[] adds={toAdd};
        transport.sendMessage(message, adds);*/
		System.out.println("发送完成~");
		return "";
	}

	public EmailImpl(String to, String form, String host) {
		super();
		this.to = to;
		this.form = form;
		this.host = host;
		// 系统属性
		Properties properties = System.getProperties();
		// 设置邮件服务器
		properties.put("mail.pop.host", "pop.sina.com.cn");  
		properties.setProperty("mail.smtp.host", "smtp.sina.com.cn");//"smtp.sina.com.cn"
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		//ssl
		properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		
		//properties.setProperty("mail.user", "630316085@qq.com");
		//properties.setProperty("mail.password", "meng2720036@@");
		// 获取默认的session对象
		//this.session = Session.getDefaultInstance(properties);
		// 获取默认session对象
	      this.session = Session.getDefaultInstance(properties,new Authenticator(){
		    public PasswordAuthentication getPasswordAuthentication()
		    {
		     return new PasswordAuthentication("myeanng@sina.com", "meng2720036"); //发件人邮件用户名、密码
		    }
		   });

		// 创建默认的MimeMessage对象
		this.message = new MimeMessage(session);
		// 设置头部信息
		try {
			// set From:
			message.setFrom(new InternetAddress(form));
			// set To:
			message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
		} catch (MessagingException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}
