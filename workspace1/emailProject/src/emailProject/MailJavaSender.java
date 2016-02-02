package emailProject;

import java.security.NoSuchProviderException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailJavaSender {
	public void enviaremail(String destinatario, String assunto, String corpo) throws NoSuchProviderException {

		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("expressov3.serpro.gov.br", "69628769120@comunicacoes.gov.br", "X102030x!");

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress("edilson.junior@comunicacoes.gov.br")); // Remetente

			Address[] toUser = InternetAddress // Destinat�rio(s)
					.parse(destinatario);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);// Assunto
			message.setText(corpo);
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");
		} catch (MessagingException e) {
			e.printStackTrace();
			System.exit(2);
		}

	}
}
