package hu.vr.representable.testrepresentables;

import hu.vr.representable.taxonomy.TextContent;

public class SimpleXmlTagWithContent extends SimpleXmlTag {

	@Override
	public TextContent getContent() {
		return TextContent.text("Lorem 5 < 6 ipsum...");
	}
	
}
