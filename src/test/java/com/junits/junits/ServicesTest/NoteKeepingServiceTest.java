package com.junits.junits.ServicesTest;

import com.junits.junits.Dao.NoteKeepingDao;
import com.junits.junits.Repository.NoteBookRepository;
import com.junits.junits.Requests.AddNoteRequest;
import com.junits.junits.Responses.GetNoteResponse;
import com.junits.junits.Services.impl.NoteKeepingServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class NoteKeepingServiceTest {

    @Mock
    private NoteKeepingDao noteKeepingDao;

    @Mock
    private NoteBookRepository noteBookRepository;

    @InjectMocks
    private NoteKeepingServicesImpl noteKeepingServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createNoteTest(){
        AddNoteRequest requests = new AddNoteRequest();
        requests.setUsername("Test");
        requests.setNote("Testing note");

        when(noteKeepingDao.createNote(requests)).thenReturn("Successfully added note");
        String response = noteKeepingServices.createNote(requests);
        assertEquals("Successfully added note", response);
    }

    @Test
    void delNoteTest() {
        int id = 1;
        when(noteBookRepository.existsById(id)).thenReturn(true);
        doNothing().when(noteKeepingDao).delNote(id);
        noteKeepingServices.delNote(id);
    }

    @Test
    void delNoteTestException() {
        int id = 1;
        when(noteBookRepository.existsById(id)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> noteKeepingServices.delNote(id));
    }

    @Test
    void updateNoteTest() {
        int id = 1;
        AddNoteRequest requests = new AddNoteRequest();
        requests.setUsername("Test");
        requests.setNote("Testing note");
        when(noteBookRepository.existsById(id)).thenReturn(true);
        when(noteKeepingDao.updateNote(requests, id)).thenReturn("Updated added note");
        String response = noteKeepingServices.updateNote(requests, id);
        assertEquals("Updated added note", response);
    }


    @Test
    void updateNoteTestException() {
        int id = 1;
        AddNoteRequest requests = new AddNoteRequest();
        requests.setUsername("Test");
        requests.setNote("Testing note");
        when(noteBookRepository.existsById(id)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> noteKeepingServices.updateNote(requests, id));
    }

    @Test
    void testGetNote() {
        int id = 1;
        GetNoteResponse mockResponse = new GetNoteResponse();
        mockResponse.setId(id);
        mockResponse.setUsername("testUser");
        mockResponse.setNote("Test note content");
        when(noteBookRepository.existsById(id)).thenReturn(true);
        when(noteKeepingDao.getNote(id)).thenReturn(mockResponse);
        GetNoteResponse response = noteKeepingServices.getNote(id);
        assertEquals(id, response.getId());
        assertEquals("testUser", response.getUsername());
        assertEquals("Test note content", response.getNote());
    }

    @Test
    void testGetNoteException() {
        int id = 1;
        when(noteBookRepository.existsById(id)).thenReturn(false);
        assertThrows(IllegalArgumentException.class, () -> noteKeepingServices.getNote(id));
    }

}
