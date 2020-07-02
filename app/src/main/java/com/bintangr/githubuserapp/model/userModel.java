package com.bintangr.githubuserapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class userModel implements Parcelable {

    String username;
    String name;
    int avatar;
    String company;
    String location;
    int repository;
    int follower;
    int following;

    public userModel() {
    }

    public userModel(String username, String name, int avatar, String company, String location, int repository, int follower, int following) {
        this.username = username;
        this.name = name;
        this.avatar = avatar;
        this.company = company;
        this.location = location;
        this.repository = repository;
        this.follower = follower;
        this.following = following;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.name);
        dest.writeInt(this.avatar);
        dest.writeString(this.company);
        dest.writeString(this.location);
        dest.writeInt(this.repository);
        dest.writeInt(this.follower);
        dest.writeInt(this.following);
    }

    protected userModel(Parcel in) {
        this.username = in.readString();
        this.name = in.readString();
        this.avatar = in.readInt();
        this.company = in.readString();
        this.location = in.readString();
        this.repository = in.readInt();
        this.follower = in.readInt();
        this.following = in.readInt();
    }

    public static final Parcelable.Creator<userModel> CREATOR = new Parcelable.Creator<userModel>() {
        @Override
        public userModel createFromParcel(Parcel source) {
            return new userModel(source);
        }

        @Override
        public userModel[] newArray(int size) {
            return new userModel[size];
        }
    };
}
