package com.example.assignment.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	public String category;
	public int count;
	public List<Element> mList = new ArrayList<Element>();

	public Category(String category, int count, List<Element> mList) {
		// TODO Auto-generated constructor stub
		this.category = category;
		this.count = count;
		this.mList = mList;
	}

}
