package com.junits.junits.Requests;


import lombok.Data;

@Data
public class AddNoteRequest {
    String username;
    String note;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
