import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.zzy.kilinlist.bean.Focus;
import org.junit.Test;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUnitTest {
    @Test
    public void DateTest(){
//        LocalDate now = LocalDate.of(2022, 11, 14);
//        String nowString = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        Date date = Date.valueOf(nowString);
//        System.out.println(date);
////        将sql.Date转为LocalDate
//        System.out.println(date.getYear() + 1900);
//        System.out.println(date.getMonth());
//        System.out.println(date.getDay());
//        String date = "2022/06/07";
//        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//        System.out.println(localDate);
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
//        LocalTime time = LocalTime.now();
//        System.out.println(time);
        LocalDateTime justNow = LocalDateTime.now();
        Date today = Date.valueOf(justNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Time now = Time.valueOf(justNow.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println(today);
        System.out.println(now);
//        Focus focus = new Focus(1, 4, "测试", "描述", today, 15, now);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//        String jsonStr = gson.toJson(focus);
//        System.out.println(jsonStr);
//
//        Focus tofocus = gson.fromJson(jsonStr, Focus.class);

//        System.out.println(tofocus.getDate());
    }
}
