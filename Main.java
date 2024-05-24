import java.io.*;
import java.util.ArrayList;
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
            double startTimeIns = System.nanoTime();
            tree.insert(tree.getRoot(), key);
            double endTimeIns = System.nanoTime();
//            System.out.println((int)(endTimeIns - startTimeIns));
        }

        for (int j = 1; j < 100; j ++) {
            double startTimeFind = System.nanoTime();
            tree.find(nums.get(j));
            double endTimeFind = System.nanoTime();
//            System.out.println((int)(endTimeFind - startTimeFind));
        }

        for (int i = 1; i < 1000; i++) {
            double startTimeDel = System.nanoTime();
            tree.delete(tree.getRoot(), nums.get(i));
            double endTimeDel = System.nanoTime();
//            System.out.println((int) (endTimeDel - startTimeDel));
        }
    }
}
