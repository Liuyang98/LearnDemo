package com.liqudel.learndemo.util.eventbus;

public class ChildEvent extends ParentEvent {
    public ChildEvent(String text) {
        super(text);
    }
}
