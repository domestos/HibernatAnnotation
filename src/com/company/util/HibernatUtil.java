package com.company.util;


import com.company.Cartridge;
import com.company.Company;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by v.pelenskyi on 08.07.2015.
 */
public class HibernatUtil  {
   //�������� � ��� ���������� ��������� ������ buildSessionFactory()
   private static final SessionFactory sessionFactory = buildSessionFactory() ;

   // ����� ���� ���� ��������� ��������� ����� �� ����������� ��� ���������� �� ���� �����
   private static SessionFactory buildSessionFactory() {
      try {
         //����������� ���� � ���� ���������� ������ ���� xml �� ��'���� �������
         return new AnnotationConfiguration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Cartridge.class).buildSessionFactory();
                 // � ��������� ����� �������� ����� �������

         //���� ��������������� ���� ������� ������ �������
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
