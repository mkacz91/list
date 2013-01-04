package com.mkacz.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyListAdapter extends BaseAdapter
{
	private final LayoutInflater	inflater;
	private final ListItem[]		items;
	
	public MyListAdapter(Context context, ListItem[] items)
	{
		this.inflater	= (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.items		= items;
	}
	
	public int getCount()
	{
		return items.length;
	}
	
	public Object getItem(int position)
	{
		return items[position];
	}
	
	public long getItemId(int position)
	{
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View view	= convertView != null
					? convertView
					: inflater.inflate(R.layout.list_item, parent, false);
		
		ListItem item			= items[position];
		CheckBox checkBox		= (CheckBox) view.findViewById(R.id.item_check_box);
		TextView caption		= (TextView) view.findViewById(R.id.item_caption);
		TextView description	= (TextView) view.findViewById(R.id.item_description);
		
		checkBox.setChecked(item.isChecked());
		checkBox.setOnCheckedChangeListener(item);
		caption.setText(item.getCaption());
		description.setText(item.getDescription());
		
		return view;
	}
}
