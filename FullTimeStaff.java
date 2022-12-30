/**
*This is a FullTimeStaff class
*Contains methods used needed for Full Time Employees
* @author Joshua Jayakumar 
* @version 6.0
* @since 2019-11-05
*/
public class FullTimeStaff extends Employee{
private static double yearlySickDay=20;  
private double yearlySalary;
private double sickDaysLeft = yearlySickDay;

/**This is a constructor, to create FullTimeStaff objects
@param Fname is The first name of the Employee
@param Lname is The last name of the Employee
@param ysal is the yearly salary of the employee
*/
public FullTimeStaff(int empnum, String fname, String lname, double ysal){
 super(empnum,fname,lname);

  yearlySalary = ysal;
  }
/**
*Deducts the number of sick days from 20
*prints # of sick days left
*@param sickdays is the # of sick days person has taken
*/
public void deductSickDay(double sickdays){
if((sickdays>=0.5)&&(sickdays<=20)){
  sickDaysLeft -= sickdays;
  System.out.println("Remaining Sick Days of Employee: "+ sickDaysLeft);
  if(sickDaysLeft ==0.0){
    System.out.println("Warning!! NO MORE SICK DAYS LEFT");
  }

}
}
/**
* This is a getter
* @return returns the yearly salary
*/
public double getYsal (){
  return yearlySalary;
}
/**
sets the number of sick days left to 20;
*/
public void resetSickDay() {
  sickDaysLeft = yearlySickDay;
}
/**
* This is a getter
* @return returns the monthly salary
*/
public double pay(){
return yearlySalary/12.0;
}
/**
* @return returns Full Time Staff Info
*/
public String toString(){
   return "\nEmployee Number: "+ employeeNumber+ "\nFirst Name: "+ firstName+ "\nLast Name: "+ lastName;
}
/**
*Finds the employee with the most sickdays
*@return returns the FullTimeStaff object with most sick days
*/
public FullTimeStaff compareToSickDay (FullTimeStaff e){
  if(this.sickDaysLeft<e.sickDaysLeft){
    return this;
  }
else if(this.sickDaysLeft>e.sickDaysLeft){
  return e;
}
else 
  return this;
}
/**
* prints the pay stub for employee
*/
public void printPayStub(){

  double taken= yearlySickDay - sickDaysLeft;
  System.out.println (" ");
  System.out.println ("Pay Stub"); 
  System.out.println("\nEmployee Number: "+ employeeNumber+"\nYearly Salary: "+ "$ "+ yearlySalary+"\nMonthly Pay: "+ "$ "+pay()+ "\nSick Days Taken: "+ taken);
}



}

