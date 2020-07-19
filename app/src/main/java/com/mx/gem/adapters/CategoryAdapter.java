package com.mx.gem.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.mx.gem.Data;
import com.mx.gem.R;
import com.mx.gem.models.Cat;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context context ;
    private List<Cat> mData;


    public CategoryAdapter(Context context, List<Cat> mData) {
        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(context).inflate(R.layout.category,viewGroup,false);
        return new MyViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int position) {

        final String title =mData.get(position).getTitle();
        final int item1 = mData.get(position).getItem1();
        final int item2 = mData.get(position).getItem2();
        final int item3 = mData.get(position).getItem3();
        final int item4 = mData.get(position).getItem4();
        myViewHolder.TvTitle.setText(title);
        myViewHolder.Img1.setImageResource(item1);
        myViewHolder.Img2.setImageResource(item2);
        myViewHolder.Img3.setImageResource(item3);
        myViewHolder.Img4.setImageResource(item4);

        myViewHolder.cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, Data.class);
                intent.putExtra("cat_title",title);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView TvTitle;
        private de.hdodenhof.circleimageview.CircleImageView Img1,Img2,Img3,Img4;
        private ConstraintLayout cat;


        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            cat = itemView.findViewById(R.id.cat_card);
            TvTitle = itemView.findViewById(R.id.item_title);
            Img1 = itemView.findViewById(R.id.item_1);
            Img2 = itemView.findViewById(R.id.item_2);
            Img3 = itemView.findViewById(R.id.item_3);
            Img4 = itemView.findViewById(R.id.item_4);
        }
    }
}
