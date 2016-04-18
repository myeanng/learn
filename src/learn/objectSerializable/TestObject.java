package learn.objectSerializable;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TestObject implements Serializable{
	
	private String name;
	private int id;
	//不进行序列化属性
	private transient String arrt;
	
	public String method(){
		return "my methods !";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArrt() {
		return arrt;
	}
	public void setArrt(String arrt) {
		this.arrt = arrt;
	}
	
}
