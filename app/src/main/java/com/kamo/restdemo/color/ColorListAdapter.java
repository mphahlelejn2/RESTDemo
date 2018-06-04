package com.kamo.restdemo.color;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.kamo.restdemo.details.DetailsActivity;
import com.kamo.restdemo.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jeffrey.Mphahlele on 1/23/2018.
 */

public class ColorListAdapter extends RecyclerView.Adapter<ColorListAdapter.ViewHolder>  implements Filterable {

    private ArrayList<Color> colorArrayList;
    private List<Color>filteredData = null;
    private Context context;
    private Color color;

    private ItemFilter mFilter = new ItemFilter();

    public ColorListAdapter(Context context, ArrayList<Color> colorArrayList) {
         this.colorArrayList = colorArrayList;
         this.filteredData= colorArrayList;
         this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View card= LayoutInflater.from(parent.getContext()).inflate(R.layout.member_card,parent,false);
        return new ViewHolder(card) ;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         color = filteredData.get(position);
        Glide.with(context).load(color.getThumbnailUrl()+"png").diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().into(holder.imageView);
        holder.summary.setText(color.getTitle());
        holder.view.setOnClickListener(view -> {
            openDetailActivity(position);
        });

    }

    private void openDetailActivity(int position) {
        Intent i=new Intent(context,DetailsActivity.class);
        i.putExtra("data", filteredData.get(position));
        context.startActivity(i);
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
            final List<Color> list = colorArrayList;
            int count = list.size();
            final ArrayList<Color> nlist = new ArrayList<>(count);
            String filterableString ;
            for (int i = 0; i < count; i++) {
                filterableString = list.get(i).getTitle();
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
            filteredData = (ArrayList<Color>) results.values;
            notifyDataSetChanged();
        }

    }
}

