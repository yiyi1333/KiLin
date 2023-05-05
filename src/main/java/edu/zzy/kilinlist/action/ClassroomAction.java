package edu.zzy.kilinlist.action;

import edu.zzy.kilinlist.bean.Classroom;
import edu.zzy.kilinlist.bean.ClassroomInfo;
import edu.zzy.kilinlist.service.ClassroomService;

public class ClassroomAction {
    private ClassroomService classroomService;
    private String email;
    private String classroomName;
    private String classroomCode;
    private Classroom classroom;
    private ClassroomInfo classroomInfo;

    public void setClassroomInfo(ClassroomInfo classroomInfo) {
        this.classroomInfo = classroomInfo;
    }

    public ClassroomInfo getClassroomInfo() {
        return classroomInfo;
    }

    public String getClassroomCode() {
        return classroomCode;
    }

    public void setClassroomCode(String classroomCode) {
        this.classroomCode = classroomCode;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public ClassroomService getClassroomService() {
        return classroomService;
    }

    public void setClassroomService(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String createClassroom(){
        System.out.println(email);
        System.out.println(classroomName);
        classroom = classroomService.createClassroom(classroomName, email);
        return "success";
    }

    public String joinClassroom(){
        System.out.println(email);
        System.out.println(classroomCode);
        classroom = classroomService.joinClassroom(classroomCode, email);
        return "success";
    }

    public String getClassroomRankInfo(){
        System.out.println(email);
        classroomInfo = classroomService.searchClassroomInfo(email);
        return "success";
    }

}
