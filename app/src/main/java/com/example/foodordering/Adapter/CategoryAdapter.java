package com.example.foodordering.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.CategoryItems;
import com.example.foodordering.MainActivity;
import com.example.foodordering.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryItems>category;

    public CategoryAdapter(ArrayList<CategoryItems> category) {
        this.category = category;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.categoryName.setText(category.get(position).getTitle());
     holder.categoryPic.setImageResource(category.get(position).getPic());
     holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),category.get(position).getBackground()));
     holder.mainlayout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

         }
     });
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
            mainlayout=itemView.findViewById(R.id.main);

        }
    }
}
