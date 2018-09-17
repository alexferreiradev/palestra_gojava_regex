package extrator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MeetupExtractor implements Extractor<List<String>> {

	private String text;

	@Override
	public List<String> getResult(String regex) {
		List<String> participantList = new ArrayList<>();

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			String participantName = matcher.group();

			participantList.add(participantName);
		}

		return participantList;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}
}
