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
        		new ListItem("Mieszkam w Legnicy", "Mie�cie wielu ludzi"),
        		new ListItem("Twoja stara", "Mieszka w piwnicy"),
        		new ListItem("Ser za 5 z�", "Taniej ju� nie b�dzie"),
        		new ListItem("Poemat", "Dzisiaj jest co� fajnego\n Jutro nie b�dzie"),
        		new ListItem("Wojtek", "Ma psa i jest super"),
        		new ListItem("Java", "Jest nawet w porz�dku"),
        		new ListItem("Paluszki rybne", "Najlepsze paluszki rybne robi lisner"),
        		new ListItem("D�ugi tekst", "Jaki� d�ugi tekst, kt�re teoretycznie " +
        				"powinien si� zawin��, bo nie zmie�ci si� na ekranie"),
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
