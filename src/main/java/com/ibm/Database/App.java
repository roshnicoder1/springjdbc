package com.ibm.Database;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.dao.CustomerDao;
import com.ibm.model.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
        CustomerDao dao=(CustomerDao)ctx.getBean("cdao");
        //insert
//        int status=dao.saveCustomer(new Customer(103,"Roshni",6500.0));
// System.out.println(status);
        //update
//        int status=dao.updateCustomer(new Customer(103,"Rosh",6500.0));
//        System.out.println(status);
      //delete 
//        Customer c=new Customer();
//        c.setCustcode(102);
//        int status=dao.deleteCustomer(c);
//        System.out.println(status);
        
        //extract data
        List<Customer>list=dao.getAllCustomers();
        for(Customer p:list)
        	System.out.println(p);
        
        
        
        
        
    }

	
}
