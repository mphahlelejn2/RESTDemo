package com.kamo.restdemo.color;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kamo.restdemo.details.DetailsActivity;
import com.kamo.restdemo.R;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jeffrey.Mphahlele on 1/23/2018.
 */

public class ColorListAdapter extends RecyclerView.Adapter<ColorListAdapter.ViewHolder> {

    private ArrayList<Color> colorArrayList;
    private Context context;
    private Color color;

    public ColorListAdapter(Context context, ArrayList<Color> colorArrayList) {
        this.colorArrayList = colorArrayList;
       this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View card= LayoutInflater.from(parent.getContext()).inflate(R.layout.member_card,parent,false);
        return new ViewHolder(card) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         color = colorArrayList.get(position);
        Glide.with(context).load(color.getThumbnailUrl()+"png").diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().into(holder.imageView);
        holder.summary.setText(color.getTitle());
        holder.view.setOnClickListener(view -> {
            openDetailActivity(position);
        });


    }

    private void openDetailActivity(int position) {
        Intent i=new Intent(context,DetailsActivity.class);
        i.putExtra("data", colorArrayList.get(position));
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return colorArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.textView)
        TextView summary;
        @BindView(R.id.view)
        TextView view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
