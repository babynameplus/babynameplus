package com.babynameplus.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wojci on 4/11/2017.
 */

@Entity
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(mappedBy = "analysis", fetch = FetchType.EAGER)
    private Set<PersonAnalysis> personAnalysis = new HashSet<PersonAnalysis>();

    public Analysis() {
    }
}
