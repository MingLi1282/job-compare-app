package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.database.JobDao;
import edu.gatech.seclass.jobcompare6300.database.JobDatabase;
import edu.gatech.seclass.jobcompare6300.model.Job;

public class CompareOffersAdaptor extends RecyclerView.Adapter<CompareOffersAdaptor.MyViewHolder> {

    private Context context;
    private List<Job> jobs;

    public CompareOffersAdaptor(Context context, List<Job> jobs){
        this.context = context;
        this.jobs = jobs;

    }

    @NonNull
    @Override
    public CompareOffersAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.recyclerview_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompareOffersAdaptor.MyViewHolder holder, int position) {
        JobDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                JobDatabase.class, "job-db").allowMainThreadQueries().build();
        JobDao jobDao = db.jobDao();
        int currentJobID = jobDao.getCurrentJob().get(0).getJobId();
        holder.index.setText(Integer.toString(jobs.get(position).getJobId()));
        holder.title.setText(jobs.get(position).getTitle());
        if(jobs.get(position).getJobId() == currentJobID){
            holder.title.setTypeface(Typeface.DEFAULT_BOLD);
            holder.title.setTextColor(Color.rgb(93, 63, 211));
            holder.company.setTypeface(Typeface.DEFAULT_BOLD);
            holder.company.setTextColor(Color.rgb(93, 63, 211));
            holder.index.setTypeface(Typeface.DEFAULT_BOLD);
            holder.index.setTextColor(Color.rgb(93, 63, 211));
            holder.jobScore.setTypeface(Typeface.DEFAULT_BOLD);
            holder.jobScore.setTextColor(Color.rgb(93, 63, 211));
        }
        else{
            holder.title.setTypeface(Typeface.DEFAULT);
            holder.title.setTextColor(Color.rgb(128, 128, 128));
            holder.company.setTypeface(Typeface.DEFAULT);
            holder.company.setTextColor(Color.rgb(128, 128, 128));
            holder.index.setTypeface(Typeface.DEFAULT);
            holder.index.setTextColor(Color.rgb(128, 128, 128));
            holder.jobScore.setTypeface(Typeface.DEFAULT);
            holder.jobScore.setTextColor(Color.rgb(128, 128, 128));
        }
        holder.company.setText(jobs.get(position).getCompany());
        holder.jobScore.setText(Double.toString(jobs.get(position).getJobScore()));
    }

    @Override
    public int getItemCount() {
        return this.jobs.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView index;
        TextView title;
        TextView company;
        TextView jobScore;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            index = itemView.findViewById(R.id.Index_RecyclerView);
            title = itemView.findViewById(R.id.Title_RecyclerView);
            company = itemView.findViewById(R.id.Company_RecyclerView);
            jobScore = itemView.findViewById(R.id.JobScore_RecyclerVIew);
        }
    }
}
