package com.example.communityapp.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communityapp.Entities.Textbook;
import com.example.communityapp.R;

import java.util.ArrayList;

public class TextbookAdapter extends RecyclerView.Adapter<TextbookAdapter.TextbookViewHolder> {

    public static class TextbookViewHolder extends RecyclerView.ViewHolder {

        public TextView bookTitle;
        public TextView authors;
        public ImageView bookCover;
        public TextView bookClass;
        public TextView bookSubject;

        public TextbookViewHolder(@NonNull View itemView) {
            super(itemView);

            bookTitle = itemView.findViewById(R.id.textbook_title);
            bookCover = itemView.findViewById(R.id.textbook_cover);
            authors = itemView.findViewById(R.id.textbook_authors);
            bookClass = itemView.findViewById(R.id.textbook_class);
            bookSubject = itemView.findViewById(R.id.textbook_subject);
        }
    }

    private ArrayList<Textbook> textbooks;

    public TextbookAdapter(ArrayList<Textbook> books) {
        this.textbooks = books;
    }

    @NonNull
    @Override
    public TextbookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.textbook_card_view, parent, false);

        return new TextbookViewHolder(view);
    }

    @Override
    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull TextbookViewHolder holder, int position) {
        Textbook currentBook = textbooks.get(position);

        String authorsNames = "";

        for (String author : currentBook.getAuthors())
            authorsNames += author + ", ";

        authorsNames = authorsNames.substring(0, authorsNames.length() - 2);

        holder.bookTitle.setText(currentBook.getTextbookTitle());
        holder.authors.setText(authorsNames);
        holder.bookClass.setText(Integer.toString(currentBook.getClassIndex()));
        holder.bookSubject.setText(currentBook.getSubjectName());
        holder.bookCover.setImageBitmap(currentBook.getTextbookCover());
    }

    @Override
    public int getItemCount() {
        return textbooks.size();
    }
}