import java.util.*;

public class Lab3dva {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ABITURIENT> ABITUR;

    public static void main(String[] args) {
        createMenu();
    }

    public static void createMenu() {
        while(true) {
            System.out.println("1 Создати масив");
            System.out.println("2 Сортування");
            System.out.println("3 Студенти с балом нижче прохідного");
            System.out.println("4 Вихід");
            if (!scanner.hasNextInt()) {
                System.out.println("Помилка");
                scanner.next();
                createMenu();
            }
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAbiturArray();
                    break;
                case 2:
                    sortArray();
                    break;
                case 3:
                    showAbiturs();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private static void createAbiturArray() {
        System.out.println("Введіть кількість абітурієнтів ");
        int size = scanner.nextInt();
        ABITUR = new ArrayList<ABITURIENT>();

        System.out.println("Введіть інформацію про абітурієнта (прізвище, ініціали, стать, спеціалізацію, результати іспитів)");

        for(int i = 0; i < size; i++) {
            System.out.println("Абітурієнт номер " +i);
            String name = scanner.next();
            char firstCredit = scanner.next().charAt(0);
            char secondCredit = scanner.next().charAt(0);
            String gender = scanner.next();
            String specialization = scanner.next();
            double firstResult = scanner.nextInt();
            double secondResult = scanner.nextInt();
            double thirdResult = scanner.nextInt();
            double[] results = {firstResult, secondResult, thirdResult};

            ABITURIENT currentABITURIENT = new ABITURIENT(name,firstCredit,secondCredit, gender, specialization, results);
            ABITUR.add(currentABITURIENT);
        }
        createMenu();

    }
    private static void showAbiturs() {
        System.out.println("Введіть прохідний бал");
        int threshold = scanner.nextInt();
        boolean gotOne = false;
        System.out.println("Цей абітурієнт не проходить");
        for(int i = 0; i < ABITUR.size(); i++) {
            if(ABITUR.get(i).getAverage()<threshold) {
                gotOne = true;
                System.out.println(ABITUR.get(i).name + " " + ABITUR.get(i).spec + " " + ABITUR.get(i).getAverage());
            }
        }
        if(!gotOne) {
            System.out.println("Всі набрали прохідний бал");
        }
    }

    private static void sortArray() {
        Collections.sort(ABITUR, new Comparator<ABITURIENT>() {
            public int compare(ABITURIENT left, ABITURIENT right)  {
                return (int)(left.getAverage() - right.getAverage()); 
            }
        });
        for(int i = 0; i < ABITUR.size(); i++) {
            System.out.println(ABITUR.get(i).getAverage());
        }
    }
    
}

class ABITURIENT {
    String name;
    String gender;
    String spec;
    double[] exam = new double[3];

    public double getAverage() {
        return ((exam[0]+exam[1]+exam[2])/3);
    }

    ABITURIENT(String name, char firstCredits, char secondsCredits, String gender, String specialization, double[] results) {
        this.name = name+firstCredits+secondsCredits;
        this.gender = gender;
        this.spec = specialization;
        this.exam = results;
    }
}


