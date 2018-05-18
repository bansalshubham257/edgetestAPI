package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pojoclasses.request.Predecessors;
import pojoclasses.request.Request;
import pojoclasses.request.Todo_Item;

public class CreateRequestBuilder {
	
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
		todo_Item.setPendingFileAttachments("");
		todo_Item.setResponsible_party_id(0);
		todo_Item.setPredecessors(getPredecessors());
		todo_Item.setTags("api,documentation");
		todo_Item.setCommentFollowerIds("");
		todo_Item.setChangeFollowerIds("");
		todo_Item.setPositionAfterTask(-1);
		
		return todo_Item;
	}

	private static List<Predecessors> getPredecessors() {
		// TODO Auto-generated method stub
		List<Predecessors> Predecessors = new ArrayList<Predecessors>();
		Predecessors predecessor = new Predecessors();
		predecessor.setId(439492);
		predecessor.setType("complete");
		Predecessors.add(predecessor);
		
		return Predecessors;
	}

}
