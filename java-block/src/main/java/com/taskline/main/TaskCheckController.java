package com.taskline.main;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class TaskCheckController {
	
	public static String userId; // may be empty string if you manage user on your side
	public static float combinedUserScore;
	public static String lastUpdateTime;
	
	public static String[] wordsRelated1 = {"!задача", "задача", "!сделать", "сделать", "!делай", "!поставил задачу", "поставил задачу", "!планирую", "планирую", "!планируем", "планируем", "!планирует", "планирует", "надо контролировать", "необходимо контролировать", "проконтролируй", "выполни", "выполнить", "!выполняй"};

	public static float checkTask(String uID, String strUserInput)
	{		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime nowTime = LocalDateTime.now();
		lastUpdateTime = dtf.format(nowTime);

		userId = uID;
		
		strUserInput = " "+strUserInput;

		for(int f = 0; f < wordsRelated1.length; f++)
		{
			if(wordsRelated1[f].substring(0,1).equals("!"))
			{
				combinedUserScore -= checkScore(wordsRelated1[f].substring(1), strUserInput, 1);
			}
			else
			{
				if(strUserInput.indexOf(wordsRelated1[f]) >= 0) combinedUserScore += 1;
			}
		}
		
		return combinedUserScore;
	}
	
	private static float checkScore(String strActual, String strUserInput, float val)
	{
		float comboScore = 0;

		int i = strUserInput.indexOf(strActual);

		if(i >= 0)
		{
			if((i >= 4 && !strUserInput.substring(i-4,i-1).equals(" не")) && (i >= 5 && !strUserInput.substring(i-5,i-1).equals(" нет")))
			{
				comboScore += val;
			}
		}

		return comboScore;
	}
}
