package com.yohendrakumar.technologyassessment.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MediaMetadataItem implements Parcelable {

	@SerializedName("format")
	private String format;

	@SerializedName("width")
	private int width;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	public void setFormat(String format){
		this.format = format;
	}

	public String getFormat(){
		return format;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"MediaMetadataItem{" + 
			"format = '" + format + '\'' + 
			",width = '" + width + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.format);
		dest.writeInt(this.width);
		dest.writeString(this.url);
		dest.writeInt(this.height);
	}

	public MediaMetadataItem() {
	}

	protected MediaMetadataItem(Parcel in) {
		this.format = in.readString();
		this.width = in.readInt();
		this.url = in.readString();
		this.height = in.readInt();
	}

	public static final Parcelable.Creator<MediaMetadataItem> CREATOR = new Parcelable.Creator<MediaMetadataItem>() {
		@Override
		public MediaMetadataItem createFromParcel(Parcel source) {
			return new MediaMetadataItem(source);
		}

		@Override
		public MediaMetadataItem[] newArray(int size) {
			return new MediaMetadataItem[size];
		}
	};
}