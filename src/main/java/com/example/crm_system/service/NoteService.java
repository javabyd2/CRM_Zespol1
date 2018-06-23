package com.example.crm_system.service;

import com.example.crm_system.model.Note;
import com.example.crm_system.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NoteService {

    NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveNote(Note note){
        note.setDateCreated(new Timestamp(System.currentTimeMillis()));
        return noteRepository.save(note);
    }

    public List<Note> getNotes(){
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id){
        return noteRepository.findById(id).get();
    }
}
