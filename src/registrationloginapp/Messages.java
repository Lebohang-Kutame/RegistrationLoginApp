/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationloginapp;

/**
 *
 * @author livhu
 */
// Importing Scanner to get input from the user
import java.util.Scanner;
// Importing Random to generate random message IDs
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class Messages {
    // Creating a Scanner object to read user input
    Scanner scanner = new Scanner(System.in);
    
     // Displaying the QuickChat menu and processing the user's choice
    int messagesSent = 0;
    
    
    public void chat(RegistrationLogin log){
        int option;
        
        // Repeating the menu until the user chooses to quit
        do{
            System.out.println("");
            
            // Displaying the main menu
            System.out.println("Welcome to Quickchat");
            System.out.println("How many messages you wich to send.");
            System.out.println("Option 1. Send message");
            System.out.println("Option 2. Coming soon");
            System.out.println("option 3. Quit");
            option = scanner.nextInt();
            
            // Calling sendMessages when the user selects option 1
            if (option == 1){
                sendMessages(log);
            }
            // Displaying a message for the unfinished option
            else if(option == 2){
            System.out.println("Coming soon");        
            }
            // Ending the menu when the user selects option 3
            else if(option  == 3){
                System.out.println("Quit");
            }
            // Displaying an error when the user enters an invalid option
            else{
                System.out.println("Error: Incorrect value");
                
            }
            
             
        
        } while (option != 3);
            
        }
    
     // Allowing the user to create, send, disregard, or store messages

        public void sendMessages(RegistrationLogin log){
            // Creating a Random object to generate message IDs
                        Random random = new Random();
                        
                        // Asking how many messages the user wants to create
            System.out.println("Enter number of Messages you want to send:");
            int number =scanner.nextInt();
            
            // Clearing the leftover newline from nextInt()
            scanner.nextLine();
            
         
            
            // Repeating the message process for the requested number of messages
        for (int i = 0; i < number; i++) {

            // Asking the user to enter the recipient's cellphone number
            System.out.println("Enter the recipient number");
            String num = scanner.nextLine();
        
            // Checking the cellphone number using the RegistrationLogin class
            while (!log.checkCellPhoneNumber(num)) {
                System.out.println("Incorrect format of the number, Enter the recipient number");
                num = scanner.nextLine();
            }

             // Asking the user to type the message
            System.out.println("Enter the Message");
            String message = scanner.nextLine();
  
            // Making sure the message does not exceed 250 characters
            while (message.length() > 250) {
                System.out.println("Message too long. Enter the message again");
                message = scanner.nextLine();
            }

            // Generating a random 10-digit message ID

           String messageID = String.format("%010d", Math.abs(random.nextLong()) % 10000000000L);
           String[] words = message.trim().split("\\s+");

           // Creating a message hash using the ID,
            // the first word, and the last word
String messageHash = messageID.substring(0, 2)
        + ":" + messageID.substring(2)
        + ":" + words[0].toUpperCase()
             + ":" + words[words.length - 1].toUpperCase();

// Displaying the message details
            System.out.println("Message ID: " + messageID);
            System.out.println("Message Hash: " + messageHash);
            System.out.println("Recipient: " + num);
            System.out.println("Message: " + message);
            
            // Asking the user what to do with the message
            System.out.println("Choose an option:");
            System.out.println("1. Send message");
            System.out.println("2. Disregard message");
            System.out.println("3. Store message");

            // Reading the selected message option

            int messageOption = scanner.nextInt();
            // Clearing the leftover newline
            scanner.nextLine();

            // Increasing the sent-message count when the message is sent
            if (messageOption == 1) {
                messagesSent++;
                System.out.println("Message sent successfully.");
                // Discarding the message without storing it
            } else if (messageOption == 2) {
                System.out.println("Message disregarded.");
            // Calling storeMessage to save the message as a JSON file
            } else if (messageOption == 3) {
                storeMessage(messageID, messageHash, num, message);
                // Handling an invalid message option
            } else {
                System.out.println("Invalid option. Message not sent.");
            }

                        
            }

        }
            
           
    
          // Saving the message details in a JSON file     
    public void storeMessage(String messageID, String messageHash,
                             String recipient, String message) {

        // Creating a folder named "messages"
        File folder = new File("messages");

        // Creating the folder if it does not already exist
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Creating a JSON filename using the message ID
        File file = new File(folder, messageID + ".json");

        try (FileWriter writer = new FileWriter(file)) {

            writer.write("{\n");
            writer.write("  \"messageID\": \"" + escapeJson(messageID) + "\",\n");
            writer.write("  \"messageHash\": \"" + escapeJson(messageHash) + "\",\n");
            writer.write("  \"recipient\": \"" + escapeJson(recipient) + "\",\n");
            writer.write("  \"message\": \"" + escapeJson(message) + "\"\n");
            writer.write("}");

            System.out.println("Message successfully stored as JSON.");

        } catch (IOException e) {
            System.out.println("Error storing message: " + e.getMessage());
        }
    }

    private String escapeJson(String text) {
        return text.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }

}      
               
     