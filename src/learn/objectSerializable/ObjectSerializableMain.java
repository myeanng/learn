package learn.objectSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializableMain {

	public static void main(String[] args) throws Exception {
		//���л�
		TestObject sto=new TestObject();
		sto.setName("�������л�");
		sto.setId(1);
		sto.setArrt("���л�����");
		set(sto);
		//�����л�
		TestObject gto=(TestObject) get();
		System.out.println("NAME:"+gto.getName());
		System.out.println("ID:"+gto.getId());
		System.out.println("ARRT:"+gto.getArrt());
		System.out.println("METHOD:"+gto.method());
	}

	private static void set(Object obj) throws Exception{
		System.out.println("���л���BEGIN");
		FileOutputStream fout=new FileOutputStream("E:\\myClass.ser");
		ObjectOutputStream oout=new ObjectOutputStream(fout);
		oout.writeObject(obj);
		oout.close();
		fout.close();
		System.out.println("���л���END");
	}
	
	private static Object get() throws Exception{
		System.out.println("�����л���BEGIN");
		Object o=null;
		FileInputStream fin=new FileInputStream("E:\\myClass.ser");
		ObjectInputStream oin=new ObjectInputStream(fin);
		o=oin.readObject();
		oin.close();
		fin.close();
		System.out.println("�����л���END");
		return o;
	}
}
