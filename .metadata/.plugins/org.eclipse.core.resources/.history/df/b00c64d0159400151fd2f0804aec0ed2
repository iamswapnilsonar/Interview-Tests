package com.example.assignment.adapter;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.model.Category;
import com.example.assignment.model.Element;
import com.example.assignment.ui.HorizontalListView;

@SuppressLint("InflateParams")
public class CategoryListAdapter extends BaseAdapter {

	private Context mContext;
	private List<Category> data = new ArrayList<Category>();
	private static LayoutInflater inflater;

	public CategoryListAdapter(Context context, List<Category> data) {
		this.mContext = context;
		this.data = data;
		inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		return data.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	private class ViewHolder {
		private HorizontalListView horizonListView;
		private TextView textItem;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View view = convertView;

		ViewHolder holder;

		if (convertView == null) {
			view = inflater.inflate(R.layout.row, null);
			holder = new ViewHolder();
			holder.horizonListView = (HorizontalListView) view.findViewById(R.id.horizonListView);
			holder.textItem = (TextView) view.findViewById(R.id.tvCategory);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

//		Response user = data.get(position);
//		holder.textItem.setText(""+user.getName());
		
		Category category = data.get(position);
		List<Element> mResponseList = category.mList;
		
		holder.textItem.setText(""+category.category);
		
		ImageListAdapter adapter = new ImageListAdapter(mContext, mResponseList);
		holder.horizonListView.setAdapter(adapter);
		holder.horizonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}
			
		});
//
//		holder.tvSubject.setText(user.subTitle);
//		holder.tvQueCount.setText("Total Questions: " + user.subQueCount);
//
//		holder.checkBox.setTag(user);
//		boolean value = user.subStatus != 1 ? false : true;
//		holder.checkBox.setChecked(value);
//		holder.checkBox.setOnCheckedChangeListener(this);
		return view;
	}

}
