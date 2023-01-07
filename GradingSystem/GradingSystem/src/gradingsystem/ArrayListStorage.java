package gradingsystem;

import java.util.ArrayList;

public class ArrayListStorage
{
    public static void Storage(ArrayList <String> Storage)
    {
        //ARRAY For Score Input Display                               //Index No.
        Storage.add("Quiz 1               : ");                       //0
        Storage.add("Quiz 2               : ");                       //1
        Storage.add("Quiz 3               : ");                       //2
        Storage.add("Homework 1           : ");                       //3
        Storage.add("Activity 1           : ");                       //4
        Storage.add("Seatwork 1           : ");                       //5
        Storage.add("Performance Task     : ");                       //6
        Storage.add("Exam                 : ");                       //7
        Storage.add("\tNumber is not within the Total Score. Try Again");       //8
        Storage.add("\tYou have entered a non numeric field value. Try Again"); //9

        //ARRAY for displaying the result of Grade
        Storage.add("=======Your Grade======="                        //10
                +"\nQuiz                 : %.2f"
                +"\nSchool Activities    : %.2f"
                +"\nPerformance Task     : %.2f"
                +"\nExam                 : %.2f");

        //ARRAY for Student Information and Grades
        Storage.add("====================================="          //11
                +"\nStudent Name         : %s"
                +"\nStudent LRN          : %s"
                +"\nPre-Lim              : %.2f"
                +"\nMidterm              : %.2f"
                +"\nPre-Finals           : %.2f"
                +"\nFinals               : %.2f");

        //ARRAY for Remark
        Storage.add("1.00 Excellent");                                 //12
        Storage.add("1.25 Very Good");                                 //13
        Storage.add("1.50 Very Good");                                 //14
        Storage.add("1.75 Very Good");                                 //15
        Storage.add("2.00 Satisfactory");                              //16
        Storage.add("2.25 Satisfactory");                              //17
        Storage.add("2.50 Satisfactory");                              //18
        Storage.add("2.75 Fair");                                      //19
        Storage.add("3.00 Fair");                                      //20
        Storage.add("Failed");                                         //21

        Storage.add("=====Student Information====="          //22
                +"\nStudent Name         : %s"
                +"\nStudent LRN          : %s"
                +"\nPre-Lim              : %.2f"
                +"\nMidterm              : %.2f"
                +"\nPre-Finals           : %.2f"
                +"\nFinals               : %.2f"
                +"\nRemark               : %.2f - %s");
    }

    public static void Students(ArrayList <String> Students)
    {
        //Arraylist For Student's Information
        Students.add("Mark Christian Luna");     Students.add("296889"); //0-1
        Students.add("Railey Alcaraz");          Students.add("723495"); //2-3
        Students.add("Jonas Emil Bernabe");      Students.add("372924"); //4-5
        Students.add("Howell Palola");           Students.add("932746"); //6-7
    }

    public static void Teacher(ArrayList <String> Teacher)
    {
        //Arraylist For Teacher's Information
        Teacher.add("Paul Arevalo");            Teacher.add("paul123"); //0-1
        Teacher.add("Rose Ann Tecson");         Teacher.add("rose123"); //2-3
    }

    public static void Admin(ArrayList <String> Admin)
    {
        //Arraylist For Admin's Information
        Admin.add("admin");              Admin.add("admin123");      //0-1
        Admin.add("name");               Admin.add("name123");       //2-3
    }
}