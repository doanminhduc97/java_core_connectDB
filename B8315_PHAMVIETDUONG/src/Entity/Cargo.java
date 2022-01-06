/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Cargo implements Serializable{
    private int id,quantity,tax;
    private String name,supplier;
    private float price;

    public Cargo() {
    }

    public Cargo(int id, int quantity, int tax, String name, String supplier, float price) {
        this.id = id;
        this.quantity = quantity;
        this.tax = tax;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void input(){
        System.out.println("Nhap name:");
        Scanner s = new Scanner(System.in);
        this.name = s.nextLine();
        while(name.length()==0){
            System.out.println("Ban khong duoc bo trong field Name.Moi nhap du lieu:");
            this.name = s.nextLine();
        }
        System.out.println("Nhap ten nha cung cap: ");
        this.supplier = s.nextLine();
        System.out.println("Nhap so luong: ");
        this.quantity = s.nextInt();
        System.out.println("Nhap gia: ");
        this.price = s.nextFloat();
        System.out.println("Nhap tax: ");
        this.tax = s.nextInt();
        System.out.println("---Nhap thong tin thanh cong---");
    }
    public void display(){
        System.out.println("id: " + id);
        System.out.println("Name: " + name);
        System.out.println("Supplier: " + supplier);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("Tax: " + tax);
    }
}
