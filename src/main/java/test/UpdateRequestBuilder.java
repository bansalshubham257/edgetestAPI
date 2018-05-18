package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import pojoclasses.request.Request;
import pojoclasses.request.Todo_Item;

public class UpdateRequestBuilder {
	
	public static Request buildRequest() {
		
		Request request =  new Request();
		
		request.setTodo_item(getTodoItem());
		
		return request;
				
	}

	private static Todo_Item getTodoItem() {
		// TODO Auto-generated method stub
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Date date = new Date();
	    String todayDate = dateFormat.format(date);
		
		Todo_Item todo_Item = new Todo_Item();
		
		todo_Item.setContent("Test Task");
		todo_Item.setNotify(true);
		todo_Item.setDescription("Test Task Sub Item");
		todo_Item.setDue_date(todayDate);
		todo_Item.setStart_date(todayDate);
		todo_Item.setEstimated_minutes("0");
		todo_Item.setPrivates(0);
		todo_Item.setGrant_access_to("");
		todo_Item.setPriority("low");
		todo_Item.setProgress("20");
		String [] attachment = {};
		todo_Item.setAttachments(attachment);
		todo_Item.setTasklistId("0");
		todo_Item.setPendingFileAttachments("");
		todo_Item.setTags("api,documentation");
		todo_Item.setColumnId("123");
		
		return todo_Item;
	}

}
