package com.example.assignment.webservice.response_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flag {

	private String category = "Flag";
	
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("imgURL")
	@Expose
	private String imgURL;

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The imgURL
	 */
	public String getImgURL() {
		return imgURL;
	}

	/**
	 * 
	 * @param imgURL
	 *            The imgURL
	 */
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

}
