import java.util.Properties;    

import javax.mail.*;    
import javax.mail.internet.*;    
class Mailer{  
	 public static void main(String[] args) {    
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "webmail.indushealthplus.com");    
          props.put("mail.smtp.socketFactory.port", "25");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "25");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication("info@indushealthplus.com","Buffer%1122");  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress("indus.nita1@gmail.com"));    
           message.setSubject("kkkkkkkk");    
           message.setText("test msg");    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  
}  