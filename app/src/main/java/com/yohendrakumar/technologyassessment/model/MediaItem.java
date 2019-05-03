package com.yohendrakumar.technologyassessment.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MediaItem implements Parcelable {

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("media-metadata")
	private List<MediaMetadataItem> mediaMetadata;

	@SerializedName("subtype")
	private String subtype;

	@SerializedName("caption")
	private String caption;

	@SerializedName("type")
	private String type;

	@SerializedName("approved_for_syndication")
	private int approvedForSyndication;

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setMediaMetadata(List<MediaMetadataItem> mediaMetadata){
		this.mediaMetadata = mediaMetadata;
	}

	public List<MediaMetadataItem> getMediaMetadata(){
		return mediaMetadata;
	}

	public void setSubtype(String subtype){
		this.subtype = subtype;
	}

	public String getSubtype(){
		return subtype;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setApprovedForSyndication(int approvedForSyndication){
		this.approvedForSyndication = approvedForSyndication;
	}

	public int getApprovedForSyndication(){
		return approvedForSyndication;
	}

	@Override
 	public String toString(){
		return 
			"MediaItem{" + 
			"copyright = '" + copyright + '\'' + 
			",media-metadata = '" + mediaMetadata + '\'' + 
			",subtype = '" + subtype + '\'' + 
			",caption = '" + caption + '\'' + 
			",type = '" + type + '\'' + 
			",approved_for_syndication = '" + approvedForSyndication + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.copyright);
		dest.writeList(this.mediaMetadata);
		dest.writeString(this.subtype);
		dest.writeString(this.caption);
		dest.writeString(this.type);
		dest.writeInt(this.approvedForSyndication);
	}

	public MediaItem() {
	}

	protected MediaItem(Parcel in) {
		this.copyright = in.readString();
		this.mediaMetadata = new ArrayList<MediaMetadataItem>();
		in.readList(this.mediaMetadata, MediaMetadataItem.class.getClassLoader());
		this.subtype = in.readString();
		this.caption = in.readString();
		this.type = in.readString();
		this.approvedForSyndication = in.readInt();
	}

	public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
		@Override
		public MediaItem createFromParcel(Parcel source) {
			return new MediaItem(source);
		}

		@Override
		public MediaItem[] newArray(int size) {
			return new MediaItem[size];
		}
	};
}