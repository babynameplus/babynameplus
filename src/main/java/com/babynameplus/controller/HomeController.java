package com.babynameplus.controller;

import com.babynameplus.dto.NameDTO;
import com.babynameplus.entities.Name;
import com.babynameplus.enums.Sex;
import com.babynameplus.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {

        List<Name> maleNames = nameService.fetchMaleNames();
        List<Name> femaleNames = nameService.fetchFemaleNames();

        model.addAttribute("maleNames", toNamesDto(maleNames));
        model.addAttribute("femaleNames", toNamesDto(femaleNames));

        return "names";
    }

    private List<NameDTO> toNamesDto(List<Name> names) {
        List<NameDTO> dtoNames = new ArrayList<>();
        names.forEach(name -> {
            System.out.println(name.getName());
            System.out.println(name.getSex());
            NameDTO dto = new NameDTO();
            dto.setName(name.getName());
            String dtoSex;

            if (name.getSex() == Sex.M) {
                System.out.println("Man");
                dtoSex = "Mężczyzna";
            } else {
                dtoSex = "Kobieta";
            }

            dto.setSex(dtoSex);
            dtoNames.add(dto);
        });
        return dtoNames;
    }
}
