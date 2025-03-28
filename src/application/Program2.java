package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJdbc;
import model.entities.Department;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println();
        System.out.println("=== Test 1:Department findById ===");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);

        System.out.println();
        System.out.println("=== Test 2:Department findALL ===");
        List<Department> list;
        list = departmentDao.findAll();
        for (Department item: list){
            System.out.println(item);
        }

        System.out.println();
        System.out.println("=== Test 3:Department insert ===");
        Department obj = new Department(null,"games");
        departmentDao.insert(obj);
        System.out.println("insert completed id = " + obj.getId());

        System.out.println();
        System.out.println("=== Test 4:Department update ===");
        obj = new Department(9,"Java");
        departmentDao.update(obj);
        System.out.println("update completed");


        System.out.println();
        System.out.println("=== Test 5:Department delete ===");
        System.out.print("Enter id for delete test:");
        departmentDao.deleteById(sc.nextInt());
        System.out.println("delete completed");

        sc.close();
    }
}
