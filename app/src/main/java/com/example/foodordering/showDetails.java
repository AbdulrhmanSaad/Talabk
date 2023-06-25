package com.example.foodordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class showDetails extends AppCompatActivity {
    TextView title, price, dis, number;
    ImageView pic, plus, muns;
    AppCompatButton add;
    public static ArrayList<Food> items = new ArrayList<>();
    ;
    int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        title = findViewById(R.id.title);
        price = findViewById(R.id.totalCost);
        number = findViewById(R.id.number);
        dis = findViewById(R.id.dis);
        pic = findViewById(R.id.pic);
        plus = findViewById(R.id.plus);
        muns = findViewById(R.id.muns);
        add = findViewById(R.id.add);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("id", -1);

        title.setText(MainActivity.foodList.get(pos).getTitle());
        price.setText(MainActivity.foodList.get(pos).getPrice()+"EGP");
        dis.setText(MainActivity.foodList.get(pos).getDescription());
        pic.setImageResource(MainActivity.foodList.get(pos).getPic());

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(number.getText().toString());
                if (num < 100)
                    number.setText("" + (++num));

            }
        });
        muns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(number.getText().toString());
                if (num > 1)
                    number.setText("" + (--num));
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = MainActivity.foodList.get(pos).getTitle();
                int exist = isExist(t);
                if(exist==-1) {
                    int pic = MainActivity.foodList.get(pos).getPic();
                    double p = MainActivity.foodList.get(pos).getPrice();
                    String dis=MainActivity.foodList.get(pos).getDescription();
                    Food f = new Food(t, pic, dis, p, num);
                    items.add(f);
                }else{
                    items.get(exist).setNumInCart(items.get(exist).getNumInCart()+num);
                }
                Toast.makeText(getApplicationContext(), "item added", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int isExist(String tt) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(tt)) {
                return i;
            }
        }
        return -1;
    }
}