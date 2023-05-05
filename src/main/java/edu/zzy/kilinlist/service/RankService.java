package edu.zzy.kilinlist.service;

import edu.zzy.kilinlist.bean.RankInfo;
import edu.zzy.kilinlist.bean.User;
import edu.zzy.kilinlist.dao.RankInfoMapper;
import edu.zzy.kilinlist.dao.UserMapper;
import org.mybatis.spring.SqlSessionTemplate;

import java.sql.Date;
import java.util.ArrayList;

public class RankService {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public ArrayList<RankInfo> getRankInfos(String email, Date date){
        //先查询email对应的roomcode
        User user = sqlSession.getMapper(UserMapper.class).searchUser(email);
        if(user == null) return null;
        return sqlSession.getMapper(RankInfoMapper.class).getRankInfoList(user.getRoomCode(), date);
    }
}
