package pojoclasses.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Request {

	@JsonProperty("todo-item")
	private Todo_Item todo_item;

	
	
}
