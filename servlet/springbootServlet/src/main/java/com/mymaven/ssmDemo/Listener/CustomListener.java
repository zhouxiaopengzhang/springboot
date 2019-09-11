package com.mymaven.ssmDemo.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CustomListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
	}

}
