package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.enclavemobileapp.DetailProjectActivity;
import com.example.enclavemobileapp.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;
import model.Project;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ExampleViewHolder>{
    private Context context;

    private ArrayList<Project> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNameTeam;
        public TextView txtNameProject;
        public TextView txtTotalMember, technology, txtStatus;
        CircleImageView imgLanguage;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            txtNameTeam = itemView.findViewById(R.id.txt_nameProject);
            txtNameProject = itemView.findViewById(R.id.txt_category);
            txtTotalMember = itemView.findViewById(R.id.txt_earning);
            imgLanguage = itemView.findViewById(R.id.img_language);
            technology = itemView.findViewById(R.id.txt_technology);
            txtStatus = itemView.findViewById(R.id.txt_status);
        }
    }

    public ProjectAdapter(Context context, ArrayList<Project> exampleList) {
        mExampleList = exampleList;
        this.context = context;
    }

    @Override
    public ProjectAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item,
                parent, false);
        ProjectAdapter.ExampleViewHolder evh = new ProjectAdapter.ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ExampleViewHolder viewHolder, int i) {
        final Project currentItem = mExampleList.get(i);
        viewHolder.txtNameTeam.setText(currentItem.getNameProject());
        viewHolder.txtNameProject.setText(currentItem.getCategory());
        viewHolder.txtTotalMember.setText(currentItem.getEarning()+"");
        viewHolder.technology.setText(currentItem.getTechnology());

        if (currentItem.getStatus().toUpperCase().equals("INPROGRESS")){
            viewHolder.txtStatus.setText(currentItem.getStatus().toUpperCase());
            viewHolder.txtStatus.setBackgroundColor(Color.GREEN);
        } else  if (currentItem.getStatus().toUpperCase().equals("DONE")){
            viewHolder.txtStatus.setText(currentItem.getStatus().toUpperCase());
            viewHolder.txtStatus.setBackgroundColor(Color.RED);
        } else  if (currentItem.getStatus().toUpperCase().equals("PENDING")){
            viewHolder.txtStatus.setText(currentItem.getStatus().toUpperCase());
            viewHolder.txtStatus.setBackgroundColor(Color.YELLOW);
        }

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailProjectActivity.class);
                intent.putExtra("id", currentItem.getId());
                context.startActivity(intent);
            }
        });

        String language = currentItem.getTechnology();
        switch (language){
            case "Swift":
                Picasso.get().load(R.drawable.swift).into(viewHolder.imgLanguage);
                break;
            case "TypeScript":
                Picasso.get().load(R.drawable.typescript).into(viewHolder.imgLanguage);
                break;
            case "React Native":
                Picasso.get().load(R.drawable.react_native).into(viewHolder.imgLanguage);
                break;
            case "Angular JS":
                Picasso.get().load(R.drawable.angular).into(viewHolder.imgLanguage);
                break;
            case "VueJS":
                Picasso.get().load(R.drawable.vuejs).into(viewHolder.imgLanguage);
                break;
            case "Go lang":
                Picasso.get().load(R.drawable.go_lang).into(viewHolder.imgLanguage);
                break;
            case "Objective-C":
                Picasso.get().load(R.drawable.object_c).into(viewHolder.imgLanguage);
                break;
            case "R":
                Picasso.get().load(R.drawable.r).into(viewHolder.imgLanguage);
                break;
            case "Nodejs":
                viewHolder.technology.setVisibility(View.GONE);
                Picasso.get().load(R.drawable.nodejs).into(viewHolder.imgLanguage);
                break;
            case "PHP":
                viewHolder.technology.setVisibility(View.GONE);
                Picasso.get().load(R.drawable.php).into(viewHolder.imgLanguage);
                break;
            case "JavaScript":
                Picasso.get().load(R.drawable.javascript).into(viewHolder.imgLanguage);
                break;
            case "Java":
                viewHolder.technology.setVisibility(View.GONE);
                Picasso.get().load(R.drawable.java).into(viewHolder.imgLanguage);
                break;
            case "C/C++":
                viewHolder.technology.setVisibility(View.GONE);
                Picasso.get().load(R.drawable.cccc).into(viewHolder.imgLanguage);
                break;
            case "Python":
                Picasso.get().load(R.drawable.python).into(viewHolder.imgLanguage);
                break;
            case "Ruby":
                Picasso.get().load(R.drawable.ruby).into(viewHolder.imgLanguage);
                break;
            case "Visual Basic":
                Picasso.get().load(R.drawable.visual_basic).into(viewHolder.imgLanguage);
                break;
            case "Kotlin":
                Picasso.get().load(R.drawable.kotlin).into(viewHolder.imgLanguage);
                break;
            case "Perl":
                Picasso.get().load(R.drawable.perl).into(viewHolder.imgLanguage);
                break;
            case "ReactJS":
                Picasso.get().load(R.drawable.react_native).into(viewHolder.imgLanguage);
                break;
            case "C#":
                viewHolder.technology.setVisibility(View.GONE);
                Picasso.get().load(R.drawable.c_sharp).into(viewHolder.imgLanguage);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public void filterList(ArrayList<Project> filteredList) {
        mExampleList = filteredList;
        notifyDataSetChanged();
    }
}
