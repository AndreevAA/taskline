from jira import JIRA

def getListOfAllTasks(jira, projectName):
	jql = 'project = ' + projectName;
	return(jira.search_issues(jql));

def getTaskNameByTicket(jira, tempTask):
	return (jira.issue(tempTask).fields.summary);

