package by.epam.training.io.Task5;

import java.util.List;

public class Student {
    private String name;
    private List<Integer> grades;

    public Student(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public float calculateAverageGrade() {
        float total = 0;
        for (Integer grade : this.grades) {
                total = total + grade;
        }
        return total / this.grades.size();
    }
}
