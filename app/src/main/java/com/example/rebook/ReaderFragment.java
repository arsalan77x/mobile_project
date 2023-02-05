package com.example.rebook;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class ReaderFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public ReaderFragment() {
        // Required empty public constructor
    }


    public static ReaderFragment newInstance(String param1, String param2) {
        ReaderFragment fragment = new ReaderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_reader, container, false);
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);



        TextView t = (TextView) v.findViewById(R.id.page1);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView c1 = (TextView) v.findViewById(R.id.content1);
        c1.setText(ReaderActivity.contentList.get(pageAdapter.counter));
        pageAdapter.counter += 1;
        t.setText(Integer.toString(pageAdapter.counter));
        return v;

    }
}