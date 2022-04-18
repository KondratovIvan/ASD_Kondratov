import java.util.LinkedList;
import java.util.Scanner;

public class Lab5 {

    static  Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        System.out.println("Введіть елементи двохзв'язного списку:");
        while(in.hasNextInt()){
            numbers.add(in.nextInt());
        }

        System.out.println("Старий список");
        for(var element1 : numbers){
            System.out.println(element1); 
        }

        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 != 0){
                numbers.add(i,numbers.get(i));
                i++;
            }
        }
        System.out.println("Новий список");
        for(var element2 : numbers){
            System.out.println(element2);
        }

        System.out.println("Покажчик на перший елемент");
        System.out.print(numbers.getFirst());
        
    }
}
