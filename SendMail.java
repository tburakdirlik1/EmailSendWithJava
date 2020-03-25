
import java.util.ArrayList;
import java.util.List;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class SendMail{

	public static void turkishhMailSender(String subject, String message1, String mail) {

		try{

			String from ="*************@gmail.com";//SENDER EMAIL
			String pass = "************";//SENDER PASSWORD
			String [] to = {mail};
			String host ="smtp.gmail.com";
                            
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", true);
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", 587);
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props,null);
                        MimeMessage message = new MimeMessage(session);
		
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];
			
			for (int i =0; i<to.length; i++){

				toAddress[i]= new InternetAddress(to[i]);
								}
			
			
			for ( int i =0; i<toAddress.length; i++){
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
								} 
                        
                        
				message.setSubject(subject);
				message.setText(message1);

				Transport transport =session.getTransport("smtp");
				transport.connect(host,from,pass);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();

				}catch(Exception e){
					System.out.println("hata: "+e);
}
	}

    public static void main(String[] args) {               
        String mail ="**************@gmail.com";//RECEIVER E-MAIL
        System.out.println(mail);
        for(int i=0; i<500; i++){
        turkishhMailSender("destek", "randommmessage", mail);     
	}   
    }
}
