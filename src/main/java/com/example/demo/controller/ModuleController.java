package com.example.demo.controller;

import com.example.demo.dto.ModuleDto;
import com.example.demo.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/module")
public class ModuleController {
    private final ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("")
    public List<ModuleDto> getAllModules() {
        return moduleService.findAll();
    }

    @GetMapping("/{id}")
    public ModuleDto getModule(@PathVariable("id") Long id) {
        return moduleService.findById(id);
    }

    //@Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    public ModuleDto updateModule(@PathVariable("id") Long id,
                                  @Valid @RequestBody ModuleRequestToUpdate request) {
        ModuleDto moduleDto = moduleService.findById(id);
        moduleDto.setTitle(request.getTitle());
        moduleDto.setDateAuthorUpdate(request.getAuthor());
        return moduleService.save(moduleDto);
    }

    @PostMapping
    public ModuleDto createModule(@Valid @RequestBody ModuleRequestToCreate request) {
        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setTitle(request.getTitle());
        moduleDto.setDateAuthorCreation(request.getAuthor());
        return moduleService.createModule(moduleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteModule(@PathVariable Long id) {
        moduleService.deleteById(id);
    }

}
