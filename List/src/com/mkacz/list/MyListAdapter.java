package com.mkacz.list;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter<ListItem>
{
	private final LayoutInflater	inflater;
	private final List<ListItem>	items;
	
	public MyListAdapter(Context context, List<ListItem> items)
	{
		super(context, R.layout.list_item, items);
		
		this.inflater = (LayoutInflater) context.getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);
		this.items = items;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View view	= convertView != null
					? convertView
					: inflater.inflate(R.layout.list_item, parent, false);
		
		ListItem item = items.get(position);
		CheckBox checkBox = (CheckBox) view.findViewById(R.id.item_check_box);
		TextView caption = (TextView) view.findViewById(R.id.item_caption);
		TextView description = (TextView) view.findViewById(
				R.id.item_description);
		
		checkBox.setOnCheckedChangeListener(null);
		checkBox.setChecked(item.isChecked());
		checkBox.setOnCheckedChangeListener(item);
		caption.setText(item.getCaption());
		description.setText(item.getDescription());
		
		return view;
	}
	
	public void removeItem(int position)
	{
		items.remove(position);
	}
}
