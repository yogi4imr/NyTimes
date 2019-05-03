package com.yohendrakumar.technologyassessment.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	public ResultsItem(String column, String section, String jsonMemberAbstract, String source, long assetId, List<MediaItem> media, String type, String title, String uri, String url, String adxKeywords, long id, String byline, String publishedDate, int views) {
		this.column = column;
		this.section = section;
		this.jsonMemberAbstract = jsonMemberAbstract;
		this.source = source;
		this.assetId = assetId;
		this.media = media;
		this.type = type;
		this.title = title;
		this.uri = uri;
		this.url = url;
		this.adxKeywords = adxKeywords;
		this.id = id;
		this.byline = byline;
		this.publishedDate = publishedDate;
		this.views = views;
	}

	@SerializedName("column")
	private String column;

	@SerializedName("section")
	private String section;

	@SerializedName("abstract")
	private String jsonMemberAbstract;

	@SerializedName("source")
	private String source;

	@SerializedName("asset_id")
	private long assetId;

	@SerializedName("media")
	private List<MediaItem> media;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private String title;



	@SerializedName("uri")
	private String uri;

	@SerializedName("url")
	private String url;

	@SerializedName("adx_keywords")
	private String adxKeywords;



	@SerializedName("id")
	private long id;

	@SerializedName("byline")
	private String byline;

	@SerializedName("published_date")
	private String publishedDate;

	@SerializedName("views")
	private int views;



	public void setColumn(String column){
		this.column = column;
	}

	public String getColumn(){
		return column;
	}

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setJsonMemberAbstract(String jsonMemberAbstract){
		this.jsonMemberAbstract = jsonMemberAbstract;
	}

	public String getJsonMemberAbstract(){
		return jsonMemberAbstract;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setAssetId(long assetId){
		this.assetId = assetId;
	}

	public long getAssetId(){
		return assetId;
	}

	public void setMedia(List<MediaItem> media){
		this.media = media;
	}

	public List<MediaItem> getMedia(){
		return media;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAdxKeywords(String adxKeywords){
		this.adxKeywords = adxKeywords;
	}

	public String getAdxKeywords(){
		return adxKeywords;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setByline(String byline){
		this.byline = byline;
	}

	public String getByline(){
		return byline;
	}

	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	public String getPublishedDate(){
		return publishedDate;
	}

	public void setViews(int views){
		this.views = views;
	}

	public int getViews(){
		return views;
	}


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.column);
        dest.writeString(this.section);
        dest.writeString(this.jsonMemberAbstract);
        dest.writeString(this.source);
        dest.writeLong(this.assetId);
        dest.writeList(this.media);
        dest.writeString(this.type);
        dest.writeString(this.title);
        dest.writeString(this.uri);
        dest.writeString(this.url);
        dest.writeString(this.adxKeywords);
        dest.writeLong(this.id);
        dest.writeString(this.byline);
        dest.writeString(this.publishedDate);
        dest.writeInt(this.views);
    }

    protected ResultsItem(Parcel in) {
        this.column = in.readString();
        this.section = in.readString();
        this.jsonMemberAbstract = in.readString();
        this.source = in.readString();
        this.assetId = in.readLong();
        this.media = new ArrayList<MediaItem>();
        in.readList(this.media, MediaItem.class.getClassLoader());
        this.type = in.readString();
        this.title = in.readString();
        this.uri = in.readString();
        this.url = in.readString();
        this.adxKeywords = in.readString();
        this.id = in.readLong();
        this.byline = in.readString();
        this.publishedDate = in.readString();
        this.views = in.readInt();
    }

    public static final Parcelable.Creator<ResultsItem> CREATOR = new Parcelable.Creator<ResultsItem>() {
        @Override
        public ResultsItem createFromParcel(Parcel source) {
            return new ResultsItem(source);
        }

        @Override
        public ResultsItem[] newArray(int size) {
            return new ResultsItem[size];
        }
    };
}