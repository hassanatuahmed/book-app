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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
        List<Books> postList;
        Context context;

        public PostAdapter(Context context, List<Books> posts){
            this.context=context;
            postList=posts;
        }

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
            return new PostViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PostViewHolder holder,  int position) {
            Books book =postList.get(position);
            holder.title.setText(book.getTitle());
            holder.author.setText(book.getAuthor());
            holder.publisher.setText(book.getPublisher());
            holder.price.setText(book.getPrice());
            Glide.with(context)
                    .asBitmap()
                    .load(book.getBook_image())
                    .into(holder.image);

//

            holder.itemView.setOnClickListener( view -> {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("title",postList.get(position).getTitle());
                intent.putExtra("author",postList.get(position).getAuthor());
                intent.putExtra("publisher",postList.get(position).getPublisher());
                intent.putExtra("price",postList.get(position).getPrice());
                intent.putExtra("image",postList.get(position).getBook_image());
                context.startActivity(intent);
            });

        }

        @Override
        public int getItemCount() {
            return postList.size();
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
