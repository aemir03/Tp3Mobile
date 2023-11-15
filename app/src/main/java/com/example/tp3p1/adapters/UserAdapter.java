package com.example.tp3p1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tp3p1.R;
import com.example.tp3p1.model.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> userList;

    public UserAdapter(Context context, ArrayList<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_score, parent, false);
        }

        // Récupérer les éléments de la mise en page
        TextView textViewFirstName = convertView.findViewById(R.id.drapeauChamp);
        TextView textViewLastName = convertView.findViewById(R.id.prenomChamp);
        TextView textViewEmail = convertView.findViewById(R.id.scoreChamp);

        // Obtenir l'objet User pour la position actuelle
        User user = userList.get(position);

        // Définir les valeurs dans les TextView
        textViewFirstName.setText("First Name: " + user.getFirstName());
        textViewLastName.setText("Last Name: " + user.getLastName());
        textViewEmail.setText("Email: " + user.getEmail());

        // Retourner la vue mise à jour
        return convertView;
    }
}
