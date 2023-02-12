package com.example.empManagement.restController;

import com.example.empManagement.dao.EmployeeDao;
import com.example.empManagement.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeControllerRest {

    private final EmployeeDao employeeDao;
    public EmployeeControllerRest(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    //    @RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET)
//    public
//    JSONObject getEmployeeById()
//    {
//        log.info("---------  Get Employee List Controller Rest  ---------");
//        JSONObject response = new JSONObject();
//        List<Employee>employeeList = new ArrayList<>();
//        try {
//            employeeList = employeeDao.findAll();
//            response.accumulate("status", 200)
//                    .accumulate("data", employeeList)
//                    .accumulate("message", "Employee List");
//        } catch (Exception ex) {
//            log.error("Error Occured :: " + ex.getMessage());
//        }
//        return response;
//    }


  /*  @RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET)
    public
    String getEmployeeById()
    {
        log.info("---------  Get Employee List Controller Rest  ---------");
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeDao.findAll();
        } catch (Exception ex) {
            log.error("Error Occured :: " + ex.getMessage());
        }
        return "index";
    }*/


    @RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET)
    public
    JSONObject getEmployeeById()
    {
        log.info("---------  Get Employee List Controller Rest  ---------");
        JSONObject response = new JSONObject();
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeDao.findAll();
            response.accumulate("status", 200)
                    .accumulate("data", employeeList)
                    .accumulate("message", "Successfully fetched employee data");
        } catch (Exception ex) {
            log.error("Error Occured :: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public
    JSONObject getEmployeeById(@RequestParam(value = "id", required = true) Integer id)
    {
        log.info("---------  Get Employee By Id Controller Rest  ---------");
        JSONObject response = new JSONObject();
        try {

        } catch (Exception ex) {
            log.error("Error Occured :: " + ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public
    JSONObject saveEmployee(@RequestBody Employee employee)
    {
        log.info("---------  Save Employee Controller Rest  ---------");
        JSONObject response = new JSONObject();
        try {
            employeeDao.save(employee);
            response.accumulate("status" , 200);
            response.accumulate("data" , employee);
            response.accumulate("message" , "Successfully Saved The Employee In Db");
        } catch (Exception ex) {
            log.error("Error Occurred :: " + ex.getMessage());
        }

        return response;
    }

}
