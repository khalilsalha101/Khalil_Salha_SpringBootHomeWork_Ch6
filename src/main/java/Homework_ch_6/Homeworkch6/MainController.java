/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_ch_6.Homeworkch6;

import Homework_ch_6.Homeworkch6.entity.Student;
import Homework_ch_6.Homeworkch6.repositories.StudentRepostiry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author khalil
 */
@RestController
public class MainController {
        @Autowired
        StudentRepostiry studentrepostiry;
        
        @RequestMapping("/")
        public String index()
        {
            return "";
        }
        @RequestMapping("/showall")
        public List<Student> stdlist(List<Student>std)
        {
            std=studentrepostiry.findAll();
            return std;
        }
        @RequestMapping("/add")
        public void newStudent(Integer sid,String sname,String major,Double grade)
        {
            Student std=new Student();
            std.setSid(sid);
            std.setSname(sname);
            std.setMajor(major);
            std.setGrade(grade);
            studentrepostiry.save(std);
        }
        @RequestMapping("/update")
        public void UpdateStudent(Integer id,String sname,String major,double grade)
        {
            Student std=studentrepostiry.findById(id).get();
            std.setSname(sname);
            std.setMajor(major);
            std.setGrade(grade);
            studentrepostiry.save(std);
            
        }
       @RequestMapping("/delete")
        public void DeleteStudent(Integer id)
        {
            Student std=studentrepostiry.findById(id).get();
            studentrepostiry.delete(std);
        }
    
  }
