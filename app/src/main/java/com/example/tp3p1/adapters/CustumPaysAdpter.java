package com.example.tp3p1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tp3p1.R;

public class CustumPaysAdpter extends BaseAdapter {

    private Context context;
    private int[] flags;
    private String[] paysNoms;
    private LayoutInflater inflter;

    public CustumPaysAdpter(Context applicationContext, int[] flags, String[] paysNoms) {
        this.context = applicationContext;
        this.flags = flags;
        this.paysNoms = paysNoms;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imgP);
        TextView names = (TextView) view.findViewById(R.id.nomP);
        icon.setImageResource(flags[i]);
        names.setText(paysNoms[i]);
        return view;
    }
}
