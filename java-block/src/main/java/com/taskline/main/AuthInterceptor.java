package com.taskline.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.taskline.main.AuthUser;
import com.taskline.main.TasklineUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor
{
   @Autowired
   private JdbcTemplate jdbc;

   private AuthData currentUser;

   @Autowired
   AuthInterceptor(AuthData currentUser) {

       this.currentUser = currentUser;
   }

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception 
   {
      if(request.getRequestURI().indexOf(".") > 0) return true;

	  HttpSession session = request.getSession();

      List<TasklineUser> results = jdbc.query("SELECT * FROM taskline_users WHERE userEmail=? AND userPassword=?",
	     new Object[] { (String)session.getAttribute("uni"), (String)session.getAttribute("pwi") },
		 new RowMapper<TasklineUser>() {
		    @Override
			public TasklineUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			   return new TasklineUser(rs.getLong("id"),
			      rs.getLong("companyId"),
			      rs.getString("userFirstName"),
			      rs.getString("userMiddleName"),
			      rs.getString("userLastName"),
			      rs.getString("userEmail"),
			      rs.getString("userLogin"),
			      rs.getString("userPassword"),
			      rs.getString("userPasswordMatch"),
			      rs.getString("userCompanyName"),
			      rs.getString("userAddress"),
			      rs.getString("userPhone"),
			      rs.getString("userCity"),
			      rs.getString("userZip"),
			      rs.getString("userState"),
			      rs.getString("userCountry"),
			      rs.getString("userAboutMe"),
			      rs.getString("profilePhotoUrl"),
			      rs.getInt("userType"),
			      rs.getString("userAuthority"),
			      rs.getInt("userMembership"),
			      rs.getInt("userActivated"),
			      rs.getString("activationCode"),
			      rs.getString("lastLoginTime"),
			      rs.getString("prevLoginTime"),
			      rs.getString("instagramId"),
			      rs.getString("facebookId"),
			      rs.getString("vkId"),
			      rs.getString("youtubeId"),
			      rs.getString("twitterId"),
			      rs.getLong("currentCompanyId"),
			      rs.getLong("currentTeamId"),
			      rs.getLong("currentProjectId"),
			      rs.getInt("status"),
			      rs.getInt("agree"),
			      rs.getString("addedTime")
			   );
			}
		 }
	  );

	  if(!results.isEmpty())
	  {
	     TasklineUser r = results.get(0);
		 this.currentUser.setCurrentUser(new AuthUser(r.getId(), 1, 1, 1, 1));
	  }
	  else
	  {
		  this.currentUser.setCurrentUser(new AuthUser(0, 0, 0, 0, 0));
	  }

	  return true;
   }
}
