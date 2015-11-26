package com.example.assignment.webservice;

import java.util.ArrayList;
import java.util.List;

import com.example.assignment.webservice.response_model.Animal;
import com.example.assignment.webservice.response_model.Bird;
import com.example.assignment.webservice.response_model.Flag;
import com.example.assignment.webservice.response_model.Flower;
import com.example.assignment.webservice.response_model.Fruit;
import com.example.assignment.webservice.response_model.Technology;
import com.example.assignment.webservice.response_model.Vegetable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

	@SerializedName("animals")
	@Expose
	private List<Animal> animals = new ArrayList<Animal>();
	@SerializedName("birds")
	@Expose
	private List<Bird> birds = new ArrayList<Bird>();
	@SerializedName("flags")
	@Expose
	private List<Flag> flags = new ArrayList<Flag>();
	@SerializedName("flowers")
	@Expose
	private List<Flower> flowers = new ArrayList<Flower>();
	@SerializedName("fruits")
	@Expose
	private List<Fruit> fruits = new ArrayList<Fruit>();
	@SerializedName("technology")
	@Expose
	private List<Technology> technology = new ArrayList<Technology>();
	@SerializedName("vegetables")
	@Expose
	private List<Vegetable> vegetables = new ArrayList<Vegetable>();

	/**
	 * 
	 * @return The animals
	 */
	public List<Animal> getAnimals() {
		return animals;
	}

	/**
	 * 
	 * @param animals
	 *            The animals
	 */
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	/**
	 * 
	 * @return The birds
	 */
	public List<Bird> getBirds() {
		return birds;
	}

	/**
	 * 
	 * @param birds
	 *            The birds
	 */
	public void setBirds(List<Bird> birds) {
		this.birds = birds;
	}

	/**
	 * 
	 * @return The flags
	 */
	public List<Flag> getFlags() {
		return flags;
	}

	/**
	 * 
	 * @param flags
	 *            The flags
	 */
	public void setFlags(List<Flag> flags) {
		this.flags = flags;
	}

	/**
	 * 
	 * @return The flowers
	 */
	public List<Flower> getFlowers() {
		return flowers;
	}

	/**
	 * 
	 * @param flowers
	 *            The flowers
	 */
	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

	/**
	 * 
	 * @return The fruits
	 */
	public List<Fruit> getFruits() {
		return fruits;
	}

	/**
	 * 
	 * @param fruits
	 *            The fruits
	 */
	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}

	/**
	 * 
	 * @return The technology
	 */
	public List<Technology> getTechnology() {
		return technology;
	}

	/**
	 * 
	 * @param technology
	 *            The technology
	 */
	public void setTechnology(List<Technology> technology) {
		this.technology = technology;
	}

	/**
	 * 
	 * @return The vegetables
	 */
	public List<Vegetable> getVegetables() {
		return vegetables;
	}

	/**
	 * 
	 * @param vegetables
	 *            The vegetables
	 */
	public void setVegetables(List<Vegetable> vegetables) {
		this.vegetables = vegetables;
	}

}


