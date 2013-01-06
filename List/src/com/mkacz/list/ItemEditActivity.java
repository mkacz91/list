package com.mkacz.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ItemEditActivity extends Activity
{	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_edit);
        
        Intent intent = getIntent();
        final int position = intent.getIntExtra("position", -1);
        final EditText captionEditText	= (EditText) findViewById(
        		R.id.caption_edit_text);
        final EditText descriptionEditText	= (EditText) findViewById(
        		R.id.description_edit_text);
        Button cancelButton = (Button) findViewById(R.id.cancel_button);
        Button updateButton = (Button) findViewById(R.id.update_button);
        
        OnClickListener	listener = new OnClickListener()
        {
        	public void onClick(View view)
        	{
        		switch (view.getId())
        		{
        		case R.id.cancel_button:
        			setResult(Activity.RESULT_CANCELED);
        			break;
        		
        		case R.id.update_button:
        			Intent result = new Intent();
        			result.putExtra("position", position);
        			result.putExtra("caption",
        					captionEditText.getText().toString());
        			result.putExtra("description",
        					descriptionEditText.getText().toString());
        			setResult(Activity.RESULT_OK, result);
        			break;
        		}
        		
        		finish();
        	}
        };
        
        captionEditText.setText(intent.getStringExtra("caption"));
        descriptionEditText.setText(intent.getStringExtra("description"));
        cancelButton.setOnClickListener(listener);
        updateButton.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.activity_item_edit, menu);
        return true;
    }
}
