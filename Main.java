import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AVLTree tree = new AVLTree();
        ArrayList<Integer> nums = new ArrayList<>();
        File file = new File("src/file.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            nums.add(number);
        }
        for (int key : nums) {
            double startTime = System.nanoTime();
            tree.insert(tree.getRoot(), key);
            double endTime = System.nanoTime();
 //           System.out.println((int)(endTime - startTime));
        }

        for (int j = 1; j < 100; j ++) {
            double startTime1 = System.nanoTime();
            tree.find(nums.get(j));
            double endTime1 = System.nanoTime();
//            System.out.println((int)(endTime1 - startTime1));
        }

        for (int i = 1; i < 1000; i++) {
            double startTime2 = System.nanoTime();
            tree.delete(tree.getRoot(), nums.get(i));
            double endTime2 = System.nanoTime();
            System.out.println((int) (endTime2 - startTime2));
        }
    }
}