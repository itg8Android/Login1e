package com.example.vaibhav.login1e.exams;


import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.vaibhav.login1e.R;
import com.example.vaibhav.login1e.common.DialogListFragmentListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListDataFragment extends DialogFragment implements AdapterView.OnItemClickListener, TextWatcher {


    @BindView(R.id.data_search)
    EditText dataSearch;
    @BindView(R.id.list_sector)
    ListView listSector;
    private ArrayList<Parcelable> list;
    private String title;
    private ListDataAdapter dataAdapter;
    private DialogListFragmentListener listner;

    public ListDataFragment() {
        // Required empty public constructor
    }


    public static ListDataFragment getInstance(Object data, String title) {
        ListDataFragment f = new ListDataFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) data);
        args.putString("hint", title);
        f.setArguments(args);
        return f;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        list = b.getParcelableArrayList("data");
        title = b.getString("hint");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_data, container, false);
        ButterKnife.bind(this, view);

        dataSearch.setHint(title);

        dataAdapter=new ListDataAdapter(list,getActivity());
        listSector.setAdapter(dataAdapter);
        listSector.setOnItemClickListener(this);
        dataSearch.addTextChangedListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listner=(DialogListFragmentListener) context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        listner.getSelectedItem(list.get(i));
        dismiss();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        dataAdapter.filter(charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {
    }
}
