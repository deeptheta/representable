package hu.vr.representable.html.elements;

import hu.vr.representable.taxonomy.TextContent;

public class Label extends TextElement {

	private final String text;
	
	public Label(String text) {
		super();
		this.text = text;
	}

	@Override
	public TextContent getContent() {
		return TextContent.text(this.text);
	}

}
