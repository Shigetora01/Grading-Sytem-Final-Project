package gradingsystem;

import static gradingsystem.ArrayListStorage.Admin;
import static gradingsystem.ArrayListStorage.Storage;
import static gradingsystem.ArrayListStorage.Students;
import static gradingsystem.ArrayListStorage.Teacher;
import java.util.*;

public class GradingSystem
{
    //These are the data types for the variables
    ArrayList<String> NewTeacherUser    = new ArrayList<>();
    ArrayList<String> NewTeacherPass    = new ArrayList<>();
    ArrayList<String> NewStudentName    = new ArrayList<>();
    ArrayList<String> NewStudentPass    = new ArrayList<>();
    ArrayList<String> storeRemark       = new ArrayList<>();
    ArrayList<Double> storeSemGrade     = new ArrayList<>();
    ArrayList<Double> storeGrade        = new ArrayList<>();
    ArrayList<String> nameOfStd         = new ArrayList<>();
    ArrayList<String> lrnOfStd          = new ArrayList<>();
    Scanner Write   = new Scanner(System.in);
    String stdscan, lrnscan, entry, adcode,user, pass, lrnConfirm;
    double q1, q2, q3, ac, hw, sw, pt, ex;
    double qGrade, schGrade, ptGrade, exGrade;
    double prelimGrade, midtermGrade, prefinalsGrade, finalsGrade;
    double term1,term2,term3,term4,semGrade;
    int select, std;

    public static void main(String[] args)
    {
        //The Program Starts Here...
        GradingSystem START=new GradingSystem();
        START.ProgramStart();
    }

    //The system will require you to press the enter button in order to redirect in UserLogin method. "Line 64"
    public void ProgramStart()
    {
        //This new ArrayList is used to call the Arraylist from the other java class
        ArrayList<String> callObject=new ArrayList<>();
        Storage(callObject);

        //This is the Introduction to the program
        System.out.println("===WELCOME TO STI MEYCAUAYAN===");
        System.out.println("Press \"ENTER\" to proceed...");

        //This is the loop that require you to press the entey key button
        while(true)
        {
            entry = Write.nextLine();
            //If you press the wrong button this will be shown
            if(!"".equals(entry))
            {
                System.out.println("Enter key not pressed");
            }
            //If you press the enter key. It will go to next method. "Line 64"
            else
            {
                userlogin(); break;
            }
        }
    }

    //The user will input the useraneme and the password and this method will determine if the input is admin account or user account
    public void userlogin()
    {
        //This new ArrayList is used to call the Arraylist from the other java class
        ArrayList<String> AdminInfo = new ArrayList<>();
        Admin(AdminInfo);
        ArrayList<String> TeacherInfo = new ArrayList<>();
        Teacher(TeacherInfo);

        //The User only have 3 tries to enter a username and admin. It will end the program after 3 tries.
        int trials = 1;
        while(trials <=3)
        {
            System.out.print("Log-In\nUsername: ");
            user = Write.nextLine();
            System.out.print("Password: ");
            pass = Write.nextLine();
            //If the account is an admin account, the system will redirect to the AdminInput method "Line 997"
            if (AdminInfo.contains(user) && AdminInfo.contains(pass))
            {
                System.out.println(" ");
                AdminInput();
                break;
            }
            //If the user input is a Teacher's account. The system will direct to the TeacherSelection method. "Line 100"
            else if (TeacherInfo.contains(user) && TeacherInfo.contains(pass) ||
                    NewTeacherUser.contains(user) && NewTeacherPass.contains(pass))
            {
                TeacherSelection();
                break;
            }
            //If user got the wrong username or password. This will be shown and loop back to try again
            else
            {
                System.out.println("\tWrong Username/Password!");
            }
            trials++;
        }
    }

