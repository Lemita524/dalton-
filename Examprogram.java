
import java.util.Scanner;

public class Examprogram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] courseworkScores = {25, 30, 28, 27, 32};  
        int finalExamScore = 35; 
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");

            System.out.print("Enter your choice (1-3): ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    viewCourseworkResults(courseworkScores);
                    break;
                case 2:
                    viewExamResults(finalExamScore);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (option == 1 || option == 2) {
                int numAssessments = countCourseworkAssessments(courseworkScores);
                System.out.println("Number of coursework assessments done in DIT409 unit: " + numAssessments);

                if (!hasDoneTwoThirdsOfCoursework(numAssessments)) {
                    System.out.println("Student has not done 2/3 of coursework. Required to repeat the course.\n");
                } else {
                    System.out.println("Student has done 2/3 of coursework.\n");
                }
            }

        } while (option != 3);

        input.close();
    }

    public static void viewCourseworkResults(int[] courseworkScores) {
        System.out.println("\nCoursework Results:");
        for (int i = 0; i < courseworkScores.length; i++) {
            System.out.println("Assessment " + (i + 1) + ": " + courseworkScores[i]);
        }
        int totalCourseworkScore = 0;
        for (int score : courseworkScores) {
            totalCourseworkScore += score;
        }
        System.out.println("Total Coursework Score: " + totalCourseworkScore + "\n");
    }

    public static void viewExamResults(int finalExamScore) {
        System.out.println("\nFinal Exam Result: " + finalExamScore + "\n");
    }

    public static int countCourseworkAssessments(int[] courseworkScores) {
        int numAssessments = 0;
        for (int score : courseworkScores) {
            numAssessments++;
        }
        return numAssessments;
    }

    public static boolean hasDoneTwoThirdsOfCoursework(int numAssessments) {
        int requiredAssessments = 5;  
        return numAssessments >= (2.0 / 3.0) * requiredAssessments;
    }

    public static double calculateCourseworkPercentage(int[] courseworkScores) {
        int totalScore = 0;
        for (int score : courseworkScores) {
            totalScore += score;
        }
        return (totalScore / 250.0) * 50; 
    }

    public static double calculateFinalExamPercentage(int finalExamScore) {
        return (finalExamScore / 50.0) * 50;  
    }

    public static double calculateTotalScore(int[] courseworkScores, int finalExamScore) {
        double courseworkPercentage = calculateCourseworkPercentage(courseworkScores);
        double finalExamPercentage = calculateFinalExamPercentage(finalExamScore);
        return courseworkPercentage + finalExamPercentage;
    }
}