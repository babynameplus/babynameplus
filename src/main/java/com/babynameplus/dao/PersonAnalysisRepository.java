package com.babynameplus.dao;

import com.babynameplus.entities.PersonAnalysis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wojci on 4/11/2017.
 */

@Repository
public interface PersonAnalysisRepository extends CrudRepository<PersonAnalysis, Long> {
}
