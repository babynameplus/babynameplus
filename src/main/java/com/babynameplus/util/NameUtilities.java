package com.babynameplus.util;

import com.babynameplus.dto.NameDTO;
import com.babynameplus.entities.Name;
import com.babynameplus.enums.Sex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spio10 on 2017-06-04.
 */
public class NameUtilities {
    public static List<NameDTO> toNamesDto(List<Name> names) {
        List<NameDTO> dtoNames = new ArrayList<>();
        names.forEach(name -> {
            NameDTO dto = toNameDto(name);
            dtoNames.add(dto);
        });
        return dtoNames;
    }

    public static NameDTO toNameDto(Name name) {
        NameDTO dto = new NameDTO();
        dto.setName(name.getName());
        dto.setNameday(name.getNameday());
        dto.setOrigin(name.getOrigin());
        dto.setDescription(name.getDescription());
        String dtoSex;

        if (name.getSex() == Sex.M) {
            dtoSex = "Mezczyzna";
        } else {
            dtoSex = "Kobieta";
        }

        dto.setSex(dtoSex);
        return dto;
    }
}
