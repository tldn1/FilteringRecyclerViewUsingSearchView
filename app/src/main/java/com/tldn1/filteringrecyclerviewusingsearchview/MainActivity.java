package com.tldn1.filteringrecyclerviewusingsearchview;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    String[] title = {"Mico","Bozo","Zoka","Zoran","Lela","Mile","Bane"};
    int[] images = {R.drawable.android5,R.drawable.android5,R.drawable.android5,R.drawable.android5,R.drawable.android5,R.drawable.android5,R.drawable.android5};
    ArrayList<Model> arrayList = new ArrayList<>();
    RecyclerAdapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        for(int i=0;i<images.length;i++){
            Model model = new Model(title[i],images[i]);
            arrayList.add(model);
        }
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Model> newList = new ArrayList<>();
        for(Model model:arrayList){
            String title = model.getTitle().toLowerCase();
            if(title.contains(newText)){
                newList.add(model);
            }
        }
        adapter.setFilter(newList);
        return true;
    }
}
