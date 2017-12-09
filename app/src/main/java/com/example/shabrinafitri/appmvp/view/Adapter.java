package com.example.shabrinafitri.appmvp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.shabrinafitri.appmvp.R;
import com.example.shabrinafitri.appmvp.model.PojoMain;
import com.example.shabrinafitri.appmvp.model.PojoMain.ResultsBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shabrinafitri on 09/12/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    Context context;
    List<PojoMain.ResultsBean> data;

    public Adapter(MainActivity mainActivity, ArrayList<ResultsBean> data) {
        this.context = mainActivity;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PojoMain.ResultsBean listitem = data.get(position);
        holder.textItem.setText(listitem.getOriginal_title());
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185" + listitem.getBackdrop_path())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageItem);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textItem;
        ImageView imageItem;

        public ViewHolder(View itemView) {
            super(itemView);
            textItem = (TextView)itemView.findViewById(R.id.text_list);
            imageItem = (ImageView) itemView.findViewById(R.id.image_list);
        }
    }
}