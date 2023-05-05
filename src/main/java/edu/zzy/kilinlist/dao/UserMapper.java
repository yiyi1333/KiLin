package edu.zzy.kilinlist.dao;

import edu.zzy.kilinlist.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User searchUser(@Param("email") String email);

    public void updateUserRoom(@Param("classroomCode") String classroomCode, @Param("email") String email);

    public void insertUser(@Param("email") String email, @Param("password") String password);

}
