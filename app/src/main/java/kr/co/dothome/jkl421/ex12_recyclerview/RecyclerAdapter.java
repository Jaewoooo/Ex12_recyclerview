package kr.co.dothome.jkl421.ex12_recyclerview;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder>{

	private Context context;
	private ArrayList<MemberModel> members;

	public RecyclerAdapter(Context context, ArrayList<MemberModel> members) {
		this.context = context;
		this.members = members;
	}

	@NonNull
	@Override
	public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(
				R.layout.recycler_item, parent, false);
		Holder holder = new Holder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull Holder holder, int position) {
		MemberModel item = members.get(position);
		Picasso.get().load(item.getUserPic()).into(holder.ivPic);
		holder.tvId.setText(item.getId());
		holder.tvuserId.setText(item.getUserId());
		holder.tvuserName.setText(item.getUserName());
		holder.tvWdate.setText(item.getwDate());
	}

	@Override
	public int getItemCount() {
		return members.size();
	}

	public class Holder extends RecyclerView.ViewHolder {
		private ImageView ivPic;
		private TextView tvuserName;
		private TextView tvuserId;
		private TextView tvId;
		private TextView tvWdate;
		public Holder(View itemView) {
			super(itemView);
			ivPic = itemView.findViewById(R.id.iv_pic);
			tvuserName = itemView.findViewById(R.id.tv_username);
			tvuserId = itemView.findViewById(R.id.tv_username);
			tvId = itemView.findViewById(R.id.tv_id);
			tvWdate = itemView.findViewById(R.id.tv_wdate);

		}
	}
}
