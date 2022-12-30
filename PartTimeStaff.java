/**
*This is a PartTimeStaff class
*Contains methods used needed for Part Time Employees
* @author Joshua Jayakumar 
* @version 6.0
* @since 2019-11-05
*/
public class PartTimeStaff extends Employee {
  /** Instance fields
*@param hoursAssigned is # of hrs the employee works
*@param hourlyRate is the wage per hour
*@param sickDaysTaken is the # of sick days taken by employee
*/
 private double hoursAssigned, hourlyRate;
 private int sickDaysTaken=0;
/**This is a constructor, to create PartTimeStaff objects
*@param employeeNumber is the number given to the employee
*@param firstName is first name of Employee
*@param lastName is the last name of Employee
@param fname is The first name of the Employee
@param lname is The last name of the Employee
@param hrs is # of hrs the employee works
@param ratr is the wage of the employee
*/
 public PartTimeStaff (int empnum, String fname, String lname,double hrs, double rate){

super(empnum,fname,lname);

hoursAssigned = hrs;
hourlyRate = rate;
}

/**
*@return returns the salary of Part Time Staff
* Converts the sick days taken into hrs
*Subtracts it from the hours assgined
*multiplies by the wage
*/

public double pay(){
return (hoursAssigned - (8*sickDaysTaken))*hourlyRate;
}

/**
* adds the number of sick days taken by {@link Employee}*@param sickdays is the # of sick days taken
*/
public void deductSickDay (double sickdays){
  sickDaysTaken += sickdays;
}
/**
*sets the sick days taken to 0
*/
public void resetSickDay() {
 sickDaysTaken = 0;
}
/**
*@return returns the hourly wage 
*/
public double getHrRate(){
return hourlyRate;
}

/**
* Prints the pay stub of the Part Time Staff
@param sickhrs converts the sick days taken into hrs
@param hoursworked is number of hrs the employee has worked deducted from sick days
*/
public void printPayStub(){
double sickhrs = sickDaysTaken*8;
double hoursworked = hoursAssigned - sickhrs;

System.out.println ("\nPay Stub "+"\nEmployee Number: "+ employeeNumber+ "\nNet Pay of PartTimeStaff: "+  "$ " + pay()+ "\nHours Worked: "+ hoursworked+ " hours");

}

/**
* @return returns Part Time Staff Info
*/

public String toString(){
   return "\nEmployee Number: "+ employeeNumber+ "\nFirst Name: "+ firstName+ "\nLast Name: "+ lastName;
}

/**
*Finds the employee with the most sickdays
*@return returns the FullTimeStaff object with most sick days
*/

public PartTimeStaff compareToSickDayTaken (PartTimeStaff e){
  if(this.sickDaysTaken>e.sickDaysTaken){
    return this;
  }
else if(this.sickDaysTaken<e.sickDaysTaken){
  return e;
}
else 
  return this;
}




}
