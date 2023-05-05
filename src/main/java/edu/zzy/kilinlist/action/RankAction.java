package edu.zzy.kilinlist.action;

import edu.zzy.kilinlist.bean.RankInfo;
import edu.zzy.kilinlist.service.RankService;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RankAction {
    private RankService rankService;
    private String date;
    private String email;
    private ArrayList<RankInfo> rankInfos;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RankService getRankService() {
        return rankService;
    }

    public void setRankService(RankService rankService) {
        this.rankService = rankService;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<RankInfo> getRankInfos() {
        return rankInfos;
    }

    public void setRankInfos(ArrayList<RankInfo> rankInfos) {
        this.rankInfos = rankInfos;
    }

    public String getFocusRankInfo(){
        System.out.println("email: " + email);
        System.out.println("date: " + date);
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        rankInfos = rankService.getRankInfos(email, Date.valueOf(localDate));
        return "success";
    }
}
