package com.babynameplus.service;

import com.babynameplus.dao.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by spio10 on 2017-06-04.
 */
@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

}
