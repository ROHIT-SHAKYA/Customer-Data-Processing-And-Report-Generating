package com.viva.CustomerProcessing.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.viva.CustomerProcessing.CustomerProcessingApplication;
import com.viva.CustomerProcessing.entity.Customer;
import com.viva.CustomerProcessing.listener.JobListner;
import com.viva.CustomerProcessing.logger.Slf4jLogger;

public class CustomerItemProcessor implements ItemProcessor<Customer,Customer> {
	//processing of data items
	@Autowired
	public JobListner job;
	
	//@Autowired
	 Slf4jLogger logger = new Slf4jLogger(CustomerProcessingApplication.class);
	public Customer process(Customer customer) {
	//	logger.info("-----------------Hello---------------------");
		//use data stored in set 
		if(job.dbRecords.contains(customer)) {
			logger.info("Customer with phone number "+customer.getPhoneNumber()+" ------->Registration Status : Failed.");
			return null;
		}
		else {
			logger.info("Customer with phone number "+customer.getPhoneNumber()+" ------->Registration Status : Success.");
			return customer;
		}
		
	}

}
