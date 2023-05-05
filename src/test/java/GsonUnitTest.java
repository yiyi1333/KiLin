import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.zzy.kilinlist.bean.Focus;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class GsonUnitTest {
    @Test
    public void toGsonTest(){
        ArrayList<Focus> arrayList = new ArrayList<>();
//        arrayList.add(new Focus(1, 1, "移动应用开发", "Android开发", Date.valueOf(LocalDate.now()), 45, Time.valueOf(LocalTime.now())));
        //将arrayList转为json字符串
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        System.out.println(json);
        //将json反序列化arrList<Focus>
        TypeToken<ArrayList<Focus>> typeToken = new TypeToken<>(){};
        ArrayList<Focus> arrayList1 = gson.fromJson(json, typeToken.getType());
        System.out.println(arrayList1.get(0).getContent());

    }

    @Test
    public void sendPostRequest() throws IOException {
        ArrayList<Focus> arrayList = new ArrayList<>();
//        arrayList.add(new Focus(1, 1, "移动应用开发", "Android开发", Date.valueOf(LocalDate.now()), 45, Time.valueOf(LocalTime.now())));
        //将arrayList转为json字符串
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        System.out.println(json);
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder().url("https://85b9-115-200-2-145.ngrok.io/KiLin_war_exploded/uploadFocus").post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        System.out.println(response.body().string());
    }
    @Test
    public void sendLoginRequest() throws IOException{
        OkHttpClient okHttpClient = new OkHttpClient();
//        RequestBody body = new FormBody.Builder().add("email", "1138154255@qq.com").add("password", "1138154255").build();
        Request request = new Request.Builder().url("https://f98a-115-200-38-114.ngrok.io/KiLin_war_exploded/login?email=1138154255@qq.com&password=1138154255").get().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response.isSuccessful()){
                    System.out.println(response.body().string());
                }
            }
        });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
