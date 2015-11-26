package com.example.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.RetrofitError;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.assignment.adapter.CategoryListAdapter;
import com.example.assignment.commans.AssignApplication;
import com.example.assignment.model.Category;
import com.example.assignment.model.Element;
import com.example.assignment.webservice.Response;
import com.example.assignment.webservice.response_model.Animal;
import com.example.assignment.webservice.response_model.Bird;
import com.example.assignment.webservice.response_model.Flag;
import com.example.assignment.webservice.response_model.Flower;
import com.example.assignment.webservice.response_model.Fruit;
import com.example.assignment.webservice.response_model.Technology;
import com.example.assignment.webservice.response_model.Vegetable;

public class MainActivity extends Activity implements OnClickListener {

	private Context mContext;

	private Button btnGetData;
	private ImageView ivSelected;
	private ListView listview;

	private HashMap<String, List<Response>> map = new HashMap<String, List<Response>>();
	private CategoryListAdapter categoryListAdapter;
	
	private List<Response> apiResponseList = new ArrayList<Response>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = MainActivity.this;

		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub

		btnGetData = (Button) findViewById(R.id.btnGetData);
		ivSelected = (ImageView) findViewById(R.id.ivSelected);
	
		listview = (ListView) findViewById(R.id.listview);
		categoryListAdapter = new CategoryListAdapter(mContext, mListCategories);
		listview.setAdapter(categoryListAdapter);
		
		btnGetData.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private List<Category> mListCategories = new ArrayList<Category>();
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int key = v.getId();
		switch (key) {
		case R.id.btnGetData:
			
			AssignApplication.getRestClient().getRestInterface().getInfo(new retrofit.Callback<Response>() {
				
				@SuppressWarnings("unused")
				@Override
				public void success(Response apiResponse, retrofit.client.Response retrofitSuccess) {
					// TODO Auto-generated method stub
					
					// ANIMAL 
					List<Element> mList = new ArrayList<Element>();
					for (Animal animal : apiResponse.getAnimals()) {
						mList.add(new Element(animal.getName(), animal.getImgURL()));
					}
					mListCategories.add(new Category("Animal", mList.size(), mList));
					
					// BIRD 
					mList.clear();
					for (Bird bird : apiResponse.getBirds()) {
						Element element = new Element(bird.getName(), bird.getImgURL());
						mList.add(element);
					}
					mListCategories.add(new Category("Bird", mList.size(), mList));
					
					// FLAG 
					mList.clear();
					for (Flag flag : apiResponse.getFlags()) {
						Element element = new Element(flag.getName(), flag.getImgURL());
						mList.add(element);
					}
					mListCategories.add(new Category("Flag", mList.size(), mList));
					
					// FLOWER 
					mList.clear();
					for (Flower flower : apiResponse.getFlowers()) {
						Element element = new Element(flower.getName(), flower.getImgURL());
						mList.add(element);
					}
					mListCategories.add(new Category("Flower", mList.size(), mList));
					
					// FRUIT 
					mList.clear();
					for (Fruit fruit : apiResponse.getFruits()) {
						Element element = new Element(fruit.getName(), fruit.getImgURL());
						mList.add(element);
					}
					mListCategories.add(new Category("Fruit", mList.size(), mList));
					
					// TECHNOLOGY 
					mList.clear();
					for (Technology technology : apiResponse.getTechnology()) {
						Element element = new Element(technology.getName(), technology.getImgURL());
						mList.add(element);
					}
					mListCategories.add(new Category("Technology", mList.size(), mList));
					
					// VEGETABLES 
					mList.clear();
					for (Vegetable vegetable : apiResponse.getVegetables()) {
						Element element = new Element(vegetable.getName(), vegetable.getImgURL());
						mList.add(element);
					}
					mListCategories.add(new Category("Vegetable", mList.size(), mList));
					
					categoryListAdapter.notifyDataSetChanged();
				}
				
				@Override
				public void failure(RetrofitError retrofitError) {
					// TODO Auto-generated method stub
					
				}
			});
			
//			AssignApplication.getRestClient().getRestInterface().getWheatherReport(new Callback<List<Response>>() {
//				
//				@Override
//				public void success(List<Response> apiResponse, retrofit.client.Response sucess) {
//					// TODO Auto-generated method stub
//					
////					apiResponseList.clear();
////					apiResponseList.addAll(apiResponse);
////					categoryListAdapter.notifyDataSetChanged();
//					
//					mListCategories.clear();
//					categoryListAdapter.notifyDataSetChanged();
//					
//					Set<String> set = new HashSet<String>();
//					for (Response object : apiResponse) {
//						set.add(object.getCategory());
//					}
//					
//					Iterator<String> iter = set.iterator();
//					while (iter.hasNext()) {
//					    
//						String category = iter.next();
//						List<Response> mList = new ArrayList<Response>();
//						
//						for (int i = 0; i < apiResponse.size(); i++) {
//							Response response = apiResponse.get(i);
//							if (category.equalsIgnoreCase(response.getCategory())) {
//								mList.add(response);
//							}
//							
//						}
//						
//						map.put(category, mList);
//						
//						Category cat = new Category(category, mList.size(), mList);
//						mListCategories.add(cat);
//						
//					}
//					
//					categoryListAdapter.notifyDataSetChanged();
//				}
//				
//				@Override
//				public void failure(RetrofitError error) {
//					// TODO Auto-generated method stub
////					Toast.makeText(mContext, error., duration)
//				}
//			});
			break;

		default:
			break;
		}
	}
}
