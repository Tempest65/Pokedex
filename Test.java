import javax.swing.*;
import java.text.*;
/**
 * Date:February 22, 2018 
 * Author: Sarthak Singh
 * Description: Program that displays receipt for company of your choice
 */

public class Test{
  public static void main(String[] args) { 
    
    double salary, increase;// declare variables
    
    DecimalFormat twoDecimals = new DecimalFormat("#.00"); // declare decimal format
    salary = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter salary"));//prompt user to enter salary
    
    if (salary <40000) {
      increase = salary *0.05 ;
      
    }
    
    else if (salary > 40000 && salary < 60000) {
      increase = 40000 * 0.05 + (salary - 40000) * 0.03;
    }
    
    else {
      increase = 40000 * 0.05 + 20000 * 0.03 + (salary - 60000) *0.01;
    }
    
    System.out.println(twoDecimals.format(increase));
  }
  
}







