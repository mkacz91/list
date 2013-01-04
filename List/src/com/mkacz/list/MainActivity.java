package com.mkacz.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListItem[] items = new ListItem[] {
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
        };
        
        MyListAdapter adapter = new MyListAdapter(this, items);
        
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
