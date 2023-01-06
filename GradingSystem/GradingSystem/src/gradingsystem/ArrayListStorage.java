package gradingsystem;

import java.util.ArrayList;

public class ArrayListStorage
{
    public static void Storage(ArrayList <String> Storage)
    {
        //ARRAY STORAGE FOR ProgramStart()                           //Index.
        Storage.add("===WELCOME TO STI MEYCAUAYAN===");               //0
        Storage.add("Press \"ENTER\" to proceed...");                 //1

        //ARRAY STORAGE FOR InfoInput()
        Storage.add("Enter your Student Information");                //2
        Storage.add("Student Name         : ");                       //3
        Storage.add("Student LRN          : ");                       //4
        Storage.add("Name or LRN is Wrong");                          //5

        //ARRAY STORAGE FOR NAMES AND LRN
        Storage.add("Mark Christian Luna");     Storage.add("296889"); //6-7
        Storage.add("Railey Alcaraz");          Storage.add("723495"); //8-9
        Storage.add("Jonas Emil Bernabe");      Storage.add("372924"); //10-11
        Storage.add("Howell Palola");           Storage.add("932746"); //12-13
        Storage.add("Carl Verano");             Storage.add("527178"); //14-15
        Storage.add("Aidan Rivero");            Storage.add("647405"); //16-17
        Storage.add("Dominic Espino");          Storage.add("628429"); //18-19
        Storage.add("Jasper Malanay");          Storage.add("966925"); //20-21
        Storage.add("Jericho Batalla");         Storage.add("922830"); //22-23
        Storage.add("Jericho Casupanan");       Storage.add("496567"); //24-25
        Storage.add("John Edric Del Poso");     Storage.add("310154"); //25-27
        Storage.add("John Kenneth Sebastian");  Storage.add("666777"); //26-29
        Storage.add("John Louie Dollente");     Storage.add("385088"); //30-31
        Storage.add("Khen Narag");              Storage.add("630298"); //32-33
        Storage.add("Karissa Camille De Asis"); Storage.add("833005"); //34-35
        Storage.add("Paul Andrew Aquino");      Storage.add("506868"); //36-37
        Storage.add("Paul Jewel Mariano");      Storage.add("949643"); //38-39
        Storage.add("Zerkiela Argarin");        Storage.add("729601"); //40-41
        Storage.add("Frank Rafael Sia");        Storage.add("943366"); //42-43
        Storage.add("Angelo Pilares");          Storage.add("869770"); //44-45

        //ARRAY STORAGE For TitleDescription
        Storage.add("\n>>>>>>PRE-LIM<<<<<<");                         //46
        Storage.add("\n>>>>>>MIDTERM<<<<<<");                         //47
        Storage.add("\n>>>>>>PRE-FINALS<<<<<<");                      //48
        Storage.add("\n>>>>>>FINALS<<<<<<");                          //49

        //ARRAY STORAGE For Description
        Storage.add("Quiz 1               : ");                       //50
        Storage.add("Quiz 2               : ");                       //51
        Storage.add("Quiz 3               : ");                       //52
        Storage.add("Homework 1           : ");                       //53
        Storage.add("Activity 1           : ");                       //54
        Storage.add("Seatwork 1           : ");                       //55
        Storage.add("Performance Task     : ");                       //56
        Storage.add("Exam                 : ");                       //57

        //ARRAY STORAGE For Display
        Storage.add("=======Your Grade=======");                      //58
        Storage.add("Quiz                 : %.2f");                   //59
        Storage.add("\nSchool Activities    : %.2f");                 //60
        Storage.add("\nPerformance Task     : %.2f");                 //61
        Storage.add("\nExam                 : %.2f");                 //62
        Storage.add("Pre-Lim              : %.2f");                   //63
        Storage.add("\nMidterm              : %.2f");                 //64
        Storage.add("\nPre-Finals           : %.2f");                 //65
        Storage.add("\nFinals               : %.2f");                 //66

        //ARRAY STORAGE FOR OTHERS
        Storage.add("____________________________");                  //67
        Storage.add("====Enter your Score====");                      //68
        Storage.add("\tNumber is either negative or over the Total Score. Try Again");   //69
        Storage.add(" ");                                             //70

        //ARRAY STORAGE FOR USER ACCOUNT
        //Admin
        Storage.add("admin");              Storage.add("admin123");      //71-72
        Storage.add("Paul Arevalo");       Storage.add("123456");        //73-74
        //User
        Storage.add("Rose Ann Tecson");    Storage.add("111678");      //75-76
        Storage.add("Paul Arevalo");       Storage.add("777321");      //77-78

        //ARRAY STORAGE FOR REMARK
        Storage.add("1.00 Excellent");                                 //79
        Storage.add("1.25 Very Good");                                 //80
        Storage.add("1.50 Very Good");                                 //81
        Storage.add("1.75 Very Good");                                 //82
        Storage.add("2.00 Satisfactory");                              //83
        Storage.add("2.25 Satisfactory");                              //84
        Storage.add("2.50 Satisfactory");                              //85
        Storage.add("2.75 Fair");                                      //86
        Storage.add("3.00 Fair");                                      //87
        Storage.add("Failed");                                         //88
        Storage.add("\nRemark               : %.2f - %s");             //89
    }
}
