CREATE TABLE taskline_users (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   companyId int(11) NOT NULL default '0',
   userFirstName char(64) NOT NULL default '',
   userMiddleName char(64) NOT NULL default '',
   userLastName char(64) NOT NULL default '',
   userEmail char(128) NOT NULL default '',
   userLogin char(64) NOT NULL default '',
   userPassword char(128) NOT NULL default '',
   userPasswordMatch char(128) NOT NULL default '',
   userCompanyName char(255) NOT NULL default '',
   userAddress char(255) NOT NULL default '',
   userPhone char(64) NOT NULL default '',
   userCity char(32) NOT NULL default '',
   userZip char(32) NOT NULL default '',
   userState char(32) NOT NULL default '',
   userCountry char(32) NOT NULL default '',
   userAboutMe BLOB,
   profilePhotoUrl char(128) NOT NULL default '',
   userType int(2) NOT NULL default '0',
   userAuthority char(16) NOT NULL default '',
   userMembership int(2) NOT NULL default '0',
   userActivated int(2) NOT NULL default '0',
   activationCode char(128) NOT NULL default '',
   lastLoginTime datetime not null,
   prevLoginTime datetime not null,
   instagramId char(64) NOT NULL default '',
   facebookId char(64) NOT NULL default '',
   vkId char(64) NOT NULL default '',
   youtubeId char(64) NOT NULL default '',
   twitterId char(64) NOT NULL default '',
   currentCompanyId int(11) NOT NULL default '0',
   currentTeamId int(11) NOT NULL default '0',
   currentProjectId int(11) NOT NULL default '0',
   status int(2) NOT NULL default '1',
   agree int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE taskline_companies (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   companyName char(255) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE taskline_projects (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   companyId int(11) NOT NULL default '0',
   projectName char(255) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE taskline_teams (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   companyId int(11) NOT NULL default '0',
   teamName char(255) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE taskline_tags (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   companyId int(11) NOT NULL default '0',
   tagName char(255) NOT NULL default '',
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE taskline_tasks (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   companyId int(11) NOT NULL default '0',
   teamId int(11) NOT NULL default '0',
   assignedUserId int(11) NOT NULL default '0',
   assignedUserName char(255) NOT NULL default '',
   taskNumber int(11) NOT NULL default '0',
   taskName char(255) NOT NULL default '',
   taskDescription TEXT,
   taskFolder int(2) NOT NULL default '0',
   taskPriority int(2) NOT NULL default '0',
   taskPriorityCalculated int(2) NOT NULL default '0',
   taskStatus int(2) NOT NULL default '0',
   taskPoints int(2) NOT NULL default '0',
   taskRisk int(2) NOT NULL default '0',
   taskCost int(2) NOT NULL default '0',
   taskDeadlineTime datetime not null,
   status int(2) NOT NULL default '1',
   addedTime datetime not null,
   PRIMARY KEY (id)
);

CREATE TABLE taskline_task_tags_connect (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   taskId int(11) NOT NULL default '0',
   tagId int(11) NOT NULL default '0',
   PRIMARY KEY (id)
);

CREATE TABLE taskline_admins (
   id int(11) unsigned NOT NULL AUTO_INCREMENT,
   adminType int(2) NOT NULL default '0',
   adminName char(55) NOT NULL default '',
   adminEmail char(255) NOT NULL default '',
   adminAccessAreas char(25) NOT NULL default '',
   adminAccessInfluencers int(2) NOT NULL default '0',
   adminAccessBrands int(2) NOT NULL default '0',
   adminAccessJobs int(2) NOT NULL default '0',
   adminAccessReviews int(2) NOT NULL default '0',
   adminAccessNews int(2) NOT NULL default '0',
   adminAccessAdmins int(2) NOT NULL default '0',
   adminAccessSettings int(2) NOT NULL default '0',
   adminAccessContentPages int(2) NOT NULL default '0',
   adminLogin char(55) NOT NULL default '',
   adminPassword char(128) NOT NULL default '',
   adminAuthority char(16) NOT NULL default '',
   adminStatus int(2) NOT NULL default '1',
   lastLoginTime datetime not null,
   addedTime datetime not null,
   PRIMARY KEY (id)
);
