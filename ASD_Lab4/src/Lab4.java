import java.util.*;

public class Lab4 {
	 public static void main(String[] args) {
//Task 1 
		 ArrayList<Object> people = new ArrayList<Object>();
	        
	        people.add(0, "Tom");
	        people.add(1, "male");
	        people.add(2, "architector");
	        people.add(3, 180);
	        people.add("Jenny");
	        people.add("female");
	        people.add(195);
	        people.add("designer");
	        people.add("Den");
	        people.add("male");
	        people.add(160);
	        people.add("teacher");
	        
	        people.remove("Den");
	        people.remove("teacher");
	          
	        if(people.contains("Tom")){       
	            System.out.println("Том на місці");
	        }
	        else {
	        	System.out.println("Тома на місці немає");
	        }
  
	        Object[] peopleArray = people.toArray();
	        for(Object person : peopleArray){
	          
	            System.out.println(person);
	        }
//Task 2	
	        
	        ArrayList<String> FirstTeam = new ArrayList<String>();
	        ArrayList<String> SecondTeam = new ArrayList<String>();
	        int n;
	        int m;
	        int x;
	        int y;
	        FirstTeam.add(0,"error");
	        SecondTeam.add(0,"error");
	        Scanner scan = new Scanner(System.in);
	        while(true) {
	        System.out.println("1 Записати прізвища спортсменів першої команди");
	        System.out.println("2 Записати прізвища спортсменів другої команди");
	        System.out.println("3 Введіть n для вибору кожного n-ного гравця з першої команди");
	        System.out.println("4 Введіть m для вибору кожного m-ного гравця з першої команди");
	        
	        int choice=scan.nextInt();
	        switch(choice) {	        
			 case 1:
				 System.out.println("Введіть прізвища гравців першої команди");
				 String surname1=scan.next();
				 FirstTeam.add(1,surname1);
				 String surname2=scan.next();
				 FirstTeam.add(2,surname2);
				 String surname3=scan.next();
				 FirstTeam.add(3,surname3);
				 String surname4=scan.next();
				 FirstTeam.add(4,surname4);
				 String surname5=scan.next();
				 FirstTeam.add(5,surname5);
				 String surname6=scan.next();
				 FirstTeam.add(6,surname6);
				 String surname7=scan.next();
				 FirstTeam.add(7,surname7);
				 String surname8=scan.next();
				 FirstTeam.add(8,surname8);
				 String surname9=scan.next();
				 FirstTeam.add(9,surname9);
				 String surname10=scan.next();
				 FirstTeam.add(10,surname10);
				 break;
				 
			 case 2:
				 System.out.println("Введіть прізвища гравців другої команди");
				 String surname11=scan.next();
				 SecondTeam.add(1,surname11);
				 String surname12=scan.next();
				 SecondTeam.add(2,surname12);
				 String surname13=scan.next();
				 SecondTeam.add(3,surname13);
				 String surname14=scan.next();
				 SecondTeam.add(4,surname14);
				 String surname15=scan.next();
				 SecondTeam.add(5,surname15);
				 String surname16=scan.next();
				 SecondTeam.add(6,surname16);
				 String surname17=scan.next();
				 SecondTeam.add(7,surname17);
				 String surname18=scan.next();
				 SecondTeam.add(8,surname18);
				 String surname19=scan.next();
				 SecondTeam.add(9,surname19);
				 String surname20=scan.next();
				 SecondTeam.add(10,surname20);
				 break;
				 
			 case 3:
				 System.out.println("Введіть n два рази");
				 x=scan.nextInt();
				 for(n=scan.nextInt();n<11;n=n+x) {
					 System.out.println(FirstTeam.get(n));
				 }
				
				 break;
			 case 4:
				System.out.println("Введіть m два рази");
				y=scan.nextInt();
				for( m=scan.nextInt();m<11;m=m+y) {
				 System.out.println(SecondTeam.get(m));
				}
				 break;
			 	}
	        }
	 }
}
//a b c d e f g h i j
//k l m n o p q r s t