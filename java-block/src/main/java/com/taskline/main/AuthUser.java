package com.taskline.main;

public class AuthUser
{
   private long userId = 0;
   private long userType = 0;
   private long currentTeamId = 0;
   private long currentCompanyId = 0;
   private long currentProjectId = 0;
   
   public AuthUser(long userId, long userType, long currentTeamId, long currentCompanyId, long currentProjectId) {

      this.userId = userId;
	  this.userType = userType;
	  this.currentTeamId = currentTeamId;
	  this.currentCompanyId = currentCompanyId;
	  this.currentProjectId = currentProjectId;
   }

   public long getUserId() {

       return userId;
   }

   public void setUserId(long userId) {

       this.userId = userId;
   }
   
   public long getUserType() {

       return userType;
   }

   public void setUserType(long userType) {

       this.userType = userType;
   }
 
   public long getCurrentTeamId() {

       return currentTeamId;
   }

   public void setCurrentTeamId(long currentTeamId) {

       this.currentTeamId = currentTeamId;
   }
   
   public long getCurrentCompanyId() {

       return currentCompanyId;
   }

   public void setCurrentCompanyId(long currentCompanyId) {

       this.currentCompanyId = currentCompanyId;
   }   

   public long getCurrentProjectId() {

       return currentProjectId;
   }

   public void setCurrentProjectId(long currentProjectId) {

       this.currentProjectId = currentProjectId;
   }
}