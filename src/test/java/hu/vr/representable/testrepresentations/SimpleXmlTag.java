package hu.vr.representable.testrepresentations;

import java.util.HashMap;
import java.util.Map;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.renderer.RendererService;

public class SimpleXmlTag implements XmlRepresentable {
	
	private final Map<String, String> attributes = new HashMap<>();
	
	public SimpleXmlTag() {
		attributes.put("a", "O'Reilly2018");
		attributes.put("b", "\"between dblquotes\"");
	}

	@Override
	public String getTagName() {
		return "simpletag";
	}

	@Override
	public Map<String, String> getAttributes() {
		return attributes;
	}

	@Override
	public String getContent() {
		return null;
	}

	@Override
	public String acceptRenderer(RendererService renderer) {
		return renderer.render(this);
	}

}
