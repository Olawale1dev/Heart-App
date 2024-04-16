package tso.brokenheart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.viewHolder> {

    Context context;
    ArrayList<SubjectModel> list;

    public SubjectAdapter(Context context, ArrayList<SubjectModel> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        if (list != null && list.size() > position) {
            SubjectModel model = list.get(position);

            if (holder.subjectName != null) {
                holder.subjectName.setText(model.getSubjectName());
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, pdfViewActivity.class);
                    intent.putExtra("name", model.getSubjectName());
                    intent.putExtra("position", position);
                    context.startActivity(intent); // Use startActivity instead of startActivities
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView subjectName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.moduleName);
        }
    }
}
