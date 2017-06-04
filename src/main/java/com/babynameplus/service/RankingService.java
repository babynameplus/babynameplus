package com.babynameplus.service;

import com.babynameplus.dao.RankingRepository;
import com.babynameplus.entities.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by spio10 on 2017-06-04.
 */
@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;


    public List<Ranking> findByYear(int year) {
        return rankingRepository.findByYearOrderByRank(year);
    }

}
