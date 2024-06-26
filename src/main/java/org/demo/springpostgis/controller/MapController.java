package org.demo.springpostgis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {
    @GetMapping("/map")
    public String map() {
        return "pages/map";
    }

    @GetMapping("/heatmap")
    public String heatmap() {
        return "pages/heatmap";
    }
}
