package edu.zzy.kilinlist.service;

import edu.zzy.kilinlist.bean.Focus;
import edu.zzy.kilinlist.dao.FocusMapper;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;

public class FocusService {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    public void insertFocusList(ArrayList<Focus> focusArrayList){
        for(Focus f : focusArrayList){
            sqlSession.getMapper(FocusMapper.class).insertFocus(f);
        }
    }

    public void insertFocus(Focus focus){
        sqlSession.getMapper(FocusMapper.class).insertFocus(focus);
    }
}
