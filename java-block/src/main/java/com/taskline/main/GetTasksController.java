package com.taskline.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/getTasks")
public class GetTasksController {

   @Autowired
   private JdbcTemplate jdbc;

   private AuthData currentUser;

   @Autowired
   GetTasksController(AuthData currentUser) {

      this.currentUser = currentUser;
   }

   @PostMapping
   public ResponseEntity<String> getTasks(@RequestParam(value = "assignedUserId", required = false) String assignedUserId,
		  @RequestParam(value = "taskName", required = false) String taskName,
		  @RequestParam(value = "taskDescription", required = false) String taskDescription,
		  @RequestParam(value = "taskPriority", required = false) String taskPriority,
		  @RequestParam(value = "taskPoints", required = false) String taskPoints,
		  @RequestParam(value = "taskDeadlineTimeFrom", required = false) String taskDeadlineTimeFrom,
		  @RequestParam(value = "taskDeadlineTimeTo", required = false) String taskDeadlineTimeTo,
		  @RequestParam(value = "taskAddedTimeFrom", required = false) String taskAddedTimeFrom,
		  @RequestParam(value = "taskAddedTimeTo", required = false) String taskAddedTimeTo,
		  @RequestParam(value = "taskRisk", required = false) String taskRisk,
		  @RequestParam(value = "taskCost", required = false) String taskCost,
		  @RequestParam(value = "taskFolder", required = false) String taskFolder,
		  @RequestParam(value = "taskStatus", required = false) String taskStatus) {

      String output1Backlog = listTasks(1);
      String output1Planning = listTasks(2);
      String output1InProgress = listTasks(3);
      String output1Done = listTasks(4);
      String output1Control = listTasks(5);
      String output1Deadline = listTasks(6);
      String output1All = listTasks(0);
      
      String output2Backlog = output1Backlog;
      String output2Planning = output1Planning;
      String output2InProgress = output1InProgress;
      String output2Done = output1Done;
      String output2Control = output1Control;
      String output2Deadline = output1Deadline;
      String output2All = output1All;
      
      String output3Backlog = output1Backlog;
      String output3Planning = output1Planning;
      String output3InProgress = output1InProgress;
      String output3Done = output1Done;
      String output3Control = output1Control;
      String output3Deadline = output1Deadline;
      String output3All = output1All;

	  return ResponseEntity
	            .ok()
	            .cacheControl(CacheControl.noCache())
	            .body("{\"status\" : \"OK\", \"output1Backlog\" : "+JSONObject.quote(output1Backlog)+", \"output1Planning\" : "+JSONObject.quote(output1Planning)+", \"output1InProgress\" : "+JSONObject.quote(output1InProgress)+", \"output1Done\" : "+JSONObject.quote(output1Done)+", \"output1Control\" : "+JSONObject.quote(output1Control)+", \"output1Deadline\" : "+JSONObject.quote(output1Deadline)+", \"output1All\" : "+JSONObject.quote(output1All)+", \"output2Backlog\" : "+JSONObject.quote(output2Backlog)+", \"output2Planning\" : "+JSONObject.quote(output2Planning)+", \"output2InProgress\" : "+JSONObject.quote(output2InProgress)+", \"output2Done\" : "+JSONObject.quote(output2Done)+", \"output2Control\" : "+JSONObject.quote(output2Control)+", \"output2Deadline\" : "+JSONObject.quote(output2Deadline)+", \"output2All\" : "+JSONObject.quote(output2All)+", \"output3Backlog\" : "+JSONObject.quote(output3Backlog)+", \"output3Planning\" : "+JSONObject.quote(output3Planning)+", \"output3InProgress\" : "+JSONObject.quote(output3InProgress)+", \"output3Done\" : "+JSONObject.quote(output3Done)+", \"output3Control\" : "+JSONObject.quote(output3Control)+", \"output3Deadline\" : "+JSONObject.quote(output3Deadline)+", \"output3All\" : "+JSONObject.quote(output3All)+" }");
   }
   
