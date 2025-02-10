package com.junits.junits.Services;

import com.junits.junits.Requests.AddNoteRequest;
import com.junits.junits.Responses.GetNoteResponse;

public interface NoteKeepingServices {
    public String createNote(AddNoteRequest addNoteRequests);
    public GetNoteResponse getNote(int id);
    public void delNote(int id);
    public String updateNote(AddNoteRequest addNoteRequests, int id);
}
