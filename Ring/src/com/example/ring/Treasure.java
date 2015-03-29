package com.example.ring;

import android.os.Parcel;
import android.os.Parcelable;

public class Treasure implements Parcelable {
	private String name;
	private int imageId;

	public Treasure(String name, int imageId) {
		this.name = name;
		this.imageId = imageId;
	}

	public Treasure() {

	}

	public String getName() {
		return name;
	}

	public int getImageId() {
		return imageId;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(name);
		dest.writeInt(imageId);

	}

	public static final Parcelable.Creator<Treasure> CREATOR = new Parcelable.Creator<Treasure>() {

		@Override
		public Treasure createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			Treasure swap = new Treasure();
			swap.name = source.readString();
			swap.imageId = source.readInt();
			return swap;
		}

		@Override
		public Treasure[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Treasure[size];
		}
	};
}