/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import Entity.Cargo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CarManager {
    Connection con = null;

    public CarManager() {
        try {
            con = ConnectDB.getConnet();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertCargo(){
        try {
            PreparedStatement ps = con.prepareStatement("insert into Cargo(name,supplier,quantity,price,tax) values(?,?,?,?,?)");
            Cargo c = new Cargo();
            c.input();
            ps.setString(1,c.getName());
            ps.setString(2,c.getSupplier());
            ps.setInt(3,c.getQuantity());
            ps.setFloat(4,c.getPrice());
            ps.setInt(5,c.getTax());
            int row = ps.executeUpdate();
            if (row > 0 ) {
                System.out.println("Insert thanh cong!");
            }else{
                System.out.println("Insert that bai. vui long xem lai du lieu!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Cargo> getAllCargo(){
        List<Cargo> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Cargo");
            while(rs.next()){
                Cargo c = new Cargo();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setSupplier(rs.getString(3));
                c.setQuantity(rs.getInt(4));
                c.setPrice(rs.getFloat(5));
                c.setTax(rs.getInt(6));
                list.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CarManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void updateCargo(int id){
        try {
            PreparedStatement ps = con.prepareStatement("update Cargo Set name=?,supplier=?,quantity=?,price=?,tax=? where id = ?");
            Cargo c = new Cargo();
            System.out.println("========Update=========");
            c.input();
            ps.setString(1,c.getName());
            ps.setString(2,c.getSupplier());
            ps.setInt(3,c.getQuantity());
            ps.setFloat(4,c.getPrice());
            ps.setInt(5,c.getTax());
            ps.setInt(6,id);
            int row = ps.executeUpdate();
            if (row>0) {
                System.out.println("Update thanh cong!");
            }else{
                System.out.println("Update that bai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void exportCargo() throws IOException{
        System.out.println("Nhap ten file can ghi ra:");
        Scanner s = new Scanner(System.in);
        String file = s.nextLine();
        List<Cargo> list = getAllCargo();
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream ob = new ObjectOutputStream(f);
            ob.writeObject(list);
            ob.flush();
            ob.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void closeCon(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CarManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
