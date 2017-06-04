package com.babynameplus.dao;

import com.babynameplus.entities.Ranking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by spio10 on 2017-06-04.
 */
@Repository
public interface RankingRepository extends CrudRepository<Ranking, Long> {
}
