package com.hacks.collegebarter.Utils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hacks.collegebarter.R;
import com.parse.ParseObject;

public class CartListFeedAdapter extends ArrayAdapter<ParseObject> {
	// Fields
	protected Context currentContext;
	protected List<ParseObject> list;

	// Constructor
	public CartListFeedAdapter(Context context, ArrayList<ParseObject> itemsList) {
		super(context, R.layout.cart_list_adapter, itemsList);

		currentContext = context;
		list = itemsList;

	}

	static class ViewHolder {
		TextView itemDescription;
		TextView dateStamp;
		TextView itemPrice;
		ImageView itemImage;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;

		// Set up views if the convertView is null or use the default ones
		if (convertView == null) {
			convertView = LayoutInflater.from(currentContext).inflate(
					R.layout.cart_fragment, null);
			holder = new ViewHolder();
			holder.itemDescription = (TextView) convertView
					.findViewById(R.id.item_description);
			holder.itemImage = (ImageView) convertView
					.findViewById(R.id.item_image);
			holder.dateStamp = (TextView) convertView
					.findViewById(R.id.date_stamp);
			holder.itemPrice = (TextView) convertView
					.findViewById(R.id.item_price_value);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

}
