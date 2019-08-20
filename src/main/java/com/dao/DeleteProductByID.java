package com.dao;

import Models.Customer;
import Models.Merchant;
import Models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class DeleteProductByID {
    public boolean delete(int id) {
        Configuration con = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Merchant.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        try {

            session.beginTransaction();
            Product p = (Product) session.get(Product.class, id);
            session.delete(p);
            session.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;


    }
}
