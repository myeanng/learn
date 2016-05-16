package excel.xssf.impl;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XSSFWorkbookImpl xss=new XSSFWorkbookImpl("E:\\test2.xlsx");
		//row与cell的下标从0开始
		//xss.createCell(xss.createSheet("Mytable1").createRow(0), 0, "aaa");
		//xss.createSheet("Mytable1");
		//xss.createSheet("Mytable2");
		//xss.createSheet("Mytable4");
		xss.outPrint();
		xss.write();
	}

}
