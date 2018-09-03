package kr.co.dothome.jkl421.ex12_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import kr.co.dothome.jkl421.ex12_recyclerview.Member.MemberData;
import kr.co.dothome.jkl421.ex12_recyclerview.Utils.ApiService;
import kr.co.dothome.jkl421.ex12_recyclerview.Utils.SetRetrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity
		extends AppCompatActivity implements Callback<JsonObject>{

	private RecyclerView recyclerView;
	private RecyclerAdapter adapter;
	private ArrayList<MemberModel> members = new ArrayList<>();
	private Gson gson = new Gson();
	private Call<JsonObject> call;
	private MemberData data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recyclerView = findViewById(R.id.rv_wrap);
		initData();
	}

	private void initData() {
		call = SetRetrofit.retrofit().create(ApiService.class).getMembers();
		call.enqueue(this);
	}

	@Override
	public void onResponse(Call call, Response response) {
		if(response.isSuccessful()) {
			data = gson.fromJson((JsonObject) response.body(), MemberData.class);
			for(int i=0; i<data.getMembers().size(); i++) {
				String id = data.getMembers().get(i).getId();
				String userId = data.getMembers().get(i).getUserid();
				String userName = data.getMembers().get(i).getUsername();
				String wDate = data.getMembers().get(i).getWdate();
				String userPic = data.getMembers().get(i).getUserpic();
				members.add(new MemberModel(id, userId, userName, userPic, wDate));
			}
			adapter = new RecyclerAdapter(this, members);
			recyclerView.setAdapter(adapter);
			LinearLayoutManager manager = new LinearLayoutManager(this);
			manager.setOrientation(LinearLayoutManager.VERTICAL);
			recyclerView.setLayoutManager(manager);
		}
		else {
			Toast.makeText(this, "데이터이상", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void onFailure(Call call, Throwable t) {
		Toast.makeText(this, "통신실패", Toast.LENGTH_LONG).show();
	}
}