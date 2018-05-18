package pojoclasses.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Predecessors {
	
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("type")
	private String type;
	
}
