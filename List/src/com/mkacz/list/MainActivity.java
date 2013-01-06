package com.mkacz.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{
	final int REQUEST_EDIT	= 1;
	final int REQUEST_ADD	= 2;
	
	private final List<ListItem> items = new LinkedList<ListItem>();
	private MyListAdapter adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateList();
        
        ListView listView = (ListView) findViewById(R.id.list_view);
        MyOnItemClickListener listener = new MyOnItemClickListener(this);
        adapter = new MyListAdapter(this, items);
        
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	if (resultCode != RESULT_OK) return;
    	
    	switch (requestCode)
    	{
    	case REQUEST_EDIT:
    		ListItem item = adapter.getItem(data.getIntExtra("position", -1));
    		item.setCaption(data.getStringExtra("caption"));
    		item.setDescription(data.getStringExtra("description"));
    		adapter.notifyDataSetInvalidated();
    		Toast toast = Toast.makeText(this, "Edit returned!", Toast.LENGTH_SHORT);
    		toast.show();
    		break;
    		
    	case REQUEST_ADD:
    		break;
    	}
    }
    
    private void populateList()
    {
    	items.addAll(Arrays.asList(
        		new ListItem("Ala", "Ma kota i jest super"),
        		new ListItem("Mieszkam w Legnicy", "Mieœcie wielu ludzi"),
        		new ListItem("Twoja stara", "Mieszka w piwnicy"),
        		new ListItem("Ser za 5 z³", "Taniej ju¿ nie bêdzie"),
        		new ListItem("Poemat", "Dzisiaj jest coœ fajnego\n Jutro nie bêdzie"),
        		new ListItem("Wojtek", "Ma psa i jest super"),
        		new ListItem("Java", "Jest nawet w porz¹dku"),
        		new ListItem("Paluszki rybne", "Najlepsze paluszki rybne robi lisner"),
        		new ListItem("D³ugi tekst", "Jakiœ d³ugi tekst, które teoretycznie " +
        				"powinien siê zawin¹æ, bo nie zmieœci siê na ekranie"),
        		new ListItem("Ostatni wpis", "To jest ostatni wpis ze wszystkich")
        ));
    }
}
