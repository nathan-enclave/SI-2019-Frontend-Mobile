package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.enclavemobileapp.DetailEnActivity;
import com.example.enclavemobileapp.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;
import model.Person;

public class ListEngineerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int resource;
    Context context;
    ArrayList<Person> personsList;

    public ListEngineerAdapter(Activity context, ArrayList<Person> personsList) {
        this.context = context;
        this.personsList = personsList;
    }

    public void  updatePersonList(ArrayList<Person> personsList) {
        this.personsList = personsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ViewGroup group = (ViewGroup) layoutInflater.inflate(R.layout.items_person_in_project, viewGroup, false);
        ListEngineerAdapter.PersonViewHolder personViewHolder = new ListEngineerAdapter.PersonViewHolder(group);
        return personViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ListEngineerAdapter.PersonViewHolder){
            PersonViewHolder personViewHolder = (PersonViewHolder) viewHolder;
            personViewHolder.txtName.setText(personsList.get(i).getName());
            personViewHolder.txtEmail.setText(personsList.get(i).getSkype());
            final String avatar = personsList.get(i).getAvatar();
            // Set avatar
            Picasso.get().load(avatar).into(personViewHolder.imgPerson);
            if (personsList.get(i).getRole().toUpperCase().equals("DEVELOPER") ){
                personViewHolder.txtRole.setBackgroundColor(Color.GREEN);
                personViewHolder.txtRole.setText("DEV");
            } else if (personsList.get(i).getRole().toUpperCase().equals("LEADER") ){
                personViewHolder.txtRole.setBackgroundColor(Color.RED);
                personViewHolder.txtRole.setText(personsList.get(i).getRole().toUpperCase());
            } else if (personsList.get(i).getRole().toUpperCase().equals("QUALITY ASSURANCE") ){
                personViewHolder.txtRole.setText("QA");
                personViewHolder.txtRole.setBackgroundColor(Color.YELLOW);
            }
            final int id = personsList.get(i).getId();
            personViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetailEnActivity.class);
                    intent.putExtra("id", id);
                    intent.putExtra("avatar",avatar);
                    context.startActivity(intent);
                }
            });
    }
}

    @Override
    public int getItemCount() {
        return personsList.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder {
            TextView txtName, txtEmail, txtRole;
            CircleImageView imgPerson;
        public PersonViewHolder(@NonNull View itemView) {
                super(itemView);
                txtName = itemView.findViewById(R.id.txt_person_name);
                txtEmail = itemView.findViewById(R.id.txt_skype);
                imgPerson = itemView.findViewById(R.id.person_avatar);
                txtRole = itemView.findViewById(R.id.txt_role);
            }
        }
    }

