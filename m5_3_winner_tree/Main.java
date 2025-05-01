package m5_3_winner_tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input
        String[] input = scanner.nextLine().split(" ");
        scanner.close();
        
        int[] scores = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            scores[i] = Integer.parseInt(input[i]);
        }
        
        // Find second minimum
        int secondMin = findSecondMinimum(scores);
        System.out.println(secondMin);
    }
    
    private static int findSecondMinimum(int[] scores) {
        if (scores.length < 2) return -1; // No second minimum possible
        
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        
        for (int score : scores) {
            if (score < min) {
                secondMin = min;
                min = score;
            } else if (score > min && score < secondMin) {
                secondMin = score;
            }
        }
        
        return (secondMin == Integer.MAX_VALUE) ? -1 : secondMin;
    }
}