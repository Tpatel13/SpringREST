package com.dao;

import Models.Admin;

import Models.Customer;
import Models.Merchant;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class LoginDao {

    public String[] checkLogin(String name, String password, String type) {


        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(Merchant.class).addAnnotatedClass(Customer.class);

        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();


        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        session.beginTransaction();

        try {


            String[] data = new String[2];
            if (type.equals("admin")) {
                Query q = session.createQuery("from Admin a where a.name=:name and a.password=:password");
                q.setString("name", name);
                q.setString("password", password);
                Admin admin = (Admin) q.uniqueResult();
                data[0] = String.valueOf(admin.getId());
                data[1] = admin.getName();
            } else if (type.equals("customer")) {
                Query q = session.createQuery("from Customer a where a.name=:name and a.password=:password");
                q.setString("name", name);
                q.setString("password", password);
                Customer user = (Customer) q.uniqueResult();
                data[0] = String.valueOf(user.getId());
                data[1] = user.getName();
            } else if (type.equals("merchant")) {
                Query q = session.createQuery("from Merchant a where a.name=:name and a.password=:password");
                q.setString("name", name);
                q.setString("password", password);
                Merchant user = (Merchant) q.uniqueResult();
                data[0] = String.valueOf(user.getId());
                data[1] = user.getName();
            }

            return data;


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
}

