package com.junits.junits.Services.impl;

import com.junits.junits.Dao.NoteKeepingDao;
import com.junits.junits.Repository.NoteBookRepository;
import com.junits.junits.Requests.AddNoteRequest;
import com.junits.junits.Responses.GetNoteResponse;
import com.junits.junits.Services.NoteKeepingServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class NoteKeepingServicesImpl implements NoteKeepingServices {

    private final NoteKeepingDao noteKeepingDao;
    private final NoteBookRepository noteBookRepository;

    public String createNote(AddNoteRequest addNoteRequests){

        return noteKeepingDao.createNote(addNoteRequests);
    }

    public GetNoteResponse getNote(int id){
        if(!noteBookRepository.existsById(id)){
            throw new IllegalArgumentException("Id doesn't exist");
        }
        return noteKeepingDao.getNote(id);
    }

    public void delNote(int id){
        if(!noteBookRepository.existsById(id)){
            throw new IllegalArgumentException("Id doesn't exist");
        }
        noteKeepingDao.delNote(id);
    }

    public String updateNote(AddNoteRequest addNoteRequests, int id){
        if(!noteBookRepository.existsById(id)){
            throw new IllegalArgumentException("Id doesn't exist");
        }
        return noteKeepingDao.updateNote(addNoteRequests,id);
    }
}


