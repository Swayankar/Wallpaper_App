package com.example.wallpaper;

public class ImageModel {

    private URLModel src;

    public ImageModel(URLModel src) {
        this.src = src;
    }

    public URLModel getSrc() {
        return src;
    }

    public void setSrc(URLModel src) {
        this.src = src;
    }
}
