package com.example.gsonp1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private Context mContext;
    private List<MovieModelClass> mData;


    public Adapter(Context mContext, List<MovieModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.activity_detail, parent, false);

        return new MyViewHolder(v);
    }




    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {                                                              //♠
        holder.titulo.setText(mData.get(position).getTitulo());
        holder.director.setText(mData.get(position).getDirector());

         Glide.with(mContext)
                .load(mData.get(position).getPortada())
                .into(holder.portada);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class  MyViewHolder extends RecyclerView.ViewHolder{


        TextView titulo;
        TextView director;
        ImageView portada;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.titulo_textView);
            director = itemView.findViewById(R.id.director_textView);
            portada = itemView.findViewById(R.id.portada_imageView);
        }
    }
}
