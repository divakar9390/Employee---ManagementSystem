package com.example.model;

public class Employee {
    private long id;
    private String name;
    private String email;
    private String department;
    private double salary;
    private long phn_no;
   

    public Employee(long id,String name,String email,String department,double salary,long phn_no) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.phn_no = phn_no;
       
    }
    public Employee(){

    }

    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;

    }
    public String getDepartment(){
        return department;

    }
    public double getSalary(){
        return salary;
    }
    public long getPhnNo(){
        return phn_no;
    }
    
    public void setId(long id ){
        this.id = id ;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setPhnNo(long phn_no){
        this.phn_no = phn_no;
    }
     
    
    @Override
    public String toString(){
        return "Employee Details:{" + "id = "+id+" ,name = "+name+" ,email = "+email+" ,department = "+department+" ,salary = "+salary+" ,Phone_No = "+phn_no+"}";

    }

    
    
}
