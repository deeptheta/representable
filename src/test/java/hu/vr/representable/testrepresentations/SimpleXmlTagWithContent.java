package hu.vr.representable.testrepresentations;

public class SimpleXmlTagWithContent extends SimpleXmlTag {

	@Override
	protected String getRawContent() {
		return "Lorem 5 < 6 ipsum...";
	}
	
}
