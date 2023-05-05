package edu.zzy.kilinlist.service;

import edu.zzy.kilinlist.bean.Classroom;
import edu.zzy.kilinlist.bean.ClassroomInfo;
import edu.zzy.kilinlist.bean.RankInfo;
import edu.zzy.kilinlist.dao.ClassroomMapper;
import edu.zzy.kilinlist.dao.RankInfoMapper;
import edu.zzy.kilinlist.dao.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClassroomService {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    private static final String[] alphabets = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                                        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                                        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    private String createRandomString(){
       //生成随机字符串
        StringBuilder randomString = new StringBuilder();
        for(int i = 0; i < 10; i++){
            //生成一个随机数
            int randomIndex = (int) (Math.random() * alphabets.length);
            //将随机数添加到字符串中
            randomString.append(alphabets[randomIndex]);
        }
        return randomString.toString();
    }

    public Classroom createClassroom(String classroomName, String email){
        String randomString = createRandomString();
        //判断是否重复
        Classroom classroom = null;
        do{
            classroom = sqlSession.getMapper(ClassroomMapper.class).selectClassroom(randomString);
            if(classroom == null) {
                classroom = new Classroom(classroomName, randomString);
                sqlSession.getMapper(ClassroomMapper.class).insertClassroom(classroom);
                sqlSession.getMapper(UserMapper.class).updateUserRoom(randomString, email);
                return classroom;
            }
        }while (classroom != null);
        return classroom;
    }

    public Classroom joinClassroom(String classroomCode, String email){
        Classroom classroom = null;
        //判断是否存在房间
        classroom = sqlSession.getMapper(ClassroomMapper.class).selectClassroom(classroomCode);
        if(classroom == null) return null;
        sqlSession.getMapper(UserMapper.class).updateUserRoom(classroomCode, email);
        return classroom;
    }

    public Classroom searchClassroom(String email){
        return sqlSession.getMapper(ClassroomMapper.class).selectClassroomByemail(email);
    }

    public ClassroomInfo searchClassroomInfo(String email){
        ClassroomInfo info = new ClassroomInfo();
        Classroom classroom = sqlSession.getMapper(ClassroomMapper.class).selectClassroomByemail(email);
        if(classroom == null){
            return null;
        }
        info.setClassroomName(classroom.getClassroomName());
        info.setRoomCode(classroom.getRoomCode());
        //查询统计信息
        LocalDate nowDate = LocalDate.now();
        ArrayList<RankInfo> rankInfos = sqlSession.getMapper(RankInfoMapper.class).getRankInfoList(classroom.getRoomCode(), Date.valueOf(nowDate));
        if(rankInfos != null){
            info.setNumber(rankInfos.size());
            for (RankInfo r:
                 rankInfos) {
                if(email.equals(r.getEmail())){
                    info.setRank(r.getRankNumber());
                    return info;
                }
            }
        }
        return info;
    }


}
