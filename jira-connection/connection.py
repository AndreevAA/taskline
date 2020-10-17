from jira import JIRA

def connect(login, api_key, server):
	options = {
	 'server': server
	}
	return(JIRA(options, basic_auth=(login, api_key)))


