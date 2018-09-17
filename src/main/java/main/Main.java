package main;

import extrator.Extractor;
import extrator.MeetupExtractor;
import html.HttpRequestExecutor;
import html.HttpRequestExecutorBase;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class Main {

	private static final String MEETUP_URL_GOJAVA = "https://www.meetup.com/mu_api/urlname/events/eventId/attendees?queries=%28endpoint%3AGOJava%2Fevents%2F254555959%2Frsvps%2Cmeta%3A%28method%3Aget%29%2Cparams%3A%28desc%3A%21t%2Cfields%3A%27answers%2Cpay_status%2Cself%2Cweb_actions%2Cattendance_status%27%2Conly%3A%27answers%2Cresponse%2Cattendance_status%2Cguests%2Cmember%2Cpay_status%2Cupdated%27%2Corder%3Atime%29%2Cref%3AeventAttendees_GOJava_254555959%2Ctype%3Aattendees%29";

	public static void main(String[] args) throws IOException {
		System.out.println("Iniciando programa...");

		HttpRequestExecutor httpRequestExecutor = new HttpRequestExecutorBase();
		Extractor<List<String>> meetupExtractor = new MeetupExtractor();

		URL meetupUrl = URI.create(MEETUP_URL_GOJAVA).toURL();
		String meetupSiteText = httpRequestExecutor.getResponseText(meetupUrl);

		meetupExtractor.setText(meetupSiteText);
		List<String> userNameList = meetupExtractor.getResult("(?<=\"member\":\\{\"id\":\\d{9},\"name\":\")[^\"]+");

		System.out.printf("Participantes encontrados: %d", userNameList.size());
		for (String userName : userNameList) {
			System.out.printf("Nome: %s\n", userName);
		}

		System.out.println("Fim de execução");
	}
}
