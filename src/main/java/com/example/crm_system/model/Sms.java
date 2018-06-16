package com.example.crm_system.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;


@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

<<<<<<< HEAD
    private String sender;
=======
    /*
     * TODO: PILNE!!!!
     * Zmieńcie nazwę tego pola. Słowo "from" jest słowek kluczowym SQL i zawsze będzie powodować problemy z tworzeniem tabelki.
     * Nie znam logiki biznesowej dla tego nie poprawiam tego pola sam.
     */
    private String from;
>>>>>>> fd3c34e8a775b0d8eaf75f2268ac6b21e7c3fb58
    private String text;
    private Timestamp sendTime;
}
