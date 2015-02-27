package com.example.ring;

public class Treasure {
	private String name;
	private int imageId;

	public Treasure(String name, int imageId) {
		this.name = name;
		this.imageId = imageId;
	}

	public String getName() {
		return name;
	}

	public int getImageId() {
		return imageId;
	}
}