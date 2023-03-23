package sv.edu.utec.parcial02;

public class Employees {

    private String EmployeeName;

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    private String EmployeePosition;

    public String getEmployeePosition() {
        return EmployeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        EmployeePosition = employeePosition;
    }
    private String EmployeeCompany;

    public String getEmployeeCompany() {
        return EmployeeCompany;
    }

    public void setEmployeeCompany(String employeeCompany) {
        EmployeeCompany = employeeCompany;
    }

    public Employees (String employeeName, String employeePosition, String employeeCompany) {
        this.EmployeeName=employeeName;
        this.EmployeePosition=employeePosition;
        this.EmployeeCompany=employeeCompany;
    }
}
