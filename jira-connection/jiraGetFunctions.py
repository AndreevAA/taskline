from jira import JIRA

# Получение списка заданий
def getListOfAllTasks(jira, projectName):
	jql = 'project = ' + projectName;
	return(jira.search_issues(jql));

# Получение всех полей тикета
def getTaskFieldsByTicket(jira, tempTask):
	return (jira.issue(tempTask).fields);

# Получение название тикета
def getTaskNameByTicket(jira, tempTask):
	return (jira.issue(tempTask).fields.summary);

# Получение описания тикета
def getTaskDesciptionByTicket(jira, tempTask):
	return (jira.issue(tempTask).fields.description);

# Получение лэйбл тикате
def getTaskLabelsByTicket(jira, tempTask):
	return (jira.issue(tempTask).fields.label);

# Получение открытых досок
def getBoards(jira, startAt, maxResults):
	return (jira.boards(startAt, maxResults));

# Получение списка комментариев к задаче
def getListOfIssueComments(jira, issue):
	return (jira.comments(issue))


