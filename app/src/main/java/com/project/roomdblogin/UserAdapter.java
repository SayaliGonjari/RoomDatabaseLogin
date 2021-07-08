package com.project.roomdblogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.roomdblogin.model.UserData;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    List<UserData> userDataList;
    Context context;

    public UserAdapter(Context mContext, List<UserData> userList) {
        this.userDataList = userList;
        this.context = mContext;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row, parent, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.txt_userEmail.setText(userDataList.get(position).getEmail());
        holder.txt_userName.setText(userDataList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {

        TextView txt_userEmail, txt_userName;

        public UserHolder(@NonNull View itemView) {
            super(itemView);
            txt_userEmail = itemView.findViewById(R.id.txt_userEmail);
            txt_userName = itemView.findViewById(R.id.txt_userName);
        }
    }
}
