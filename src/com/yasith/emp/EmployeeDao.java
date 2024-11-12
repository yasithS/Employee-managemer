package com.yasith.emp;

public interface EmployeeDao {

    //create employee
    public void createEmployee (Employee emp);
    //show all employee
    public void showAllEmployee ();
    //show employee base on id
    public void showEmployee (int id);
    //update Employee
    public void updateEmployee (int id);
    //delete employee
    public void deleteEmployee (int id);
}
