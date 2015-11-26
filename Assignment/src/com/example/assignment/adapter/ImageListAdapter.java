package com.example.assignment.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.assignment.R;
import com.example.assignment.model.Element;
import com.squareup.picasso.Picasso;

public class ImageListAdapter extends BaseAdapter {

	private Context mContext;
	private List<Element> dataList;
	private LayoutInflater inflater = null;

	public ImageListAdapter(Context context, List<Element> dataList) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.dataList = dataList;

		inflater = (LayoutInflater) this.mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		View rowView = convertView;
		ViewHolder holder; // to reference the child views for later actions

		if (rowView == null) {

			rowView = inflater.inflate(R.layout.list_item, parent, false);

			// cache view fields into the holder
			holder = new ViewHolder();
			holder.image = (ImageView) rowView.findViewById(R.id.image);
			// associate the holder with the view for later lookup
			rowView.setTag(holder);
			
		} else {
			// view already exists, get the holder instance from the view
			holder = (ViewHolder) rowView.getTag();
			rowView = convertView;
		}

		Element response = dataList.get(position);
		Picasso.with(mContext).load(response.getImgURL()).into(holder.image);
		
//		int ResId = context.getResources().getIdentifier(
//				dataList.get(position), "drawable", context.getPackageName());
//		holder.image.setBackgroundResource(ResId);

		return rowView;
	}

	// somewhere else in your class definition
	class ViewHolder {
		ImageView image;
	}
}
