package com.example.communityapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.communityapp.Adapter.FreelanceTaskAdapter;
import com.example.communityapp.Adapter.GDZBookAdapter;
import com.example.communityapp.Entities.BookEntity;
import com.example.communityapp.Entities.FreelanceTaskEntity;
import com.example.communityapp.R;
import com.example.communityapp.Utils.DateUtil;

import java.util.ArrayList;


public class GdzBookListFragment extends Fragment {

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public GdzBookListFragment() {
//        // Required empty public constructor
//    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment GdzBookListFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static GdzBookListFragment newInstance(String param1, String param2) {
//        GdzBookListFragment fragment = new GdzBookListFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    private RecyclerView.Adapter bookAdapter;
    private RecyclerView bookRecycler;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gdz_book_list, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        BookEntity book1 = new BookEntity();
        book1.title = "Физика 10 класс Мякишев";
        book1.authors = "Мякишева Г.Я.,Буховцева Б.Б., Сотского Н.Н";
        book1.classIndex = 10;
        book1.subjectName = "Физика";

        BookEntity book2 = new BookEntity();
        book2.title = "ГДЗ по Алгебре за 8 класс Учебник ФГОС";
        book2.authors = "Ю.Н. Макарычев, Н.Г. Миндюк, К.И. Нешков, С.Б. Суворова";
        book2.classIndex = 8;
        book2.subjectName = "Математика";


        ArrayList<BookEntity> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book1);
        books.add(book2);
        books.add(book1);
        books.add(book2);
        books.add(book1);
        books.add(book2);

        layoutManager = new LinearLayoutManager(getActivity());
        bookAdapter = new GDZBookAdapter(books);

        bookRecycler = getActivity().findViewById(R.id.gdz_book_recycler_view);
        bookRecycler.setLayoutManager(layoutManager);
        bookRecycler.setAdapter(bookAdapter);
    }
}