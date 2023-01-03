package gradingsystem;

import static gradingsystem.ArrayListStorage.Storage;
import java.util.ArrayList;
import java.util.Scanner;

public class GradingSystem 
{
    //Initialization
    ArrayList<Double> storeGrade = new ArrayList<>();
    ArrayList<String> nameOfStd = new ArrayList<>();
    ArrayList<String> lrnOfStd = new ArrayList<>();
    Scanner Write   = new Scanner(System.in),
            Write2  = new Scanner(System.in);
    String stdscan, lrnscan, backtostart, entry, adname, adID;
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

    //The user will input the useraneme and the password and this method will determine if the input is admin account or user account
    public void userlogin()
    {
        ArrayList<String> accounts = new ArrayList<>();
        Storage(accounts);

        while(true) {
            System.out.print("Log-In\nUsername: ");
            String user = Write2.nextLine();
            System.out.print("Password: ");
            String pass = Write2.nextLine();
            //If the account is an admin account, the system will redirect to the AdminInput method and Confirm the name and id of the admin. "Line 82"
            if ( user.equals(accounts.get(71)) && pass.equals(accounts.get(72))) 
            {
                System.out.println(" ");
                AdminInput();
                break;
            }
            //If the user input is a Teacher's account. The system will direct to the ProgramStart method. "Line62"
            else if (user.equals(accounts.get(75)) && pass.equals(accounts.get(76)) ||
                     user.equals(accounts.get(77)) && pass.equals(accounts.get(78)))
            {
                System.out.println(" ");
                UserInput();
                break;
            }
            else
            {
                System.out.println("\nWrong Username/Password!");
            }
        }
    }
    //The system will require you to press the enter button in order to redirect in UserInput method. "Line 106"
    public void ProgramStart()
    {
        ArrayList<String> callObject=new ArrayList<>();
        Storage(callObject);
        //INTRO
        System.out.println(callObject.get(0));
        System.out.println(callObject.get(1));
        while(true)
        {
            entry = Write.nextLine();
            if(!"".equals(entry))
            {
                System.out.println("Enter key not pressed");
            }
            else
            {
                userlogin(); break;
            }
        }
    }
    //Here, the system will confirm the name and id of user input to determine if the user is an admin.
    public void AdminInput()
    {
        ArrayList<String> info=new ArrayList<>();
        Storage(info);
        System.out.println("=====WELCOME=====");
        while(true)
        {
            System.out.print("Admin Name  : ");
            adname=Write.nextLine();
            System.out.print("Admin ID    : ");
            adID=Write.nextLine();
            if(adname.equals(info.get(73)) && (adID.equals(info.get(74))))
            {
                DisplayAdmin();
                break;
            }
            else
            {
                System.out.println("Invalid! Pls Try Again");
            }
        }
    }
    //If the User input is a Teacher's account
    public void UserInput()
    {
        //Call Array from another method
        ArrayList<String> callObject=new ArrayList<>();
        Storage(callObject);

        //Intro
        System.out.println(callObject.get(67));
        System.out.println(callObject.get(2));

        //The Teacher will input the name and the Student ID.
        while(true)
        {
            System.out.print(callObject.get(3));
            stdscan=Write.nextLine();
            System.out.print(callObject.get(4));
            lrnscan=Write.nextLine();
            if (
                    stdscan.equals(callObject.get(6))  && lrnscan.equals(callObject.get(7))  ||
                    stdscan.equals(callObject.get(8))  && lrnscan.equals(callObject.get(9))  ||
                    stdscan.equals(callObject.get(10)) && lrnscan.equals(callObject.get(11)) ||
                    stdscan.equals(callObject.get(12)) && lrnscan.equals(callObject.get(13)) ||
                    stdscan.equals(callObject.get(14)) && lrnscan.equals(callObject.get(15)) ||
                    stdscan.equals(callObject.get(16)) && lrnscan.equals(callObject.get(17)) ||
                    stdscan.equals(callObject.get(18)) && lrnscan.equals(callObject.get(19)) ||
                    stdscan.equals(callObject.get(20)) && lrnscan.equals(callObject.get(21)) ||
                    stdscan.equals(callObject.get(22)) && lrnscan.equals(callObject.get(23)) ||
                    stdscan.equals(callObject.get(24)) && lrnscan.equals(callObject.get(25)) ||
                    stdscan.equals(callObject.get(26)) && lrnscan.equals(callObject.get(27)) ||
                    stdscan.equals(callObject.get(28)) && lrnscan.equals(callObject.get(29)) ||
                    stdscan.equals(callObject.get(30)) && lrnscan.equals(callObject.get(31)) ||
                    stdscan.equals(callObject.get(32)) && lrnscan.equals(callObject.get(33)) ||
                    stdscan.equals(callObject.get(34)) && lrnscan.equals(callObject.get(35)) ||
                    stdscan.equals(callObject.get(36)) && lrnscan.equals(callObject.get(37)) ||
                    stdscan.equals(callObject.get(38)) && lrnscan.equals(callObject.get(39)) ||
                    stdscan.equals(callObject.get(40)) && lrnscan.equals(callObject.get(41)) ||
                    stdscan.equals(callObject.get(42)) && lrnscan.equals(callObject.get(43)) ||
                    stdscan.equals(callObject.get(44)) && lrnscan.equals(callObject.get(45))
                )
            {
                //If the name and LRN is the same as stored in Array List then it will be stored in another Arraylist and redirect to method Prelim.
                nameOfStd.add(stdscan);
                lrnOfStd.add(lrnscan);
                prelim(); break;
            }
            else
            {
                System.out.println(callObject.get(5));
                System.out.println(callObject.get(67));
            }
        }
    }
    //This method is the start of Inputting raw score of the student.
    public void prelim()
    {
        //This where the prelim grade should be stored.
        ArrayList <String> callObject=new ArrayList<>();
        Storage(callObject);

        //Calling the introduction of method.
        System.out.println(callObject.get(46));
        System.out.println(callObject.get(68));

        //This while loop is used to set a limit to the user input. The user cannot input negative number but also cannot exceed to 100.
        //This is the input for Quizzes.
        while(true)
        {
            System.out.print(callObject.get(50));
            q1=Write.nextInt();
            if   (q1 >=0 && q1<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(51));
            q2=Write.nextInt();
            if(q2 >=0 && q2<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(52));
            q3=Write.nextInt();
            if(q3 >=0 && q3<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        //This is the input for minor scores.
        while(true)
        {
            System.out.print(callObject.get(53));
            hw=Write.nextInt();
            if(hw >=0 && hw<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(54));
            ac=Write.nextInt();
            if(ac >=0 && ac<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(55));
            sw=Write.nextInt();
            if(sw >=0 && sw<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        //This is the input for Major scores AKA "Performance task and Exam".
        while(true)
        {
            System.out.print(callObject.get(56));
            pt=Write.nextInt();
            if(pt >=0 && pt<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(57));
            ex=Write.nextInt();
            if(ex >=0 && ex<=100) {break;}
            else {System.out.println(callObject.get(69));}
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
        System.out.println(callObject.get(58));
        System.out.printf(callObject.get(59), qGrade);
        System.out.printf(callObject.get(60), schGrade);
        System.out.printf(callObject.get(61), ptGrade);
        System.out.printf(callObject.get(62), exGrade);
        System.out.println(callObject.get(70));
        System.out.printf(callObject.get(63), prelimGrade);
        System.out.println(callObject.get(70));

        //After the result of grade. It will go to the next method.
        midterm();
    }

    public void midterm()
    {
        //This where the prelim grade should be stored.
        ArrayList <String> callObject=new ArrayList<>();
        Storage(callObject);

        //Intro
        System.out.println(callObject.get(47));
        System.out.println(callObject.get(68));

        //This while loop is used to set a limit to the user input. The user cannot input negative number but also cannot exceed to 100.
        //This is the input for Quizzes.
        while(true)
        {
            System.out.print(callObject.get(50));
            q1=Write.nextInt();
            if   (q1 >=0 && q1<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(51));
            q2=Write.nextInt();
            if(q2 >=0 && q2<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(52));
            q3=Write.nextInt();
            if(q3 >=0 && q3<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        //This is the input for minor scores.
        while(true)
        {
            System.out.print(callObject.get(53));
            hw=Write.nextInt();
            if(hw >=0 && hw<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(54));
            ac=Write.nextInt();
            if(ac >=0 && ac<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(55));
            sw=Write.nextInt();
            if(sw >=0 && sw<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        //This is the input for Major scores AKA "Performance task and Exam".
        while(true)
        {
            System.out.print(callObject.get(56));
            pt=Write.nextInt();
            if(pt >=0 && pt<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(57));
            ex=Write.nextInt();
            if(ex >=0 && ex<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }

        //Alternative Computation
        //This is the process for computing the grades. The Raw score will be converted into percentage.
        qGrade       = (q1+q2+q3)/3*0.3;
        schGrade     = (hw+ac+sw)/3*0.05;
        ptGrade      = pt/100*50;
        exGrade      = ex/100*15;
        midtermGrade = qGrade+schGrade+ptGrade+exGrade;
        //The total grade will be added into new Arraylist.
        storeGrade.add(midtermGrade);

        //This will display the result of percentages.
        System.out.println(callObject.get(58));
        System.out.printf(callObject.get(59), qGrade);
        System.out.printf(callObject.get(60), schGrade);
        System.out.printf(callObject.get(61), ptGrade);
        System.out.printf(callObject.get(62), exGrade);
        System.out.printf(callObject.get(64), midtermGrade);
        System.out.println(callObject.get(70));

        //After the result of grade. It will go to the next method.
        prefinals();
    }

    public void prefinals()
    {
        //This where the prelim grade should be stored.
        ArrayList <String> callObject=new ArrayList<>();
        Storage(callObject);

        //Intro
        System.out.println(callObject.get(48));
        System.out.println(callObject.get(68));

        //This while loop is used to set a limit to the user input. The user cannot input negative number but also cannot exceed to 100.
        //This is the input for Quizzes.
        while(true)
        {
            System.out.print(callObject.get(50));
            q1=Write.nextInt();
            if(q1 >=0 && q1<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(51));
            q2=Write.nextInt();
            if(q2 >=0 && q2<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(52));
            q3=Write.nextInt();
            if(q3 >=0 && q3<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        //This is the input for minor scores.
        while(true)
        {
            System.out.print(callObject.get(53));
            hw=Write.nextInt();
            if(hw >=0 && hw<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(54));
            ac=Write.nextInt();
            if(ac >=0 && ac<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(55));
            sw=Write.nextInt();
            if(sw >=0 && sw<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        //This is the input for Major scores AKA "Performance task and Exam".
        while(true)
        {
            System.out.print(callObject.get(56));
            pt=Write.nextInt();
            if(pt >=0 && pt<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(57));
            ex=Write.nextInt();
            if(ex >=0 && ex<=100) {break;}
            else {System.out.println(callObject.get(69));}
        }

        //Alternative Computation
        //This is the process for computing the grades. The Raw score will be converted into percentage.
        qGrade         = (q1+q2+q3)/3*0.3;
        schGrade       = (hw+ac+sw)/3*0.05;
        ptGrade        = pt/100*50;
        exGrade        = ex/100*15;
        prefinalsGrade = qGrade+schGrade+ptGrade+exGrade;
        //The total grade will be added into new Arraylist.
        storeGrade.add(prefinalsGrade);

        //This will display the result of percentages.
        System.out.println(callObject.get(58));
        System.out.printf(callObject.get(59), qGrade);
        System.out.printf(callObject.get(60), schGrade);
        System.out.printf(callObject.get(61), ptGrade);
        System.out.printf(callObject.get(62), exGrade);
        System.out.printf(callObject.get(65), prefinalsGrade);
        System.out.println(callObject.get(70));

        //After the result of grade. It will go to the next method.
        finals();
    }

    public void finals()
    {
        //This where the prelim grade should be stored.
        ArrayList <String> callObject=new ArrayList<>();
        Storage(callObject);

        //Intro
        System.out.println(callObject.get(49));
        System.out.println(callObject.get(68));

        //This while loop is used to set a limit to the user input. The user cannot input negative number but also cannot exceed to 100.
        //This is the input for Quizzes.
        while(true)
        {
            System.out.print(callObject.get(50));
            q1=Write.nextInt();
            if(q1 >=0 && q1<=100){break;}
            else{System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(51));
            q2=Write.nextInt();
            if(q2 >=0 && q2<=100){break;}
            else{System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(52));
            q3=Write.nextInt();
            if(q3 >=0 && q3<=100){break;}
            else{System.out.println(callObject.get(69));}
        }
        //This is the input for minor scores.
        while(true)
        {
            System.out.print(callObject.get(53));
            hw=Write.nextInt();
            if(hw >=0 && hw<=100){break;}
            else{System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(54));
            ac=Write.nextInt();
            if(ac >=0 && ac<=100){break;}
            else{System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(55));
            sw=Write.nextInt();
            if(sw >=0 && sw<=100){break;}
            else{System.out.println(callObject.get(69));}
        }
        //This is the input for Major scores AKA "Performance task and Exam".
        while(true)
        {
            System.out.print(callObject.get(56));
            pt=Write.nextInt();
            if(pt >=0 && pt<=100){break;}
            else{System.out.println(callObject.get(69));}
        }
        while(true)
        {
            System.out.print(callObject.get(57));
            ex=Write.nextInt();
            if(ex >=0 && ex<=100){break;}
            else{System.out.println(callObject.get(69));}
        }

        //Alternative Computation
        //This is the process for computing the grades. The Raw score will be converted into percentage.
        qGrade       = (q1+q2+q3)/3*0.3;
        schGrade     = (hw+ac+sw)/3*0.05;
        ptGrade      = pt/100*50;
        exGrade      = ex/100*15;
        finalsGrade  = qGrade+schGrade+ptGrade+exGrade;
        //The total grade will be added into new Arraylist.
        storeGrade.add(finalsGrade);

        //This will display the result of percentages.
        System.out.println(callObject.get(58));
        System.out.printf(callObject.get(59), qGrade);
        System.out.printf(callObject.get(60), schGrade);
        System.out.printf(callObject.get(61), ptGrade);
        System.out.printf(callObject.get(62), exGrade);
        System.out.printf(callObject.get(66), finalsGrade);
        System.out.println("\n" + callObject.get(67));

        //After the result of grade. It will go to the next method.
        semesterGrade();
    }
    //This method is the calculation of overall grades.
    public void semesterGrade()
    {
        ArrayList<String> info = new ArrayList<>();
        Storage(info);

        term1 = prelimGrade / 100 * 10 + 10;
        term2 = midtermGrade / 100 * 10 + 10;
        term3 = prefinalsGrade / 100 * 10 + 10;
        term4 = finalsGrade / 100 * 20 + 20;
        semGrade = term1 + term2 + term3 + term4;

        while(true)
        {
            System.out.print("\nConfirmation of LRN  : ");
            String lrnscan1 = Write2.nextLine();
            if (lrnscan1.equals(lrnscan))
            {
                System.out.println("=====================================");
                System.out.println(info.get(3) + stdscan);
                System.out.println(info.get(4) + lrnscan);
                System.out.printf(info.get(63), prelimGrade);
                System.out.printf(info.get(64), midtermGrade);
                System.out.printf(info.get(65), prefinalsGrade);
                System.out.printf(info.get(66), finalsGrade);
                System.out.print("\nRemark               : ");

                if(semGrade >= 97.5 && semGrade <= 100)
                { System.out.printf("%.2f - 1.00 Excellent", semGrade);
                  break; }
                else if(semGrade >= 94.50 && semGrade <= 97.49)
                { System.out.printf("%.2f - 1.25 Very Good", semGrade);
                  break; }
                else if(semGrade >= 91.50 && semGrade <= 94.49)
                { System.out.printf("%.2f - 1.50 Very Good", semGrade);
                  break; }
                else if (semGrade >= 88.50 && semGrade <= 91.49)
                { System.out.printf("%.2f - 1.75 Very Good", semGrade);
                  break; }
                else if (semGrade >= 85.50 && semGrade <= 88.49)
                { System.out.printf("%.2f - 2.00 Satisfactory", semGrade);
                  break; }
                else if(semGrade >= 82.50 && semGrade <= 85.49)
                { System.out.printf("%.2f - 2.25 Satisfactory", semGrade);
                  break; }
                else if(semGrade >= 79.50 && semGrade <= 82.49)
                { System.out.printf("%.2f - 2.50 Satisfactory", semGrade);
                  break; }
                else if(semGrade >= 76.50 && semGrade <= 79.49)
                { System.out.printf("%.2f - 2.75 Fair", semGrade);
                  break; }
                else if(semGrade >= 74.50 && semGrade <= 76.49)
                { System.out.printf("%.2f - 3.00 Fair", semGrade);
                  break; }
                else
                {
                    System.out.println("Failed");
                    break;
                }
            }
            else
            {
                System.out.println("Invalid LRN! Try again.");
            }
        }
        
        //next
        SelectionUser();
    }
    
    public void SelectionUser()
    {
        ArrayList<String> info = new ArrayList<>();
        Storage(info);
        
        System.out.println("\n=====================================");
        OUTER:
        while (true) 
        {
            System.out.print("Select from the following: "
                    + "\n[1]Input another Grade"
                    + "\n[2]Display Stored Grade"
                    + "\n[3]Go back to Log-In"
                    + "\n[4]Exit the Program"
                    + "\n: ");
            select = Write.nextInt();
            switch (select) 
            {
                case 1:
                    ProgramStart();
                    break OUTER;
                case 2:
                    displayInputGrade();
                    break OUTER;
                case 3:
                    userlogin();
                    break OUTER;
                case 4:
                    System.out.println("END");
                    break OUTER;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    
    public void displayInputGrade()
    {
        ArrayList<String> info = new ArrayList<>();
        Storage(info);
        
        System.out.println("=====================================");
        for (String storedstd : nameOfStd) 
        { System.out.println(storedstd); }
        
        System.out.print("Select Stored Grades from the index: "
                        + "\n[0] Go back to Selection"
                        + "\n: ");
        std = Write.nextInt();
        
        //Try call names for selection.
        switch (std) 
        {
            case 0:
                SelectionUser();
                break; 
            case 1:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(0));
                System.out.println(info.get(4) +   lrnOfStd.get(0));
                System.out.printf (info.get(63), storeGrade.get(0));
                System.out.printf (info.get(64), storeGrade.get(1));
                System.out.printf (info.get(65), storeGrade.get(2));
                System.out.printf (info.get(66), storeGrade.get(3));
                System.out.println("");
                displayInputGrade();
                break;
            case 2:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(1));
                System.out.println(info.get(4) +   lrnOfStd.get(1));
                System.out.printf (info.get(63), storeGrade.get(4));
                System.out.printf (info.get(64), storeGrade.get(5));
                System.out.printf (info.get(65), storeGrade.get(6));
                System.out.printf (info.get(66), storeGrade.get(7));
                System.out.println("");
                displayInputGrade();
                break;
            case 3:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(2));
                System.out.println(info.get(4) +   lrnOfStd.get(2));
                System.out.printf (info.get(63), storeGrade.get(8));
                System.out.printf (info.get(64), storeGrade.get(9));
                System.out.printf (info.get(65), storeGrade.get(10));
                System.out.printf (info.get(66), storeGrade.get(11));
                System.out.println("");
                displayInputGrade();
                break;
            case 4:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(3));
                System.out.println(info.get(4) +   lrnOfStd.get(3));
                System.out.printf (info.get(63), storeGrade.get(12));
                System.out.printf (info.get(64), storeGrade.get(13));
                System.out.printf (info.get(65), storeGrade.get(14));
                System.out.printf (info.get(66), storeGrade.get(15));
                System.out.println("");
                displayInputGrade();
                break;
            case 5:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(4));
                System.out.println(info.get(4) +   lrnOfStd.get(4));
                System.out.printf (info.get(63), storeGrade.get(16));
                System.out.printf (info.get(64), storeGrade.get(17));
                System.out.printf (info.get(65), storeGrade.get(18));
                System.out.printf (info.get(66), storeGrade.get(19));
                System.out.println("");
                displayInputGrade();
                break;
            case 6:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(5));
                System.out.println(info.get(4) +   lrnOfStd.get(5));
                System.out.printf (info.get(63), storeGrade.get(20));
                System.out.printf (info.get(64), storeGrade.get(21));
                System.out.printf (info.get(65), storeGrade.get(22));
                System.out.printf (info.get(66), storeGrade.get(23));
                System.out.println("");
                displayInputGrade();
                break;
            case 7:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(6));
                System.out.println(info.get(4) +   lrnOfStd.get(6));
                System.out.printf (info.get(63), storeGrade.get(24));
                System.out.printf (info.get(64), storeGrade.get(25));
                System.out.printf (info.get(65), storeGrade.get(26));
                System.out.printf (info.get(66), storeGrade.get(27));
                System.out.println("");
                displayInputGrade();
                break;
            case 8:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(7));
                System.out.println(info.get(4) +   lrnOfStd.get(7));
                System.out.printf (info.get(63), storeGrade.get(28));
                System.out.printf (info.get(64), storeGrade.get(29));
                System.out.printf (info.get(65), storeGrade.get(30));
                System.out.printf (info.get(66), storeGrade.get(31));
                System.out.println("");
                displayInputGrade();
                break;
            case 9:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(8));
                System.out.println(info.get(4) +   lrnOfStd.get(8));
                System.out.printf (info.get(63), storeGrade.get(32));
                System.out.printf (info.get(64), storeGrade.get(33));
                System.out.printf (info.get(65), storeGrade.get(34));
                System.out.printf (info.get(66), storeGrade.get(35));
                System.out.println("");
                displayInputGrade();
                break;
            case 10:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(9));
                System.out.println(info.get(4) +   lrnOfStd.get(9));
                System.out.printf (info.get(63), storeGrade.get(36));
                System.out.printf (info.get(64), storeGrade.get(37));
                System.out.printf (info.get(65), storeGrade.get(38));
                System.out.printf (info.get(66), storeGrade.get(39));
                System.out.println("");
                displayInputGrade();
                break;
            case 11:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(10));
                System.out.println(info.get(4) +   lrnOfStd.get(10));
                System.out.printf (info.get(63), storeGrade.get(40));
                System.out.printf (info.get(64), storeGrade.get(41));
                System.out.printf (info.get(65), storeGrade.get(42));
                System.out.printf (info.get(66), storeGrade.get(43));
                System.out.println("");
                displayInputGrade();
                break;
            case 12:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(11));
                System.out.println(info.get(4) +   lrnOfStd.get(11));
                System.out.printf (info.get(63), storeGrade.get(44));
                System.out.printf (info.get(64), storeGrade.get(45));
                System.out.printf (info.get(65), storeGrade.get(46));
                System.out.printf (info.get(66), storeGrade.get(47));
                System.out.println("");
                displayInputGrade();
                break;
            case 13:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(12));
                System.out.println(info.get(4) +   lrnOfStd.get(12));
                System.out.printf (info.get(63), storeGrade.get(48));
                System.out.printf (info.get(64), storeGrade.get(49));
                System.out.printf (info.get(65), storeGrade.get(50));
                System.out.printf (info.get(66), storeGrade.get(51));
                System.out.println("");
                displayInputGrade();
                break;
            case 14:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(13));
                System.out.println(info.get(4) +   lrnOfStd.get(13));
                System.out.printf (info.get(63), storeGrade.get(52));
                System.out.printf (info.get(64), storeGrade.get(53));
                System.out.printf (info.get(65), storeGrade.get(54));
                System.out.printf (info.get(66), storeGrade.get(55));
                System.out.println("");
                displayInputGrade();
                break;
            case 15:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(14));
                System.out.println(info.get(4) +   lrnOfStd.get(14));
                System.out.printf (info.get(63), storeGrade.get(56));
                System.out.printf (info.get(64), storeGrade.get(57));
                System.out.printf (info.get(65), storeGrade.get(58));
                System.out.printf (info.get(66), storeGrade.get(59));
                System.out.println("");
                displayInputGrade();
                break;
            case 16:
                System.out.println(info.get(67));
               System.out.println(info.get(3) +   nameOfStd.get(15));
                System.out.println(info.get(4) +   lrnOfStd.get(15));
                System.out.printf (info.get(63), storeGrade.get(60));
                System.out.printf (info.get(64), storeGrade.get(61));
                System.out.printf (info.get(65), storeGrade.get(62));
                System.out.printf (info.get(66), storeGrade.get(63));
                System.out.println("");
                displayInputGrade();
                break;
            case 17:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(16));
                System.out.println(info.get(4) +   lrnOfStd.get(16));
                System.out.printf (info.get(63), storeGrade.get(64));
                System.out.printf (info.get(64), storeGrade.get(65));
                System.out.printf (info.get(65), storeGrade.get(66));
                System.out.printf (info.get(66), storeGrade.get(67));
                System.out.println("");
                displayInputGrade();
                break;
            case 18:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(17));
                System.out.println(info.get(4) +   lrnOfStd.get(17));
                System.out.printf (info.get(63), storeGrade.get(68));
                System.out.printf (info.get(64), storeGrade.get(69));
                System.out.printf (info.get(65), storeGrade.get(70));
                System.out.printf (info.get(66), storeGrade.get(71));
                System.out.println("");
                displayInputGrade();
                break;
            case 19:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(18));
                System.out.println(info.get(4) +   lrnOfStd.get(18));
                System.out.printf (info.get(63), storeGrade.get(72));
                System.out.printf (info.get(64), storeGrade.get(73));
                System.out.printf (info.get(65), storeGrade.get(74));
                System.out.printf (info.get(66), storeGrade.get(75));
                System.out.println("");
                displayInputGrade();
                break;
            case 20:
                System.out.println(info.get(67));
                System.out.println(info.get(3) +  nameOfStd.get(19));
                System.out.println(info.get(4) +   lrnOfStd.get(19));
                System.out.printf (info.get(63), storeGrade.get(76));
                System.out.printf (info.get(64), storeGrade.get(77));
                System.out.printf (info.get(65), storeGrade.get(78));
                System.out.printf (info.get(66), storeGrade.get(79));
                System.out.println("");
                displayInputGrade();
                break;
             default:
                System.out.println("Invalid Input. Program Ends");
                break;
        }
    }
     
    public void DisplayAdmin()
    {
        ArrayList<String> info = new ArrayList<>();
        Storage(info);

        System.out.println("=====================================");

        if (nameOfStd.isEmpty())
        {
            System.out.println("No Stored Grades");
        }

        for (String storedstd : nameOfStd) 
        { System.out.println(storedstd); }
        
        System.out.print("Select Stored Grades from the index: "
                + "\n[0]Go back to Log-In"
                + "\n[100]Exit the Program"
                + "\n: ");
        std = Write.nextInt();
        switch (std) 
        {
            case 0:
                userlogin();
                break;
            case 100:
                System.out.println("END");
                break;
                case 1:
                System.out.println(info.get(3) +  nameOfStd.get(0));
                System.out.println(info.get(4) +   lrnOfStd.get(0));
                System.out.printf (info.get(63), storeGrade.get(0));
                System.out.printf (info.get(64), storeGrade.get(1));
                System.out.printf (info.get(65), storeGrade.get(2));
                System.out.printf (info.get(66), storeGrade.get(3));
                System.out.println("");
                DisplayAdmin();
                break;
            case 2:
                System.out.println(info.get(3) +  nameOfStd.get(1));
                System.out.println(info.get(4) +   lrnOfStd.get(1));
                System.out.printf (info.get(63), storeGrade.get(4));
                System.out.printf (info.get(64), storeGrade.get(5));
                System.out.printf (info.get(65), storeGrade.get(6));
                System.out.printf (info.get(66), storeGrade.get(7));
                System.out.println("");
                DisplayAdmin();
                break;
            case 3:
                System.out.println(info.get(3) +  nameOfStd.get(2));
                System.out.println(info.get(4) +   lrnOfStd.get(2));
                System.out.printf (info.get(63), storeGrade.get(8));
                System.out.printf (info.get(64), storeGrade.get(9));
                System.out.printf (info.get(65), storeGrade.get(10));
                System.out.printf (info.get(66), storeGrade.get(11));
                System.out.println("");
                DisplayAdmin();
                break;
            case 4:
                System.out.println(info.get(3) +  nameOfStd.get(3));
                System.out.println(info.get(4) +   lrnOfStd.get(3));
                System.out.printf (info.get(63), storeGrade.get(12));
                System.out.printf (info.get(64), storeGrade.get(13));
                System.out.printf (info.get(65), storeGrade.get(14));
                System.out.printf (info.get(66), storeGrade.get(15));
                System.out.println("");
                DisplayAdmin();
                break;
            case 5:
                System.out.println(info.get(3) +  nameOfStd.get(4));
                System.out.println(info.get(4) +   lrnOfStd.get(4));
                System.out.printf (info.get(63), storeGrade.get(16));
                System.out.printf (info.get(64), storeGrade.get(17));
                System.out.printf (info.get(65), storeGrade.get(18));
                System.out.printf (info.get(66), storeGrade.get(19));
                System.out.println("");
                DisplayAdmin();
                break;
            case 6:
                System.out.println(info.get(3) +  nameOfStd.get(5));
                System.out.println(info.get(4) +   lrnOfStd.get(5));
                System.out.printf (info.get(63), storeGrade.get(20));
                System.out.printf (info.get(64), storeGrade.get(21));
                System.out.printf (info.get(65), storeGrade.get(22));
                System.out.printf (info.get(66), storeGrade.get(23));
                System.out.println("");
                DisplayAdmin();
                break;
            case 7:
                System.out.println(info.get(3) +  nameOfStd.get(6));
                System.out.println(info.get(4) +   lrnOfStd.get(6));
                System.out.printf (info.get(63), storeGrade.get(24));
                System.out.printf (info.get(64), storeGrade.get(25));
                System.out.printf (info.get(65), storeGrade.get(26));
                System.out.printf (info.get(66), storeGrade.get(27));
                System.out.println("");
                DisplayAdmin();
                break;
            case 8:
                System.out.println(info.get(3) +  nameOfStd.get(7));
                System.out.println(info.get(4) +   lrnOfStd.get(7));
                System.out.printf (info.get(63), storeGrade.get(28));
                System.out.printf (info.get(64), storeGrade.get(29));
                System.out.printf (info.get(65), storeGrade.get(30));
                System.out.printf (info.get(66), storeGrade.get(31));
                System.out.println("");
                DisplayAdmin();
                break;
            case 9:
                System.out.println(info.get(3) +  nameOfStd.get(8));
                System.out.println(info.get(4) +   lrnOfStd.get(8));
                System.out.printf (info.get(63), storeGrade.get(32));
                System.out.printf (info.get(64), storeGrade.get(33));
                System.out.printf (info.get(65), storeGrade.get(34));
                System.out.printf (info.get(66), storeGrade.get(35));
                System.out.println("");
                DisplayAdmin();
                break;
            case 10:
                System.out.println(info.get(3) +  nameOfStd.get(9));
                System.out.println(info.get(4) +   lrnOfStd.get(9));
                System.out.printf (info.get(63), storeGrade.get(36));
                System.out.printf (info.get(64), storeGrade.get(37));
                System.out.printf (info.get(65), storeGrade.get(38));
                System.out.printf (info.get(66), storeGrade.get(39));
                System.out.println("");
                DisplayAdmin();
                break;
            case 11:
                System.out.println(info.get(3) +  nameOfStd.get(10));
                System.out.println(info.get(4) +   lrnOfStd.get(10));
                System.out.printf (info.get(63), storeGrade.get(40));
                System.out.printf (info.get(64), storeGrade.get(41));
                System.out.printf (info.get(65), storeGrade.get(42));
                System.out.printf (info.get(66), storeGrade.get(43));
                System.out.println("");
                DisplayAdmin();
                break;
            case 12:
                System.out.println(info.get(3) +  nameOfStd.get(11));
                System.out.println(info.get(4) +   lrnOfStd.get(11));
                System.out.printf (info.get(63), storeGrade.get(44));
                System.out.printf (info.get(64), storeGrade.get(45));
                System.out.printf (info.get(65), storeGrade.get(46));
                System.out.printf (info.get(66), storeGrade.get(47));
                System.out.println("");
                DisplayAdmin();
                break;
            case 13:
               System.out.println(info.get(3) +   nameOfStd.get(12));
                System.out.println(info.get(4) +   lrnOfStd.get(12));
                System.out.printf (info.get(63), storeGrade.get(48));
                System.out.printf (info.get(64), storeGrade.get(49));
                System.out.printf (info.get(65), storeGrade.get(50));
                System.out.printf (info.get(66), storeGrade.get(51));
                System.out.println("");
                DisplayAdmin();
                break;
            case 14:
               System.out.println(info.get(3) +   nameOfStd.get(13));
                System.out.println(info.get(4) +   lrnOfStd.get(13));
                System.out.printf (info.get(63), storeGrade.get(52));
                System.out.printf (info.get(64), storeGrade.get(53));
                System.out.printf (info.get(65), storeGrade.get(54));
                System.out.printf (info.get(66), storeGrade.get(55));
                System.out.println("");
                DisplayAdmin();
                break;
            case 15:
                System.out.println(info.get(3) +  nameOfStd.get(14));
                System.out.println(info.get(4) +   lrnOfStd.get(14));
                System.out.printf (info.get(63), storeGrade.get(56));
                System.out.printf (info.get(64), storeGrade.get(57));
                System.out.printf (info.get(65), storeGrade.get(58));
                System.out.printf (info.get(66), storeGrade.get(59));
                System.out.println("");
                DisplayAdmin();
                break;
            case 16:
               System.out.println(info.get(3) +   nameOfStd.get(15));
                System.out.println(info.get(4) +   lrnOfStd.get(15));
                System.out.printf (info.get(63), storeGrade.get(60));
                System.out.printf (info.get(64), storeGrade.get(61));
                System.out.printf (info.get(65), storeGrade.get(62));
                System.out.printf (info.get(66), storeGrade.get(63));
                System.out.println("");
                DisplayAdmin();
                break;
            case 17:
                System.out.println(info.get(3) +  nameOfStd.get(16));
                System.out.println(info.get(4) +   lrnOfStd.get(16));
                System.out.printf (info.get(63), storeGrade.get(64));
                System.out.printf (info.get(64), storeGrade.get(65));
                System.out.printf (info.get(65), storeGrade.get(66));
                System.out.printf (info.get(66), storeGrade.get(67));
                System.out.println("");
                DisplayAdmin();
                break;
            case 18:
                System.out.println(info.get(3) +  nameOfStd.get(17));
                System.out.println(info.get(4) +   lrnOfStd.get(17));
                System.out.printf (info.get(63), storeGrade.get(68));
                System.out.printf (info.get(64), storeGrade.get(69));
                System.out.printf (info.get(65), storeGrade.get(70));
                System.out.printf (info.get(66), storeGrade.get(71));
                System.out.println("");
                DisplayAdmin();
                break;
            case 19:
                System.out.println(info.get(3) +  nameOfStd.get(18));
                System.out.println(info.get(4) +   lrnOfStd.get(18));
                System.out.printf (info.get(63), storeGrade.get(72));
                System.out.printf (info.get(64), storeGrade.get(73));
                System.out.printf (info.get(65), storeGrade.get(74));
                System.out.printf (info.get(66), storeGrade.get(75));
                System.out.println("");
                DisplayAdmin();
                break;
            case 20:
                System.out.println(info.get(3) +  nameOfStd.get(19));
                System.out.println(info.get(4) +   lrnOfStd.get(19));
                System.out.printf (info.get(63), storeGrade.get(76));
                System.out.printf (info.get(64), storeGrade.get(77));
                System.out.printf (info.get(65), storeGrade.get(78));
                System.out.printf (info.get(66), storeGrade.get(79));
                System.out.println("");
                DisplayAdmin();
                break;
            default:
                System.out.println("Invalid Input. Program Ends");
                break;
        } 
    }  
}