package com.example.books;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.PostViewHolder> {
    List<BookEntity> booksList;


    Context context;

    public Adapter(Context context, List<BookEntity> books){
        this.context=context;
        booksList =books;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder,  int position) {
        BookEntity book = booksList.get(position);
        holder.title.setText(book.getBookTitle());
        holder.author.setText(book.getBookAuthor());
        holder.publisher.setText(book.getBookPublisher());
        holder.price.setText(book.getBookPrice());
        Glide.with(context)
                .asBitmap()
                .load(book.getBook_image())
                .into(holder.image);

//
//
//        holder.itemView.setOnClickListener( view -> {
//            Intent intent = new Intent(context,DetailActivity.class);
//            intent.putExtra("title", booksList.get(position).getTitle());
//            intent.putExtra("author", booksList.get(position).getAuthor());
//            intent.putExtra("publisher", booksList.get(position).getPublisher());
//            intent.putExtra("price", booksList.get(position).getPrice());
//            intent.putExtra("image", booksList.get(position).getBook_image());
//            context.startActivity(intent);
//        });

    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView title,author,publisher,price;
        RecyclerView parent;
        CircleImageView image;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            author=itemView.findViewById(R.id.author);
            publisher=itemView.findViewById(R.id.publisher);
            price=itemView.findViewById(R.id.price);
            parent=itemView.findViewById(R.id.recycleView);
            image=itemView.findViewById(R.id.circleImage);

        }
    }
}
