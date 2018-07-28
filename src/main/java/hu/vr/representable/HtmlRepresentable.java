package hu.vr.representable;

import java.util.Map;

public interface HtmlRepresentable extends XmlRepresentable {
	//public HtmlTag getTagName();
    public Map<String, String> getAttributes();
    public String getContent();
}
