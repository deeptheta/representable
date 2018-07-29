package hu.vr.representable.testrepresentations;

import hu.vr.representable.TextContent;

public class SimpleXmlTagWithContent extends SimpleXmlTag {

	@Override
	public TextContent getContent() {
		return TextContent.Domain.text("Lorem 5 < 6 ipsum...");
	}
	
}
