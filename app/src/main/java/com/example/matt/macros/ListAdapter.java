package com.example.matt.macros;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

/**
 * Created by Matt on 4/17/18.
 */

public class ListAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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

        }

        public void onClick(View view)
        {

        }
    }
}
