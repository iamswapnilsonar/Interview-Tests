package com.example.assignment.model;


public class Element {

	private String name;
	private String imgURL;

	public Element(String name, String imgURL) {
		this.name = name;
		this.imgURL = imgURL;
	}
	
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