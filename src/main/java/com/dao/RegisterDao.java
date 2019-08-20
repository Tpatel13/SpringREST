package com.dao;


import Models.Admin;
import Models.Customer;
import Models.Merchant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class RegisterDao {

       public boolean addUser(String name, String password, String email, String type) {


        try {
            Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Merchant.class);
            ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
            SessionFactory sf = con.buildSessionFactory(reg);
            Session session = sf.openSession();
            session.beginTransaction();
            if (type.equals("admin")) {
                Admin ob = new Admin();
                ob.setEmail(email);
                ob.setName(name);
                ob.setPassword(password);
                session.save(ob);


            } else if (type.equals("customer")) {
                Customer ob = new Customer();
                ob.setEmail(email);
                ob.setName(name);
                ob.setPassword(password);
                session.save(ob);
            } else {
                Merchant ob = new Merchant();
                ob.setEmail(email);
                ob.setName(name);
                ob.setPass(password);
                session.save(ob);
            }

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }
        return false;

    }


//        try {
//
//
//            Connection con = dbConnection.connect();
//            PreparedStatement pst = con.prepareStatement(" insert into `" + type + "`(name,password,email) values(?,?,?)");
//            pst.setString(1, name);
//            pst.setString(2, password);
//            pst.setString(3, email);
//            pst.execute();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//        return false;
//
//
//    }
}
