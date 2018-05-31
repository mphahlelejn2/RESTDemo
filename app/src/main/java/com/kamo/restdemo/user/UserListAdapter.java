package com.kamo.restdemo.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kamo.restdemo.R;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jeffrey.Mphahlele on 2/13/2018.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private ArrayList<User> usersArrayList;
    private Context context;
    private User user;

    public UserListAdapter(ArrayList<User> usersArrayList, Context context) {
        this.usersArrayList = usersArrayList;
        this.context = context;
    }

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card,parent,false);
        return new UserListAdapter.ViewHolder(card) ;
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {
        user= usersArrayList.get(position);
       // Glide.with(context).load(color.getThumbnailUrl()+"png").diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().into(holder.imageView);
        holder.name.setText(user.getName());
        holder.surname.setText(user.getUsername());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

          @BindView(R.id.name)
         TextView name;
          @BindView(R.id.surname)
          TextView surname;
          @BindView(R.id.email)
          TextView email;
          @BindView(R.id.phone)
          TextView phone;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
