package edu.zzy.kilinlist.dao;

import edu.zzy.kilinlist.bean.Classroom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassroomMapper {
    public void insertClassroom(Classroom classroom);

    public Classroom selectClassroom(@Param("code") String code);

    public Classroom selectClassroomByemail(@Param("email") String email);
}
