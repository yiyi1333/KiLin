package edu.zzy.kilinlist.dao;

import edu.zzy.kilinlist.bean.RankInfo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.ArrayList;

public interface RankInfoMapper {
    public ArrayList<RankInfo> getRankInfoList(@Param("roomCode") String roomCode, @Param("date")Date date);
}
