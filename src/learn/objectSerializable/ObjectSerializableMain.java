package learn.objectSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializableMain {

	public static void main(String[] args) throws Exception {
		//序列化
		TestObject sto=new TestObject();
		sto.setName("测试序列化");
		sto.setId(1);
		sto.setArrt("序列化属性");
		set(sto);
		//反序列化
		TestObject gto=(TestObject) get();
		System.out.println("NAME:"+gto.getName());
		System.out.println("ID:"+gto.getId());
		System.out.println("ARRT:"+gto.getArrt());
		System.out.println("METHOD:"+gto.method());
	}

	private static void set(Object obj) throws Exception{
		System.out.println("序列化：BEGIN");
		FileOutputStream fout=new FileOutputStream("E:\\myClass.ser");
		ObjectOutputStream oout=new ObjectOutputStream(fout);
		oout.writeObject(obj);
		oout.close();
		fout.close();
		System.out.println("序列化：END");
	}
	
	private static Object get() throws Exception{
		System.out.println("反序列化：BEGIN");
		Object o=null;
		FileInputStream fin=new FileInputStream("E:\\myClass.ser");
		ObjectInputStream oin=new ObjectInputStream(fin);
		o=oin.readObject();
		oin.close();
		fin.close();
		System.out.println("反序列化：END");
		return o;
	}
}
