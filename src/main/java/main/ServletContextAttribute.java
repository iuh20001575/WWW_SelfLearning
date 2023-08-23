package main;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;

public class ServletContextAttribute implements ServletContextAttributeListener {
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		ServletContextAttributeListener.super.attributeAdded(scae);
		
		System.out.println("attributeAdded");
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		ServletContextAttributeListener.super.attributeRemoved(scae);
		
		System.out.println("attributeRemoved");
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		ServletContextAttributeListener.super.attributeReplaced(scae);
		
		System.out.println("attributeReplaced");
	}
}
