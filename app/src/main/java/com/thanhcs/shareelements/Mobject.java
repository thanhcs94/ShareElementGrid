package com.thanhcs.shareelements;

import java.io.Serializable;

/**
 * Created by thanhcs94 on 9/14/2016.
 */
public class Mobject implements Serializable {
    private String name;
    private String download;
    private String storeUrl;
    private  int resource;

    public Mobject(String name, String download, String storeUrl, int resource) {
        this.name = name;
        this.download = download;
        this.storeUrl = storeUrl;
        this.resource = resource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public String getDownload() {
        return download;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public int getResource() {
        return resource;
    }
}
