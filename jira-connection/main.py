from jira import JIRA
import secret_data, connection, jiraGetFunctions, jiraAddFunctions

def main():
	jira = connection.connect(secret_data.login, secret_data.api_key, secret_data.server);
	
	#listOfAllTasks = jiraGetFunctions.getListOfAllTasks(jira, secret_data.project_name);
	connection.getJsonFile(jira, "test.txt");
	# jiraAddFunctions.addCommentToIssue(jira, listOfAllTasks[0], "Паша, выполни задачу!");
	# for i in listOfAllTasks:
	# 	print(jiraGetFunctions.getTaskFieldsByTicket(jira, i));
	# 	print(jiraGetFunctions.getTaskNameByTicket(jira, i));

	# 	print(jiraGetFunctions.getTaskDesciptionByTicket(jira, i))
		#print(jiraGetFunctions.getTaskLabelsByTicket(jira, i))
	connection.close(jira);


main();
