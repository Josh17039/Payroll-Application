/**
*This is an abstract class
*Contains abstact methods used in the child classes
* @author Joshua Jayakumar 
* @version 6.0
* @since 2019-11-05
*/
public abstract class Employee{
 /** Instance fields
*@param employeeNumber is the number given to the employee
*@param firstName is first name of Employee
*@param lastName is the last name of Employee
*/
protected int employeeNumber; 
protected String firstName;
protected String lastName;
/**This is a constructor, to create employee objects
*@ param empnum is the the employee number
*@ param fname is the first name of Employee
*@ param lname is the last name of Employee
*/
public Employee(int empnum, String fname, String lname){
  employeeNumber = empnum;
  firstName = fname;
  lastName = lname;

}

/**
* abstract methods inherited by the child class
*/
public abstract double pay();
public abstract void deductSickDay(double sickdays);
public abstract void resetSickDay();
public abstract void printPayStub(); 

public abstract String toString();

 














}