package com.elearning.front.actions;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.elearning.models.ContactModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.mail.smtp.SMTPTransport;

public class ContactAction extends ActionSupport implements
		ModelDriven<ContactModel> {
	
	ContactModel contactModel = new ContactModel();

	@Override
	public ContactModel getModel() {
		return contactModel;
	}
	
	public String execute() throws Exception {
		String from = contactModel.getMailFrom();
		String[] args = new String[] {contactModel.getFullName(), contactModel.getMessage(), from};
        String[] recipients = new String[] { "aymen1212@gmail.com" };
        String subject = getText("contact.mail.subject");
        String message = getText("contact.mail.content",args);
       
        if (from!=null && message!=null && subject!=null) {
                // Sending e-mail
                sendMail(recipients, subject, message, from);
                this.contactModel=null;
                addActionMessage("Votre demande de contact a été effectuée avec succès");
                return INPUT;
        } else {
                return INPUT;
        }
}
	
//	@Override
//    public void validate() {
//            if (contactModel.getMailTo() == "" || contactModel.getMailTo() == null) {
//                    addFieldError("mailTo", getText("mailTo"));
//            }
//
//            if (contactModel.getSubject() == "" || contactModel.getSubject() == null) {
//                    addFieldError("subject", getText("subject"));
//            }
//
//            if (contactModel.getMessage() == "" || contactModel.getMessage() == null) {
//                    addFieldError("message", getText("message"));
//            }
//
//            super.validate();
//    }
	
	 // Method for sending e-mail
    public void sendMail(String recipients[], String subject, String message,
                    String from) throws MessagingException {
            boolean debug = false;

            // Set the host smtp address like String SMTPHost = "192.168.14.123";
            String SMTPHost = "smtp.gmail.com";

            // Create properties object
            Properties properties = new Properties();

            
            properties.put("mail.smtp.host", SMTPHost);
            properties.put("mail.smtp.port", "587"); 
            properties.put("mail.smtp.auth", "true");  

            // getting Session
            Session session = Session.getDefaultInstance(properties, null);
            session.setDebug(debug);
            
            // getting Transport
            SMTPTransport  transport = (SMTPTransport)session.getTransport("smtp");
            transport.connect(SMTPHost, Integer.parseInt("587"), "fattouchsquall"," bqwfonfgdrmyifen");

            // create a message
            Message msg = new MimeMessage(session);

            // Setting sender and Recipients address
            InternetAddress addressFrom = new InternetAddress(from);
            msg.setFrom(addressFrom);

            // Adding all recipients
            InternetAddress[] addressTo = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                    addressTo[i] = new InternetAddress(recipients[i]);
            }
            msg.setRecipients(Message.RecipientType.TO, addressTo);

            // Setting e-mail header
            msg.addHeader("MailingApplication", "Struts 2 Mailing Application");

            // Setting the Subject and Content Type
            msg.setSubject(subject);
            msg.setContent(message, "text/html");
            transport.sendMessage(msg,msg.getAllRecipients());
            transport.close();
    }
}
