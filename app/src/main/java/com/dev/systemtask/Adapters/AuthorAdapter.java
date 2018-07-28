package com.dev.systemtask.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.systemtask.Model.Data;
import com.dev.systemtask.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Sumanth on 7/28/2018.
 */

public class AuthorAdapter extends RecyclerView.Adapter<AuthorAdapter.MyViewHolder> {
    Context context;
    ArrayList<Data.Entrylist> list = null;

    public AuthorAdapter(Context context,ArrayList<Data.Entrylist> list){
        this.context= context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.label.setText(list.get(position).title.label);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvlabel)
        TextView label;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
