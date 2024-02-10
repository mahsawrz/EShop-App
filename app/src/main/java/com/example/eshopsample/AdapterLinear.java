package com.example.eshopsample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterLinear extends RecyclerView.Adapter<AdapterLinear.MyHolder> {

    private ArrayList<Product> ProductList;
    private Context c;


    public AdapterLinear(Context c, ArrayList<Product> productArrayList) {
        this.ProductList = productArrayList;
        this.c = c;
    }


    /*
    INITIALIZE VIEWHOLDER
     */

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.row_layout, parent, false);
        return new MyHolder(v);
    }

    /*
    BIND
     */
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        Product s = ProductList.get(position);

//        holder.txtCode.setText(s.getId());
        holder.txtName.setText(s.getName());
        holder.txtPrice.setText(s.getPrice() + " دلار ");
        Picasso.with(c).load(Config.Ip_Value + "/images/" + s.getPhoto()).into(holder.imgv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductActivity.product = s;
                c.startActivity(new Intent(c,ProductActivity.class));
            }
        });

    }

    /*
    TOTAL SPACECRAFTS NUM
     */
    @Override
    public int getItemCount() {
        return ProductList.size();
    }

    /*
    VIEW HOLDER CLASS
     */
    class MyHolder extends RecyclerView.ViewHolder {

        TextView txtCode;
        TextView txtName;
        TextView txtPrice;
        ImageView imgv;
//        Button b;

        public MyHolder(View itemView) {
            super(itemView);

//             txtCode = itemView.findViewById(R.id.rowTxtCode);
            txtName = itemView.findViewById(R.id.rowTxtProductName);
            txtPrice = itemView.findViewById(R.id.rowTxtPrice);
            imgv = itemView.findViewById(R.id.rowImgProduct);
        }
    }
}
