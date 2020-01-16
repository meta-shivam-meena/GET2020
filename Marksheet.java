package scf.assignment2;

import java.text.DecimalFormat;

/**
 * This class stores grades of students and has various methods to apply
 * on them. Grades are assumed to be between 0 and 100, both inclusive.
 * @author Shivam Kumar Meena
 * created on 16th January, 2020.
 */
public class Marksheet {
    
    /**
     * It stores grades of students.
     */
    private int[] grades;
    
    /**
     * It initializes the Marksheet object with given grades.
     * @param grades an array of student grades.
     */
    public Marksheet(int[] grades) {
        this.grades = grades;
    }
    
    /**
     * It calculates and returns average grade of students.
     * @return average grade of students.
     */
    public float getAverageGrade() {
        float sumOfGrades = 0.0f;
        float averageGrade;
        for (int i = 0; i < grades.length; i++) {
            sumOfGrades += grades[i];
        }
        averageGrade = sumOfGrades / (float) grades.length;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String result = decimalFormat.format(averageGrade);
        averageGrade = Float.parseFloat(result);
        return averageGrade;
    }
    
    /**
     * It returns the maximum grade obtained by a student.
     * @return maximum grade obtained by a student.
     */
    public int getMaximumGrade() {
        int maximumGrade = -1;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > maximumGrade) {
                maximumGrade = grades[i];
            }
        }
        return maximumGrade;
    }
    
    /**
     * It returns the minimum grade obtained by a student.
     * @return minimum grade obtained by a student.
     */
    public int getMinimumGrade() {
        int minimumGrade = 101;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < minimumGrade) {
                minimumGrade = grades[i];
            }
        }
        return minimumGrade;
    }
    
    /**
     * It returns the percentage of passed students
     * assuming passing marks as 40 or above.
     * @return percentage of passed students.
     */
    public float getPercentageOfStudentsPassed() {
        int numberOfStudentsPassed = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 40) {
                numberOfStudentsPassed++;
            }
        }
        float percentageOfStudentsPassed = 100 *
                numberOfStudentsPassed / (float) grades.length;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String result = decimalFormat.format(percentageOfStudentsPassed);
        percentageOfStudentsPassed = Float.parseFloat(result);
        return percentageOfStudentsPassed;
    }
}
