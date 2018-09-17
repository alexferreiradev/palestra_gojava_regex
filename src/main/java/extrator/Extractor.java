package extrator;

public interface Extractor<ResultType> {

	ResultType getResult(String regex);

	void setText(String text);

}
