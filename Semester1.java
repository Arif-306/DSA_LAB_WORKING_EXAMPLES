
package com.mycompany.semester1;

// Ye line batati hai ke yeh code"com.mycompany.semester_2" package mein hai.//

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Yeh lines bata rahi hain ke hum kuch classes ko import kar rahe hain jo file handling aur list management ke liye kaam karengi//

class FileManager { // file manager ki class ha//
    private File file;

    public FileManager(String filename) {
        file = new File(filename);
    }
    // 'FileManager' class file operations manage karti hai Constructor file ka naam
    // leta hai aur file object banata hai//

    public void createFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Unable to create file");
            e.printStackTrace();
        }
    }
    // 'createFile'method naye file banane ki koshish karta hai.Agar file ban jati
    // hai,message print hota hai,warna error print hota hai java//

    public void writeToFile(String content) {
        try (FileWriter filewriter = new FileWriter(file, true)) {
            filewriter.write(content + "\n");
        } catch (IOException e) {
            System.out.println("Unable to write to file");
            e.printStackTrace();
        }
    }
    // 'writeToFile'method file mein content likhta hai.Agar likhne mein problem
    // aati hai,to error message print hota hai//

    public List<String> readFile() {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file");
            e.printStackTrace();
        }
        return lines;
    }
}
// 'readFile'method file se lines read karta hai aur unhe list mein add karta
// hai.Agar problem hoti hai to error message print hota hai//

class Quiz { // quiz ki class ha
    private List<String> questions;
    private int totalStudents;

    public Quiz(List<String> questions, int totalStudents) {
        this.questions = questions;
        this.totalStudents = totalStudents;
    } // 'Quiz'class quiz questions aur students ka data handle karti hai

    public void analyzeQuiz() {
        int correctAnswers = totalStudents * questions.size() / 2; // Assume 50% correct answers
        double averageScore = (double) correctAnswers / (totalStudents * questions.size()) * 100;
        double difficultyLevel = (double) correctAnswers / questions.size() * 100;
        // 'analyzeQuiz' method quiz ke results analyze karta hai,jaise ke correct
        // answers,average score,aur difficulties.

        System.out.println("Total Students: " + totalStudents);
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Average Score: " + averageScore + "%");
        System.out.println("Difficulty Level: " + difficultyLevel + "%");
    }
} // yeh saari line analysis ki hui lines ko print karengi

class Student { // student ki class
    private Scanner scanner = new Scanner(System.in);

    // 'student'class student login aur quiz attempt krne process manage karti hai
    public void login() {
        System.out.println("Enter student password: ");
        String password = scanner.nextLine();
        // 'login' method student se password mangti hai

        if (password.equals("schoolname")) {
            System.out.println("Login successfully as a Student");
            courseSelection();
        } else {
            System.out.println("Incorrect password. Try again.");
            login();
        }
    } // Agar password "schoolname" hai to student login successful hota hai,warna
      // phir se login karne ko kehta hai

    private void courseSelection() {
        System.out.println("COURSE OFFERED");
        System.out.println("1. Database Management System Theory (DBT-2001)");
        System.out.println("2. Database Management System Lab (DBL-2001)");
        System.out.println("3. Object Oriented Programming Theory (OOPT-2002)");
        System.out.println("4. Object Oriented Programming Lab (OOPL-2002)");
        System.out.println("5. Operating System Lab (OSL-2003)");
        System.out.println("6. Operating System Theory (OST-2003)");
        System.out.println("7. Software Design and Architecture (SDA-2004)");
        // 'courseSelection' method courses list karta hai jo student select kar sakta
        // ha

        System.out.println("Select a course:");
        int courseNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        System.out.println("You have selected course number " + courseNumber);

        FileManager fileManager = new FileManager("Semester_Project.txt");
        List<String> questions = fileManager.readFile();
        if (questions.isEmpty()) {
            System.out.println("No questions available for this course.");
            return;
        }
        Collections.shuffle(questions);

        int score = calculateMarks(questions);
        displayScore(score);
        // Student se course number select karwata hai then Selected course ka number
        // print karta hai.Questions file se read karta hai aur shuffle karta hai or phr
        // Score calculate karta hai aur display karwadeta ha

        // Record attendance
        FileManager attendanceFile = new FileManager("Attendance.txt");
        attendanceFile.createFile();
        attendanceFile.writeToFile("Attendance for course " + courseNumber + ":");
        attendanceFile.writeToFile("Present: " + getStudentName());
        attendanceFile.writeToFile("Score: " + score);
    } // Attendance file mein student ka attendance aur score record karta hai

    private int calculateMarks(List<String> questions) {
        int score = 0;

        for (String question : questions) {
            boolean result = askQuestion(question);
            if (result) {
                score++;
            }
        }
        return score;
    } // 'calculateMarks'method questions ke answers check karta hai aur score
      // increment karta hai agar answer sahi ho

