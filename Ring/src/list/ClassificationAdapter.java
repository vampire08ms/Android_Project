package list;

import java.util.List;

import com.example.ring.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ClassificationAdapter extends ArrayAdapter<Classification> {

	private int resourceId;

	public ClassificationAdapter(Context context,	int textViewResourceId, List<Classification> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Classification standard = getItem(position);
		View view = null;
		ViewHolder viewHolder = null;
		if (null == convertView) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.classificationName = (TextView) view.findViewById(R.id.classification_name);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.classificationName.setText(standard.getName());
		return view;
	}

}

class ViewHolder {
	TextView classificationName;
}