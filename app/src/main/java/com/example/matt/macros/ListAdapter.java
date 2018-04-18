package com.example.matt.macros;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Matt on 4/17/18.
 */

public class ListAdapter extends RecyclerView.Adapter {

    private List<Info> listItems;

    public ListAdapter(List<Info> listItems)
    {
        this.listItems = listItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newlay, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Info listItem = listItems.get(position);
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    private class ListViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView carbs;
        private TextView fats;
        private TextView proteins;
        private TextView name;

        public ListViewHolder(View itemView)
        {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            carbs = (TextView) itemView.findViewById(R.id.carbs);
            fats = (TextView) itemView.findViewById(R.id.fats);
            proteins = (TextView) itemView.findViewById(R.id.proteins);
            itemView.setOnClickListener(this);

        }

        public void bindView(int position)
        {
            name.setText(listItems.get(position).getName());
            carbs.setText(String.valueOf(listItems.get(position).getFoodcarbs()));
            fats.setText(String.valueOf(listItems.get(position).getFoodfats()));
            proteins.setText(String.valueOf(listItems.get(position).getFoodfats()));
        }

        public void onClick(View view)
        {

        }
    }
}
