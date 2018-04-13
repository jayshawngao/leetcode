package algorithm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class People implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) {
		People people = new People();
		people.setAge(12);
		people.setName("AA");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("people.model"));
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("people.model"));) 
		{
			oos.writeObject(people);
			People p1 = null;
			p1 = (People) ois.readObject();
			System.out.println(p1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
