package com.itsfercodes.code_school.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itsfercodes.code_school.model.Holiday;
import com.itsfercodes.code_school.repository.HolidaysRepository;

@Controller
public class HolidaysController {

  @Autowired
  private HolidaysRepository holidaysRepository;

  @GetMapping("/holidays/{display}")
  public String displayHolidays(@PathVariable String display, Model model) {

    if (display.equals("all")) {
      model.addAttribute("festival", true);
      model.addAttribute("federal", true);
    } else if (display.equals("federal")) {
      model.addAttribute("federal", true);
    } else if (display.equals("festival")) {
      model.addAttribute("festival", true);
    }

    List<Holiday> holidays = holidaysRepository.findAll();

    // Collect the values of the enum
    Holiday.Type[] types = Holiday.Type.values();
    // For each value in types, group all the holidays by type in a list and add it
    // to the model
    for (Holiday.Type type : types) {
      model.addAttribute(type.toString(), (holidays.stream()
          .filter(holiday -> holiday.getType().equals(type))
          .collect(Collectors.toList())));
    }

    return "holidays.html";
  }
}
