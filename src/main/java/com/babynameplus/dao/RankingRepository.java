package com.babynameplus.dao;

import com.babynameplus.entities.Ranking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by spio10 on 2017-06-04.
 */
@Repository
public interface RankingRepository extends CrudRepository<Ranking, Long> {

    List<Ranking> findByYearOrderByRank(int year);
}
