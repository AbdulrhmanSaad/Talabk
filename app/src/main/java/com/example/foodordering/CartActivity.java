package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.foodordering.Adapter.CartAdapter;

public class CartActivity extends AppCompatActivity {
TextView total,cost,empty;
RecyclerView recyclerView;
AppCompatButton checkout;
    ScrollView scrollView;
    LinearLayout homeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        total=findViewById(R.id.totalCost);
        cost=findViewById(R.id.Cost);
        checkout=findViewById(R.id.checkout);
        recyclerView=findViewById(R.id.recyclerView);
        empty=findViewById(R.id.empty);
        scrollView=findViewById(R.id.scrollView3);
        initList();
        if(showDetails.items.size()==0){
            scrollView.setVisibility(View.INVISIBLE);
            empty.setVisibility(View.VISIBLE);
        }
        double price=0.0;
        for(int i=0;i<showDetails.items.size();i++){
          price+=(showDetails.items.get(i).getPrice()*showDetails.items.get(i).getNumInCart());
        }
        cost.setText(String.valueOf(price)+"EGP");
        total.setText(String.valueOf(price+20)+"EGP");
        homeBtn=findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this,MainActivity.class));
            }
        });
    }
    private void initList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        CartAdapter adapter=new CartAdapter(showDetails.items);
        recyclerView.setAdapter(adapter);

    }
}