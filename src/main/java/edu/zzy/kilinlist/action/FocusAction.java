package edu.zzy.kilinlist.action;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import edu.zzy.kilinlist.bean.Focus;
import edu.zzy.kilinlist.service.FocusService;
import edu.zzy.kilinlist.service.JsonService;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

public class FocusAction implements ServletRequestAware {
    private String message;
    private FocusService focusService;
    private JsonService jsonService;
    private HttpServletRequest request;

    public FocusService getFocusService() {
        return focusService;
    }

    public void setFocusService(FocusService focusService) {
        this.focusService = focusService;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public JsonService getJsonService() {
        return jsonService;
    }

    public void setJsonService(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String upLoadFocus() throws IOException {
//        获取json字符串
        String jsonData = jsonService.getRequestPostData(request);
//        对json字符串反序列化
        System.out.println(jsonData);
        Focus focus = jsonService.toFocusFromJson(jsonData);
//        插入数据库中
        focusService.insertFocus(focus);
        message = "上传数据成功";
        return "success";
    }

    public String upLoadFocusList() throws IOException{
        //        获取json字符串
        String jsonData = jsonService.getRequestPostData(request);
//        对json字符串反序列化
        ArrayList<Focus> focusArrayList = jsonService.toFocusListFromJson(jsonData);
//        插入数据库中
        focusService.insertFocusList(focusArrayList);
        message = "上传数据成功";
        return "success";
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
