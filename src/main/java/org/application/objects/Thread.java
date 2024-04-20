package org.application.objects;

import java.util.ArrayList;

public class Thread {

    //PRIVATE ATTRIBUTES
    private String _titre;
    private ArrayList<String> _participants;
    private String _date;
    private ArrayList<String> _categories;

    //PUBLIC INTERFACE
    public Thread(String titre, ArrayList<String> participants, String date, ArrayList<String> categories) {
        this._titre = titre;
        this._participants = participants;
        this._date = date;
        this._categories = categories;
    }

    public String get_titre() {
        return _titre;
    }

    public void set_titre(String _titre) {
        this._titre = _titre;
    }

    public ArrayList<String> get_participants() {
        return _participants;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public ArrayList<String> get_categories() {
        return _categories;
    }

    public void addParticipant(String participant) {
        _participants.add(participant);
    }

    public void removeParticipant(String participant) {
        _participants.remove(participant);
    }

    public void addCategory(String category) {
        _categories.add(category);
    }

    public void removeCategory(String category) {
        _categories.remove(category);
    }

}
