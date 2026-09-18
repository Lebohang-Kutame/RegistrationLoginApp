/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrationloginapp;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author livhu
 */
public class RegistrationLoginApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter username");
        String user = scanner.nextLine();
        
        System.out.println("Enter password");
        String password = scanner.nextLine();
        
System.out.println("Enter cellphone number");
String cellphone = scanner.nextLine();

RegistrationLogin c = new RegistrationLogin(user, password, cellphone);

if (c.checkUsername(user)){
    System.out.println("Username successfully captured");
}else {
    System.out.println("Username not correctly typed");
}
if (c.checkCellPhoneNumber(cellphone)){
    System.out.println("Cellphone number successfully added");
}
else{
    System.out.println("Cellphone number incorrectly formatted");
}
if (c.checkUsername(user)
   &&  c.checkPasswordComplexity(password)
       && c.checkCellPhoneNumber(cellphone)){
        
    
        System.out.println("Registration successfull");
        
        System.out.println("\n-----LOGIN-----");
        
        System.out.println("Enter username");
        
        String enteredUsername = scanner.nextLine();
        
        System.out.println("Enter password");
        String enteredPassword = scanner.nextLine();
        
        boolean loginSuccessful = c.loginUser(enteredUsername , enteredPassword);
        
        System.out.println(c.returnLoginStatus(loginSuccessful));
    }   
    }
}