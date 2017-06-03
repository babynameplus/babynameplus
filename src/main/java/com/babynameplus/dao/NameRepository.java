package com.babynameplus.dao;

import com.babynameplus.entities.Name;
import com.babynameplus.enums.Sex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wojci on 4/11/2017.
 */

@Repository
public interface NameRepository extends CrudRepository<Name, Long> {

    List<Name> findBySex(Sex sex);
}
