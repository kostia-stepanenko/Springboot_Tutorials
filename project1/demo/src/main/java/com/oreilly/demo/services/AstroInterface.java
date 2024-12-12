package com.oreilly.demo.services;

import com.oreilly.demo.json.AstroResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface AstroInterface {
    @GetExchange("/astros.json")
    AstroResponse getResponse();
}
