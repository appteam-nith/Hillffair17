package com.nith.appteam.hillffair17.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sahil on 4/3/17.
 */

public class GalleryDetailResponse {

    @SerializedName("albums")
    private ArrayList<GalleryDetail> galleryDetailArrayList;

    public GalleryDetailResponse(ArrayList<GalleryDetail> galleryDetailArrayList) {
        this.galleryDetailArrayList = galleryDetailArrayList;
    }

    public ArrayList<GalleryDetail> getGalleryDetailArrayList() {
        return galleryDetailArrayList;
    }

    public void setGalleryDetailArrayList(ArrayList<GalleryDetail> galleryDetailArrayList) {
        this.galleryDetailArrayList = galleryDetailArrayList;
    }
}
