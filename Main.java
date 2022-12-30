import java.util.*;
import java.io.*;
public class Main {
  public static void main(String[] args)throws FileNotFoundException{

  Scanner scan2 = new Scanner (System.in);
  Employee e1 = new FullTimeStaff(123, "Issac", "Newton", 345);
Employee e2 = new FullTimeStaff(124, "Boris", "Jaxon", 335);
Employee e3 = new PartTimeStaff (132,"Cris", "Karlson", 40, 12.0);
Employee e4 = new PartTimeStaff (133,"Brian", "Steven", 438, 12.0);
  int choose;
  int enumber;
  double sdays;
  System.out.println ("Payroll Application");
  Payroll job = new Payroll();
job.setStaff(e1);

job.setStaff(e2);
job.setStaff(e3);
job.setStaff(e4);


do{

System.out.println ("===============================================");

System.out.println ("1- Find Average Salary of Full Time Staff");
System.out.println ("2- Find Average Hourly Rate of Part TimeS taff");
System.out.println ("3- Deduct Sick Day");
System.out.println ("4- Find the most absent Full Time Staff");
System.out.println ("5- Print Pay Stubs of All Employees");
System.out.println ("6- Reset Sick Days for all Full Time Staff");
System.out.println ("7- Reset Sick Days for all Part Time Staff");
System.out.println ("8- Display Information of all Employees");
System.out.println ("9- Write Application to a Text File");
System.out.println ("10- Find the most absent Part Time Staff ");
System.out.println ("11- Read From Text File ");
System.out.println ("-1- To Close Application");
System.out.println ("===============================================");
System.out.print ("What Would you Like to do: ");
choose = scan2.nextInt();
if(choose ==1){
System.out.println ("The Average Salary for Full Time Staff is: $ "+ job.averageSalary());
}
else if(choose ==2){
System.out.println ("The Average Hourly Rate for Full Time Staff is: $ "+ job.avgHrRate());
}
else if (choose == 3){
  System.out.print ("Enter the Employee Number: ");
  enumber = scan2.nextInt();
  System.out.print ("Enter the Number of Sick Days Taken by Employee: ");
  sdays = scan2.nextInt();
 job.enterSickDay(enumber,sdays);

}
else if (choose == 4){
System.out.println ("Most Absent Employee Info: "+ job.mostAbsent());
}
else if (choose == 5){
job.printAllpaystub();
}
 
else if (choose == 6){
 System.out.println ("Resetting Sick Days");
 if(job.yearlySickDayReset() == true){
   System.out.println ("Sick Days Reset Successful");
 }
 else 
  System.out.println ("Sick Days Reset Not Successful");
}
else if(choose == 7){
System.out.println ("Resetting Sick Days");
 if(job. monthlySickDayReset()== true){
   System.out.println ("Sick Days Reset Successful");
 }
 else
  System.out.println ("Sick Days Reset Not Successful");
}
else if (choose ==8){
 System.out.println ("Employee Information:");
 System.out.println ("======================");
 job.getStaff();
 }
else if (choose ==9){
   System.out.println("");
   System.out.println ("Saving Employee Information to Text File");
   job.saveStaffList();
}

 else if (choose == 10){
   System.out.println ("Most Absent Employee Info: "+ job.mostAbsentPartTime());
 }

else if (choose == 11){
  System.out.println ("Reading Text File");
  job.loadStaffList();
}





}while (choose != -1);

if (choose == -1){
  System.out.println ("Shutting Down");

}

  }
}
