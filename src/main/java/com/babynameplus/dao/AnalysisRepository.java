package com.babynameplus.dao;

import com.babynameplus.entities.Analysis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wojci on 4/11/2017.
 */

@Repository
public interface AnalysisRepository extends CrudRepository<Analysis, Long> {
}
