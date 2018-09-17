package main;

import extrator.Extractor;
import extrator.MeetupExtractor;
import html.HttpRequestExecutor;
import html.HttpRequestExecutorBase;
import util.StreamUtil;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Iniciando programa...");

		HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutorBase();
		Extractor<List<String>> meetupExtractor = new MeetupExtractor();

//		URL meetupUrl = URI.create("").toURL();
//		String meetupSiteText = httpRequestExecutor.getResponseText(meetupUrl);
		String meetupSiteText = StreamUtil.extractTextFromStream(Main.class.getResourceAsStream("/meetup_example.html"));

		meetupExtractor.setText(meetupSiteText);
		List<String> userNameList = meetupExtractor.getResult("(?<=\\\"visibility\\-\\-a11yHide\\\"\\>)[^<]+");

		System.out.printf("Participantes encontrados: %d", userNameList.size());
		for (String userName : userNameList) {
			System.out.printf("Nome: %s\n", userName);
		}

		System.out.println("Fim de execução");
	}
}
