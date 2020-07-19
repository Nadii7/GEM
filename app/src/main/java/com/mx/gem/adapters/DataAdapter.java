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

import com.mx.gem.Finish;
import com.mx.gem.R;
import com.mx.gem.models.Catitem;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private Context context ;
    private List<Catitem> mData;


    public DataAdapter(Context context, List<Catitem> mData) {
        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        LayoutInflater inflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(context).inflate(R.layout.category_item,viewGroup,false);
        return new MyViewHolder(view);


        }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int position) {

        final String title =mData.get(position).getItem_title();
        final String description =mData.get(position).getItem_description();
        final int img = mData.get(position).getItem_pic();
        final int qr = mData.get(position).getItem_qr();
        myViewHolder.CTitle.setText(title);
        myViewHolder.CImg.setImageResource(img);

        myViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Finish.class);
                intent.putExtra("name",title);
                intent.putExtra("pic",img);
                intent.putExtra("qr",qr);
                intent.putExtra("des",description);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView CTitle;
        private ImageView CImg;
        private ConstraintLayout layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            CTitle =itemView.findViewById(R.id.cat_item_title);
            CImg =itemView.findViewById(R.id.cat_item_img);
            layout = itemView.findViewById(R.id.cat_item_card);
        }
    }
}
