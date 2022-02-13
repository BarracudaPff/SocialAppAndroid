package com.samsung.socialappandroid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.samsung.socialappandroid.R;
import com.samsung.socialappandroid.models.User;

import java.util.Date;

public class UsersAdapter extends FirebaseRecyclerAdapter<User, UsersAdapter.UserViewHolder> {
    public UsersAdapter(@NonNull FirebaseRecyclerOptions<User> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull UserViewHolder holder, int position, @NonNull User model) {
        holder.bind(model);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView emailTextView;
        TextView nameTextView;
        TextView descriptionTextView;
        TextView creationDateTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            creationDateTextView = itemView.findViewById(R.id.timeTextView);
        }

        public void bind(User user) {
            emailTextView.setText(user.email);
            nameTextView.setText(user.name);
            descriptionTextView.setText(user.description);

            Date date = new Date(user.creationDate);
            String time = date.getHours() + ":" + date.getMinutes();
            creationDateTextView.setText(time);
        }
    }
}
