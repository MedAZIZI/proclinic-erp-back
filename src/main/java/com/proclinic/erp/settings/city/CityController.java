package com.proclinic.erp.settings.city;

import com.proclinic.erp.settings.city.dto.CityResponse;
import com.proclinic.erp.settings.city.dto.CreateCityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<CityResponse> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public CityResponse getById(@PathVariable Long id) {
        return cityService.getById(id);
    }

    @PostMapping
    public CityResponse create(@RequestBody CreateCityRequest request) {
        System.out.println("CREATING CITY...");
        System.out.println(request.getName());
        System.out.println(request.getCode());
        return cityService.create(request);

    }

    @PutMapping("/{id}")
    public CityResponse update(
            @PathVariable Long id,
            @RequestBody CreateCityRequest request
    ) {
        return cityService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }


}