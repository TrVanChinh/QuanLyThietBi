/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trunghuynh
 */
public class Kho {
    private int id;
    private String name;
    private String area;
    private String area_empty;
    private String address;
    private String idP;

    public Kho() {
    }

    public Kho(int id, String name, String area, String area_empty, String address, String idP) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.area_empty = area_empty;
        this.address = address;
        this.idP = idP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getArea_empty() {
        return area_empty;
    }

    public void setArea_empty(String area_empty) {
        this.area_empty = area_empty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }
    
    
}
