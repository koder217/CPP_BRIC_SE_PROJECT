package edu.cpp.brcm.frontend;

import edu.cpp.brcm.dtos.ProfessorDto;
import edu.cpp.brcm.dtos.StudentDto;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

public class ManageCustomersController {


    //region UI Field References
    @FXML
    public HBox professorControls;
    @FXML
    public HBox studentControls;
    @FXML
    public ChoiceBox choiceCustomerType;
    @FXML
    public Button btnSaveChanges;
    @FXML
    public DatePicker dtGrad;
    @FXML
    public DatePicker dtEnter;
    @FXML
    public TextField txtMinor;
    @FXML
    public TextField txtMajor;
    @FXML
    public TextField txtDepartment;
    @FXML
    public TextField txtOffice;
    @FXML
    public TextField txtState;
    @FXML
    public TextField txtCity;
    @FXML
    public TextField txtZip;
    @FXML
    public TextField txtNumber;
    @FXML
    public TextField txtStreet;
    @FXML
    public DatePicker dtDob;
    @FXML
    public TextField txtPhone;
    @FXML
    public TextField txtLastName;
    @FXML
    public TextField txtFirstName;
    @FXML
    public Label lblStudentProfessorId;
    @FXML
    public TableView tableStudents;
    @FXML
    public TableView tableProfessors;
    public Button btnAddNewStudent;
    public Button btnRefreshStudents;
    public Button btnAddNewProfessor;
    public Button btnRefreshProfessors;
    //endregion

    private void initializeTables(){
        tableStudents.setPlaceholder(
                new Label("No students to display. Try adding one!"));
        TableColumn<StudentDto, Integer> columnId = new TableColumn<>("Id");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<StudentDto, String> column1 = new TableColumn<>("FirstName");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        TableColumn<StudentDto, String> column2 = new TableColumn<>("LastName");
        column2.setCellValueFactory(new PropertyValueFactory<>("lasttname"));
        TableColumn<StudentDto, LocalDate> column3 = new TableColumn<>("DoB");
        column3.setCellValueFactory(new PropertyValueFactory<>("dateofbirth"));
        TableColumn<StudentDto, String> column4 = new TableColumn<>("Phone");
        column4.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<StudentDto, String> column5 = new TableColumn<>("Street");
        column5.setCellValueFactory(new PropertyValueFactory<>("address.street"));
        TableColumn<StudentDto, String> column6 = new TableColumn<>("Number");
        column6.setCellValueFactory(new PropertyValueFactory<>("address.number"));
        TableColumn<StudentDto, Integer> column7 = new TableColumn<>("Zipcode");
        column7.setCellValueFactory(new PropertyValueFactory<>("address.zipcode"));
        TableColumn<StudentDto, String> column8 = new TableColumn<>("City");
        column8.setCellValueFactory(new PropertyValueFactory<>("address.city"));
        TableColumn<StudentDto, String> column9 = new TableColumn<>("State");
        column9.setCellValueFactory(new PropertyValueFactory<>("address.state"));
        TableColumn<StudentDto, String> column10 = new TableColumn<>("Major");
        column10.setCellValueFactory(new PropertyValueFactory<>("major"));
        TableColumn<StudentDto, String> column11 = new TableColumn<>("Minor");
        column11.setCellValueFactory(new PropertyValueFactory<>("minor"));
        TableColumn<StudentDto, LocalDate> column12 = new TableColumn<>("Enter Date");
        column12.setCellValueFactory(new PropertyValueFactory<>("enterdate"));
        TableColumn<StudentDto, LocalDate> column13 = new TableColumn<>("Grad Date");
        column13.setCellValueFactory(new PropertyValueFactory<>("graddate"));
        var studentColumns= tableStudents.getColumns();
        studentColumns.add(columnId);
        studentColumns.add(column1);
        studentColumns.add(column2);
        studentColumns.add(column3);
        studentColumns.add(column4);
        studentColumns.add(column5);
        studentColumns.add(column6);
        studentColumns.add(column7);
        studentColumns.add(column8);
        studentColumns.add(column9);
        studentColumns.add(column10);
        studentColumns.add(column11);
        studentColumns.add(column12);
        studentColumns.add(column13);

        tableProfessors.setPlaceholder(
                new Label("No professors to display. Try adding one!"));
        TableColumn<ProfessorDto, Integer> columnId1 = new TableColumn<>("Id");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<ProfessorDto, String> columnA = new TableColumn<>("FirstName");
        columnA.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        TableColumn<ProfessorDto, String> columnB = new TableColumn<>("LastName");
        columnB.setCellValueFactory(new PropertyValueFactory<>("lasttname"));
        TableColumn<ProfessorDto, LocalDate> columnC = new TableColumn<>("DoB");
        columnC.setCellValueFactory(new PropertyValueFactory<>("dateofbirth"));
        TableColumn<ProfessorDto, String> columnD = new TableColumn<>("Phone");
        columnD.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<ProfessorDto, String> columnE = new TableColumn<>("Street");
        columnE.setCellValueFactory(new PropertyValueFactory<>("address.street"));
        TableColumn<ProfessorDto, String> columnF = new TableColumn<>("Number");
        columnF.setCellValueFactory(new PropertyValueFactory<>("address.number"));
        TableColumn<ProfessorDto, Integer> columnG = new TableColumn<>("Zipcode");
        columnG.setCellValueFactory(new PropertyValueFactory<>("address.zipcode"));
        TableColumn<ProfessorDto, String> columnH = new TableColumn<>("City");
        columnH.setCellValueFactory(new PropertyValueFactory<>("address.city"));
        TableColumn<ProfessorDto, String> columnI = new TableColumn<>("State");
        columnI.setCellValueFactory(new PropertyValueFactory<>("address.state"));
        TableColumn<ProfessorDto, String> columnJ = new TableColumn<>("Office");
        columnJ.setCellValueFactory(new PropertyValueFactory<>("office"));
        TableColumn<ProfessorDto, String> columnK = new TableColumn<>("Department");
        columnK.setCellValueFactory(new PropertyValueFactory<>("department"));
        TableColumn<ProfessorDto, String> columnL = new TableColumn<>("Research");
        columnL.setCellValueFactory(new PropertyValueFactory<>("research"));
        var professorColumns= tableProfessors.getColumns();
        professorColumns.add(columnId1);
        professorColumns.add(columnA);
        professorColumns.add(columnB);
        professorColumns.add(columnC);
        professorColumns.add(columnD);
        professorColumns.add(columnE);
        professorColumns.add(columnF);
        professorColumns.add(columnG);
        professorColumns.add(columnH);
        professorColumns.add(columnI);
        professorColumns.add(columnJ);
        professorColumns.add(columnK);
        professorColumns.add(columnL);
    }
    @FXML
    public void initialize(){
        initializeTables();
        refreshStudents();
        refreshProfessors();
        choiceCustomerType.getItems().add("STUDENT");
        choiceCustomerType.getItems().add("PROFESSOR");
        choiceCustomerType.setValue("STUDENT");
        professorControls.managedProperty().bind(professorControls.visibleProperty());
        studentControls.managedProperty().bind(studentControls.visibleProperty());
        choiceCustomerType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                System.out.println(choiceCustomerType.getItems().get((Integer) number2));
                var selection = choiceCustomerType.getItems().get((Integer) number2);
                if (selection == "STUDENT"){
                    studentControls.setVisible(true);
                    professorControls.setVisible(false);
                }else{
                    studentControls.setVisible(false);
                    professorControls.setVisible(true);
                }
            }
        });
    }

    private void refreshStudents() {

    }

    private void refreshProfessors() {

    }
}