   public String listTasks(int taskFolderId)
   {
	  String strOutput = "";
	  List<TasklineTask> results = null;

	  if(taskFolderId > 0)
	  {
         results = jdbc.query("SELECT * FROM taskline_tasks WHERE taskFolder=? ORDER BY addedTime DESC",
    	    new Object[] { taskFolderId },
            new RowMapper<TasklineTask>() {
	           @Override
	    	   public TasklineTask mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	      return new TasklineTask(rs.getLong("id"),
	    	         rs.getLong("companyId"),
	    		     rs.getLong("teamId"),
	    		     rs.getLong("assignedUserId"),
	    		     rs.getString("assignedUserName"),
	    		     rs.getLong("taskNumber"),
	    		     rs.getString("taskName"),
	    		     rs.getString("taskDescription"),
	    		     rs.getInt("taskFolder"),
	    		     rs.getInt("taskPriority"),
	    		     rs.getInt("taskPriorityCalculated"),
	    		     rs.getInt("taskStatus"),
	    		     rs.getInt("taskPoints"),
	    		     rs.getInt("taskRisk"),
	    		     rs.getInt("taskCost"),
	    		     rs.getString("taskDeadlineTime"),
	    		     rs.getInt("status"),
	    		     rs.getString("addedTime")
	    	      );
	           }
	        }
         );
	  }
	  else
	  {
	     results = jdbc.query("SELECT * FROM taskline_tasks ORDER BY addedTime DESC",
	        new RowMapper<TasklineTask>() {
	     	@Override
	     	   public TasklineTask mapRow(ResultSet rs, int rowNum) throws SQLException {
	     	      return new TasklineTask(rs.getLong("id"),
	     	         rs.getLong("companyId"),
	     	    	 rs.getLong("teamId"),
	     	    	 rs.getLong("assignedUserId"),
	     	    	 rs.getString("assignedUserName"),
	     	    	 rs.getLong("taskNumber"),
	     	    	 rs.getString("taskName"),
	     	    	 rs.getString("taskDescription"),
	     	    	 rs.getInt("taskFolder"),
	     	    	 rs.getInt("taskPriority"),
	     	    	 rs.getInt("taskPriorityCalculated"),
	     	    	 rs.getInt("taskStatus"),
	     	    	 rs.getInt("taskPoints"),
	     	    	 rs.getInt("taskRisk"),
	     	    	 rs.getInt("taskCost"),
	     	    	 rs.getString("taskDeadlineTime"),
	     	    	 rs.getInt("status"),
	     	    	 rs.getString("addedTime")
	     	      );
	     	   }
	     	}
	     );
	  }

