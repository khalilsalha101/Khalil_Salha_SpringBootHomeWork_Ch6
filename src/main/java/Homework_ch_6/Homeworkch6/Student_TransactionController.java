/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework_ch_6.Homeworkch6;

import Homework_ch_6.Homeworkch6.entity.Student;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Component;

/**
 * FXML Controller class
 *
 * @author khalil
 */
@Component
public class Student_TransactionController implements Initializable {

    @FXML
    private TextField txtsid;
    @FXML
    private TextField txtsname;
    @FXML
    private TextField txtmajor;
    @FXML
    private TextField txtgrade;
    @FXML
    private TableView<Student> tableviewstd;
    @FXML
    private TableColumn<Student,Integer> tcSID;
    @FXML
    private TableColumn<Student,String> tcSNAME;
    @FXML
    private TableColumn<Student,String> tcMjo;
    @FXML
    private TableColumn<Student,Double> tcGRADE;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonEdit;
    @FXML
    private Button buttonDelete;
    private EntityManagerFactory emf;
    private MainController main;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tcSID.setCellValueFactory(new PropertyValueFactory("sid"));
        tcSNAME.setCellValueFactory(new PropertyValueFactory("sname"));
        tcMjo.setCellValueFactory(new PropertyValueFactory("major"));
        tcGRADE.setCellValueFactory(new PropertyValueFactory("grade"));
        main=new MainController();
        List<Student>std=new ArrayList<>();
        tableviewstd.getItems().setAll(main.stdlist(std));
        tableviewstd.getSelectionModel().selectedItemProperty().addListener(
                event-> showSelectedStudent()
          );
        
    }    

    @FXML
    private void buttonAddHandle(ActionEvent event) {
        Integer sid=Integer.parseInt(txtsid.getText());
        String sname=txtsname.getText();
        String majot=txtmajor.getText();
        Double grade=Double.parseDouble(txtgrade.getText());
        main.newStudent(sid, sname, majot, grade);
        tableviewstd.getItems().clear();
        referachTable();
    }

    @FXML
    private void buttonEditHandle(ActionEvent event) {
        Integer sid=Integer.parseInt(txtsid.getText());
        String sname=txtsname.getText();
        String majot=txtmajor.getText();
        Double grade=Double.parseDouble(txtgrade.getText());
        main.UpdateStudent(sid, sname, majot, grade);
        tableviewstd.getItems().clear();
        referachTable();
    }

    @FXML
    private void buttonDeleteHandle(ActionEvent event) {
        Integer sid=Integer.parseInt(txtsid.getText());
        main.DeleteStudent(sid);
        tableviewstd.getItems().clear();
        referachTable();
    }
    private void showSelectedStudent(){
        Student student = tableviewstd.getSelectionModel().getSelectedItem();
        if(student != null){
        txtsid.setText(String.valueOf(student.getSid()));
        txtsname.setText(student.getSname());
        txtmajor.setText(student.getMajor());
        txtgrade.setText(String.valueOf(student.getGrade()));
        }

    }
    private void referachTable()
    {
        tcSID.setCellValueFactory(new PropertyValueFactory("sid"));
        tcSNAME.setCellValueFactory(new PropertyValueFactory("sname"));
        tcMjo.setCellValueFactory(new PropertyValueFactory("major"));
        tcGRADE.setCellValueFactory(new PropertyValueFactory("grade"));
        this.emf = Persistence.createEntityManagerFactory("PR3_2020PU");
        EntityManager em=emf.createEntityManager();
        List<Student> std=new ArrayList<>();
        tableviewstd.getItems().setAll(main.stdlist(std));
        
    }
    
}
