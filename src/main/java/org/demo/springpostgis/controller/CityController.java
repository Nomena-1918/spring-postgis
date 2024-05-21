package org.demo.springpostgis.controller;

import org.demo.springpostgis.model.City;
import org.demo.springpostgis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort.Order;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("city")
public class CityController {
    private final CityService service;
    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping
    public Page<City> getCityPage(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id,asc") String[] sort) {
        List<Order> orders = getOrders(sort);
        return service.findAll(PageRequest.of(page, size, Sort.by(orders)));
    }


    @GetMapping("/{lat}/{lon}/{distanceM}")
    public Page<City> getCityNear(@PathVariable double lat,
                                  @PathVariable double lon,
                                  @PathVariable double distanceM,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "id,asc") String[] sort) {
        List<Order> orders = getOrders(sort);
        return service.findAround(lat, lon, distanceM, PageRequest.of(page, size, Sort.by(orders)));
    }

    private List<Order> getOrders(@RequestParam(defaultValue = "id,asc") String[] sort) {
        List<Order> orders = new ArrayList<>();

        if (sort[0].contains(",")) {
            // will sort more than 2 fields
            // sortOrder="field, direction"
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            // sort=[field, direction]
            orders.add(new Order(getSortDirection(sort[1]), sort[0]));
        }

        return orders;
    }

    public Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }
}