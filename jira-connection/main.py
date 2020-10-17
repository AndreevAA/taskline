from jira import JIRA
import secret_data

# jira_options = {secret_data.server: secret_data.webPage}
# jira = JIRA(options=jira_options, basic_auth=(secret_data.login, secret_data.api_key))

# jql = 'project = ' + project_key + ' AND  worklogDate >= ' + work_date
# issues_list = jira.search_issues(jql)

#print(issues_list)

user = secret_data.login
apikey = secret_data.api_key
server = secret_data.server

options = {
 'server': server
}

jira = JIRA(options, basic_auth=(user,apikey) )

