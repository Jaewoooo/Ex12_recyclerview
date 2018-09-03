package kr.co.dothome.jkl421.ex12_recyclerview.Utils;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
	static final String BASEURL = "http://motive.co.kr/ex02_app_board/main/";
	@GET("select.php")
	Call<JsonObject> getMembers();
}

