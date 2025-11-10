package Component_Design;

public class NameStorage {
	int id;
	String name;
	int marks;
	int capacity;
	public NameStorage() {
		
	}
	public NameStorage(int id,String name,int marks, int cap) {
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.capacity = cap;
	}
	String printing() {
		return "Name is - "+name+"\n Id is - "+id+" \n Marks obtained -"+marks+"\n Capacity -"+ capacity+"\n";
	}
}
