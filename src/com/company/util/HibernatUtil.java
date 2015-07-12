package com.company.util;


import com.company.Cartridge;
import com.company.Company;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by v.pelenskyi on 08.07.2015.
 */
public class HibernatUtil  {
   //перемінна в яку записується резуьлтат методу buildSessionFactory()
   private static final SessionFactory sessionFactory = buildSessionFactory() ;

   // метод який будує повертати екземпляр обєкту із параметрами для підключення до бази даних
   private static SessionFactory buildSessionFactory() {
      try {
         //створюється обєкт в який передається конфіг файл xml та об'єкти таблиць
         return new AnnotationConfiguration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Cartridge.class).buildSessionFactory();
                 // в екземпляр обєкту передаємо обєкти таблиць

         //якщо конфігураційний файл відсутній видати посилку
      } catch (Throwable ex) {
         System.err.println("Initial SessionFactory creation failed." + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }

   public static SessionFactory getSessionFactory() {
      return sessionFactory;
   }

   public static void shutdown() {
      getSessionFactory().close();
   }

}
