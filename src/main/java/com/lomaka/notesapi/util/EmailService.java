package com.lomaka.notesapi.util;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;


    @Value("${spring.email.username}")
    private String fromEmail;



    public void sendVerificationEmail(String to, String verificationLink) {
        String html = """
                <html>
                  <body>
                    <h2>Welcome to NotesAPI!</h2>
                    <p>Click the button below to verify your account:</p>
                    <a href="%s" style="
                        background-color:#4CAF50;
                        color:white;
                        padding:10px 20px;
                        text-decoration:none;
                        display:inline-block;
                        border-radius:5px;">
                      Verify Email
                    </a>
                    <p>If you didn’t sign up, please ignore this message.</p>
                  </body>
                </html>
                """.formatted(verificationLink);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject("Confirm your NotesAPI account");
            helper.setText(html, true);
            helper.setFrom(fromEmail);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
