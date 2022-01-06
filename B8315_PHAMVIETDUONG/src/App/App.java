/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import DatabaseAccess.CarManager;
import Entity.Cargo;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        CarManager cm = new CarManager();
        int choice;
        do {
            System.out.println("======Menu=====");
            System.out.println("1.Add new Cargo.");
            System.out.println("2.View Cargo list.");
            System.out.println("3.Update Cargo.");
            System.out.println("4.Export data to file.");
            System.out.println("5.Exit.");
            System.out.println("Choice: ");
            Scanner d = new Scanner(System.in);
             choice = d.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("======Inputdata=======");
                    cm.insertCargo();
                    break;
                case 2:
                    List<Cargo> list = cm.getAllCargo();
                    System.out.println("=======DisPlay=========");
                    for (Cargo car : list) {
                        car.display();
                        System.out.println("---");
                    }
                    break;
                case 3:
                    System.out.println("Nhap id Car can update:");
                    Scanner s = new Scanner(System.in);
                    int id = s.nextInt();
                    cm.updateCargo(id);
                    break;
                case 4:
                    cm.exportCargo();
                    break;
                case 5:
                    cm.closeCon();
                    System.exit(0);
                    break;
            }
        } while (choice >=1 && choice <=5);

    }

}
