package com.example.vaibhav.login1e.exams;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vaibhav.login1e.R;
import com.example.vaibhav.login1e.dashboard.model.CitystateList;
import com.example.vaibhav.login1e.dashboard.model.Jobrole;
import com.example.vaibhav.login1e.dashboard.model.SectorSsc;
import com.example.vaibhav.login1e.dashboard.model.StateList;

import java.util.ArrayList;
import java.util.Locale;


class ListDataAdapter extends BaseAdapter {
    private final ArrayList<Parcelable> list;
    private final Activity activity;
    private final LayoutInflater layoutInflater;
    private final ArrayList<Parcelable> arraylist;

    public ListDataAdapter(ArrayList<Parcelable> list, Activity activity) {
        this.list = list;
        this.activity = activity;
        this.arraylist = new ArrayList<Parcelable>();
        this.arraylist.addAll(list);
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View vh = convertView;
        if (convertView == null) {
            vh = layoutInflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        }

        TextView text = (TextView) vh;
        String itemName = null;

        if (text != null) {
            if (list.get(i) instanceof SectorSsc) {
                SectorSsc sectorSsc = (SectorSsc) list.get(i);
                itemName = sectorSsc.getSscName();
            } else if (list.get(i) instanceof Jobrole) {
                Jobrole jobrole = (Jobrole) list.get(i);
                itemName = jobrole.getJobrole();
            }else if(list.get(i) instanceof StateList){
                StateList stateList = (StateList) list.get(i);
                itemName = stateList.getState();
            }else if(list.get(i) instanceof CitystateList){
                itemName=((CitystateList) list.get(i)).getCity();
            }
            if (itemName != null) {
                text.setText(itemName);
            }
        }


        return vh;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        list.clear();
        if (charText.length() == 0) {
            list.addAll(arraylist);
        } else {
            for (Parcelable wp : arraylist) {
                if(wp instanceof SectorSsc){
                    SectorSsc sectorSsc= (SectorSsc) wp;
                    if (sectorSsc.getSscName().toLowerCase(Locale.getDefault())
                            .contains(charText)) {
                        list.add(wp);
                    }
                }

            }
        }
        notifyDataSetChanged();
    }


}

