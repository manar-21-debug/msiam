package ma.bkam.msiam.common.email;


import ma.bkam.msiam.common.utils.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailSender{

//    private final JavaMailSender javaMailSender;

private final static Logger logger= LoggerFactory.getLogger(EmailService.class);

//    public EmailService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }


    @Override
    @Async
    public void send(String to, String email) {

        try{
         //   MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessage ss = null;
            MimeMessageHelper helper=new MimeMessageHelper(ss,"utf-8");
            helper.setText(email,true);
            helper.setTo(to);
            helper.setSubject("Confirm your email by Creating ur Password ");
            helper.setFrom("alae051@outlook.fr");
        }catch (MessagingException e){

            logger.error("Error sending email",e);
            throw Utilities.raiseError("failed to send email");
        }
    }
}
