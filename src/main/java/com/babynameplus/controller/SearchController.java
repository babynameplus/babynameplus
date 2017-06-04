package com.babynameplus.controller;

import com.babynameplus.dto.SearchOptions;
import com.babynameplus.entities.Name;
import com.babynameplus.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spio10 on 2017-06-04.
 */

@RequestMapping("/search")
public class SearchController {

    @Autowired
    private NameService nameService;

    @RequestMapping(value = "/females", method = RequestMethod.GET)
    public String searchFemales(Model model, @ModelAttribute SearchOptions searchOptions) {

        List<Name> foundNames = new ArrayList<>();
        List<Name> allFemales = nameService.fetchFemaleNames();

        if (!searchOptions.getLetter().equals("") && !searchOptions.getOrigin().equals("")) {
            searchLetterAndOrigin(searchOptions, foundNames, allFemales);

        } else if (!searchOptions.getLetter().equals("") && searchOptions.getOrigin().equals("")) {
            searchLetter(searchOptions, foundNames, allFemales);

        } else if (searchOptions.getLetter().equals("") && searchOptions.getOrigin().equals("")) {
            searchOrigin(searchOptions, foundNames, allFemales);

        }
        model.addAttribute("femaleNames", foundNames);

        return "names";
    }

    private void searchOrigin(@ModelAttribute SearchOptions searchOptions, List<Name> foundNames, List<Name> allFemales) {
        for (Name name : allFemales) {
            if (name.getOrigin().equals(searchOptions.getOrigin())) {
                foundNames.add(name);
            }

        }
    }

    private void searchLetter(@ModelAttribute SearchOptions searchOptions, List<Name> foundNames, List<Name> allFemales) {
        for (Name name : allFemales) {
            String firstLetter = name.getName().substring(1);
            if (firstLetter.toLowerCase().equals(searchOptions.getLetter().toLowerCase())) {
                foundNames.add(name);
            }

        }
    }

    private void searchLetterAndOrigin(@ModelAttribute SearchOptions searchOptions, List<Name> foundNames, List<Name> allFemales) {
        for (Name name : allFemales) {
            String firstLetter = name.getName().substring(1);
            if (firstLetter.toLowerCase().equals(searchOptions.getLetter().toLowerCase())) {
                foundNames.add(name);
            }

            if (name.getOrigin().equals(searchOptions.getOrigin())) {
                foundNames.add(name);
            }

        }
    }
}
