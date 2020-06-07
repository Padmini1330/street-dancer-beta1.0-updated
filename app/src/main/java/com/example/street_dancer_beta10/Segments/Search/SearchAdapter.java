package com.example.street_dancer_beta10.Segments.Search;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.street_dancer_beta10.R;
import com.example.street_dancer_beta10.Segments.Search.Model.Users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private Context Context;
    private List<Users> Users;
    private FirebaseUser firebaseUser;
    private boolean isFragment;

    public SearchAdapter(Context context, List<Users> users, boolean isFragment){
        Context = context;
        Users = users;
        this.isFragment = isFragment;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Context).inflate(R.layout.fragment_search_item, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchAdapter.ViewHolder holder, final int position) {

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        final Users user = Users.get(position);


        holder.username.setText(user.getName());


    }


    @Override
    public int getItemCount() {
        return Users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;

        public ViewHolder(View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);

        }
    }

}

