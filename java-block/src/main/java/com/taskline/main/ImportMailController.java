package com.taskline.main;

import com.taskline.main.mail.MailFetcher;
import com.taskline.main.mail.analisys.KeyWordsDictionary;
import com.taskline.main.mail.analisys.ParsingWrapper;
import com.taskline.main.mail.entity.MailEntity;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
@RequestMapping("/importMail")
public class ImportMailController {

   @Autowired
   private JdbcTemplate jdbc;

   private AuthData currentUser;

   @Autowired
   ImportMailController(AuthData currentUser) {

      this.currentUser = currentUser;
   }

   @PostMapping
   public ResponseEntity<String> importMail(@RequestParam(value = "searchString", required = false) String searchString) {

	  String taskNumber = "12345";
	  String taskDeadlineTimeX = "2050-01-01 23:59:59";
	  
	  int taskPriorityValue = 50;
	  int taskPointsValue = 50;
	  int taskRiskValue = 3;
	  int taskCostValue = 3;
	  int taskFolderValue = 1;
	  int taskStatusValue = 1;

	  String assignedUserId = "0";
	  // String taskName = "";
	  // String taskDescription = "";

	  int n = 1;

	  List<MailEntity> mailEntityList = MailFetcher.fetchFromMailRu("flimhacktest@mail.ru", "Mk1211801");
	  ParsingWrapper parsingWrapper = new ParsingWrapper();
	  if(mailEntityList != null) {
	     mailEntityList.forEach(mailEntity -> {
	        AtomicInteger points = new AtomicInteger();
	        KeyWordsDictionary.keyWordsList.forEach(keyWord -> {
	           try {
	              points.addAndGet(parsingWrapper.search(mailEntity.getEmailHeader().trim().toLowerCase(), mailEntity.getEmailText().trim().toLowerCase(), keyWord).size());
	           }
	           catch (IOException | ParseException e) {
	              e.printStackTrace();
	           }
	        });
	        if(points.get() > 0)
	           System.out.println("put into db this record (" + mailEntity + ")");

               jdbc.update("INSERT INTO taskline_tasks (companyId,"
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
		            "",
		            taskNumber,
		            mailEntity.getEmailHeader().trim(),
		            mailEntity.getEmailText().trim(),
		            taskFolderValue,
		            taskPriorityValue,
		            0,
		            taskStatusValue,
		            taskPointsValue,
		            taskRiskValue,
		            taskCostValue,
		            taskDeadlineTimeX,
		            1);	           
	     });
      }

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
