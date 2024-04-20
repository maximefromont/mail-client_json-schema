package org.application.objects;

import java.util.ArrayList;

public class Mail {

    private Thread _thread;
    private ArrayList<Message> _messages;

    public Mail(Thread thread, ArrayList<Message> messages) {
        this._thread = thread;
        this._messages = messages;
    }

    public Thread get_thread() {
        return _thread;
    }

    public void set_thread(Thread _thread) {
        this._thread = _thread;
    }

    public ArrayList<Message> get_messages() {
        return _messages;
    }

    public void addMessage(Message message) {
        _messages.add(message);
    }

    public void removeMessage(Message message) {
        _messages.remove(message);
    }

}
