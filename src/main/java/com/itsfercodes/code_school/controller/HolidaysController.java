package com.itsfercodes.code_school.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.itsfercodes.code_school.model.Holiday;

@Controller
public class HolidaysController {

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

    if (!model.containsAttribute("festival") && !model.containsAttribute("federal")) {
      // TODO: Add 404 error page
      return "404.html";

    }

    // TODO: move holidays to db
    List<Holiday> holidays = Arrays.asList(
        new Holiday("Jan 1", "New Year's Day", Holiday.Type.FESTIVAL),
        new Holiday("Oct 31", "Halloween", Holiday.Type.FESTIVAL),
        new Holiday("Nov 24", "Thanksgiving Day", Holiday.Type.FESTIVAL),
        new Holiday("Dec 25", "Christmas", Holiday.Type.FESTIVAL),
        new Holiday("Jan 17", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
        new Holiday("Jul 4", "Independence Day", Holiday.Type.FEDERAL),
        new Holiday("Sep 5", "Labor Day", Holiday.Type.FEDERAL),
        new Holiday("Nov 11", "Veterans Day", Holiday.Type.FEDERAL));

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
