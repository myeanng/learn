package string.main;

public class StringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("交易密码重置成功,资金密码重置<font color='red'>失败</font>,通讯密码重置<font color='red'>失败</font>,");
		String[] strs=str.split(",");
		StringBuffer sb=new StringBuffer();
		for (String string : strs) {
			System.out.println(string);
			if(!string.isEmpty()&&string.contains("失败")){
				string=string.substring(0,6)+"失败";
				System.out.println(string);
			}
			sb.append(string);
			sb.append(",");
			
		}
		sb.append("如需帮助请致电95330");
		System.out.println(sb.toString());
	}

}
