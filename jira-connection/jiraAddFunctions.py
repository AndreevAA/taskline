from jira import JIRA

# Добавление комментария к задаче
def addCommentToIssue(jira, tempTask, message):
	jira.add_comment(jira.issue(tempTask), message);

# Перемещение задачи в SPrint
def addIssuesToSprint(jira, sprintId, listOfIssueKeys):
	jira.add_issues_to_sprint(sprintId, listOfIssueKeys);

# Назначение задачи на пользователя
def assignIssueToUder(jira, tempIssue, tempAssignee):
	jira.add_issues_to_sprint(sprintId, listOfIssueKeys);

# Создание задачи
def addNewIssue(jira, fieldList):
	jira.create_issues(fieldList);
	