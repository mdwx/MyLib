package retrofit;

import com.orhanobut.logger.L;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Arales on 2016/9/8.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class GitHubUserInfo {
    private static final String API_URL = "https://api.github.com";

    static class User {
        String login;
        int id;

        @Override
        public String toString() {
            return login + ", " + id;
        }

    }
    Call<User> getUserInfo(String user) {
        return null;
    }

    interface GitHub {
        @GET("users/{user}")
        Call<User> getUserInfo(@Path("user") String user);
    }

    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/") //设置baseUrl,注意，baseUrl必须后缀"/"
                .addConverterFactory(GsonConverterFactory.create()) //添加Gson转换器
                .build();
        /**
         * 获取GitHubUserInfo的实例
         */
        GitHubUserInfo userInfo = retrofit.create(GitHubUserInfo.class);
        Call<User> userCall = userInfo.getUserInfo("nickyangjun");
        userCall.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Logger.d(L.All(), "name:  " + response.body().login + " id: " + response.body().id);
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }


}
