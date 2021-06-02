package com.example.android.newsfeed;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 06-03-2018.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private static final String TAB3 = RecycleViewAdapter.class.getSimpleName();
    private Context mContext;
    private LayoutInflater mInflater;
    private List<News> mlist = new ArrayList<>();
    private OnItemClickListener monItemClickListener;

    RecycleViewAdapter(Context context,OnItemClickListener onItemClickListener){
        Log.i(TAB3,"RecycleAdapter call");
        this.monItemClickListener = onItemClickListener;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAB3,"onCreateViewHolder call");
        View view = mInflater.inflate(R.layout.news_card_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i(TAB3,"onBindViewHolder call");
        News currentitem = mlist.get(position);
        holder.mnewsection.setText(currentitem.getmSectionName());
        holder.mnewtitle.setText(currentitem.getmWebTitle());
        holder.mnewtype.setText(currentitem.getmType());
        holder.mnewdate.setText(currentitem.getmDate());
        holder.BindOnClick(mlist.get(position),monItemClickListener);
    }

    @Override
    public int getItemCount() {
        Log.i(TAB3,"getItemCount call");
        Log.i(TAB3, String.valueOf(mlist.size()));
        return mlist.size();
    }

    void add(List<News> list){
        Log.i(TAB3,"on add list in recycle view method call");
        for (int i=0; i<list.size(); i++){
            Log.i(TAB3,list.get(i).getmWebTitle());
        }
            mlist = list;
            notifyDataSetChanged();
        }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mnewsection, mnewtitle, mnewtype, mnewdate;

        public ViewHolder(View itemView) {
            super(itemView);
            mnewsection = itemView.findViewById(R.id.section_card);
            mnewtitle = itemView.findViewById(R.id.title_card);
            mnewdate = itemView.findViewById(R.id.date_card);
        }

        void BindOnClick(final News news, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(news);
                }
            });
        }
    }
}
