package com.babynameplus.controller;

import com.babynameplus.dto.SearchOptions;
import com.babynameplus.entities.Name;
import com.babynameplus.enums.Origin;
import com.babynameplus.service.NameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static com.babynameplus.util.NameUtilities.toNamesDto;

/**
 * Created by spio10 on 2017-06-04.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    private final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    final char[] letters = "abcdefghijkl³mnopqrstuvwxyz¿".toUpperCase().toCharArray();

    @Autowired
    private NameService nameService;

    @RequestMapping(value = "/females", method = RequestMethod.POST)
    public String searchFemales(Model model, @ModelAttribute SearchOptions searchOptions) {

        LOGGER.info("Searching females");
        List<Name> foundNames = new ArrayList<>();
        List<Name> allFemales = nameService.fetchFemaleNames();

        if (!searchOptions.getLetter().equals("") && !searchOptions.getOrigin().equals("")) {
            LOGGER.info("searchLetterAndOrigin");
            searchLetterAndOrigin(searchOptions, foundNames, allFemales);

        } else if (!searchOptions.getLetter().equals("") && searchOptions.getOrigin().equals("")) {
            LOGGER.info("searchLetter");
            searchLetter(searchOptions, foundNames, allFemales);

        } else if (searchOptions.getLetter().equals("") && searchOptions.getOrigin().equals("")) {
            LOGGER.info("searchOrigin");
            searchOrigin(searchOptions, foundNames, allFemales);

        }

        model.addAttribute("searchOptions", searchOptions);
        model.addAttribute("origins", Origin.FEMALE_ORIGINS);
        model.addAttribute("letters", letters);
        model.addAttribute("femaleNames", toNamesDto(foundNames));

        return "femaleNames";
    }

    @RequestMapping(value = "/males", method = RequestMethod.POST)
    public String searchMales(Model model, @ModelAttribute SearchOptions searchOptions) {

        LOGGER.info("Searching males");
        List<Name> foundNames = new ArrayList<>();
        List<Name> allMales = nameService.fetchMaleNames();

        if (!searchOptions.getLetter().equals("") && !searchOptions.getOrigin().equals("")) {
            LOGGER.info("searchLetterAndOrigin");
            searchLetterAndOrigin(searchOptions, foundNames, allMales);

        } else if (!searchOptions.getLetter().equals("") && searchOptions.getOrigin().equals("")) {
            LOGGER.info("searchLetter");
            searchLetter(searchOptions, foundNames, allMales);

        } else if (searchOptions.getLetter().equals("") && searchOptions.getOrigin().equals("")) {
            LOGGER.info("searchOrigin");
            searchOrigin(searchOptions, foundNames, allMales);

        }

        model.addAttribute("searchOptions", searchOptions);
        model.addAttribute("origins", Origin.MALE_ORIGINS);
        model.addAttribute("letters", letters);
        model.addAttribute("maleNames", toNamesDto(foundNames));

        return "maleNames";
    }

    private void searchOrigin(SearchOptions searchOptions, List<Name> foundNames, List<Name> allNames) {
        for (Name name : allNames) {
            if (name.getOrigin() != null && name.getOrigin().toLowerCase().trim().equals(searchOptions.getOrigin().toLowerCase().trim())) {
                foundNames.add(name);
            }

        }
    }

    private void searchLetter(SearchOptions searchOptions, List<Name> foundNames, List<Name> allNames) {
        for (Name name : allNames) {
            String firstLetter = String.valueOf(name.getName().charAt(0));
            LOGGER.info(firstLetter);
            if (firstLetter.toLowerCase().equals(searchOptions.getLetter().trim().toLowerCase())) {
                foundNames.add(name);
            }

        }
    }

    private void searchLetterAndOrigin(SearchOptions searchOptions, List<Name> foundNames, List<Name> allNames) {
        for (Name name : allNames) {

            String firstLetter = String.valueOf(name.getName().charAt(0));
            LOGGER.info(firstLetter);
            if (firstLetter.toLowerCase().equals(searchOptions.getLetter().trim().toLowerCase())) {
                foundNames.add(name);
            }

            if (name.getOrigin() != null && name.getOrigin().toLowerCase().trim().equals(searchOptions.getOrigin().toLowerCase().trim())) {
                foundNames.add(name);
            }

        }
    }
}
