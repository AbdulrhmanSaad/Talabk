package com.example.foodordering.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.Food;
import com.example.foodordering.Onclick;
import com.example.foodordering.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<Food>foodList;
Onclick onclick;
    public PopularAdapter(ArrayList<Food> foodList,Onclick onclick) {
        this.foodList = foodList;
        this.onclick=onclick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos=position;
     holder.title.setText(foodList.get(position).getTitle());
     holder.pic.setImageResource(foodList.get(position).getPic());
     holder.price.setText(String.valueOf(foodList.get(position).getPrice()));
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             onclick.setClick(pos);
        }
       });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,price,addBtn;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.food_title);
            pic=itemView.findViewById(R.id.pic);
            price=itemView.findViewById(R.id.totalCost);

        }
    }
}
