package com.example.demo.service;

import com.example.demo.dto.ModuleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModuleService {

    List<ModuleDto> findAll();
    ModuleDto findById(Long id);
    ModuleDto findByTitle(String title);
    ModuleDto save(ModuleDto moduleDto);
    ModuleDto createModule(ModuleDto moduleDto);
    void deleteById(Long id);

}
