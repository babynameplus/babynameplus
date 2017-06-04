package com.babynameplus.controller;

import com.babynameplus.dto.NameDTO;
import com.babynameplus.dto.SearchOptions;
import com.babynameplus.entities.Name;
import com.babynameplus.enums.Origin;
import com.babynameplus.enums.Sex;
import com.babynameplus.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wojci on 4/11/2017.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private NameService nameService;

    final char[] letters = "abcdefghijklłmnopqrstuvwxyzż".toUpperCase().toCharArray();

    @RequestMapping(method = RequestMethod.GET)
    public String landing(Model model) {
        return "landing";
    }

    @RequestMapping(value = "/femaleNames", method = RequestMethod.GET)
    public String femaleNames(Model model) {
        SearchOptions searchOptions = new SearchOptions();
        List<Name> femaleNames = nameService.fetchFemaleNames();

        model.addAttribute("searchOptions", searchOptions);
        model.addAttribute("femaleNames", toNamesDto(femaleNames));
        model.addAttribute("origins", Origin.FEMALE_ORIGINS);
        model.addAttribute("letters", letters);

        return "femaleNames";
    }

    @RequestMapping(value = "/maleNames", method = RequestMethod.GET)
    public String maleNames(Model model) {
        SearchOptions searchOptions = new SearchOptions();
        List<Name> maleNames = nameService.fetchMaleNames();

        model.addAttribute("searchOptions", searchOptions);
        model.addAttribute("maleNames", toNamesDto(maleNames));
        model.addAttribute("letters", letters);

        return "maleNames";
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String nameDetails(@RequestParam("name") String name, Model model) {
        Name requestedName = nameService.getName(name);
        model.addAttribute("name", toNameDto(requestedName));
        return "nameDetails";

    }

    private List<NameDTO> toNamesDto(List<Name> names) {
        List<NameDTO> dtoNames = new ArrayList<>();
        names.forEach(name -> {
            NameDTO dto = new NameDTO();
            dto.setName(name.getName());
            String dtoSex;

            if (name.getSex() == Sex.M) {
                dtoSex = "Mężczyzna";
            } else {
                dtoSex = "Kobieta";
            }

            dto.setSex(dtoSex);
            dtoNames.add(dto);
        });
        return dtoNames;
    }

    private NameDTO toNameDto(Name name) {
        NameDTO dto = new NameDTO();
        dto.setName(name.getName());
        String dtoSex;

        if (name.getSex() == Sex.M) {
            dtoSex = "Mężczyzna";
        } else {
            dtoSex = "Kobieta";
        }

        dto.setSex(dtoSex);
        return dto;
    }
}