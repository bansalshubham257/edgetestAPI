package pojoclasses.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Dependents {
	
	@JsonProperty("responsible-party-id")
	private String responsible_party_id;
	@JsonProperty("predecessorMust")
	private String predecessorMust;
	@JsonProperty("name")
	private String name;
	@JsonProperty("id")
	private String id;
	@JsonProperty("hardness")
	private String hardness;
	@JsonProperty("projectId")
	private String projectId;
	@JsonProperty("dependentCant")
	private String dependentCant;
	@JsonProperty("responsible-party-summary")
	private String responsible_party_summary;
	@JsonProperty("responsible-party-names")
	private String responsible_party_names;

}
