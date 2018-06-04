package com.kamo.restdemo.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.kamo.restdemo.R;
import com.kamo.restdemo.color.Color;
import com.kamo.restdemo.color.ColorListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jeffrey.Mphahlele on 2/13/2018.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private ArrayList<User> usersArrayList;
    private ItemFilter mFilter = new ItemFilter();
    private List<User>filteredData = null;

    private Context context;
    private User user;

    public UserListAdapter(ArrayList<User> usersArrayList, Context context) {
        this.usersArrayList = usersArrayList;
       this.filteredData = usersArrayList;
        this.context = context;
    }

    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card,parent,false);
        return new UserListAdapter.ViewHolder(card) ;
    }

    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {
        user= filteredData.get(position);
       // Glide.with(context).load(color.getThumbnailUrl()+"png").diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().into(holder.imageView);
        holder.name.setText(user.getName());
        holder.surname.setText(user.getUsername());
        holder.email.setText(user.getEmail());
        holder.phone.setText(user.getPhone());

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



    @Override
    public int getItemCount() {
        return filteredData.size();
    }

    public long getItemId(int position) {
        return position;
    }
    public Filter getFilter() {
        return mFilter;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();
            final List<User> list = usersArrayList;
            int count = list.size();
            final ArrayList<User> nlist = new ArrayList<>(count);
            String filterableString ;
            for (int i = 0; i < count; i++) {
                filterableString = list.get(i).getName();
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(list.get(i));
                }
            }
            results.values = nlist;
            results.count = nlist.size();
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<User>) results.values;
            notifyDataSetChanged();
        }

    }

}
