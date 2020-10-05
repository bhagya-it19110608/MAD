package com.example.myapplication123;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapterClass extends  RecyclerView.Adapter<UserAdapterClass.ViewHolder> {

        List<UserModuleClass> user;
        Context context;
        Database database;

    public UserAdapterClass(List<UserModuleClass> user, Context context) {
        this.user = user;
        this.context = context;
        database = new Database(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final UserModuleClass userModuleClass = user.get(position);

                holder.textViewID.setText(Integer.toString(userModuleClass.getId()));
                holder.editText_Name.setText(userModuleClass.getName());
                holder.editText_Email.setText(userModuleClass.getEmail());
                holder.editText_Age.setText(userModuleClass.getAge());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Email;
        EditText editText_Age;
        Button button_edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_Id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            editText_Age = itemView.findViewById(R.id.edittext_age);
            button_edit = itemView.findViewById(R.id.button_edit);
            button_delete = itemView.findViewById(R.id.button_delete);

        }
    }
}
