package com.babynameplus.entities;

import javax.persistence.*;

/**
 * Created by wojci on 4/11/2017.
 */

@Entity
public class PersonAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    private Analysis analysis;


    public PersonAnalysis() {
    }
}
