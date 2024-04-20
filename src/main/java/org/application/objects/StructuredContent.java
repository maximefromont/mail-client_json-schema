package org.application.objects;

public class StructuredContent {

    //PRIVATE ATTRIBUTES
    private String _type;
    private Object _value;

    //PUBLIC INTERFACE
    public StructuredContent(String type, Object value) {
        this._type = type;
        this._value = value;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public Object get_value() {
        return _value;
    }

    public void set_value(Object _value) {
        this._value = _value;
    }

}
