import java.util.*;

public class Lab6 {
	public static void main(String[] args){
		PriorityQueue<Double> cherga = new PriorityQueue<Double>();
		 cherga.add(-2.2);
		 cherga.add(2.3);
		 cherga.add(2.2);
		 cherga.add(5.1);
		 cherga.add(6.7);
		 System.out.println("Перша черга");
		 
		 for(double one : cherga) {
	            System.out.println(one);
	        }
		 
		 cherga.remove();
		 cherga.remove();
		 cherga.remove();
		 cherga.add(1.9);
		 System.out.println("Друга черга");
		 
		 for(double two : cherga) {
	            System.out.println(two);
	        }
		 
		 
	}
}
