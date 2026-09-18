package registrationloginapp;


import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author livhu
 */

public class RegistrationLogin {
  
    public String username;
    public String password;
    public String cellphone;
    
    public RegistrationLogin(String username, String password, String cellphone){
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
    }

public boolean checkUsername(String username){
    if(username.contains("_")&& username.length()<=5){
        System.out.println("Username Successfully captured.");
        return true;
    }
    else{
        System.out.println("Username not correctly tyeped!!");
    return false;
    
}
}
    public boolean checkPasswordComplexity(String password){
        boolean length= password.length()>=8;
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigits = password.matches(".*[0-9].*");
        boolean hasSpecial = password.chars().anyMatch(c-> !Character.isLetterOrDigit(c));
        return length && hasUpper && hasDigits && hasSpecial;
    }
    public boolean checkCellPhoneNumber(String cellphone){
        Pattern pattern = Pattern.compile("\\+27" + "[0-9]{9}"+"$");
        return pattern.matcher(cellphone).matches();
      
    }
    public String registerUser(){
        
        return "";
    }
    public boolean loginUser(String enteredUsername,String enteredpassword){
        if(username.equals(enteredUsername) && password.equals(enteredpassword)){
            return true;
        
        
        
        }
        return false;
    }
    public String returnLoginStatus(boolean loginSuccessful){
        if(loginSuccessful){
            return"Successfully logged in!!";
        }
        else{
            return"Access denied";
        }
    }
}