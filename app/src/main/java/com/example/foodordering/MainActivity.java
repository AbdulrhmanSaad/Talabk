package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodordering.Adapter.CategoryAdapter;
import com.example.foodordering.Adapter.PopularAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerViewCategory,recyclerViewPopular;
CategoryAdapter adapter;
PopularAdapter popularAdapter;
Onclick onclick;
FloatingActionButton view;
    public static ArrayList<Food>foodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewCategory();
        recyclerViewPopular();
        view=findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategory=findViewById(R.id.recyclerView);
        recyclerViewCategory.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryItems>category=new ArrayList<>();
        category.add(new CategoryItems("Pizza",R.drawable.cat_1,R.drawable.category_background1));
        category.add(new CategoryItems("Burger",R.drawable.cat_2,R.drawable.category_background2));
        category.add(new CategoryItems("Hotdog",R.drawable.cat_3,R.drawable.category_background3));
        category.add(new CategoryItems("Drink",R.drawable.cat_4,R.drawable.category_background4));
        category.add(new CategoryItems("Donut",R.drawable.cat_5,R.drawable.category_background5));

        adapter=new CategoryAdapter(category);
        recyclerViewCategory.setAdapter(adapter);
    }
    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopular=findViewById(R.id.PopularRecycle);
        recyclerViewPopular.setLayoutManager(linearLayoutManager);
        foodList=new ArrayList<>();
        foodList.add(new Food("Cheese Burger", R.drawable.pop_2,"Beef, cheese, special sauce, lettuce, tomato.",60.0,1));
        foodList.add(new Food("Vegetable pizza",R.drawable.pop_3, "olive oil,Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil.",65.0,1));
        foodList.add(new Food("pepperoni pizza", R.drawable.pop_1,"Slices pepperoni, mozzerella cheese, fresh oregano, black pepper, pizza sauce.",100.0,1));

        onclick=new Onclick() {
            @Override
            public void setClick(int pos) {
                Intent intent=new Intent(MainActivity.this,showDetails.class);
                intent.putExtra("id",pos);
                startActivity(intent);
            }
        };
        popularAdapter=new PopularAdapter(foodList,onclick);
        recyclerViewPopular.setAdapter(popularAdapter);

    }

}