import db.DBCustomer;
import models.Customer;
import models.Order;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        Customer customer = new Customer("Paul", "Kelly", "shoes");
        DBCustomer.save(customer);
        List<Customer> customers = DBCustomer.getAllCustomers();
        customer.setFirstName("Elaine");
        DBCustomer.update(customer );
        Order order = new Order("12/05/18", "Shoes");
        DBCustomer.save(order);
        List<Order> orders = DBCustomer.getAllOrders();
        Order newOrder = DBCustomer.findOrder(order.getId());
        DBCustomer.delete(customer);
        Customer customer1 = new Customer("Bob", "Bell", "Jacket");
        DBCustomer.save(customer1);
        List<Customer> customersAfterDelete = DBCustomer.getAllCustomers();
    }
}