    private boolean askQuestion(String question) {
        String[] parts = question.split(" Correct answer: ");
        if (parts.length < 2) {
            System.out.println("Invalid question format: " + question);
            return false; // Or handle the error
        }

        String questionText = parts[0];
        System.out.println(questionText);
        return true;
    }
    // 'askQuestion'method question ka text print karta hai aur copy karta hai ke
    // answer sahi diya gaya

    private void displayScore(int score) {
        System.out.println("Your score is: " + score);
    } // 'displayScore'method score print karta hai

    private String getStudentName() {
        System.out.println("Enter your name:");
        return scanner.nextLine();
    } // 'getStudentName'method student ka naam call krta hai
}

class Teacher { // teacher ki class ha
    private Scanner scanner = new Scanner(System.in);
    // 'Teacher' ki class teacher login aur question create krne ke process ko
    // manage karti hai

    public void login() {
        System.out.println("Enter teacher password: ");
        String password = scanner.nextLine();
        // 'login' method teacher se password mangti hai

        if (password.equals("teacher000")) {
            System.out.println("Login successfully as a Teacher");
            FileManager fileManager = new FileManager("Semester_Project.txt");
            fileManager.createFile();
            QuestionBank questionBank = new QuestionBank(fileManager);
            System.out.println("Enter the topic name:");
            String topicName = scanner.nextLine();
            questionBank.setTopicName(topicName);
            questionBank.displayOptions();
        } else {
            System.out.println("Incorrect password. Please try again.");
            login();
        }
    }
} // Agar password "teacher000" hai to teacher login successfull hoga aur
  // questions add karne ke options dikhayega

class QuestionBank { // QuestionBank ki class
    private Scanner scanner = new Scanner(System.in);
    private FileManager fileManager;
    private String topicName;

    public QuestionBank(FileManager fileManager) {
        this.fileManager = fileManager;
    } // 'QuestionBank'class questions add karne ka kaam karti hai

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    } // 'setTopicName'method topic name set karta hai

    public void displayOptions() {
        System.out.println("Enter number: ");
        System.out.println("1 for MCQs  2 for True and False  3 for Subjective");
        int number = scanner.nextInt();
        scanner.nextLine();

        switch (number) {
            case 1:
                addMCQs();
                break;
            case 2:
                addTrueFalse();
                break;
            case 3:
                addSubjective();
                break;
            default:
                System.out.println("Invalid option.");
                displayOptions();
                break;
        }
    } // 'displayOptions' method question type ke options dikhayega or teacher se
      // choice leta ha

    private void addMCQs() {
        System.out.println("Enter up to 10 MCQ questions:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter question " + (i + 1) + ":");
            String question = scanner.nextLine();
            System.out.println("Enter options (A, B, C, D):");
            String options = scanner.nextLine();
            System.out.println("Enter correct answer:");
            String answer = scanner.nextLine();
            fileManager
                    .writeToFile(topicName + ": " + question + " Options: " + options + " Correct answer: " + answer);
            System.out.println("Question " + (i + 1) + " added successfully.");
        }
    }

    private void addTrueFalse() {
        System.out.println("Enter up to 10 True or False questions:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter question " + (i + 1) + ":");
            String question = scanner.nextLine();
            System.out.println("Enter true or false:");
            String answer = scanner.nextLine();
            fileManager.writeToFile(topicName + ": " + question + " Answer: " + answer);
            System.out.println("Question " + (i + 1) + " added successfully.");
        }
    }

    private void addSubjective() {
        System.out.println("Enter up to 10 Subjective questions:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter question " + (i + 1) + ":");
            String question = scanner.nextLine();
            fileManager.writeToFile(topicName + ": " + question);
            System.out.println("Question " + (i + 1) + " added successfully.");
        }
    }
} // 'addMCQs','addTrueFalse','addSubjective' yeh teeno methods questions ko addd
  // krne ke liye use hue ha

public class Semester1 { // main class
    public static void main(String[] args) {
        System.out.println("Hint: For Student: schoolname, For Teacher: teacher000");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter S if you are a student. Enter T if you are a teacher.");
        String role = scanner.nextLine().toUpperCase();

        if (role.equals("S")) {
            Student student = new Student();
            student.login();
        } else if (role.equals("T")) {
            Teacher teacher = new Teacher();
            teacher.login();
        } else {
            System.out.println("Invalid input. Exiting.");
        }

    }
} // 'Semester_2' main class application ko run karti hai. User se role (student
  // ya teacher) mangti hai aur accordingly 'Student' ya 'Teacher' class ka login
  // method call karti hai Agar input invalid ho to program exit hojayega
