package edu.zzy.kilinlist.action;

import edu.zzy.kilinlist.bean.User;
import edu.zzy.kilinlist.service.LoginService;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class LoginAction{
    private String email;
    private String password;
    private String message;
    private LoginService loginService;
    private String classroomCode;
    private String verificationCode;
    private User userResult;

    public User getUserResult() {
        return userResult;
    }

    public void setUserResult(User userResult) {
        this.userResult = userResult;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getClassroomCode() {
        return classroomCode;
    }

    public void setClassroomCode(String classroomCode) {
        this.classroomCode = classroomCode;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String login(){
        if(email != null){
            System.out.println(email);
        }else {
            System.out.println("No Email");
        }
        if(password != null){
            System.out.println(password);
        }
        else System.out.println("No password");

        userResult = loginService.loginUser(email, password);
        if(userResult == null){
            userResult = new User();
            userResult.setUserName("用户名密码错误");
        }
        System.out.println(userResult);
        return "success";
    }

    public String getUserClassroomCode(){
        classroomCode = loginService.getUserClassroomCode(email);
        return "success";
    }

    public String verification(){
        System.out.println(email);
        verificationCode = loginService.verification(email);
        return "success";
    }

    public String register(){
        System.out.println(email);
        System.out.println(password);
        message = loginService.registerUser(email, password);
        return "success";
    }
}
