package main;

import extrator.Extractor;
import extrator.MeetupExtractor;
import html.HttpRequestExecutor;
import html.HttpRequestExecutorBase;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class Main {

	static void main(String[] args, int argc) throws MalformedURLException {
		System.out.println("Iniciando programa...");

		HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutorBase();
		Extractor<List<String>> meetupExtractor = new MeetupExtractor();

		URL meetupUrl = URI.create("").toURL();
		String meetupSiteText = httpRequestExecutor.getResponseText(meetupUrl);

		meetupExtractor.setText(meetupSiteText);
		List<String> userNameList = meetupExtractor.getResult("");

		System.out.printf("Participantes encontrados: %d", userNameList.size());
		for (String userName : userNameList) {
			System.out.printf("Nome: %s\n", userName);
		}

		System.out.println("Fim de execução");
	}
}
