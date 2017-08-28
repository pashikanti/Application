import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleSenderServlet extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response)
throws IOException, ServletException {
this.doService(request, response);
}

public void doPost(
HttpServletRequest request,
HttpServletResponse response)
throws IOException, ServletException {
this.doService(request, response);
}

public void doService(
HttpServletRequest request,
HttpServletResponse response)
throws IOException, ServletException {

String recipients[] =
{ "indus.lavanya@gmail.com"};

String recipientsCC[] = {"indus.lavanya@gmail.com"};
String from = "info@indushealthplus.com";
String host = "172.19.31.189";
String filename =
"C:\\Documents and Settings\\vraju.SYNTELDCX\\Desktop\\aqua.jpeg";
String msgText1 = "Sending a file.\n";
String subject = "Sending a file";

Properties props = System.getProperties();
props.put("mail.smtp.host", host);

Session session = Session.getInstance(props, null);

try {

MimeMessage msg = new MimeMessage(session);
msg.setFrom(new InternetAddress(from));
InternetAddress[] addressTo =
new InternetAddress[recipients.length];
for (int i = 0; i < recipients.length; i++) {
addressTo[i] = new InternetAddress(recipients[i]);
}
msg.setRecipients(Message.RecipientType.TO, addressTo);
InternetAddress[] addressCC =
new InternetAddress[recipientsCC.length];
for (int i = 0; i < recipientsCC.length; i++) {
addressCC[i] = new InternetAddress(recipientsCC[i]);
}
msg.setRecipients(Message.RecipientType.CC, addressCC);
msg.setSubject(subject);

MimeBodyPart mbp1 = new MimeBodyPart();
mbp1.setText(msgText1);

MimeBodyPart mbp2 = new MimeBodyPart();

FileDataSource fds = new FileDataSource(filename);
mbp2.setDataHandler(new DataHandler(fds));
mbp2.setFileName(fds.getName());

Multipart mp = new MimeMultipart();
mp.addBodyPart(mbp1);
mp.addBodyPart(mbp2);

msg.setContent(mp);
msg.setSentDate(new Date());

Transport.send(msg);

} catch (MessagingException mex) {
mex.printStackTrace();
Exception ex = null;
if ((ex = mex.getNextException()) != null) {
ex.printStackTrace();
}
}

}
public static void main(String args[]){
	new SimpleSenderServlet();
}
}