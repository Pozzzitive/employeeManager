package bog.getArrays.employeeManager;

import bog.getArrays.employeeManager.model.Employee;
import bog.getArrays.employeeManager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;


    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>>  getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee>  getEmployeesById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @PostMapping("/add")//Adds things from the rfront end to the data base
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @PutMapping("/update") //Update Employee de aceea e put
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){ // Request body deoarece este un obiect transmis
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/update/{id}") //Update Employee de aceea e put
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){ // @PathVariable deoarece este o variabila deja transmisa in pathul mappingului -> "/update/{id}"
        //<?> arata ca nu se returneaza nimic
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Se foloseste postman pentru ca browserul poate sa trimita numai GetRequest
    //Postman poate sa trimita si PutRequest PostRequest DeteleRequest ...
}
