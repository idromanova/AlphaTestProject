package com.aplha.test.models;

public class GiphyFullModel {
    private  GiphyModel data;

    public GiphyFullModel( GiphyModel giphyModel)
    {
        this.data = giphyModel;
    }
    public GiphyModel getData() {
        return data;
    }
}
