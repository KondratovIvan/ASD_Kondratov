
public class Lab11 {

    public static void main(String[] args) {

        long[][] firstMatrix = new long[6][6];
        long firstSum = 0;
        long firstProduct = 1;

        for(int i = 0; i < 6; i++) {    
            for (int j = 0; j < 6; j++) {
                firstMatrix[i][j] = 2;
                System.out.print(2 + "  ");
                if (i > j) {
                    firstSum += 2;
                } else if (i < j) {
                    firstProduct *= 2;
                }
            }
            System.out.println();
        }

        System.out.println("Sum is " + firstSum);
        System.out.println("Product is " + firstProduct);

        long[][] secondMatrix = new long[8][8];
        long secondSum = 0;
        long secondProduct = 1;

        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                secondMatrix[i][j] = 2;
                System.out.print(2 + "  ");
                if (i > j) {
                    secondSum += 2;
                } else if (i < j) {
                    secondProduct *= 2;
                }
            }
            System.out.println();
        }

        System.out.println("Sum is " + secondSum);
        System.out.println("Product is " + secondProduct);
    }
}
