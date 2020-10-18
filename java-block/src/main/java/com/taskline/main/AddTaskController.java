package com.taskline.main;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/addTask")
public class AddTaskController {

   @Autowired
   private JdbcTemplate jdbc;

   private AuthData currentUser;

   @Autowired
   AddTaskController(AuthData currentUser) {

      this.currentUser = currentUser;
   }

   @PostMapping
   public ResponseEntity<String> addTask(@RequestParam(value = "assignedUserId", required = false) String assignedUserId,
		  @RequestParam(value = "taskName", required = false) String taskName,
		  @RequestParam(value = "taskDescription", required = false) String taskDescription,
		  @RequestParam(value = "taskPriority", required = false) String taskPriority,
		  @RequestParam(value = "taskPoints", required = false) String taskPoints,
		  @RequestParam(value = "taskDeadlineTime", required = false) String taskDeadlineTime,
		  @RequestParam(value = "taskRisk", required = false) String taskRisk,
		  @RequestParam(value = "taskCost", required = false) String taskCost,
		  @RequestParam(value = "taskFolder", required = false) String taskFolder,
		  @RequestParam(value = "taskStatus", required = false) String taskStatus) {

	  String taskNumber = "12345";
	  System.out.println(taskDescription);
	  String taskDeadlineTimeX = "2050-01-01 23:59:59";
	  if(taskDeadlineTime != null && taskDeadlineTime.length() > 0)
	  {
		 String c[] = taskDeadlineTime.split("/");
		 taskDeadlineTimeX = c[2]+"-"+String.format("%2.0f", Float.valueOf(c[1]))+"-"+String.format("%2.0f", Float.valueOf(c[0]))+" 23:59:59";
	  }
	  
	  int taskPriorityValue = 0;
	  int taskPointsValue = 0;
	  int taskRiskValue = 0;
	  int taskCostValue = 0;
	  int taskFolderValue = 0;
	  int taskStatusValue = 0;

	  if(assignedUserId == null) assignedUserId = "1";
	  if(taskName == null) taskName = "Тестовое задание";
	  if(taskDescription == null) taskDescription = "";
	  if(taskPriority != null && taskPriority.length() > 0) taskPriorityValue = Integer.valueOf(taskPriority);
	  if(taskPoints != null && taskPoints.length() > 0) taskPointsValue = Integer.valueOf(taskPoints);
	  if(taskRisk != null && taskRisk.length() > 0) taskRiskValue = Integer.valueOf(taskRisk);
	  if(taskCost != null && taskCost.length() > 0) taskCostValue = Integer.valueOf(taskCost);
	  if(taskFolder != null && taskFolder.length() > 0) taskFolderValue = Integer.valueOf(taskFolder);
	  if(taskStatus != null && taskStatus.length() > 0) taskStatusValue = Integer.valueOf(taskStatus);

      int n = jdbc.update("INSERT INTO taskline_tasks (companyId,"
		            + "teamId,"
		            + "assignedUserId,"
		            + "assignedUserName,"
		            + "taskNumber,"
			        + "taskName,"
		            + "taskDescription,"
		            + "taskFolder,"
		            + "taskPriority,"
		            + "taskPriorityCalculated,"
		            + "taskStatus,"
		            + "taskPoints,"
		            + "taskRisk,"
		            + "taskCost,"
		            + "taskDeadlineTime,"
		            + "status,"
		            + "addedTime) values(?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "?,"
		            + "CURRENT_TIMESTAMP)",
		            1,
		            1,
		            assignedUserId,
		            "Иванов Иван Иванович",
		            taskNumber,
		            taskName,
		            taskDescription,
		            taskFolderValue,
		            taskPriorityValue,
		            0,
		            taskStatusValue,
		            taskPointsValue,
		            taskRiskValue,
		            taskCostValue,
		            taskDeadlineTimeX,
		            1);
      if(n > 0)
	  {
         String strOutput = "OK!";

	     return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
	  }
      else
      {
    	 String strOutput = "Error!";

 	     return ResponseEntity
 	            .ok()
 	            .cacheControl(CacheControl.noCache())
 	            .body("{\"status\" : \"OK\", \"output\" : "+JSONObject.quote(strOutput)+"}");
      }
   }
}