    //If the Login is a Teacher's account. It will direct here and select from the following choices.
    public void TeacherSelection()
    {
        //This new ArrayList is used to call the Arraylist in the new java class
        ArrayList<String> info = new ArrayList<>();
        Storage(info);

        //This is the Display of SelectionUser Method
        System.out.println("=====================================");
        System.out.println(">>>WELCOME TEACHER<<<");
        System.out.print("Enter a number from the following: "
                + "\n[1]Add a Student Grade"
                + "\n[2]Display Stored Grades"
                + "\n[3]Go back to Log-In"
                + "\n[4]Exit the Program"
                + "\n: ");
        select = Write.nextInt();

        //This is the process when the user enter a number from the following
        switch (select)
        {
            case 1:
                Write.nextLine();
                TeacherInputGrade();
                break;
            case 2:
                DisplayStoredGrade();
                break;
            case 3:
                Write.nextLine();
                userlogin();
                break;
            case 4:
                System.out.println("END");
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

    //This is the method for the Display of the Stored Grades
    public void DisplayStoredGrade()
    {
        //This new ArrayList is used to call the Arraylist from the other java class
        ArrayList<String> Display = new ArrayList<>();
        Storage(Display);

        System.out.println("=====================================");
        //If there's no stored grades then this will be shown.
        if (nameOfStd.isEmpty())
        {
            System.out.println("No Stored Grades");
        }
        //This is for each index of nameOfStudent it will print the ArrayList using the variable storedstd.
        //It uses lambda expression "->"
        nameOfStd.forEach((storedstd) -> {System.out.println(storedstd);});

        System.out.print("Select Stored Grades from the index: "
                + "\n[0] Go back to Selection"
                + "\n: ");
        std = Write.nextInt();

        //Try catch to prevent Exeptional Error.
        try
        {
            //Call names for selection of student.
            switch (std)
            {
                case 0:
                    TeacherSelection();
                    break;
                case 1:
                    System.out.printf(Display.get(22),nameOfStd.get(0),lrnOfStd.get(0)
                            ,storeGrade.get(0),storeGrade.get(1),storeGrade.get(2),storeGrade.get(3)
                            ,storeSemGrade.get(0), storeRemark.get(0));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 2:
                    System.out.printf(Display.get(22),nameOfStd.get(1),lrnOfStd.get(1)
                            ,storeGrade.get(4),storeGrade.get(5),storeGrade.get(6),storeGrade.get(7)
                            ,storeSemGrade.get(1), storeRemark.get(1));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 3:
                    System.out.printf(Display.get(22),nameOfStd.get(2),lrnOfStd.get(2)
                            ,storeGrade.get(8),storeGrade.get(9),storeGrade.get(10),storeGrade.get(11)
                            ,storeSemGrade.get(2), storeRemark.get(2));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 4:
                    System.out.printf(Display.get(22),nameOfStd.get(3),lrnOfStd.get(3)
                            ,storeGrade.get(12),storeGrade.get(13),storeGrade.get(14),storeGrade.get(15)
                            ,storeSemGrade.get(3), storeRemark.get(3));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 5:
                    System.out.printf(Display.get(22),nameOfStd.get(4),lrnOfStd.get(4)
                            ,storeGrade.get(16),storeGrade.get(17),storeGrade.get(18),storeGrade.get(19)
                            ,storeSemGrade.get(4), storeRemark.get(4));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 6:
                    System.out.printf(Display.get(22),nameOfStd.get(5),lrnOfStd.get(5)
                            ,storeGrade.get(20),storeGrade.get(21),storeGrade.get(22),storeGrade.get(23)
                            ,storeSemGrade.get(5), storeRemark.get(5));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 7:
                    System.out.printf(Display.get(22),nameOfStd.get(6),lrnOfStd.get(6)
                            ,storeGrade.get(24),storeGrade.get(25),storeGrade.get(26),storeGrade.get(27)
                            ,storeSemGrade.get(6), storeRemark.get(6));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 8:
                    System.out.printf(Display.get(22),nameOfStd.get(7),lrnOfStd.get(7)
                            ,storeGrade.get(28),storeGrade.get(29),storeGrade.get(30),storeGrade.get(31)
                            ,storeSemGrade.get(7), storeRemark.get(7));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 9:
                    System.out.printf(Display.get(22),nameOfStd.get(8),lrnOfStd.get(8)
                            ,storeGrade.get(32),storeGrade.get(33),storeGrade.get(34),storeGrade.get(35)
                            ,storeSemGrade.get(8), storeRemark.get(8));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                case 10:
                    System.out.printf(Display.get(22),nameOfStd.get(9),lrnOfStd.get(9)
                            ,storeGrade.get(36),storeGrade.get(37),storeGrade.get(38),storeGrade.get(39)
                            ,storeSemGrade.get(9), storeRemark.get(9));
                    System.out.println("");
                    DisplayStoredGrade();
                    break;
                default:
                    System.out.println("Invalid Input. Program Ends");
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid Input");
            DisplayStoredGrade();
        }
    }

    //This is the method where the teacher input the Student's Information and Grades
    public void TeacherInputGrade()
    {
        //This new ArrayList is used to call the Arraylist in the new java class
        ArrayList<String> Display=new ArrayList<>();
        Storage(Display);
        ArrayList<String> StudentInfo=new ArrayList<>();
        Students(StudentInfo);

        //Calling the introduction of the method
        System.out.println("======================");
        System.out.println("Enter Student Information");

        //The Teacher will input the name and the Student ID.
        while(true)
        {
            System.out.print("Student Name         : ");
            stdscan=Write.nextLine();
            System.out.print("Student LRN          : ");
            lrnscan=Write.nextLine();

            if (StudentInfo.contains(stdscan) && StudentInfo.contains(lrnscan))
            {
                //If the name and LRN is the same as stored in Array List then it will be stored in another Arraylist and redirect to method Prelim. "Line 182"
                nameOfStd.add(stdscan);
                lrnOfStd.add(lrnscan);
                prelim(); break;
            }
            //If it is wrong input, this will be shown and loop back to try again
            else
            {
                System.out.println("Name or LRN is Wrong");
                System.out.println("======================");
            }
        }
    }

    //This method is the start of Inputting raw score of the student.
    public void prelim()
    {
        //This new ArrayList is used to call the Arraylist in the new java class
        ArrayList <String> Display=new ArrayList<>();
        Storage(Display);

        //Calling the introduction of method.
        System.out.println("\n>>>>>>PRE-LIM<<<<<<");
        System.out.println("====Enter your Score====");

        //This while loop is used to set a limit to the user input. The user cannot input negative number but also cannot exceed to 100.
        //This is the input for Quizzes.
        while(true)
        {
            //This will try to catch non numeric value and loop back to enter another input.
            try
            {
                System.out.print(Display.get(0));
                q1=Write.nextInt();
                //If the inputted number is within the limit. This loop will break and go to the next loop. It is the same for the others until the last loop have been broken.
                if   (q1 >=0 && q1<=100) {break;}
                //Else if is wrong number. It will loop back to try again.
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(1));
                q2=Write.nextInt();
                if(q2 >=0 && q2<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(2));
                q3=Write.nextInt();
                if(q3 >=0 && q3<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        //This is the input for minor scores.
        while(true)
        {
            try
            {
                System.out.print(Display.get(3));
                hw=Write.nextInt();
                if(hw >=0 && hw<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(4));
                ac=Write.nextInt();
                if(ac >=0 && ac<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(5));
                sw=Write.nextInt();
                if(sw >=0 && sw<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        //This is the input for Major scores AKA "Performance task and Exam".
        while(true)
        {
            try
            {
                System.out.print(Display.get(6));
                pt=Write.nextInt();
                if(pt >=0 && pt<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(7));
                ex=Write.nextInt();
                if(ex >=0 && ex<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }

        //This is the process for computing the grades. The Raw score will be converted into percentage.
        qGrade       = (q1+q2+q3)/3*0.3;
        schGrade     = (hw+ac+sw)/3*0.05;
        ptGrade      = pt/100*50;
        exGrade      = ex/100*15;
        prelimGrade = qGrade+schGrade+ptGrade+exGrade;
        //The total grade will be added into new Arraylist.
        storeGrade.add(prelimGrade);

        //This will display the result of percentages.
        System.out.printf(Display.get(10),qGrade,schGrade,ptGrade,exGrade);
        System.out.printf("\nPre-Lim              : %.2f",prelimGrade);

        //After the result of grade. It will go to the next method. "Line 344"
        midterm();
    }

    public void midterm()
    {
        //This new ArrayList is used to call the Arraylist in the new java class
        ArrayList <String> Display=new ArrayList<>();
        Storage(Display);

        //Calling the introduction of method.
        System.out.println("\n>>>>>>MIDTERM<<<<<<");
        System.out.println("====Enter your Score====");

        //This while loop is used to set a limit to the user input. The user cannot input negative number but also cannot exceed to 100.
        //This is the input for Quizzes.
        while(true)
        {
            //This will try to catch non numeric value and loop back to enter another input.
            try
            {
                System.out.print(Display.get(0));
                q1=Write.nextInt();
                //If the inputted number is within the limit. This loop will break and go to the next loop. It is the same for the others until the last loop have been broken.
                if   (q1 >=0 && q1<=100) {break;}
                //Else if is wrong number. It will loop back to try again.
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(1));
                q2=Write.nextInt();
                if(q2 >=0 && q2<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(2));
                q3=Write.nextInt();
                if(q3 >=0 && q3<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        //This is the input for minor scores.
        while(true)
        {
            try
            {
                System.out.print(Display.get(3));
                hw=Write.nextInt();
                if(hw >=0 && hw<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(4));
                ac=Write.nextInt();
                if(ac >=0 && ac<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(5));
                sw=Write.nextInt();
                if(sw >=0 && sw<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        //This is the input for Major scores AKA "Performance task and Exam".
        while(true)
        {
            try
            {
                System.out.print(Display.get(6));
                pt=Write.nextInt();
                if(pt >=0 && pt<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(7));
                ex=Write.nextInt();
                if(ex >=0 && ex<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }

        //This is the process for computing the grades. The Raw score will be converted into percentage.
        qGrade       = (q1+q2+q3)/3*0.3;
        schGrade     = (hw+ac+sw)/3*0.05;
        ptGrade      = pt/100*50;
        exGrade      = ex/100*15;
        midtermGrade = qGrade+schGrade+ptGrade+exGrade;
        //The total grade will be added into new Arraylist.
        storeGrade.add(midtermGrade);

        //This will display the result of percentages.
        System.out.printf(Display.get(10),qGrade,schGrade,ptGrade,exGrade);
        System.out.printf("\nMidterm              : %.2f",midtermGrade);

        //After the result of grade. It will go to the next method. "Line 504"
        prefinals();
    }

    public void prefinals()
    {
        //This new ArrayList is used to call the Arraylist in the new java class
        ArrayList <String> Display=new ArrayList<>();
        Storage(Display);

        //Calling the introduction of method.
        System.out.println("\n>>>>>>PRE-FINALS<<<<<<");
        System.out.println("====Enter your Score====");

        //This while loop is used to set a limit to the user input. The user cannot input negative number but also cannot exceed to 100.
        //This is the input for Quizzes.
        while(true)
        {
            //This will try to catch non numeric value and loop back to enter another input.
            try
            {
                System.out.print(Display.get(0));
                q1=Write.nextInt();
                //If the inputted number is within the limit. This loop will break and go to the next loop. It is the same for the others until the last loop have been broken.
                if   (q1 >=0 && q1<=100) {break;}
                //Else if is wrong number. It will loop back to try again.
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(1));
                q2=Write.nextInt();
                if(q2 >=0 && q2<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(2));
                q3=Write.nextInt();
                if(q3 >=0 && q3<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        //This is the input for minor scores.
        while(true)
        {
            try
            {
                System.out.print(Display.get(3));
                hw=Write.nextInt();
                if(hw >=0 && hw<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(4));
                ac=Write.nextInt();
                if(ac >=0 && ac<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(5));
                sw=Write.nextInt();
                if(sw >=0 && sw<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        //This is the input for Major scores AKA "Performance task and Exam".
        while(true)
        {
            try
            {
                System.out.print(Display.get(6));
                pt=Write.nextInt();
                if(pt >=0 && pt<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(7));
                ex=Write.nextInt();
                if(ex >=0 && ex<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }

        //This is the process for computing the grades. The Raw score will be converted into percentage.
        qGrade         = (q1+q2+q3)/3*0.3;
        schGrade       = (hw+ac+sw)/3*0.05;
        ptGrade        = pt/100*50;
        exGrade        = ex/100*15;
        prefinalsGrade = qGrade+schGrade+ptGrade+exGrade;
        //The total grade will be added into new Arraylist.
        storeGrade.add(prefinalsGrade);

        //This will display the result of percentages and grade.
        System.out.printf(Display.get(10),qGrade,schGrade,ptGrade,exGrade);
        System.out.printf("\nPre-Finals           : %.2f",prefinalsGrade);

        //After the result of grade. It will go to the next method. "Line 664"
        finals();
    }

    public void finals()
    {
        ///This new ArrayList is used to call the Arraylist in the new java class
        ArrayList <String> Display=new ArrayList<>();
        Storage(Display);

        //Calling the introduction of method.
        System.out.println("\n>>>>>>FINALS<<<<<<");
        System.out.println("====Enter your Score====");

        //This while loop is used to set a limit to the user input. The user cannot input negative number but also cannot exceed to 100.
        //This is the input for Quizzes.
        while(true)
        {
            //This will try to catch non numeric value and loop back to enter another input.
            try
            {
                System.out.print(Display.get(0));
                q1=Write.nextInt();
                //If the inputted number is within the limit. This loop will break and go to the next loop. It is the same for the others until the last loop have been broken.
                if   (q1 >=0 && q1<=100) {break;}
                //Else if is wrong number. It will loop back to try again.
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(1));
                q2=Write.nextInt();
                if(q2 >=0 && q2<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(2));
                q3=Write.nextInt();
                if(q3 >=0 && q3<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        //This is the input for minor scores.
        while(true)
        {
            try
            {
                System.out.print(Display.get(3));
                hw=Write.nextInt();
                if(hw >=0 && hw<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(4));
                ac=Write.nextInt();
                if(ac >=0 && ac<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(5));
                sw=Write.nextInt();
                if(sw >=0 && sw<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        //This is the input for Major scores AKA "Performance task and Exam".
        while(true)
        {
            try
            {
                System.out.print(Display.get(6));
                pt=Write.nextInt();
                if(pt >=0 && pt<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }
        while(true)
        {
            try
            {
                System.out.print(Display.get(7));
                ex=Write.nextInt();
                if(ex >=0 && ex<=100) {break;}
                else {System.out.println(Display.get(8));}
            }
            catch (InputMismatchException e)
            {
                System.out.println(Display.get(9));
                Write.nextLine();
            }
        }

        //This is the process for computing the grades. The Raw score will be converted into percentage.
        qGrade       = (q1+q2+q3)/3*0.3;
        schGrade     = (hw+ac+sw)/3*0.05;
        ptGrade      = pt/100*50;
        exGrade      = ex/100*15;
        finalsGrade  = qGrade+schGrade+ptGrade+exGrade;
        //The total grade will be added into new Arraylist.
        storeGrade.add(finalsGrade);

        //This will display the result of percentages.
        System.out.printf(Display.get(10),qGrade,schGrade,ptGrade,exGrade);
        System.out.printf("\nFinals               : %.2f",finalsGrade);
        System.out.println("");

        //After the result of grade. It will go to the next method. "Line 824"
        semesterGrade();
    }

    //This method is the calculation of overall grades.
    public void semesterGrade()
    {
        ///This new ArrayList is used to call the Arraylist in the new java class
        ArrayList<String> Display = new ArrayList<>();
        Storage(Display);

        //This is the process for computating the Semester Grade. It will be converted into percentage then adding them all to get the semGrade
        term1 = prelimGrade*.2;
        term2 = midtermGrade*.2;
        term3 = prefinalsGrade*.2;
        term4 = finalsGrade*.4;
        semGrade = term1 + term2 + term3 + term4;
        //The Semester Grade will be added into new ArrayList
        storeSemGrade.add(semGrade);

        //The user must confirm the lrn in order to display the result of Semester Grade.
        Write.nextLine();
        while(true)
        {
            System.out.print("\nConfirmation of LRN  : ");
            lrnConfirm = Write.nextLine();
            if (lrnConfirm.equals(lrnscan))
            {
                System.out.printf(Display.get(11),stdscan,lrnscan,prelimGrade,midtermGrade,prefinalsGrade,finalsGrade);
                System.out.print("\nRemark               : ");

                //This is for determining the remark of student based on the average of  terms.
                if(semGrade >= 97.5 && semGrade <= 100)
                { System.out.printf("%.2f - "+ Display.get(12), semGrade);
                    storeRemark.add(Display.get(12));
                    break; }
                else if(semGrade >= 94.50 && semGrade <= 97.49)
                { System.out.printf("%.2f - "+ Display.get(13), semGrade);
                    storeRemark.add(Display.get(13));
                    break; }
                else if(semGrade >= 91.50 && semGrade <= 94.49)
                { System.out.printf("%.2f - "+ Display.get(14), semGrade);
                    storeRemark.add(Display.get(14));
                    break; }
                else if (semGrade >= 88.50 && semGrade <= 91.49)
                { System.out.printf("%.2f - "+ Display.get(15), semGrade);
                    storeRemark.add(Display.get(15));
                    break; }
                else if (semGrade >= 85.50 && semGrade <= 88.49)
                { System.out.printf("%.2f - "+ Display.get(16), semGrade);
                    storeRemark.add(Display.get(16));
                    break; }
                else if(semGrade >= 82.50 && semGrade <= 85.49)
                { System.out.printf("%.2f - "+ Display.get(17), semGrade);
                    storeRemark.add(Display.get(17));
                    break; }
                else if(semGrade >= 79.50 && semGrade <= 82.49)
                { System.out.printf("%.2f - "+ Display.get(18), semGrade);
                    storeRemark.add(Display.get(18));
                    break; }
                else if(semGrade >= 76.50 && semGrade <= 79.49)
                { System.out.printf("%.2f - "+ Display.get(19), semGrade);
                    storeRemark.add(Display.get(19));
                    break; }
                else if(semGrade >= 74.50 && semGrade <= 76.49)
                { System.out.printf("%.2f - "+ Display.get(20), semGrade);
                    storeRemark.add(Display.get(20));
                    break; }
                else
                {
                    System.out.println(Display.get(21));
                    storeRemark.add(Display.get(21));
                    break;
                }
                //If the user input the wrong lrn. This will be shown and loop back to try again
            }
            else
            {
                System.out.println("Invalid LRN! Try again.");
            }
        }
        System.out.println("Student Graded!");
        //After the result of Semester Grade. It will go to the next method
        TeacherSelection();
    }

    //Here, the system will confirm the code of user input to to determine if the user is an admin.
    public void AdminInput()
    {
        //This new ArrayList is used to call the Arraylist from the other java class
        ArrayList<String> AdminInfo=new ArrayList<>();
        Admin(AdminInfo);

        //This is the introduction of the Method
        System.out.println("============================");
        System.out.println("Enter Admin Code");

        //This is where the admin input the name and id
        while(true)
        {
            System.out.print("Admin Code  : ");
            adcode=Write.nextLine();
            //If the input is correct. The system will direct to the DisplayAdmin Method. "Line 1024"
            if(adcode.equals("12345"))
            {
                AdminSelection();
                break;
            }
            //If it is wrong, it will loop back to try again.
            else
            {
                System.out.println("Invalid!. Try Again");
            }
        }
    }

    //This method is for the display of Admin
    public void AdminSelection()
    {
        System.out.println("=====================================");
        System.out.println(">>>WELCOME ADMIN<<<");
        System.out.print("Enter a number from the following: "
                + "\n[1]Add a new Teacher"
                + "\n[2]Add a new Student"
                + "\n[3]Go back to Log-In"
                + "\n[4]Exit the Program"
                + "\n: ");
        select = Write.nextInt();

        //This is the process when the user enter a number from the following
        switch (select)
        {
            case 1:
                Write.nextLine();
                CreateTeacher();
                break;
            case 2:
                Write.nextLine();
                CreateStudent();
                break;
            case 3:
                Write.nextLine();
                System.out.println("");
                userlogin();
                break;
            case 4:
                System.out.println("END");
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

    //This method is for creating a new teacher for Log-in
    public void CreateTeacher()
    {
        //This new ArrayList is used to call the Arraylist in the new java class
        System.out.println("\nEnter Teacher's Username and Password");
        System.out.print("Username: ");
        String newuser = Write.nextLine();
        NewTeacherUser.add(newuser);

        System.out.print("Password: ");
        String newpass = Write.nextLine();
        NewTeacherPass.add(newpass);

        System.out.println("Teacher Account Created!");
        AdminSelection();
    }

    //This method is for adding a new student for Log-in
    public void CreateStudent()
    {
        //This new ArrayList is used to call the Arraylist in the new java class
        System.out.println("\nEnter Student Name and LRN");
        System.out.print("Username: ");
        String newname = Write.nextLine();
        NewStudentName.add(newname);

        System.out.print("Password: ");
        String newid = Write.nextLine();
        NewStudentPass.add(newid);

        System.out.println("Teacher Account Created!");
        AdminSelection();
    }
}