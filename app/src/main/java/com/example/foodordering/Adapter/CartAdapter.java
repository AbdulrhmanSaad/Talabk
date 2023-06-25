package com.example.foodordering.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodordering.ChangeNumberOfItems;
import com.example.foodordering.Food;
import com.example.foodordering.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder>{
    ArrayList<Food>foods;
    private ChangeNumberOfItems changeNumberOfItems;

    public CartAdapter(ArrayList<Food> foods) {
        this.foods = foods;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
      holder.title.setText(foods.get(position).getTitle());
      holder.pic.setImageResource(foods.get(position).getPic());
      holder.price.setText(String.valueOf(foods.get(position).getPrice()));
      holder.totalEachItem.setText(String.valueOf(foods.get(position).getNumInCart()*foods.get(position).getPrice()));
      holder.dis.setText(String.valueOf(foods.get(position).getDescription()));
      holder.num.setText(String.valueOf(foods.get(position).getNumInCart())+"x");
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView title,price,totalEachItem,dis,num;
        ImageView pic;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.totalCost);
            totalEachItem=itemView.findViewById(R.id.totalEach);
            pic=itemView.findViewById(R.id.pic);
            dis=itemView.findViewById(R.id.discription);
            num=itemView.findViewById(R.id.num);
        }
    }
}
