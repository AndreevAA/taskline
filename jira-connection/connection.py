from jira import JIRA
import json, codecs, jiraGetFunctions, jiraAddFunctions, secret_data

# Открытие соединения с сервером
def connect(login, api_key, server):
	options = {
	 'server': server
	}
	return(JIRA(options, basic_auth=(login, api_key)))

# Закрытие соединения с сервером
def close(jira):
	jira.close();

# Создание JSON-файла
def getJsonFile(jira, outputFileName):
	data = dict();

	allTicketList = jiraGetFunctions.getListOfAllTasks(jira, secret_data.project_name);
	for tempTicket in allTicketList:
		tempTiketData = dict();
		tempTiketData["Name"] = jiraGetFunctions.getTaskNameByTicket(jira, tempTicket);
		tempTiketData["Body"] = jiraGetFunctions.getTaskDesciptionByTicket(jira, tempTicket);

		data[str(tempTicket)] = tempTiketData;

	print(data);
	with open(outputFileName, 'wb') as outputFile: 
		json.dump(data, codecs.getwriter('utf-8')(outputFile), ensure_ascii=False)

