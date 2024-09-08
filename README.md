# Documentation for `Mail` Class

## Overview
The `Mail` class is a utility class for sending emails using JavaMail API. It is designed to send email messages through an SMTP server, specifically using Gmail's SMTP settings. The class contains methods to configure the email properties, authenticate the sender's email credentials, and send the email with specified recipients, subject, and content.

Link to Creata App Password -  https://myaccount.google.com/apppasswords

## Class and Fields

### 1. **Class: `Mail`**
   This is the main class responsible for handling email sending operations.

### 2. **Fields:**
   - **APP_EMAIL**: A constant string representing the sender's email address.
   - **APP_PASSWORD**: A constant string representing the sender's email password or application-specific password.

   These constants hold the credentials needed for authentication when sending an email.

   Example values (replace `...` with actual data):
   ```java
   private static final String APP_EMAIL = "youremail@gmail.com";
   private static final String APP_PASSWORD = "yourpassword";
   ```

## Methods

### 1. **Method: `sendMail`**
   - **Signature:**
     ```java
     public static void sendMail(String email, String subject, String content)
     ```
   - **Parameters:**
     - `email`: The recipient's email address (String).
     - `subject`: The subject of the email (String).
     - `content`: The body content of the email (String).
   
   - **Purpose:**
     Sends an email with the provided subject and content to the specified email address. It uses the sender’s credentials to authenticate through Gmail’s SMTP server.

   - **Process:**
     1. **Set Up Email Properties:**
        - Configures the necessary email properties for the SMTP connection.
        - Properties include enabling authentication (`mail.smtp.auth`), starting TLS encryption (`mail.smtp.starttls.enable`), and specifying the Gmail SMTP host and port (`mail.smtp.host`, `mail.smtp.port`).

     2. **Session Creation and Authentication:**
        - Creates a session using `Session.getInstance()` method with the defined properties.
        - Implements `javax.mail.Authenticator` to authenticate the sender's email using the `APP_EMAIL` and `APP_PASSWORD`.

     3. **Message Preparation:**
        - Constructs a `MimeMessage` object to represent the email.
        - Sets the "From" address, "To" recipient address, subject, and message content.

     4. **Send Email:**
        - The `Transport.send()` method is used to send the email through the Gmail SMTP server.
        - If the email is successfully sent, a success message is printed to the console.

     5. **Error Handling:**
        - If there is a `MessagingException`, it is caught and a `RuntimeException` is thrown, halting execution with an appropriate error message.


## Key Components

- **`Properties` Class**: Used to set key-value pairs for SMTP configuration.
- **`Session` Class**: Represents a mail session, handling authentication and managing email properties.
- **`Message` Class**: Represents the email message to be sent.
- **`MimeMessage` Class**: Subclass of `Message`, used for creating a MIME-style email.
- **`Transport.send()`**: Sends the email message.
- **Exception Handling**: Catches `MessagingException` and throws a runtime exception in case of any issues during email sending.

## Usage
To use this `Mail` class:
1. Replace `APP_EMAIL` and `APP_PASSWORD` with your Gmail address and the app-specific password.
2. Call `Mail.sendMail("recipient@example.com", "Subject", "Email body content")` to send an email.

Ensure that less secure apps access is enabled for the Gmail account or generate an app-specific password for secure usage.
