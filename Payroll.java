/**
*This is a Payroll class
*Mediator between all classes
* @author Joshua Jayakumar 
* @version 6.0
* @since 2019-11-05
*/
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;
import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;

public class Payroll {
  /** Instance fields
*@param rdempnum is the employee number read from the txt file
*@param rdfname is the first name read from the txt file
*@param rdlname is the last name read from the txt file
*@param rdysal is the yearly salary read from the txt file
*@param empty stores the lines not needed to create the object 
*/
private int rdempnum;
private String rdfname ="";
private String rdlname = "";
private int rdysal;
private String empty = "";
private String emptype = "";
/**Creates new Array of type Employee*/
ArrayList<Employee> staffList = new ArrayList();

/**
*This is a setter
* adds a Employee object to the array
*/
public void setStaff(Employee e){
staffList.add(e);
} 
/**
*Prints all the Employee info in the array
*/
public void getStaff (){
  
 for (int j =0; j<staffList.size(); j++){
System.out.println (staffList.get(j));
 }
}
/**
*@return returns the monthly salary of Full Time Staff
*/
public double averageSalary(){
double avgsal =0;
int count =0;
for (int j =0; j<staffList.size();j++){
  if (staffList.get(j) instanceof FullTimeStaff){
    avgsal+= staffList.get(j).pay();
    count++;
  }

}
return (avgsal*12)/count;


}

/**
*@return returns average hourly rate of Part Time Staff
*/
public double avgHrRate(){
double avgrate =0;
int count =0;
for (int j =0; j<staffList.size();j++){
  if (staffList.get(j) instanceof PartTimeStaff){
    avgrate+= ((PartTimeStaff)staffList.get(j)).getHrRate();
    count++;
  }

}
return avgrate/count;


}
/**
* @return returns the employee object with the most absents
* Finds the first full time staffList
* compares every other full time object with the first one
*returns the one with fewest sick days left
*/

public FullTimeStaff mostAbsent (){
FullTimeStaff e5 =null;

  for (int j =0; j<staffList.size();j++){
if(staffList.get(j) instanceof FullTimeStaff ) {
   e5 =(FullTimeStaff) staffList.get(j);
   break;
}   
}
  
  for(int j=0; j<staffList.size();j++){
if(staffList.get(j) instanceof FullTimeStaff ) {
 e5 = (((FullTimeStaff)staffList.get(j)).compareToSickDay((FullTimeStaff)e5));
}
  }
   return e5;
  }
  /**
* @return returns the employee object with the most absents
* Finds the first part time staffList
* compares every other part time object with the first one
*returns the one with most sick days taken
*/

  
  
public PartTimeStaff mostAbsentPartTime (){
PartTimeStaff e6 =null;

  for (int j =0; j<staffList.size();j++){
if(staffList.get(j) instanceof PartTimeStaff ) {
   e6 =(PartTimeStaff) staffList.get(j);
   break;
}   
}
  
  for(int j=0; j<staffList.size();j++){
if(staffList.get(j) instanceof PartTimeStaff ) {
 e6 = (((PartTimeStaff)staffList.get(j)).compareToSickDayTaken((PartTimeStaff)e6));
}
  }
   return e6;
  }
  





/**
*Prints the pays stubs of all objects in the array
*/


public void printAllpaystub(){
  for (int j =0; j<staffList.size();j++){

staffList.get(j).printPayStub();
  }
}

/**
*deducts sick day for the specified employeeNumber
*@param EN is the employee number
*@param sd is the sick days the employee has taken
*/

public void enterSickDay(int EN, double sd ){

for (int j =0; j<staffList.size();j++){
if(staffList.get(j) instanceof FullTimeStaff ) {
if(staffList.get(j).employeeNumber == EN){
((FullTimeStaff)staffList.get(j)).deductSickDay(sd);

}

}

else if (staffList.get(j) instanceof PartTimeStaff ){
if(staffList.get(j).employeeNumber == EN){
((PartTimeStaff)staffList.get(j)).deductSickDay(sd);
}
}
}
}

/**
*Sets the number of sick days left of FullTimeStaff to 20
*Sets the number of sick days taken of parttime to 0
*/
public boolean yearlySickDayReset() {
for (int j =0; j<staffList.size();j++){

if(staffList.get(j) instanceof FullTimeStaff ) {
((FullTimeStaff)staffList.get(j)).resetSickDay();
return true;
}

}
return false;
}


public boolean monthlySickDayReset() {
for (int j =0; j<staffList.size();j++){

if(staffList.get(j) instanceof PartTimeStaff ) {
((PartTimeStaff)staffList.get(j)).resetSickDay();
return true;
}
}
return false;
}

public void saveStaffList (){
 /**
 *Writes all the Employee information to a text file from the object
 */
 try {
            FileWriter writer = new FileWriter("Employee.txt");
            BufferedWriter bwr = new BufferedWriter(writer);

            for (int j =0; j<staffList.size();j++){
            if(staffList.get(j) instanceof FullTimeStaff ) {
            bwr.write("Full Time Staff:");
            bwr.write("\n");
            bwr.write(staffList.get(j).firstName);
             bwr.write("\n");
            bwr.write(staffList.get(j).lastName);
            bwr.write("\n");
            
            bwr.write(String.valueOf(staffList.get(j).employeeNumber));
            
            bwr.write("\n");
            bwr.write (String.valueOf(((FullTimeStaff)staffList.get(j)).getYsal()));
            bwr.write("\n");
            }
            }

 for (int j =0; j<staffList.size();j++){
            if(staffList.get(j) instanceof PartTimeStaff ) {
            bwr.write("Part Time Staff:");
            bwr.write("\n");
            
        
            bwr.write(staffList.get(j).firstName);
           
             bwr.write("\n");
            bwr.write(staffList.get(j).lastName);
         
           bwr.write("\n");
            bwr.write(String.valueOf(staffList.get(j).employeeNumber));
           
            bwr.write("\n");
            
            bwr.write(String.valueOf(((PartTimeStaff)staffList.get(j)).getHrRate()));
            bwr.write("\n");
            }
            }
        
        bwr.close();
          
            System.out.println("succesfully written to a file");
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
}





/**
*reads from Txt file and creates objects based on Part Time and Full Time
*/


  public void loadStaffList() {
    BufferedReader br = null;
   try {
			br = new BufferedReader(new FileReader("Employee.txt"));
			String emptype;
			
			while ((emptype = br.readLine()) != null) {
				 if ((emptype.equalsIgnoreCase("Full Time Staff"))) {
             staffList.add(new FullTimeStaff((Integer.parseInt(br.readLine())),br.readLine(), br.readLine(),Double.parseDouble(br.readLine() )));

            } else if ((emptype.equalsIgnoreCase("Part Time Staff"))) {
               staffList.add(new PartTimeStaff(Integer.parseInt(br.readLine()),br.readLine(), br.readLine(),(Double.parseDouble(br.readLine())),(Double.parseDouble(br.readLine()))) );
            }
        }
      
    }
			
			
		 catch (IOException e) {
			e.printStackTrace();
		} 

		finally {
			try {
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
   }
































}