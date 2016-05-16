package excel.xssf.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFWorkbookImpl {

	/**
	 * 这个类有读写Microsoft
	 * Excel和OpenOffice的XML文件的格式.xls或.xlsx的方法。它与MS-Office版本2007或更高版本兼容。
	 */
	private XSSFWorkbook xssf;

	private String address;

	public XSSFWorkbook getXssf() {
		return xssf;
	}

	public void setXssf(XSSFWorkbook xssf) {
		this.xssf = xssf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 读取现有的Excel
	 * 
	 * @param address
	 */
	public XSSFWorkbookImpl(String address) {
		super();
		this.address = address;
		File file = new File(address);
		if (file.isFile() && file.exists()) {
			System.out.println("->读入表格：" + address + "完成");
			try {
				FileInputStream fis = new FileInputStream(file);
				this.xssf = new XSSFWorkbook(fis);
			} catch (IOException e) {
				System.out.println("->初始化表格：" + address + "IO错误");
				e.printStackTrace();
			}
		} else {
			System.out.println("->读入表格：" + address + "错误");
			System.out.println("->新建表格：" + address + "BRGIN");
			this.xssf = new XSSFWorkbook();
			System.out.println("->新建表格：" + address + "END");
		}
	}

	public void write() {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File(address));
		} catch (FileNotFoundException e) {
			System.out.println("->创建表格文件错误");
			e.printStackTrace();
		}
		// write operation workbook using file out object
		try {
			xssf.write(out);
		} catch (IOException e) {
			System.out.println("->创建表格写出错误");
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.out.println("->创建表格关闭IO错误");
				e.printStackTrace();
			}
		}
		System.out.println("写完成");
	}

	/**
	 * 创建sheet
	 * 
	 * @param sheetName
	 * @return
	 */
	public XSSFSheet createSheet(String sheetName) {
		// 创建sheetName的单元表
		XSSFSheet xssfSheet = xssf.createSheet(sheetName);
		return xssfSheet;
	}

	/**
	 * 创建行
	 * 
	 * @param xssfSheet
	 * @param index
	 * @return
	 */
	public XSSFRow createRow(XSSFSheet xssfSheet, int index) {
		XSSFRow xssfRow = xssfSheet.createRow(index);
		return xssfRow;
	}

	/**
	 * set单元格内容
	 * 
	 * @param xssfRow
	 * @param cellnum
	 * @param text
	 * @return
	 */
	public XSSFCell createCell(XSSFRow xssfRow, int cellnum, String text) {
		XSSFCell xssfCell = xssfRow.createCell(cellnum);
		xssfCell.setCellValue(text);
		return xssfCell;
	}

	public void outPrint() {
		//Iterator<Sheet> sheets = xssf.iterator();
		for (Sheet sheet : xssf) {
			System.out.println("->开始输出表内容");
			System.out.println("----------------------");
			for (Row row : sheet) {
				//Iterator<Cell> cells = row.iterator();
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + " \t\t ");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + " \t\t ");
						break;
					default:
						System.out.print("---" + " \t\t ");
						break;
					}
				}
				System.out.println();
				System.out.println("----------------------");
			}
		}
	}
}
