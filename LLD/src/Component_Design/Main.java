package Component_Design;

import java.util.List;
import java.util.*;
public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		 List<NameStorage> list = new ArrayList<>();
		 System.out.println("Enter number of Strudents ");
		 int n = scan.nextInt();
		 for(int i=0;i<n;i++) {
			 System.out.println("Enter id");
			 int id = scan.nextInt();
			 System.out.println("Enter name");
			 String name = scan.next();
			 System.out.println("Enter marks");
			 int marks = scan.nextInt();
			 System.out.println("Enter capacity");
			 int cap = scan.nextInt();
			 NameStorage lists = new NameStorage(id,name,marks,cap);
			 list.add(lists);
		 }
		NameStorage name = new NameStorage();
		for(NameStorage s : list) {
			System.out.print(s.printing());
		}
	}
}

