package com.example.getusermyapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserItemViewHolder> {
    private List<User> users;
    private Context context;
    private clickedListener listener;

    public UserAdapter(List<User> users, Context context, clickedListener listener) {
        this.users = users;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rcv_items, parent, false);

        return new UserItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        User user = users.get(position);
        holder.id.setText(String.valueOf("ID: " + user.id));
        holder.name.setText("Tên: " + user.name);
        holder.age.setText("Tuổi: " + user.age);
        holder.gender.setText(String.valueOf("Giới tính: " + user.gender));
    }

    public class UserItemViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView name;
        public TextView age;
        public TextView gender;

        public UserItemViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.txtId);
            name = (TextView) itemView.findViewById(R.id.txtName);
            age = (TextView) itemView.findViewById(R.id.txtAge);
            gender = (TextView) itemView.findViewById(R.id.txtGender);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // lay so vi tri cua recyclerview khi click
                    listener.onClickedListener(getPosition());
                }
            });
        }
    }
    // hoi tao interface cho su kien clicked
    public interface clickedListener {
        void onClickedListener(int position);
    }
}
