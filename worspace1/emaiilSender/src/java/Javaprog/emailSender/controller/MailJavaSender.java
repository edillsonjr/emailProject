package Javaprog.emailSender.entidade;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MailJavaSender {

   public void enviaremail(String destinatario, String assunto, String corpo) {
        Properties props = new Properties();
        /**
         * Par�metros de conex�o com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("edilsonjuniormvf@gmail.com", "x102030x!");
            }
        });

        /**
         * Ativa Debug para sess�o
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("edilsonjuniormvf@gmail.com")); // Remetente

            Address[] toUser = InternetAddress // Destinat�rio(s)
                    .parse(destinatario);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);// Assunto
            message.setText(corpo);
            /**
             * M�todo para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

   public void Lerplanilha() throws BiffException, IOException {

        Workbook workbook = Workbook.getWorkbook(new File("Itapuranga.xls"));
        Sheet sheet = workbook.getSheet(0);
        int linhas = sheet.getRows();
        System.out.println("Iniciando a leitura da planilha XLS:");
        for (int i = 1; i < linhas; i++) {
            Cell a1 = sheet.getCell(0, i);
            Cell a2 = sheet.getCell(1, i);
            Cell a3 = sheet.getCell(2, i);
            Cell a4 = sheet.getCell(3, i);
            Cell a5 = sheet.getCell(4, i);
            Cell a6 = sheet.getCell(5, i);

            String as1 = a1.getContents();
            String as2 = a2.getContents();
            String as3 = a3.getContents();
            String as4 = a4.getContents();
            String as5 = a5.getContents();
            String as6 = a6.getContents();
            if (as4.contains("2")) {

                MailJavaSender enviar = new MailJavaSender();
                enviar.enviaremail(as5, "Teste", " a atividade " + as1 + " com previs�o de t�rmino em " + as3
                        + " est� atrasada. Favor acompanhar e tomar as medidas neces�rias.");
            } else {
                System.out.println("sem atrasoS \n" + as4);
            }

        }
        workbook.close();
    }

    public void moverarquivo(String endereco) {

        // arquivo a ser movido
        File arquivo = new File(endereco);

        // diretorio de destino
        File dir = new File("c:\\Users\\edilson.junior\\workspace\\emailProject");

        // move o arquivo para o novo diretorio
        boolean ok = arquivo.renameTo(new File(dir, arquivo.getName()));
        if (ok) {
            System.out.println("Arquivo foi movido com sucesso");
        } else {
            System.out.println("Nao foi possivel mover o arquivo");
        }
    }
}
