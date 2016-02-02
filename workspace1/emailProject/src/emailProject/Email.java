package emailProject;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Email {
	// Create the email message
	
	public void enviarEmail(String titulo, String mensagem,
			String destinatario
		) throws Exception{
		
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("expressov3.serpro.gov.br");
		email.setSmtpPort(465);
		email.setTLS(true);
		email.setSSL(false);
		email.setFrom("edilson.junior@comunicacoes.gov.br", "assunto");
		email.setAuthenticator(new DefaultAuthenticator("69628769120", "X102030x!"));
		email.setSubject(titulo);
		email.setMsg(mensagem);
		email.addTo(destinatario);
		email.setDebug(true);
		email.send();
	}
}