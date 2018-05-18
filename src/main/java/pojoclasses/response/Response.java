package pojoclasses.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response {

	@JsonProperty("dependents")
	private List<Dependents> dependents;
	@JsonProperty("STATUS")
	private String staus;
	@JsonProperty("id")
	private Integer id;
	
}
