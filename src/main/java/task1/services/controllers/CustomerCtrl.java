package task1.services.controllers;

import task1.services.DB.data.CustomerRepo;
import task1.services.DB.data.PaymentsRepo;
import task1.services.DB.data.ProductRepo;
import task1.services.DB.data.interfaces.ICustomerRepo;
import task1.services.DB.models.Customer;
import task1.services.DB.models.PaymentCheck;
import task1.services.DB.models.Product;

import java.util.List;
import java.util.Scanner;

public class CustomerCtrl {
    ICustomerRepo customerRepo;

    static Scanner sc = new Scanner(System.in);
    List<Product> products = new ProductRepo().getAll();
    PaymentsRepo paymentsRepo = new PaymentsRepo();

    public CustomerCtrl(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer createCustomer(int id, int table){
            customerRepo.create(new Customer(id, table));
            return customerRepo.get(id);
        }
}
