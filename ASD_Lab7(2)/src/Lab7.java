import java.util.ArrayList;
import java.util.Collections;

public class Lab7 {
    static double sum = 0;

    static double average(Tree tree) {
        sum = 0;
        ArrayList<Double> array = tree.all();
        int size = array.size();
        array.forEach(number -> sum += number);
        return sum / size;
    }
    static void addAverageNode(Tree tree) {
        double average = average(tree);
        tree.add(average);
    }

    public static void main(String[] args) {
        Tree mainTree = new Tree();
        createTreeNodes(mainTree);
        System.out.println("Середнє арифметичне " + average(mainTree));
        addAverageNode(mainTree);
        System.out.println("Всі числа:");
        mainTree.all().forEach(number -> System.out.println(number));

        ArrayList<Double> results = new ArrayList<Double>(mainTree.search(400, 500));
        
        Collections.sort(results);
        System.out.println("Сортовані знайдені числа");
        results.forEach(number -> System.out.println(number));

    }

    static void createTreeNodes(Tree tree) {
        tree.add(456);
        tree.add(124);
        tree.add(786);
        tree.add(435);
        tree.add(788);
        tree.add(444);
        tree.add(565);
        tree.add(127);
        tree.add(458);
        tree.add(322);
        tree.add(411);
        tree.add(531);
        tree.add(400);
        tree.add(546);
        tree.add(410);
    }
}
class Node {
    public Node left;
    public Node right;
    public double value;

    public Node(double value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class Tree {
    protected Node root;
    public void add(double newValue) {
        root = addRecursion(root, newValue);
    }
    private Node addRecursion(Node currentNode, double newValue) {
        if (currentNode == null) {
            return new Node(newValue);
        }
        if (newValue < currentNode.value) {
            currentNode.left = addRecursion(currentNode.left, newValue);
            addRecursion(currentNode.left, newValue);
        } else if (newValue > currentNode.value) {
            currentNode.right = addRecursion(currentNode.right, newValue);
        } else {
            return currentNode;
        }
        return  currentNode;
    }
    private ArrayList<Double> allRecursive(Node currentNode) {
        ArrayList<Double> array = new ArrayList<Double>();
        if (currentNode == null) {return array;}
        array.addAll(allRecursive(currentNode.left));
        array.addAll(allRecursive(currentNode.right));
        array.add(currentNode.value);

        return array;
    }

    public ArrayList<Double> all() {
        return(allRecursive(root));
    }

    private ArrayList<Double> searchRecursive(Node currentNode, double minValue, double maxValue) {
        ArrayList<Double> array = new ArrayList<Double>();
        if (currentNode == null) {return array;}
        if (currentNode.value > maxValue) {
            array.addAll(searchRecursive(currentNode.left, minValue, maxValue));
        } else if (currentNode.value < minValue)  {
            array.addAll(searchRecursive(currentNode.right, minValue, maxValue));
        } else {
            array.add(currentNode.value);
            array.addAll(searchRecursive(currentNode.right, minValue, maxValue));
            array.addAll(searchRecursive(currentNode.left, minValue, maxValue));
        }
        return array;
    }

    public ArrayList<Double> search(double minValue, double maxValue) {
        if (minValue >= maxValue) {
            System.out.println("Мінімальне значення повинно бути меньше ніж максимальне!");
            return null;
        }
        return(searchRecursive(root, minValue, maxValue));
    }
}