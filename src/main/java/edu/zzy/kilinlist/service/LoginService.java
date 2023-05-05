package edu.zzy.kilinlist.service;

import edu.zzy.kilinlist.bean.User;
import edu.zzy.kilinlist.dao.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class LoginService {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User loginUser(String email, String password){
        User user = sqlSession.getMapper(UserMapper.class).searchUser(email);
        if(user == null) return null;
        return password.equals(user.getPassword()) ? user : null;
    }

    public String getUserClassroomCode(String email){
        return sqlSession.getMapper(UserMapper.class).searchUser(email).getRoomCode();
    }

    public String verification(String email){
        //生成随机的六位数字字符串
        String verificationCode = String.valueOf((int)((Math.random()*9+1)*100000));
        System.out.println(verificationCode);
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sendMessage(verificationCode, email);
                } catch (MessagingException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return verificationCode;
    }

    public void sendMessage(String code, String toEmail) throws MessagingException, UnsupportedEncodingException {
        String emailHost = "smtp.qq.com"; //发邮件的主机
        String transportType = "smtp";
        String fromUser = "1138154255";
        String fromEmail = "1138154255@qq.com";
        String authCode = "xhyhnilvtjfhjaaa";
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

    public String registerUser(String email, String password){
        User user = sqlSession.getMapper(UserMapper.class).searchUser(email);
        if(user != null) {
            return "邮箱已被使用";
        }
        sqlSession.getMapper(UserMapper.class).insertUser(email, password);
        return "注册成功";
    }
}
