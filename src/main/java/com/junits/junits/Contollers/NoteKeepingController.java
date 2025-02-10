package com.junits.junits.Contollers;
import com.junits.junits.Requests.AddNoteRequest;
import com.junits.junits.Responses.GetNoteResponse;
import com.junits.junits.Services.impl.NoteKeepingServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RequestMapping("notebook")
@Service
@RestController
@Validated
@Slf4j
public class NoteKeepingController {
    private final NoteKeepingServicesImpl noteKeepingServices;
    @PostMapping
    public String createNote(@RequestBody AddNoteRequest addNoteRequests){
        log.info("[createNote] NoteKeppingController");
        return noteKeepingServices.createNote(addNoteRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetNoteResponse> getNote(@PathVariable int id){
        GetNoteResponse resp = new GetNoteResponse();
        resp = noteKeepingServices.getNote(id);
        return ResponseEntity.ok().body(resp);
    }

    @DeleteMapping("/{id}")
    public String delNote(@PathVariable int id){
        noteKeepingServices.delNote(id);
        return "Deleted id successfully";
    }

    @PostMapping("/{id}")
    public String updateNote(@RequestBody AddNoteRequest addNoteRequests, @PathVariable int id){
        return noteKeepingServices.updateNote(addNoteRequests,id);
    }
}
