/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author livhu
 */

package registrationloginapp;

import java.io.File;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessagesTest {

    @Test
    public void testStoreMessage() {
        Messages messages = new Messages();

        String messageID = "1234567890";
        String messageHash = "12:34567890:HELLO:WORLD";
        String recipient = "+27821234567";
        String message = "Hello World";

        messages.storeMessage(
                messageID,
                messageHash,
                recipient,
                message
        );

        File file = new File("messages", messageID + ".json");

        assertTrue(
                file.exists(),
                "The JSON message file should exist"
        );
    }
}
 