package pojoclasses.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Todo_Item {
	
	@JsonProperty("content")
	private String content;
	@JsonProperty("notify")
	private boolean notify;
	@JsonProperty("description")
	private String description;
	@JsonProperty("due-date")
	private String due_date;
	@JsonProperty("start-date")
	private String start_date;
	@JsonProperty("estimated-minutes")
	private String estimated_minutes;
	@JsonProperty("private")
	private Integer privates;
	@JsonProperty("grant-access-to")
	private String grant_access_to;
	@JsonProperty("priority")
	private String priority;
	@JsonProperty("progress")
	private String progress;
	@JsonProperty("attachments")
	private String[] attachments;
	@JsonProperty("pendingFileAttachments")
	private String pendingFileAttachments;
	@JsonProperty("responsible-party-id")
	private Integer responsible_party_id;
	
	@JsonProperty("predecessors")
	private List<Predecessors> predecessors;
	
	@JsonProperty("tags")
	private String tags;
	@JsonProperty("commentFollowerIds")
	private String commentFollowerIds;
	@JsonProperty("changeFollowerIds")
	private String changeFollowerIds;
	@JsonProperty("positionAfterTask")
	private Integer positionAfterTask;
	
	@JsonProperty("tasklistId")
	private String tasklistId;
	@JsonProperty("columnId")
	private String columnId;

}
