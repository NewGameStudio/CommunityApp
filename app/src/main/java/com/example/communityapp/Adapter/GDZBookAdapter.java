package com.example.communityapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Entities.BookEntity;
import com.example.communityapp.R;

import java.util.ArrayList;

public class GDZBookAdapter extends RecyclerView.Adapter<GDZBookAdapter.GDZBookViewHolder> {

    public static class GDZBookViewHolder extends RecyclerView.ViewHolder {

        public TextView bookTitle;
        public TextView authors;
        public ImageView bookCover;
        public TextView bookClass;
        public TextView bookSubject;

        public GDZBookViewHolder(@NonNull View itemView) {
            super(itemView);

            bookTitle = itemView.findViewById(R.id.gdz_book_title);
            authors = itemView.findViewById(R.id.gdz_book_authors);
            bookCover = itemView.findViewById(R.id.gdz_book_cover);
            bookClass = itemView.findViewById(R.id.gdz_book_class);
            bookSubject = itemView.findViewById(R.id.gdz_book_subject);
        }
    }

    private ArrayList<BookEntity> books;

    public GDZBookAdapter(ArrayList<BookEntity> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public GDZBookAdapter.GDZBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gdz_book_card_view, parent, false);

        return new GDZBookAdapter.GDZBookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GDZBookAdapter.GDZBookViewHolder holder, int position) {
        BookEntity currentBook = books.get(position);

        holder.bookTitle.setText(currentBook.title);
        holder.authors.setText(currentBook.authors);
//        holder.bookClass.setText(currentBook.classIndex);
//        holder.bookSubject.setText(currentBook.subjectName);
//        holder.bookCover.setImageResource(currentBook.imageResId);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}