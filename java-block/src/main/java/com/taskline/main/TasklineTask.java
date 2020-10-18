package com.taskline.main;

public class TasklineTask {

   private long id;
   private long companyId;
   private long teamId;
   private long assignedUserId;
   private String assignedUserName;
   private long taskNumber;
   private String taskName;
   private String taskDescription;
   private int taskFolder;
   private int taskPriority;
   private int taskPriorityCalculated;
   private int taskStatus;
   private int taskPoints;
   private int taskRisk;
   private int taskCost;
   private String taskDeadlineTime;
   private int status;
   private String addedTime;

    public TasklineTask() {

      this.id = 0;
      this.companyId = 0;
      this.teamId = 0;
      this.assignedUserId = 0;
      this.assignedUserName = "";
      this.taskNumber = 0;
      this.taskName = "";
      this.taskDescription = "";
      this.taskFolder = 0;
      this.taskPriority = 0;
      this.taskPriorityCalculated = 0;
      this.taskStatus = 0;
      this.taskPoints = 0;
      this.taskRisk = 0;
      this.taskCost = 0;
      this.taskDeadlineTime = "";
      this.status = 0;
      this.addedTime = "";
   }

   public TasklineTask(long id, long companyId, long teamId, long assignedUserId, String assignedUserName, long taskNumber, String taskName, String taskDescription, int taskFolder, int taskPriority, int taskPriorityCalculated, int taskStatus, int taskPoints, int taskRisk, int taskCost, String taskDeadlineTime, int status, String addedTime) {

      this.id = id;
      this.companyId = companyId;
      this.teamId = teamId;
      this.assignedUserId = assignedUserId;
      this.assignedUserName = assignedUserName;
      this.taskNumber = taskNumber;
      this.taskName = taskName;
      this.taskDescription = taskDescription;
      this.taskFolder = taskFolder;
      this.taskPriority = taskPriority;
      this.taskPriorityCalculated = taskPriorityCalculated;
      this.taskStatus = taskStatus;
      this.taskPoints = taskPoints;
      this.taskRisk = taskRisk;
      this.taskCost = taskCost;
      this.taskDeadlineTime = taskDeadlineTime;
      this.status = status;
      this.addedTime = addedTime;
   }

   public long getId() {

      return id;
   }

   public void setId(long id) {

      this.id = id;
   }

   public long getCompanyId() {

      return companyId;
   }

   public void setCompanyId(long companyId) {

      this.companyId = companyId;
   }
   
   public long getTeamId() {

	  return teamId;
   }

   public void setTeamId(long teamId) {

	  this.teamId = teamId;
   }
   
   public long getAssignedUserId() {

	  return assignedUserId;
   }

   public void setAssignedUserId(long assignedUserId) {

	  this.assignedUserId = assignedUserId;
   }
   
   public String getAssignedUserName() {

	  return assignedUserName;
   }

   public void setAssignedUserName(String assignedUserName) {

	  this.assignedUserName = assignedUserName;
   }
   
   public long getTaskNumber() {

	  return id; // taskNumber;
   }

   public void setTaskNumber(long taskNumber) {

	  this.taskNumber = taskNumber;
   }   
   
   public String getTaskName() {

      return taskName;
   }

   public void setTaskName(String taskName) {

      this.taskName = taskName;
   }

   public String getTaskDescription() {

      return taskDescription;
   }

   public void setTaskDescription(String taskDescription) {

      this.taskDescription = taskDescription;
   }
   
   public int getTaskFolder() {

      return taskFolder;
   }

   public void setTaskFolder(int taskFolder) {

      this.taskFolder = taskFolder;
   }

   public int getTaskPriority() {

      return taskPriority;
   }

   public void setTaskPriority(int taskPriority) {

      this.taskPriority = taskPriority;
   }

   public int getTaskPriorityCalculated() {

      return taskPriorityCalculated;
   }

   public void setTaskPriorityCalculated(int taskPriorityCalculated) {

      this.taskPriorityCalculated = taskPriorityCalculated;
   }   

   public int getTaskStatus() {

      return taskStatus;
   }

   public void setTaskStatus(int taskStatus) {

      this.taskStatus = taskStatus;
   }      
   
   public int getTaskPoints() {

      return taskPoints;
   }

   public void setTaskPoints(int taskPoints) {

      this.taskPoints = taskPoints;
   }

   public int getTaskRisk() {

      return taskRisk;
   }

   public void setTaskRisk(int taskRisk) {

      this.taskRisk = taskRisk;
   }   
	   
   public int getTaskCost() {

      return taskCost;
   }

   public void setTaskCost(int taskCost) {

      this.taskCost = taskCost;
   }

   public String getTaskDeadlineTime() {

      return taskDeadlineTime;
   }

   public void setTaskDeadlineTime(String taskDeadlineTime) {

      this.taskDeadlineTime = taskDeadlineTime;
   }
   
   public int getStatus() {

      return status;
   }

   public void setStatus(int status) {

      this.status = status;
   }

   public String getAddedTime() {

      return addedTime;
   }

   public void setAddedTime(String addedTime) {

      this.addedTime = addedTime;
   }

   public String toString() {

      return String.format("TasklineTasks[id='%d', companyId='%d', teamId='%d', assignedUserId='%d', assignedUserName='%s', taskNumber='%d', taskName='%s', taskDescription='%s', taskFolder='%d', taskPriority='%d', taskPriorityCalculated='%d', taskStatus='%d', taskPoints='%d', taskRisk='%d', taskCost='%d', taskDeadlineTime='%s', status='%d', addedTime='%s']",
         id, companyId, teamId, assignedUserId, assignedUserName, taskNumber, taskName, taskDescription, taskFolder, taskPriority, taskPriorityCalculated, taskStatus, taskPoints, taskRisk, taskCost, taskDeadlineTime, status, addedTime);
   }
}
