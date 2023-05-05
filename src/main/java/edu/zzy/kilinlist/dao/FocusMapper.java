package edu.zzy.kilinlist.dao;

import edu.zzy.kilinlist.bean.Focus;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.sql.Time;


public interface FocusMapper {
//    public void insertFocus(@Param("kilinUserId") int kilinUserId, @Param("groupId") int groupId, @Param("content") String content,
//                            @Param("description") String description, @Param("date")Date date, @Param("focusTime")int focusTime, @Param("time")Time time);
    public void insertFocus(Focus focus);

}
