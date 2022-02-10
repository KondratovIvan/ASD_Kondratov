import java.util.Scanner;


public class Task1{
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        System.out.println("1. Задача про автомобілі");
        System.out.println("2. Обчислити значення y");
        System.out.println("3. Чи може кінь за один хід перейти на вказану клітину шахової дошки");
        System.out.print("Ваш вибір:");
        int choice=sc.nextInt();
        if (choice < 0 || choice >3) {
        	System.out.println("Помилка");
        }
        switch (choice) {
        	
        	case 1 -> first();
        	case 2 -> second();
        	case 3 -> third();
        }

	}

	static void first() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Введіть швидкість першого автомобіля(км/год)");
		int firstAutoSp=sc.nextInt();
		System.out.println("Введіть швидкість другого автомобіля(км/год)");
		int SecondAutoSp=sc.nextInt();
		System.out.println("Введіть початкову відстань(км)");
		int distance=sc.nextInt();
		System.out.println("Введіть час руху автомобілів(год)");
		int time=sc.nextInt();
		
		
		
		int generalSp=firstAutoSp+SecondAutoSp;
		int fullDistance=(generalSp*time)+distance;
		System.out.println("Відстань між автомобілями через"+time+"год="+fullDistance+"км");
	}
	static void second() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Введіть a");
		int a=sc.nextInt();
		System.out.println("Введіть x");
		int x=sc.nextInt();
		double cosnumber=a*x;
		double y=1/(1.1+Math.pow(Math.cos(cosnumber), 2));
		System.out.println("y="+y);
	}
	static void third() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Введіть цифру клітинки 1");
		int number1=sc.nextInt();
		System.out.println("Введіть номер букви клітинки 1 починаючи від А(А=1; B=2..) ");
		int letter1=sc.nextInt();
		System.out.println("Введіть цифру клітинки 2");
		int number2=sc.nextInt();
		System.out.println("Введіть номер букви клітинки 2 починаючи від А(А=1; B=2..) ");
		int letter2=sc.nextInt();
		boolean firstvar=((number1==number2+2)&&(letter1==letter2+1));
		boolean secondvar=((number1==number2+1)&&(letter1==letter2+2));
		boolean thirdvar=((number1==number2-1)&&(letter1==letter2+2));
		boolean fourthvar=((number1==number2-2)&&(letter1==letter2+1));
		boolean fifthvar=((number1==number2-1)&&(letter1==letter2-2));
		boolean sixthvar=((number1==number2-2)&&(letter1==letter2-1));
		boolean seventhvar=((number1==number2+1)&&(letter1==letter2-2));
		boolean eighthvar=((number1==number2+2)&&(letter1==letter2-1));
		
		
		
		if((firstvar==true)||(secondvar==true)||(thirdvar==true)||(fourthvar==true)||(fifthvar==true)||(sixthvar==true)||(seventhvar==true)||(eighthvar==true)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}
}
	