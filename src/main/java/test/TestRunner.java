package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import pojoclasses.response.Response;
import webservices.DeleteMethod;
import webservices.GetMethod;
import webservices.PostMethod;
import webservices.UpdateMethod;


public class TestRunner {


	@Test(priority=1)
    public void test_Positive() throws JsonProcessingException{
		
		Response response;
		response = PostMethod.createSubTask("1234");
		Assert.assertEquals(response.getStaus(), "OK");
		
		// Retrieve For The given ID after create
		response = GetMethod.retrieveDependencies(response.getId()+"");
		Assert.assertEquals(response.getStaus(), "OK");
		
		//Update For The given ID after create
		response = UpdateMethod.updateTask(response.getId()+"");
		Assert.assertEquals(response.getStaus(), "OK");
		
		// Retrieve For The given ID after update
		response = GetMethod.retrieveDependencies(response.getId()+"");
		Assert.assertEquals(response.getStaus(), "OK");
		
		// Delete For The given ID
		response = DeleteMethod.deleteTask(response.getId()+"");
		Assert.assertEquals(response.getStaus(), "OK");
		
	}
	
	@Test(priority=2)
    public void test_Negative() throws JsonProcessingException{
		
		Response response;
		response = PostMethod.createSubTask("1234");
		
		// Delete For The given ID after create
		response = DeleteMethod.deleteTask(response.getId()+"");
		
		// Retrieve For The given ID after Delete
		response = GetMethod.retrieveDependencies(response.getId()+"");
		Assert.assertNotEquals(response.getStaus(), "OK");
		
		//Update For The given ID after Delete
		response = UpdateMethod.updateTask(response.getId()+"");
		Assert.assertNotEquals(response.getStaus(), "OK");
		
		// Delete For The given ID after Delete
		response = DeleteMethod.deleteTask(response.getId()+"");
		Assert.assertNotEquals(response.getStaus(), "OK");
		
		//Create with invalid data
		response = PostMethod.createSubTask("@#");
		Assert.assertNotEquals(response.getStaus(), "OK");
		
	}
	

}
