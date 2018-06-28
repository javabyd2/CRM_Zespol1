package com.example.crm_system.controller;

import com.example.crm_system.model.Contacts;
import com.example.crm_system.model.Contractors;
import com.example.crm_system.model.Note;
import com.example.crm_system.model.Task;
import com.example.crm_system.pdfutils.ContactsPdfGeneratorUtil;
import com.example.crm_system.pdfutils.ContractorsPdfGeneratorUtil;
import com.example.crm_system.pdfutils.NotesPdfGeneratorUtil;
import com.example.crm_system.pdfutils.TasksPdfGeneratorUtil;
import com.example.crm_system.service.ContactsService;
import com.example.crm_system.service.ContractorsService;
import com.example.crm_system.service.NoteService;
import com.example.crm_system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * This controller is responsible for all pdf files
 */
@Controller
public class PdfReportsController {

    ContractorsService contractorsService;
    NoteService noteService;
    TaskService taskService;
    ContactsService contactsService;

    @Autowired
    public PdfReportsController(ContractorsService contractorsService, NoteService noteService, TaskService taskService, ContactsService contactsService) {
        this.contractorsService = contractorsService;
        this.noteService = noteService;
        this.taskService = taskService;
        this.contactsService = contactsService;
    }

    @RequestMapping(value = "/contractors/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> contractorsPdf() {

        List<Contractors> cities = contractorsService.getContractors();

        ByteArrayInputStream bis = ContractorsPdfGeneratorUtil.contractorsPdf(cities);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=contractors.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/notes/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> notesPdf() {

        List<Note> notes = noteService.getNotes();

        ByteArrayInputStream bis = NotesPdfGeneratorUtil.notesPdf(notes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=notes.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/contacts/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> contactsPdf() {

        List<Contacts> contacts = contactsService.getContacts();

        ByteArrayInputStream bis = ContactsPdfGeneratorUtil.contactsPdf(contacts);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=contacts.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @RequestMapping(value = "/tasks/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> tasksPdf() {

        List<Task> tasks = taskService.getTasks();

        ByteArrayInputStream bis = TasksPdfGeneratorUtil.tasksPdf(tasks);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=tasks.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
