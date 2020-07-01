package com.example.firebase_jsondocument;
public class Employee {
    String id,name,salary;
    public Employee(String id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public Employee() { }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSalary() { return salary; }
    public void setSalary(String salary) { this.salary = salary; }
}
