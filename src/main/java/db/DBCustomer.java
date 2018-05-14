package db;

import models.Customer;
import models.Order;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBCustomer {

    public static Session session;
    public static Transaction transaction;

    public static void save(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void save(Order order){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public static List<Customer> getAllCustomers(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> results = null;
        try{
            String hql = "from Customer";
            results = session.createQuery(hql).list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static List<Order> getAllOrders(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Order> results = null;
        try{
            String hql = "from Order";
            results = session.createQuery(hql).list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void delete(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static Customer find(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Customer result = null;
        try{
            String hql = "from Customer where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            result = (Customer)query.uniqueResult();
        } catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }   return result;
    }

    public static Order findOrder(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Order result = null;
        try{
            String hql = "from Order where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            result = (Order)query.uniqueResult();
        } catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }   return result;
    }

    public static void update(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
