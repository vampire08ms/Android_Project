package com.example.ring;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TreasureAdapter extends ArrayAdapter<Treasure> {

	private int resourceId;

	public TreasureAdapter(Context context, int textViewResourceId,
			List<Treasure> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Treasure treasure = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (null == convertView) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.treasureImage = (ImageView) view
					.findViewById(R.id.treasure_image);
			viewHolder.treasureName = (TextView) view
					.findViewById(R.id.treasure_name);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.treasureImage.setImageResource(treasure.getImageId());
		viewHolder.treasureName.setText(treasure.getName());
		return view;
	}
};

class ViewHolder {
	ImageView treasureImage;
	TextView treasureName;
}