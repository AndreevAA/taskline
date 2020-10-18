package com.taskline.main;

public class TasklineUser {

   private long id;
   private long companyId;
   private String userFirstName;
   private String userMiddleName;
   private String userLastName;
   private String userEmail;
   private String userLogin;
   private String userPassword;
   private String userPasswordMatch;
   private String userCompanyName;
   private String userAddress;
   private String userPhone;
   private String userCity;
   private String userZip;
   private String userState;
   private String userCountry;
   private String userAboutMe;
   private String profilePhotoUrl;
   private int userType;
   private String userAuthority;
   private int userMembership;
   private int userActivated;
   private String activationCode;
   private String lastLoginTime;
   private String prevLoginTime;
   private String instagramId;
   private String facebookId;
   private String vkId;
   private String youtubeId;
   private String twitterId;
   private long currentCompanyId;
   private long currentTeamId;
   private long currentProjectId;
   private int status;
   private int agree;
   private String addedTime;

    public TasklineUser() {

      this.id = 0;
      this.companyId = 0;
      this.userFirstName = "";
      this.userMiddleName = "";
      this.userLastName = "";
      this.userEmail = "";
      this.userLogin = "";
      this.userPassword = "";
      this.userPasswordMatch = "";
      this.userCompanyName = "";
      this.userAddress = "";
      this.userPhone = "";
      this.userCity = "";
      this.userZip = "";
      this.userState = "";
      this.userCountry = "";
      this.userAboutMe = "";
      this.profilePhotoUrl = "";
      this.userType = 0;
      this.userAuthority = "";
      this.userMembership = 0;
      this.userActivated = 0;
      this.activationCode = "";
      this.lastLoginTime = "";
      this.prevLoginTime = "";
      this.instagramId = "";
      this.facebookId = "";
      this.vkId = "";
      this.youtubeId = "";
      this.twitterId = "";
      this.currentCompanyId = 0;
      this.currentTeamId = 0;
      this.currentProjectId = 0;
      this.status = 0;
      this.agree = 0;
      this.addedTime = "";
   }

