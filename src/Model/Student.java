/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Student {
    private int     id;
    private String  email;
    private String  name;
    private String  phone;
    private int  batchId;
    private String  batch;
    private String  address;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String email, String name, String phone, int batchId, String batch, String address) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.batchId = batchId;
        this.batch = batch;
        this.address = address;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
