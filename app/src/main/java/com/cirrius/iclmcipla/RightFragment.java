package com.cirrius.iclmcipla;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RightFragment extends Fragment {
    ListView lv;
    EditText editText;
    List<String[]> dataList = new ArrayList<String[]>();

    String[] Specialty = {"Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine",
            "Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine",
            "Nuclear cardiology", "Cardiac electrophysiology",
            "Urologic oncology", "Urologic oncology", "Neuromuscular Medicine"};
    String[] Class = {"Class B", "Class A", "Class C", "Class C", "Class B",
            "Class B", "Class A", "Class C", "Class C", "Class B", "Class B",
            "Class A", "Class C", "Class C", "Class B"};

    private String[] Drname = {"Mason Lopes", "Michael Jeremy", "Mike Gomez",
            "Michelle Cardoza", "Mabel D'costa", "Macaria D'souza",
            "Macra Dmello", "Macrina Colaco", "Madeleine Miles",
            "Madonna Pears", "Magda Mclachlan", "Magdalene Donavan",
            "Margaret Ricardo", "Maria Gonsalvez", "Macance Piers"};
    CustomAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        String index = getArguments().getString("index");
        View view = getView(index);
        return view;
    }

    public View getView(String index) {
        if (index.equals("1")) {
            LinearLayout parent = new LinearLayout(getActivity());
            parent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT));
            parent.setPadding(10, 0, 10, 0);
            parent.setBackgroundResource(R.drawable.bg_roundedgray);
            parent.setOrientation(LinearLayout.VERTICAL);
            editText = new EditText(getActivity());
            editText.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.ic_action_search, 0);
            editText.setHint("Physician Name/Patch");
            editText.addTextChangedListener(watcher);
            editText.setLayoutParams(new android.view.ViewGroup.LayoutParams(
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT));

            for (int i = 0; i < Drname.length; i++) {
                String[] str = {Drname[i], Specialty[i], Class[i]};
                dataList.add(str);
            }

            lv = new ListView(getActivity());
            lv.setLayoutParams(new android.view.ViewGroup.LayoutParams(
                    android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
            adapter = new CustomAdapter(getActivity(), dataList, 0);
            lv.setAdapter(adapter);
            parent.addView(editText);
            parent.addView(lv);
            return parent;
        } else if (index.equals("2")) {

        }
        return null;

    }

    TextWatcher watcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            // TODO Auto-generated method stub
            adapter.getFilter().filter(s.toString());
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub

        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub

        }
    };
}
