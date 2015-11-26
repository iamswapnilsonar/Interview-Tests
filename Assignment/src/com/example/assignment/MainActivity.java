package com.example.assignment;

import java.util.ArrayList;
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
import android.widget.RelativeLayout;

import com.example.assignment.adapter.CategoryListAdapter;
import com.example.assignment.commans.AssignApplication;
import com.example.assignment.commans.IMethodCaller;
import com.example.assignment.methods.CheckInternetUtil;
import com.example.assignment.model.Category;
import com.example.assignment.model.Element;
import com.example.assignment.webservice.Response;
import com.example.assignment.webservice.RestClient;
import com.example.assignment.webservice.response_model.Animal;
import com.example.assignment.webservice.response_model.Bird;
import com.example.assignment.webservice.response_model.Flag;
import com.example.assignment.webservice.response_model.Flower;
import com.example.assignment.webservice.response_model.Fruit;
import com.example.assignment.webservice.response_model.Technology;
import com.example.assignment.webservice.response_model.Vegetable;
import com.squareup.picasso.Picasso;

public class MainActivity extends Activity implements OnClickListener, IMethodCaller{

	private Context mContext;

	private Button btnTryAgain;
	private ImageView ivSelected;
	private ListView listview;

	private CategoryListAdapter categoryListAdapter;
	private RelativeLayout relContainer, relConnectivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = MainActivity.this;

		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub

		ivSelected = (ImageView) findViewById(R.id.ivSelected);
	
		listview = (ListView) findViewById(R.id.listview);
		categoryListAdapter = new CategoryListAdapter(mContext, mListCategories);
		listview.setAdapter(categoryListAdapter);
		
		relContainer = (RelativeLayout) findViewById(R.id.relContainer);
		relConnectivity = (RelativeLayout) findViewById(R.id.relConnectivity);
		
		btnTryAgain = (Button) findViewById(R.id.btnTryAgain);
		btnTryAgain.setOnClickListener(this);
		
		tryAgainForConnectivity();
		
	}

	private void tryAgainForConnectivity() {
		
		if (CheckInternetUtil.isNetAvailable(mContext)) {
			relConnectivity.setVisibility(View.GONE);
			relContainer.setVisibility(View.VISIBLE);
			loadAndPrepareScreen();
		}else{
			relConnectivity.setVisibility(View.VISIBLE);
			relContainer.setVisibility(View.GONE);
		}
		
	}
	
	/**
	 * API consumption and info loading..
	 * @author Swapnil Sonar
	 */
	private void loadAndPrepareScreen() {
		
		AssignApplication.getRestClient().getRestInterface().getInfo(new retrofit.Callback<Response>() {
			
			@Override
			public void success(Response apiResponse, retrofit.client.Response retrofitSuccess) {
				// TODO Auto-generated method stub
				
				mListCategories.clear();
				categoryListAdapter.notifyDataSetChanged();
				
				// ANIMAL 
				List<Element> mList = new ArrayList<Element>();
				for (Animal animal : apiResponse.getAnimals()) {
					mList.add(new Element(animal.getName(), animal.getImgURL()));
				}
				mListCategories.add(new Category("Animal", mList.size(), mList));
				
				// BIRD 
				mList = new ArrayList<Element>();
				for (Bird bird : apiResponse.getBirds()) {
					Element element = new Element(bird.getName(), bird.getImgURL());
					mList.add(element);
				}
				mListCategories.add(new Category("Bird", mList.size(), mList));
				
				// FLAG 
				mList = new ArrayList<Element>();
				for (Flag flag : apiResponse.getFlags()) {
					Element element = new Element(flag.getName(), flag.getImgURL());
					mList.add(element);
				}
				mListCategories.add(new Category("Flag", mList.size(), mList));
				
				// FLOWER 
				mList = new ArrayList<Element>();
				for (Flower flower : apiResponse.getFlowers()) {
					Element element = new Element(flower.getName(), flower.getImgURL());
					mList.add(element);
				}
				mListCategories.add(new Category("Flower", mList.size(), mList));
				
				// FRUIT 
				mList = new ArrayList<Element>();
				for (Fruit fruit : apiResponse.getFruits()) {
					Element element = new Element(fruit.getName(), fruit.getImgURL());
					mList.add(element);
				}
				mListCategories.add(new Category("Fruit", mList.size(), mList));
				
				// TECHNOLOGY 
				mList = new ArrayList<Element>();
				for (Technology technology : apiResponse.getTechnology()) {
					Element element = new Element(technology.getName(), technology.getImgURL());
					mList.add(element);
				}
				mListCategories.add(new Category("Technology", mList.size(), mList));
				
				// VEGETABLES 
				mList = new ArrayList<Element>();
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
		case R.id.btnTryAgain:
			tryAgainForConnectivity();
			break;

		default:
			break;
		}
	}

	@Override
	public void refreshSelectedImage(Element element) {
		// TODO Auto-generated method stub
		String imageURL = RestClient.BASE_URL + "/" + element.getImgURL();
		Picasso.with(mContext).load(imageURL)
		.centerCrop()
		.placeholder(R.drawable.ic_launcher)
		.resize(200, 200)
		.error(R.drawable.ic_launcher)
		.into(ivSelected);
	}
}

