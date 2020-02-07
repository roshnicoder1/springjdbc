package com.ibm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.ibm.model.Customer;

public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	  
	public int saveCustomer(Customer c){  
	    String query="insert into customer values('"+c.getCustcode() +"','"+c.getCustname()+"','"+c.getAmount()+"')";  
	    return jdbcTemplate.update(query);  
	}  
	
	public int updateCustomer(Customer c){  
	    String query="update customer set custname='"+c.getCustname()+"', amount='"+c.getAmount()+"' where custcode='"+c.getCustcode()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	public int deleteCustomer(Customer c){  
	    String query="delete from customer where custcode='"+c.getCustcode()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	public List<Customer> getAllCustomers(){  
		 return jdbcTemplate.query("select * from customer",new ResultSetExtractor<List<Customer>>(){  
		    public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException {  
		      
		        List<Customer> list=new ArrayList<Customer>();  // Array list declared
		        while(rs.next()){  
		        Customer c = new Customer();
		        c.setCustcode(rs.getInt(1));
		        c.setCustname(rs.getString(2));
		        c.setAmount(rs.getInt(3));
		        list.add(c);  
		        }  
		        return list;  
		        }  
		    });  
}
}
