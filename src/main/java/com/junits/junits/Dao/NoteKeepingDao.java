package com.junits.junits.Dao;

import com.junits.junits.Entity.NotebookEntity;
import com.junits.junits.Repository.NoteBookRepository;
import com.junits.junits.Requests.AddNoteRequest;
import com.junits.junits.Responses.GetNoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service

public class NoteKeepingDao {

    private final NoteBookRepository repo;

    public String createNote(AddNoteRequest addNoteRequests){
        NotebookEntity entity = new NotebookEntity();
        entity.setUsername(addNoteRequests.getUsername());
        entity.setNote(addNoteRequests.getNote());
        repo.save(entity);
        return "Successfully added note";
    }

    public GetNoteResponse getNote(int id){
        NotebookEntity entity = new NotebookEntity();
        entity = repo.findById(id);
        GetNoteResponse resp = new GetNoteResponse();
        resp.setNote(entity.getNote());
        resp.setId(entity.getId());
        resp.setUsername(entity.getUsername());
        return resp;
    }

    public void delNote(int id){
        repo.deleteById(id);
    }

    public String updateNote(AddNoteRequest addNoteRequests, int id){
        NotebookEntity entity = new NotebookEntity();
        entity = repo.findById(id);
        entity.setUsername(addNoteRequests.getUsername());
        entity.setNote(addNoteRequests.getNote());
        repo.save(entity);
        return "Updated added note";
    }


}
