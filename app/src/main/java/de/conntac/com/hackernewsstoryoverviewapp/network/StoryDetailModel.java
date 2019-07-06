package de.conntac.com.hackernewsstoryoverviewapp.network;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryDetailModel implements Parcelable {

    @SerializedName("by")
    private String author;
    @SerializedName("descendants")
    private int descendants;
    @SerializedName("kids")
    private List<Integer> kidIDs;
    @SerializedName("score")
    private int score;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("time")
    private Long time;
    @SerializedName("id")
    private int id;


    protected StoryDetailModel(Parcel in) {
        author = in.readString();
        descendants = in.readInt();
        score = in.readInt();
        title = in.readString();
        type = in.readString();
        url = in.readString();
        if (in.readByte() == 0) {
            time = null;
        } else {
            time = in.readLong();
        }
        id = in.readInt();
    }

    public static final Creator<StoryDetailModel> CREATOR = new Creator<StoryDetailModel>() {
        @Override
        public StoryDetailModel createFromParcel(Parcel in) {
            return new StoryDetailModel(in);
        }

        @Override
        public StoryDetailModel[] newArray(int size) {
            return new StoryDetailModel[size];
        }
    };

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDescendants() {
        return descendants;
    }

    public void setDescendants(int descendants) {
        this.descendants = descendants;
    }

    public List<Integer> getKidIDs() {
        return kidIDs;
    }

    public void setKidIDs(List<Integer> kidIDs) {
        this.kidIDs = kidIDs;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(author);
        parcel.writeInt(descendants);
        parcel.writeInt(score);
        parcel.writeString(title);
        parcel.writeString(type);
        parcel.writeString(url);
        if (time == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(time);
        }
        parcel.writeInt(id);
    }
}
