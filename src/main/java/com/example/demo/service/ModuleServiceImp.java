package com.example.demo.service;

import com.example.demo.dto.ModuleDto;
import com.example.demo.errorhandlers.ModuleAlreadyExistException;
import com.example.demo.errorhandlers.UserAlreadyExistException;
import com.example.demo.model.Module;
import com.example.demo.model.Topic;
import com.example.demo.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModuleServiceImp implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleServiceImp(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<ModuleDto> findAll() {
        List<ModuleDto> moduleDtoList = moduleRepository.findAll().stream()
                .map(m -> moduleToModuleDto(m)).collect(Collectors.toList());
        return moduleDtoList;
    }

    @Override
    public ModuleDto findById(Long id) {
        Module module = moduleRepository.findById(id).orElseThrow();
        return moduleToModuleDto(module);
    }

    @Override
    public ModuleDto findByTitle(String title) {
        Module module = moduleRepository.findByTitle(title).orElseThrow();
        return moduleToModuleDto(module);
    }

    @Override
    public ModuleDto save(ModuleDto moduleDto) {
        Module module;
        Optional<Module> moduleRepo = moduleRepository.findByTitle(moduleDto.getTitle());
        if (moduleRepo.isEmpty()) { //new Module creation
            module = moduleDtoToEnrichModule(moduleDto, new Module());
        } else { //update Module
            module = moduleDtoToEnrichModule(moduleDto, moduleRepo.get());
        }
        Module moduleSaved = moduleRepository.save(module);
        return moduleToModuleDto(moduleSaved);
    }

    @Override
    public ModuleDto createModule(ModuleDto moduleDto) {
        Optional<Module> moduleRepo = moduleRepository.findByTitle(moduleDto.getTitle());
        if (moduleRepo.isPresent()) {
            throw new ModuleAlreadyExistException("Module with such title already exist. Provide another title.");
        }
        return save(moduleDto);
    }

    @Override
    public void deleteById(Long id) {
        moduleRepository.deleteById(id);
    }

    private ModuleDto moduleToModuleDto(Module module) {
        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setId(module.getId());
        moduleDto.setTitle(module.getTitle());
        moduleDto.setDescription(module.getDescription());
        moduleDto.setDateAuthorCreation(module.getDateAuthorCreation());
        moduleDto.setDateAuthorUpdate(module.getDateAuthorUpdate());
        moduleDto.setDateAuthorDeletion(module.getDateAuthorDeletion());
        if (module.getCourse() != null) {
            moduleDto.setCourseId(module.getCourse().getId());
        }
        if (module.getTopics() != null) {
            moduleDto.setTopicIds(module.getTopics().stream().map(Topic::getId).collect(Collectors.toSet()));
        }
        return moduleDto;
    }

    private Module moduleDtoToEnrichModule(ModuleDto moduleDto, Module module) {
        if (moduleDto.getTitle() != null && !moduleDto.getTitle().isEmpty()) {
            module.setTitle(moduleDto.getTitle());
        }
        if (moduleDto.getDescription() != null && !moduleDto.getDescription().isEmpty()) {
            module.setDescription(moduleDto.getDescription());
        }
        if (moduleDto.getDateAuthorCreation() != null && !moduleDto.getDateAuthorCreation().isEmpty()) {
            module.setDateAuthorCreation(moduleDto.getDateAuthorCreation());
        }
        if (moduleDto.getDateAuthorUpdate() != null && !moduleDto.getDateAuthorUpdate().isEmpty()) {
            module.setDateAuthorUpdate(moduleDto.getDateAuthorUpdate());
        }
        if (moduleDto.getDateAuthorDeletion() != null && !moduleDto.getDateAuthorDeletion().isEmpty()) {
            module.setDateAuthorDeletion(moduleDto.getDateAuthorDeletion());
        }
        return module;
    }

}
