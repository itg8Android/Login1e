package com.example.vaibhav.login1e.exams;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vaibhav.login1e.R;
import com.example.vaibhav.login1e.login.model.TodayExams;

public class Todays_Exams extends RecyclerView.Adapter<Todays_Exams.ViewHolder> {

    private RecyclerView recyclerView;




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclar_view,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.examtitle.setText("title");
        holder.centerno.setText("2");
        holder.location.setText("Nagpur");
        holder.date.setText(3-3-17);

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView examtitle;
        TextView centerno;
        TextView location;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);

            examtitle = (TextView) itemView.findViewById(R.id.text_exam_title);
            centerno = (TextView) itemView.findViewById(R.id.center_no);
            location = (TextView) itemView.findViewById(R.id.location_center);
            date = (TextView) itemView.findViewById(R.id.date_time_exam);
        }
    }
}
