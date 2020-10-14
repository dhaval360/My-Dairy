package com.example.mydairy;

import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.WordViewHolder> {
   // private DataBase db;
    private List<notesDataObject> list = new ArrayList<>();


    public recycleAdapter(List<notesDataObject> list){
       // this.db = db;
        this.list = list;

    }



    @NonNull
    @Override
    public recycleAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new WordViewHolder(view,this);
    }



    @Override
    public void onBindViewHolder(@NonNull recycleAdapter.WordViewHolder holder, int position) {

        holder.date.setText(list.get(position).getDate());
        holder.note.setText(list.get(position).getNoteData());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        recycleAdapter adapter;
        TextView date;
        TextView note;
        public WordViewHolder(@NonNull View itemView,recycleAdapter adapter) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            note = (TextView) itemView.findViewById(R.id.note);
            this.adapter = adapter;
        }
    }
}
