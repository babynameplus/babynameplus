package com.babynameplus.service;

import com.babynameplus.dao.NameRepository;
import com.babynameplus.entities.Name;
import com.babynameplus.enums.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by spio10 on 2017-06-03.
 */
@Service
public class NameService {

    @Autowired
    private NameRepository nameRepository;

    public List<Name> fetchMaleNames() {

        List<Name> maleNames = nameRepository.findBySexOrderByName(Sex.M);
        return maleNames;
    }

    public List<Name> fetchFemaleNames() {

        List<Name> femaleNames = nameRepository.findBySexOrderByName(Sex.F);
        return femaleNames;

    }

    public Name getName(String name) {
        return nameRepository.findByNameOrderByName(name);
    }
}
