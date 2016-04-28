package email.impl;

public class EmailMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmailImpl email=new EmailImpl("630316085@qq.com","myeanng@sina.com","localhost");
		//EmailImpl email=new EmailImpl("abcd@gmail.com","web@gmail.com","localhost");
		email.sendEmail("This is title ？", "Test ...");
	}

}
