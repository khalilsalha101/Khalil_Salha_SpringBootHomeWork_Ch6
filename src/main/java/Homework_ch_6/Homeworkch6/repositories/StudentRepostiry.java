/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_ch_6.Homeworkch6.repositories;

import Homework_ch_6.Homeworkch6.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author khalil
 */
public interface StudentRepostiry extends JpaRepository<Student, Integer>{
    
}
