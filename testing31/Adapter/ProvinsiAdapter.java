package com.example.testing31.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testing31.Model.Provinsi;
import com.example.testing31.R;
import java.util.List;

public class ProvinsiAdapter extends ArrayAdapter<Provinsi> {
    private List<Provinsi> provinsiList;
    private Context mCtx;

    public ProvinsiAdapter(List<Provinsi> P,Context c){
        super(c, R.layout.listprovinsi,P);
        this.provinsiList = P;
        this.mCtx = c;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.listprovinsi,null,true);
        TextView name =(TextView) view.findViewById(R.id.tvNameprov);
        TextView id =(TextView) view.findViewById(R.id.tvidprov);
        Provinsi provinsi = provinsiList.get(position);
        name.setText(provinsi.getName());
        id.setText(provinsi.getId());
        return view;

    }
}

