from jira import JIRA
import secret_data, connection, jiraFunctions

def main():
	jira = connection.connect(secret_data.login, secret_data.api_key, secret_data.server);
	
	listOfAllTasks = jiraFunctions.getListOfAllTasks(jira, secret_data.project_name);

	




main();
