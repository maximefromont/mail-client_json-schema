package org.application.objects;

import java.util.ArrayList;

public class Message {

    //PRIVATE ATTRIBUTES
    private String _text;
    private Metadata _metedata;

    //PUBLIC INTERFACE
    public Message(String text, Metadata metedata) {
        this._text = text;
        this._metedata = metedata;
    }

    public String get_text() {
        return _text;
    }

    public void set_text(String _text) {
        this._text = _text;
    }

    public Metadata get_metedata() {
        return _metedata;
    }

    public void set_metedata(Metadata _metedata) {
        this._metedata = _metedata;
    }

}
