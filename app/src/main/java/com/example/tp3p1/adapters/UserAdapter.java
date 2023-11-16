package com.example.tp3p1.adapters;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tp3p1.R;
import com.example.tp3p1.model.Score;
import com.example.tp3p1.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<Score> scores;

    public UserAdapter(Context context, List<Score> scores) {
        this.context = context;
        this.scores = scores;
    }

    @Override
    public int getCount() {
        return scores.size();
    }

    @Override
    public Object getItem(int position) {
        return scores.get(position);
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
        TextView drapeauView = convertView.findViewById(R.id.drapeauChamp);
        TextView prenomView = convertView.findViewById(R.id.prenomChamp);
        TextView nomView = convertView.findViewById(R.id.nomChamp);
        TextView scoreView = convertView.findViewById(R.id.scoreChamp);
        TextView dateView = convertView.findViewById(R.id.dateChamp);

        // Obtenir l'objet User pour la position actuelle
        Score score = scores.get(position);

        // Définir les valeurs dans les TextView
        SpannableString spannableString = new SpannableString(score.getUser().getPays());
        spannableString.setSpan(new android.text.style.ForegroundColorSpan(android.graphics.Color.RED), 0, spannableString.length(), 0);
        drapeauView.setText(spannableString);
        prenomView.setText(score.getUser().getFirstName());
        nomView.setText(score.getUser().getLastName());
        scoreView.setText(String.valueOf(score.getNbEssais()));
        if(score.getDate() != null) dateView.setText(score.getDate().toString());

        // Retourner la vue mise à jour
        return convertView;
    }
}