    public TasklineUser(long id, long companyId, String userFirstName, String userMiddleName, String userLastName, String userEmail, String userLogin, String userPassword, String userPasswordMatch, String userCompanyName, String userAddress, String userPhone, String userCity, String userZip, String userState, String userCountry, String userAboutMe, String profilePhotoUrl, int userType, String userAuthority, int userMembership, int userActivated, String activationCode, String lastLoginTime, String prevLoginTime, String instagramId, String facebookId, String vkId, String youtubeId, String twitterId, long currentCompanyId, long currentTeamId, long currentProjectId, int status, int agree, String addedTime) {

      this.id = id;
      this.companyId = companyId;
      this.userFirstName = userFirstName;
      this.userMiddleName = userMiddleName;
      this.userLastName = userLastName;
      this.userEmail = userEmail;
      this.userLogin = userLogin;
      this.userPassword = userPassword;
      this.userPasswordMatch = userPasswordMatch;
      this.userCompanyName = userCompanyName;
      this.userAddress = userAddress;
      this.userPhone = userPhone;
      this.userCity = userCity;
      this.userZip = userZip;
      this.userState = userState;
      this.userCountry = userCountry;
      this.userAboutMe = userAboutMe;
      this.profilePhotoUrl = profilePhotoUrl;
      this.userType = userType;
      this.userAuthority = userAuthority;
      this.userMembership = userMembership;
      this.userActivated = userActivated;
      this.activationCode = activationCode;
      this.lastLoginTime = lastLoginTime;
      this.prevLoginTime = prevLoginTime;
      this.instagramId = instagramId;
      this.facebookId = facebookId;
      this.vkId = vkId;
      this.youtubeId = youtubeId;
      this.twitterId = twitterId;
      this.currentCompanyId = currentCompanyId;
      this.currentTeamId = currentTeamId;
      this.currentProjectId = currentProjectId;
      this.status = status;
      this.agree = agree;
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

   public String getUserFirstName() {

      return userFirstName;
   }

   public void setUserFirstName(String userFirstName) {

      this.userFirstName = userFirstName;
   }

   public String getUserMiddleName() {

      return userMiddleName;
   }

   public void setUserMiddleName(String userMiddleName) {

      this.userMiddleName = userMiddleName;
   }

   public String getUserLastName() {

      return userLastName;
   }

   public void setUserLastName(String userLastName) {

      this.userLastName = userLastName;
   }

   public String getUserEmail() {

      return userEmail;
   }

   public void setUserEmail(String userEmail) {

      this.userEmail = userEmail;
   }

   public String getUserLogin() {

      return userLogin;
   }

   public void setUserLogin(String userLogin) {

      this.userLogin = userLogin;
   }

   public String getUserPassword() {

      return userPassword;
   }

   public void setUserPassword(String userPassword) {

      this.userPassword = userPassword;
   }

   public String getUserPasswordMatch() {

      return userPasswordMatch;
   }

   public void setUserPasswordMatch(String userPasswordMatch) {

      this.userPasswordMatch = userPasswordMatch;
   }

   public String getUserCompanyName() {

      return userCompanyName;
   }

   public void setUserCompanyName(String userCompanyName) {

      this.userCompanyName = userCompanyName;
   }

   public String getUserAddress() {

      return userAddress;
   }

   public void setUserAddress(String userAddress) {

      this.userAddress = userAddress;
   }

   public String getUserPhone() {

      return userPhone;
   }

   public void setUserPhone(String userPhone) {

      this.userPhone = userPhone;
   }

   public String getUserCity() {

      return userCity;
   }

   public void setUserCity(String userCity) {

      this.userCity = userCity;
   }

   public String getUserZip() {

      return userZip;
   }

   public void setUserZip(String userZip) {

      this.userZip = userZip;
   }

   public String getUserState() {

      return userState;
   }

   public void setUserState(String userState) {

      this.userState = userState;
   }

   public String getUserCountry() {

      return userCountry;
   }

   public void setUserCountry(String userCountry) {

      this.userCountry = userCountry;
   }

   public String getUserAboutMe() {

      return userAboutMe;
   }

   public void setUserAboutMe(String userAboutMe) {

      this.userAboutMe = userAboutMe;
   }

   public String getProfilePhotoUrl() {

      return profilePhotoUrl;
   }

   public void setProfilePhotoUrl(String profilePhotoUrl) {

      this.profilePhotoUrl = profilePhotoUrl;
   }

   public int getUserType() {

      return userType;
   }

   public void setUserType(int userType) {

      this.userType = userType;
   }

   public String getUserAuthority() {

      return userAuthority;
   }

   public void setUserAuthority(String userAuthority) {

      this.userAuthority = userAuthority;
   }

   public int getUserMembership() {

      return userMembership;
   }

   public void setUserMembership(int userMembership) {

      this.userMembership = userMembership;
   }

   public int getUserActivated() {

      return userActivated;
   }

   public void setUserActivated(int userActivated) {

      this.userActivated = userActivated;
   }

   public String getActivationCode() {

      return activationCode;
   }

   public void setActivationCode(String activationCode) {

      this.activationCode = activationCode;
   }

   public String getLastLoginTime() {

      return lastLoginTime;
   }

   public void setLastLoginTime(String lastLoginTime) {

      this.lastLoginTime = lastLoginTime;
   }

   public String getPrevLoginTime() {

      return prevLoginTime;
   }

   public void setPrevLoginTime(String prevLoginTime) {

      this.prevLoginTime = prevLoginTime;
   }

   public String getInstagramId() {

      return instagramId;
   }

   public void setInstagramId(String instagramId) {

      this.instagramId = instagramId;
   }

   public String getFacebookId() {

      return facebookId;
   }

   public void setFacebookId(String facebookId) {

      this.facebookId = facebookId;
   }

   public String getVkId() {

      return vkId;
   }

   public void setVkId(String vkId) {

      this.vkId = vkId;
   }

   public String getYoutubeId() {

      return youtubeId;
   }

   public void setYoutubeId(String youtubeId) {

      this.youtubeId = youtubeId;
   }

   public String getTwitterId() {

      return twitterId;
   }

   public void setTwitterId(String twitterId) {

      this.twitterId = twitterId;
   }

   public long getCurrentCompanyId() {

      return currentCompanyId;
   }

   public void setCurrentCompanyId(long currentCompanyId) {

      this.currentCompanyId = currentCompanyId;
   }

   public long getCurrentTeamId() {

      return currentTeamId;
   }

   public void setCurrentTeamId(long currentTeamId) {

      this.currentTeamId = currentTeamId;
   }

   public long getCurrentProjectId() {

      return currentProjectId;
   }

   public void setCurrentProjectId(long currentProjectId) {

      this.currentProjectId = currentProjectId;
   }

   public void setStatus(int status) {

      this.status = status;
   }

   public int getAgree() {

      return agree;
   }

   public void setAgree(int agree) {

      this.agree = agree;
   }

   public String getAddedTime() {

      return addedTime;
   }

   public void setAddedTime(String addedTime) {

      this.addedTime = addedTime;
   }

   public String toString() {

      return String.format("TasklineUser[id='%d', companyId='%d', userFirstName='%s', userMiddleName='%s', userLastName='%s', userEmail='%s', userLogin='%s', userPassword='%s', userPasswordMatch='%s', userCompanyName='%s', userAddress='%s', userPhone='%s', userCity='%s', userZip='%s', userState='%s', userCountry='%s', userAboutMe='%s', profilePhotoUrl='%s', userType='%d', userAuthority='%s', userMembership='%d', userActivated='%d', activationCode='%s', lastLoginTime='%s', prevLoginTime='%s', instagramId='%s', facebookId='%s', vkId='%s', youtubeId='%s', twitterId='%s', currentCompanyId='%d', currentTeamId='%d', currentProjectId='%d', status='%d', agree='%d', addedTime='%s']",
         id, companyId, userFirstName, userMiddleName, userLastName, userEmail, userLogin, userPassword, userPasswordMatch, userCompanyName, userAddress, userPhone, userCity, userZip, userState, userCountry, userAboutMe, profilePhotoUrl, userType, userAuthority, userMembership, userActivated, activationCode, lastLoginTime, prevLoginTime, instagramId, facebookId, vkId, youtubeId, twitterId, currentCompanyId, currentTeamId, currentProjectId, status, agree, addedTime);
   }
}

