package hu.vr.representable.html;

import java.util.Map;

import hu.vr.representable.XmlRepresentable;

public interface HtmlRepresentable extends XmlRepresentable {
	//public HtmlTag getTagName();
    public Map<String, String> getAttributes();
    public String getContent();
}
