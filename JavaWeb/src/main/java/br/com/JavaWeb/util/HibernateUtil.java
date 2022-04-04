package br.com.JavaWeb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
 private  static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

 
 public static SessionFactory getFabricaDeSessoes() {
	return fabricaDeSessoes;
}


public static SessionFactory criarFabricaDeSessoes() {
	   try {
		   
		   Configuration configuracao = new Configuration().configure("hibernate.cfg.xml");
		   SessionFactory fabrica = configuracao.buildSessionFactory();
		   return fabrica;
	
	   } catch (Throwable ex) {
		   System.out.println("A fabrica de sessoes não pode ser criada");
		   throw new ExceptionInInitializerError(ex);
	}
 }
 
}
