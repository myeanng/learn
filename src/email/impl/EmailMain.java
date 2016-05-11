package email.impl;

public class EmailMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmailImpl email=new EmailImpl("854529175@qq.com","myeanng@sina.com","localhost");
		EmailImpl e2=new EmailImpl("976500328@qq.com","myeanng@sina.com","localhost");
		EmailImpl e3=new EmailImpl("guojin355@qq.com","myeanng@sina.com","localhost");
		//EmailImpl email=new EmailImpl("abcd@gmail.com","web@gmail.com","localhost");
		email.sendEmail("标题 ？", "测试程序用，嘿嘿嘿 ...孟岩");
		e2.sendEmail("标题 ？", "测试程序用，嘿嘿嘿 ...孟岩");
		e3.sendEmail("傻逼 ？", "测试程序用，嘿嘿嘿 ...孟岩");
	}

}
