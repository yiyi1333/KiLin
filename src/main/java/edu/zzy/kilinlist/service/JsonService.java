package edu.zzy.kilinlist.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.zzy.kilinlist.bean.Focus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

public class JsonService {
    public String getRequestPostData(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength <= 0){
            return null;
        }
        byte [] buffer = new byte[contentLength];
//        for (int i = 0; i < contentLength;) {
//            int len = request.getInputStream().read(buffer, i, contentLength - i);
//            System.out.println("read:" + len + "  contentlength:" + contentLength);
//            if (len == -1) {
//                break;
//            }
//            i += len;
//        }
        request.getInputStream().read(buffer, 0, contentLength);

        return new String(buffer, "utf-8");
    }

    public ArrayList<Focus> toFocusListFromJson(String jsonString){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        TypeToken<ArrayList<Focus>> typeToken = new TypeToken<>(){};
        ArrayList<Focus> arrayList = gson.fromJson(jsonString, typeToken.getType());
        return arrayList;
    }

    public Focus toFocusFromJson(String jsonString){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        return gson.fromJson(jsonString, Focus.class);
    }
}
