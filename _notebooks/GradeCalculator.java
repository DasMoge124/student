import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        String grade = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Enter your midterm score (0-100): \n");
        int midtermScore = scanner.nextInt();
        System.out.print(midtermScore);

        System.out.print("\n Enter your final exam score (0-100): \n");
        int finalExamScore = scanner.nextInt();
        System.out.print(finalExamScore);

        System.out.print("\n Did you complete the homework (yes/no): \n");
        String homeworkComplete = scanner.next().toLowerCase();
        System.out.print(homeworkComplete);

        // write code here
        int total = midtermScore + finalExamScore;
        if (homeworkComplete == "no" || total < 70) {
            grade = "Fail";
        } else{
            grade = "Pass";
        }

        System.out.println("\n Your final grade is: " + grade);

        scanner.close();
    }
}