package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MobileInitializeAdapter extends RecyclerView.Adapter<MobileInitializeAdapter.MobileViewHolder> {
    List<String> responseItem;
    Context context;
    public MobileInitializeAdapter(List<String> responseItem) {
        this.responseItem = responseItem;
    }

    @NonNull
    @Override
    public MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new MobileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MobileViewHolder holder, int position) {
        holder.listItemView.setText(responseItem.get(position));
        holder.listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent nextIntent = new Intent(context,ResponseDetailActivity.class);
                    nextIntent.putExtra("responseElement",holder.listItemView.getText());
                    context.startActivity(nextIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return responseItem.size();
    }

    class MobileViewHolder extends RecyclerView.ViewHolder {
        public TextView listItemView;

        public MobileViewHolder(@NonNull View itemView) {
            super(itemView);
            listItemView = itemView.findViewById(R.id.text_view_item);
        }
    }
}
