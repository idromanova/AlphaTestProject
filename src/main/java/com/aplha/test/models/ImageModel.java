package com.aplha.test.models;

public class ImageModel {
    private OriginalModel original;

    public ImageModel(OriginalModel original)
    {
        this.original = original;
    }

    public OriginalModel getOriginal() {
        return original;
    }
}
