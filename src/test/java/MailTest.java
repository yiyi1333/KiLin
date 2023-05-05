import org.junit.Test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class MailTest {
    @Test
    public void sendMail(String code) throws UnsupportedEncodingException, MessagingException {
        String emailHost = "smtp.qq.com"; //发邮件的主机
        String transportType = "smtp";
        String fromUser = "1138154255";
        String fromEmail = "1138154255@qq.com";
        String authCode = "xhyhnilvtjfhjaaa";
        String toEmail = "zhengzhanyi2000@163.com";
        String subject = "注册验证码";
        //初始化参数配置
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", transportType);
        props.setProperty("mail.host", emailHost);
        props.setProperty("mail.user", fromUser);
        props.setProperty("mail.from", fromEmail);
        //获取session
        Session session = Session.getInstance(props, null);
        //开启调试信息
        session.setDebug(true);

        //创建Message接口子类
        MimeMessage message = new MimeMessage(session);
        //邮件设置
        String formName = MimeUtility.encodeWord("KiLin ToDo") + "<" + fromEmail + ">";
        InternetAddress from = new InternetAddress(formName);
        message.setFrom(from);
        //设置收件人
        InternetAddress to = new InternetAddress(toEmail);
        message.setRecipients(Message.RecipientType.TO, String.valueOf(to));
        message.setSubject(subject);
        message.setContent("<h1>"+  code + "</h1>", "text/html;charset=UTF-8");
        message.saveChanges();
        Transport transport = session.getTransport();
        transport.connect(null, null, authCode);
        transport.sendMessage(message, message.getAllRecipients());
    }
}
