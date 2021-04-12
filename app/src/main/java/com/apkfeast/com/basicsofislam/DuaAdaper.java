package com.apkfeast.com.basicsofislam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class DuaAdapter extends RecyclerView.Adapter<DuaAdapter.DuaViewHolder> {
    private final ArrayList<DuaItem> mDuaList;

    private OnItemClickListener mListener;

    public DuaAdapter(ArrayList<DuaItem> DuaList) {
        mDuaList = DuaList;
    }

    public void SetOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;

    }

    @NonNull
    @Override
    public DuaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.duaitem, viewGroup, false);

        return new DuaViewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DuaViewHolder holder, int position) {

        DuaItem currentItem = mDuaList.get(position);
        holder.title.setText(currentItem.getMtitle());
    }

    @Override
    public int getItemCount() {
        return mDuaList.size();
    }

    public interface OnItemClickListener {
        void OnItemClick(int position);


    }

    public static class DuaViewHolder extends RecyclerView.ViewHolder {

        final TextView title;

        DuaViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            title = itemView.findViewById(R.id.tit);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
        }

    }

}
