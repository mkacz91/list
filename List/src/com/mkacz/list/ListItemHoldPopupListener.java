package com.mkacz.list;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;


public class ListItemHoldPopupListener implements OnClickListener
{
	private final MyListAdapter	adapter;
	private final int			position;
	private final PopupWindow	popup;
	
	ListItemHoldPopupListener(MyListAdapter adapter, int itemPosition, PopupWindow popup)
	{
		this.adapter	= adapter;
		this.position	= itemPosition;
		this.popup		= popup;
	}
	
	public void onClick(View view)
	{
		switch (view.getId())
		{
		case R.id.item_edit_button:
			ListItem item = adapter.getItem(position);
			Intent intent = new Intent(view.getContext(),
					ItemEditActivity.class);
			MainActivity main = (MainActivity) view.getContext();
			intent.putExtra("position", position);
			intent.putExtra("caption", item.getCaption());
			intent.putExtra("description", item.getDescription());
			main.startActivityForResult(intent, main.REQUEST_EDIT);
			break;
			
		case R.id.item_delete_button:
			adapter.removeItem(position);
			adapter.notifyDataSetChanged();
			break;
		}
		
		popup.dismiss();
	}
}
