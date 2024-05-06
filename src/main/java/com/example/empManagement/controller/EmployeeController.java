package com.example.empManagement.controller;

import com.example.empManagement.dao.EmployeeDao;
import com.example.empManagement.enums.DesignationEnum;
import com.example.empManagement.enums.GenderEnum;
import com.example.empManagement.model.Employee;
import com.example.empManagement.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class, true));
        binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true));
    }


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/list")
    public String employeeList(HttpServletRequest request, Model model){
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeDao.findAll();
        } catch (Exception ex) {
            log.error("Error Occured :: " + ex.getMessage());
        }
        model.addAttribute("employees",employeeList);
        return "employeeList";
    }
    @GetMapping(value = {"/create","/edit", "/view"})
    public String employeeCreate(Model model) {
//        log.info(" --------- Employee Create,View,Edit Get Controller ---------");
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("genderList", GenderEnum.genderAsJsonArray());
        model.addAttribute("positionList", DesignationEnum.positionAsJsonArray());
        return "employeeCreate";
    }

    @PostMapping("/save")
    public String employeeCreatePost(@ModelAttribute("employee") Employee employee) {
//        log.info(" --------- Employee  Post Controller ---------");
        try{
            employeeDao.save(employee);
        } catch (Exception ex) {
            log.error("Error Occurred :" + ex.getMessage());
        }
        return "redirect:./employee";
    }



}
