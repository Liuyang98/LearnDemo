package com.liqudel.learndemo.util.eventbus;

public class ParentEvent {
    protected String text;

    public ParentEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
