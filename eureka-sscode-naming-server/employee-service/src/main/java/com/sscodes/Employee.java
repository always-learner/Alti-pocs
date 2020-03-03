package com.sscodes;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by ssharma6757 on 10/10/2019.
 */

public class Employee {

    @ApiModelProperty(notes = "Employee id ")
    private long id;

    @ApiModelProperty(notes = "Employee name can not be empty  ", required = true)
    private String name;

    @ApiModelProperty(notes = "Employee should have assigned to a department ", required = true)
    private String department;

    public Employee() {
    }

    public Employee(long id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return department != null ? department.equals(employee.department) : employee.department == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }
}
