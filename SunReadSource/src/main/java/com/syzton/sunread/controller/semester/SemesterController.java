package com.syzton.sunread.controller.semester;

import javassist.NotFoundException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syzton.sunread.dto.common.PageResource;
import com.syzton.sunread.dto.semester.SemesterDTO;
import com.syzton.sunread.model.semester.Semester;
import com.syzton.sunread.service.semester.SemesterService;

/*
 * @Date:2015-3-15
 * @Author: Morgan-Leon
 */
@Controller
@RequestMapping(value="/api")
public class SemesterController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(SemesterController.class);
    private SemesterService service;
    @Autowired
    public  SemesterController(SemesterService service){
    	this.service = service;
    }
    
//Add a Semester 
    @RequestMapping(value = "/semester", method = RequestMethod.POST)
    @ResponseBody
    public SemesterDTO add(@Valid @RequestBody SemesterDTO dto) {
        LOGGER.debug("Adding a new semester entry with information: {}", dto);
        
        SemesterDTO added = service.add(dto);
        LOGGER.debug("Added a semester entry with information: {}", added);
              
       return added;
    }
    
    
//Delete a semester
    @RequestMapping(value = "/semester/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Semester deleteById(@Valid @PathVariable("id") Long id) {
        LOGGER.debug("Deleting a semester entry with id: {}", id);

        Semester deleted = service.deleteById(id);
        LOGGER.debug("Deleted semester entry with information: {}", deleted);

        return deleted;
    }
    
//Update a semester    
    @RequestMapping(value = "/semester/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public SemesterDTO update(@Valid @RequestBody SemesterDTO dto,@PathVariable("id") long id) throws NotFoundException {
        LOGGER.debug("Adding a new semester entry with information: {}", dto);
        
        SemesterDTO updated = service.update(dto);
        LOGGER.debug("Added a semester with information: {}", updated);
              
       return updated;
    } 

//Get all Semesters
    @RequestMapping(value = "/semesters", method = RequestMethod.GET)
    @ResponseBody
    public PageResource<Semester> findAll(
    						@RequestParam("page") int page,
                            @RequestParam("size") int size,
                            @RequestParam(value = "sortBy",required = false) String sortBy) throws NotFoundException {
        LOGGER.debug("Finding  semesters entry " );
        sortBy = sortBy==null?"id": sortBy;
        Pageable pageable = new PageRequest(page,size,new Sort(sortBy));
        Page<Semester> pageResult = service.findAll(pageable);

        return new PageResource<>(pageResult,"page","size");
    }
    
//Get a Semester    
    @RequestMapping(value = "/semester/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Semester findById(@PathVariable("id") Long id) throws NotFoundException {
        LOGGER.debug("Finding a semester entry with id: {}", id);

        Semester found = service.findOne(id);
        LOGGER.debug("Found semester entry with information: {}", found);

        return found;
    }

}