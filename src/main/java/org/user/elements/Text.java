package org.user.elements;

import hu.vr.representable.html.elements.TextElement;
import hu.vr.representable.taxonomy.TextContent;

public class Text extends TextElement {

	private final String text;
	
	public Text(String text) {
		super();
		this.text = text;
	}

	@Override
	public TextContent getContent() {
		return TextContent.text(this.text);
	}

}