	  if(!results.isEmpty())
	  {
		 strOutput += "<form class=\"form-inline search-area\">\n" + 
		 		"                     <select class=\"custom-select my-1\" id=\"inlineFormCustomSelectPref\">\n" + 
		 		"                        <option value=\"0\">Приоритет</option>\n" + 
		 		"                        <option value=\"1\">Авто</option>\n" + 
		 		"                        <option value=\"2\">Ручной</option>\n" + 
		 		"                        <option value=\"3\">Сначала высокие</option>\n" + 
		 		"                        <option value=\"4\">Сначала низкие</option>\n" + 
		 		"                     </select>\n" + 
		 		"                     <select class=\"custom-select my-1\" id=\"inlineFormCustomSelectPref\">\n" + 
		 		"                        <option value=\"0\">Исполнитель</option>\n" + 
		 		"                        <option value=\"1\">Иван Иваныч Иванов</option>\n" + 
		 		"                        <option value=\"2\">Петр Петрович Петров</option>\n" + 
		 		"                     </select>\n" + 
		 		"                     <select class=\"custom-select my-1\" id=\"inlineFormCustomSelectPref\">\n" + 
		 		"                        <option value=\"0\">Теги</option>\n" + 
		 		"                        <option value=\"1\">Производство</option>\n" + 
		 		"                        <option value=\"2\">IT Департамент</option>\n" + 
		 		"                        <option value=\"3\">Управление</option>\n" + 
		 		"                     </select>\n" + 
		 		"                     <select class=\"custom-select my-1\" id=\"inlineFormCustomSelectPref\">\n" + 
		 		"                        <option value=\"0\">Статус</option>\n" + 
		 		"                        <option value=\"1\">Нормальные</option>\n" + 
		 		"                        <option value=\"2\">Критические</option>\n" + 
		 		"                     </select>\n" + 
		 		"                  </form>\n" + 
		 		"               <div style=\"width:100%;height:590px;overflow-y:scroll;\">\n" + 
		 		"               <div class=\"timeline\">";
		  
	     for(TasklineTask r : results)
	     {
	    	String startDate = r.getAddedTime().split(" ")[0];
	    	String deadlineDate = r.getTaskDeadlineTime().split(" ")[0];
            if(deadlineDate.equals("2050-01-01")) deadlineDate = "не определен";

	    	String assignedUserName = "Не назначена";
	    	if(r.getAssignedUserName().length() > 1) assignedUserName = r.getAssignedUserName();

	    	String points = "";
	    	if(r.getTaskPoints() <= 20) points = "Низкая ("+r.getTaskPoints()+")";
	    	else if(r.getTaskPoints() <= 40) points = "Ниже среднего ("+r.getTaskPoints()+")";
	    	else if(r.getTaskPoints() <= 60) points = "Средняя ("+r.getTaskPoints()+")";
	    	else if(r.getTaskPoints() <= 80) points = "Выше среднего ("+r.getTaskPoints()+")";
	    	else points = "Высокая ("+r.getTaskPoints()+")";

	    	String risk = "";
	    	if(r.getTaskRisk() == 1) risk = "Низкий ("+r.getTaskRisk()+")";
	    	else if(r.getTaskRisk() == 2) risk = "Ниже среднего ("+r.getTaskRisk()+")";
	    	else if(r.getTaskRisk() == 3) risk = "Средний ("+r.getTaskRisk()+")";
	    	else if(r.getTaskRisk() == 4) risk = "Выше среднего ("+r.getTaskRisk()+")";
	    	else risk = "Высокий ("+r.getTaskRisk()+")";

	    	String cost = "";
	    	if(r.getTaskCost() == 1) cost = "Низкая ("+r.getTaskCost()+")";
	    	else if(r.getTaskCost() == 2) cost = "Ниже среднего ("+r.getTaskCost()+")";
	    	else if(r.getTaskCost() == 3) cost = "Средняя ("+r.getTaskCost()+")";
	    	else if(r.getTaskCost() == 4) cost = "Выше среднего ("+r.getTaskCost()+")";
	    	else cost = "Высокая ("+r.getTaskCost()+")";
	    	
	    	
	        strOutput += "<div class=\"timeline-content\">\n" + 
	        		"                     <h5 class=\"text-light\">"+startDate+" &nbsp; <font color=\"#a4cdfe\">#"+r.getTaskNumber()+"</font> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <a href=\"#\" role=\"button\" class=\"btn btn-primary\"><img src=\"assets/img/check-square.svg\" style=\"width:16px;height:16px;border:0;margin-top:-3px;filter:invert(1);\"></a> &nbsp; <a href=\"#\" role=\"button\" class=\"btn btn-primary\"><img src=\"assets/img/edit.svg\" style=\"width:16px;height:16px;border:0;margin-top:-3px;filter:invert(1);\"></a> &nbsp; <a href=\"#\" role=\"button\" class=\"btn btn-primary\"><img src=\"assets/img/trash-2.svg\" style=\"width:16px;height:16px;border:0;margin-top:-3px;filter:invert(1);\"></a></h5>\n" + 
	        		"                     <p><span class=\"task_title\">"+r.getTaskName()+"</span><br>"+r.getTaskDescription()+"</p>\n" + 
	        		"                     <hr>\n" + 
	        		"                     <div class=\"txt\">\n" + 
	        		"                        <div class=\"f-row\">\n" + 
	        		"                           <div class=\"f-block\" style=\"width:60%;\">\n" + 
	        		"                              <small><b>Трудоемкость:</b> "+points+"<br><b>Риск:</b> "+risk+"<br><b>Стоимость:</b> "+cost+"</small>\n" + 
	        		"                           </div>\n" + 
	        		"                           <div class=\"f-block\">\n" + 
	        		"                              <small><b>Исполнитель:</b><br>"+assignedUserName+"<br><b>Срок:</b> "+deadlineDate+"</small>\n" + 
	        		"                           </div>\n" + 
	        		"                         </div>\n" + 
	        		"                         <span class=\"badge badge-secondary\">Производство</span>\n" + 
	        		"                         <span class=\"badge badge-secondary\">Индустрия</span>\n" + 
	        		"                         <span class=\"badge badge-secondary\">IT департамент</span>\n" + 
	        		"                      </div>\n" + 
	        		"                  </div>";
	     }
	     
	     strOutput += "</div></div>";
	  }
	  else
	  {
		  strOutput += "<b>Нет текущих задач.</b>";
	  }
	  
	  return strOutput;
   }
}
