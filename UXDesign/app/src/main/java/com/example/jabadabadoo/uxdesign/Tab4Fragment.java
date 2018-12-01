package com.example.jabadabadoo.uxdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Tab4Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4_fragment, container, false);

        ListView resultListView = (ListView)view.findViewById(R.id.ListViewFragment4);
        resultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), FoodActivity.class);
                startActivity(intent);
            }
        });


        HashMap<String, String> foodMenuItems = new HashMap<>();
        foodMenuItems.put("Pomfritter", "Firkantede kartoffler");
        foodMenuItems.put("Spagetthi med Ketchup", "En ret for fattige studerende");
        foodMenuItems.put("Pandekager", "Med Fyld");
        foodMenuItems.put("Lagsagne", "Som mor laver den");
        foodMenuItems.put("Ghost Pebber Salat", "Stakkels børn");

        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(getContext(), listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.tv1, R.id.tv2});

        Iterator it = foodMenuItems.entrySet().iterator();

        while (it.hasNext())
        {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry)it.next();
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }
        resultListView.setAdapter(adapter);
        return view;
    }
}