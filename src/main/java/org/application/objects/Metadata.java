package org.application.objects;

import java.util.ArrayList;

public class Metadata {

    private String _timestamp;
    private ArrayList<StructuredContent> _structuredContent;

    //PUBLIC INTERFACE
    public Metadata(String timestamp, ArrayList<StructuredContent> structuredContent) {
        this._timestamp = timestamp;
        this._structuredContent = structuredContent;
    }

    public String get_timestamp() {
        return _timestamp;
    }

    public void set_timestamp(String _timestamp) {
        this._timestamp = _timestamp;
    }

    public ArrayList<StructuredContent> get_structuredContent() {
        return _structuredContent;
    }

    public void addStructuredContent(StructuredContent structuredContent) {
        _structuredContent.add(structuredContent);
    }

    public void removeStructuredContent(StructuredContent structuredContent) {
        _structuredContent.remove(structuredContent);
    }

}
