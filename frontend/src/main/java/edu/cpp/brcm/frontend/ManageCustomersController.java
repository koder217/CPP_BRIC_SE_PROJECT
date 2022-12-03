package edu.cpp.brcm.frontend;

import edu.cpp.brcm.dtos.*;
import edu.cpp.brcm.frontend.http.BrcmAPI;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
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
    @FXML
    public Button btnAddNewStudent;
    @FXML
    public Button btnRefreshStudents;
    @FXML
    public Button btnAddNewProfessor;
    @FXML
    public Button btnRefreshProfessors;
    @FXML
    public TextField txtResearch;
    @FXML
    public TabPane tabsContainer;
    @FXML
    private TableView.TableViewSelectionModel<ProfessorDto> professorSelectionModel;
    @FXML
    private TableView.TableViewSelectionModel<StudentDto> studentSelectionModel;
    //endregion

    private void initializeTables(){
        tableStudents.setPlaceholder(
                new Label("No students to display. Try adding one!"));
        TableColumn<StudentDto, Integer> columnId = new TableColumn<>("Id");
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<StudentDto, String> column1 = new TableColumn<>("FirstName");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        TableColumn<StudentDto, String> column2 = new TableColumn<>("LastName");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        TableColumn<StudentDto, LocalDate> column3 = new TableColumn<>("DoB");
        column3.setCellValueFactory(new PropertyValueFactory<>("dateofbirth"));
        TableColumn<StudentDto, String> column4 = new TableColumn<>("Phone");
        column4.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<StudentDto, String> column5 = new TableColumn<>("Street");
        column5.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getStreet()));
        TableColumn<StudentDto, String> column6 = new TableColumn<>("Number");
        column6.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getNumber()));
        TableColumn<StudentDto, String> column7 = new TableColumn<>("Zipcode");
        column7.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getZipcode().toString()));
        TableColumn<StudentDto, String> column8 = new TableColumn<>("City");
        column8.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getCity()));
        TableColumn<StudentDto, String> column9 = new TableColumn<>("State");
        column9.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getState()));
        TableColumn<StudentDto, String> column10 = new TableColumn<>("Major");
        column10.setCellValueFactory(new PropertyValueFactory<>("major"));
        TableColumn<StudentDto, String> column11 = new TableColumn<>("Minor");
        column11.setCellValueFactory(new PropertyValueFactory<>("minor"));
        TableColumn<StudentDto, LocalDate> column12 = new TableColumn<>("Enter Date");
        column12.setCellValueFactory(new PropertyValueFactory<>("enterdate"));
        TableColumn<StudentDto, LocalDate> column13 = new TableColumn<>("Grad Date");
        column13.setCellValueFactory(new PropertyValueFactory<>("graddate"));
        TableColumn<StudentDto, Button> columnSedit =
                new TableColumn<>("Edit");
        columnSedit.setCellFactory(EditButtonTableCell.<StudentDto>forTableColumn("Edit", (StudentDto p) -> {
            choiceCustomerType.setValue("STUDENT");
            populateFormWithStudent(p);
            tabsContainer.getSelectionModel().selectLast();
            return p;
        }));
        TableColumn<StudentDto, Button> columnSdelete =
                new TableColumn<>("Delete");
        columnSdelete.setCellFactory(DeleteButtonTableCell.<StudentDto>forTableColumn("Delete", (StudentDto p) -> {
            deleteStudent(p);
            return p;
        }));

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
        studentColumns.add(columnSedit);
        studentColumns.add(columnSdelete);
        tableProfessors.setPlaceholder(
                new Label("No professors to display. Try adding one!"));
        TableColumn<ProfessorDto, Integer> columnId1 = new TableColumn<>("Id");
        columnId1.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<ProfessorDto, String> columnA = new TableColumn<>("FirstName");
        columnA.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        TableColumn<ProfessorDto, String> columnB = new TableColumn<>("LastName");
        columnB.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        TableColumn<ProfessorDto, LocalDate> columnC = new TableColumn<>("DoB");
        columnC.setCellValueFactory(new PropertyValueFactory<>("dateofbirth"));
        TableColumn<ProfessorDto, String> columnD = new TableColumn<>("Phone");
        columnD.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<ProfessorDto, String> columnE = new TableColumn<>("Street");
        columnE.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getStreet()));
        TableColumn<ProfessorDto, String> columnF = new TableColumn<>("Number");
        columnF.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getNumber()));
        TableColumn<ProfessorDto, String> columnG = new TableColumn<>("Zipcode");
        columnG.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getZipcode().toString()));
        TableColumn<ProfessorDto, String> columnH = new TableColumn<>("City");
        columnH.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getCity()));
        TableColumn<ProfessorDto, String> columnI = new TableColumn<>("State");
        columnI.setCellValueFactory(celldata->new SimpleStringProperty(celldata.getValue().getAddress().getState()));
        TableColumn<ProfessorDto, String> columnJ = new TableColumn<>("Office");
        columnJ.setCellValueFactory(new PropertyValueFactory<>("office"));
        TableColumn<ProfessorDto, String> columnK = new TableColumn<>("Department");
        columnK.setCellValueFactory(new PropertyValueFactory<>("department"));
        TableColumn<ProfessorDto, String> columnL = new TableColumn<>("Research");
        columnL.setCellValueFactory(new PropertyValueFactory<>("research"));
        TableColumn<ProfessorDto, Button> columnPedit =
                new TableColumn<>("Edit");
        columnPedit.setCellFactory(EditButtonTableCell.<ProfessorDto>forTableColumn("Edit", (ProfessorDto p) -> {
            choiceCustomerType.setValue("PROFESSOR");
            populateFormWithProfessor(p);
            tabsContainer.getSelectionModel().selectLast();
            return p;
        }));
        TableColumn<ProfessorDto, Button> columnPdelete =
                new TableColumn<>("Delete");
        columnPdelete.setCellFactory(DeleteButtonTableCell.<ProfessorDto>forTableColumn("Delete", (ProfessorDto p) -> {
            deleteProfessor(p);
            return p;
        }));

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
        professorColumns.add(columnPedit);
        professorColumns.add(columnPdelete);

        professorSelectionModel = tableProfessors.getSelectionModel();
        professorSelectionModel.setSelectionMode(SelectionMode.SINGLE);
        refreshProfessors();
        ObservableList<ProfessorDto> professorSelectedItems = professorSelectionModel.getSelectedItems();
        professorSelectedItems.addListener(
                (ListChangeListener<ProfessorDto>) change -> {
                    var ol = change.getList();
                    if (ol.size() > 0) {
                        ProfessorDto ad = change.getList().get(0);
                        populateFormWithProfessor(ad);
                    }
                });
        professorSelectionModel.select(0);

        studentSelectionModel = tableStudents.getSelectionModel();
        studentSelectionModel.setSelectionMode(SelectionMode.SINGLE);
        refreshStudents();
        ObservableList<StudentDto> studentSelectedItems = studentSelectionModel.getSelectedItems();
        studentSelectedItems.addListener(
                (ListChangeListener<StudentDto>) change -> {
                    var ol = change.getList();
                    if (ol.size() > 0) {
                        StudentDto ad = change.getList().get(0);
                        populateFormWithStudent(ad);
                    }
                });
        studentSelectionModel.select(0);
    }

    private void deleteProfessor(ProfessorDto p) {
        try {
            BrcmAPI.DeleteRequest(BrcmAPI.ProfessorsUrl+p.getId().toString());
            refreshProfessors();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteStudent(StudentDto p) {
        try {
            BrcmAPI.DeleteRequest(BrcmAPI.StudentsUrl+p.getId().toString());
            refreshStudents();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void initialize(){
        btnAddNewStudent.setOnAction(this::btnAddNewStudent_Clicked);
        btnAddNewProfessor.setOnAction(this::btnAddNewProfessor_Clicked);
        btnRefreshStudents.setOnAction(this::btnRefreshStudents_Clicked);
        btnRefreshProfessors.setOnAction(this::btnRefreshProfessors_Clicked);
        btnSaveChanges.setOnAction(this::btnSaveChanges_Clicked);

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

    private void btnSaveChanges_Clicked(ActionEvent actionEvent) {
        var customerType= choiceCustomerType.getValue();
        try {
            if (customerType == "STUDENT") {
                StudentDto sd = new StudentDto(0, dtEnter.getValue(), txtMajor.getText(), txtMinor.getText(), dtGrad.getValue(), getCustomerDtoFromForm());
                try {
                    BrcmAPI.PostRequest(BrcmAPI.StudentsUrl, sd, StudentDto.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                ProfessorDto pd = new ProfessorDto(0, txtDepartment.getText(), txtOffice.getText(), txtResearch.getText(), getCustomerDtoFromForm());
                try {
                    BrcmAPI.PostRequest(BrcmAPI.ProfessorsUrl, pd, ProfessorDto.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }catch (NumberFormatException ex){
            ErrorUtil.showError("Zip code must be a number");
        }
    }

    private void btnRefreshProfessors_Clicked(ActionEvent actionEvent) {
        refreshProfessors();
    }

    private void btnRefreshStudents_Clicked(ActionEvent actionEvent) {
        refreshStudents();
    }

    private void btnAddNewProfessor_Clicked(ActionEvent actionEvent) {
        resetCustomerFieldsToEmpty();
        choiceCustomerType.setValue("PROFESSOR");
        txtDepartment.setText("");
        txtOffice.setText("");
        txtResearch.setText("");
        tabsContainer.selectionModelProperty().get().selectLast();
    }

    private void btnAddNewStudent_Clicked(ActionEvent actionEvent) {
        resetCustomerFieldsToEmpty();
        choiceCustomerType.setValue("STUDENT");
        txtMajor.setText("");
        txtMinor.setText("");
        dtEnter.setValue(LocalDate.now());
        dtGrad.setValue(LocalDate.now().plusYears(4));
        tabsContainer.selectionModelProperty().get().selectLast();
    }

    private void refreshStudents() {
        var dto = BrcmAPI.GetRequest(BrcmAPI.StudentsUrl, StudentDto[].class);
        if(dto != null){
            System.out.println("# of Students:"+dto.length);
            tableStudents.getItems().clear();
            tableStudents.getItems().addAll(dto);
            studentSelectionModel.select(0);
        }
    }

    private void refreshProfessors() {
        var dto = BrcmAPI.GetRequest(BrcmAPI.ProfessorsUrl, ProfessorDto[].class);
        if(dto != null){
            System.out.println("# of Professors: "+dto.length);
            tableProfessors.getItems().clear();
            tableProfessors.getItems().addAll(dto);
            professorSelectionModel.select(0);
        }
    }

    private void populateFormWithStudent(StudentDto ad) {
        populateFormWithCustomerFields(ad);
        txtMajor.setText(ad.getMajor());
        txtMinor.setText(ad.getMinor());
        dtEnter.setValue(ad.getEnterdate());
        dtGrad.setValue(ad.getGraddate());
    }

    private void populateFormWithProfessor(ProfessorDto ad) {
        populateFormWithCustomerFields(ad);
        txtDepartment.setText(ad.getDepartment());
        txtOffice.setText(ad.getOffice());
        txtResearch.setText(ad.getResearch());
    }
    private void resetCustomerFieldsToEmpty(){
        txtFirstName.setText("");
        txtLastName.setText("");
        dtDob.setValue(LocalDate.now().minusYears(18));
        txtPhone.setText("");
        txtStreet.setText("");
        txtNumber.setText("");
        txtZip.setText("");
        txtCity.setText("");
        txtState.setText("");
    }
    private void populateFormWithCustomerFields(CustomerDto cd){
        txtFirstName.setText(cd.getFirstname());
        txtLastName.setText(cd.getLastname());
        dtDob.setValue(cd.getDateofbirth());
        txtPhone.setText(cd.getPhone());
        txtStreet.setText(cd.getAddress().getStreet());
        txtNumber.setText(cd.getAddress().getNumber());
        txtZip.setText(cd.getAddress().getZipcode().toString());
        txtCity.setText(cd.getAddress().getCity());
        txtState.setText(cd.getAddress().getState());
    }
    private AddressDto getAddressDtoFromForm() throws NumberFormatException{
        return new AddressDto(0,
                txtStreet.getText(),
                txtNumber.getText(),
                Integer.parseInt(txtZip.getText()),
                txtCity.getText(),
                txtState.getText());
    }
    private CustomerDto getCustomerDtoFromForm() throws NumberFormatException{
        return new CustomerDto(0, txtFirstName.getText(), txtLastName.getText(),dtDob.getValue(), txtPhone.getText(), getAddressDtoFromForm());
    }

}
