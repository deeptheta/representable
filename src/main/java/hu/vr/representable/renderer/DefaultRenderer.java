package hu.vr.representable.renderer;

import java.util.Map.Entry;

import hu.vr.representable.HtmlRepresentable;
import hu.vr.representable.XmlRepresentable;

public class DefaultRenderer extends AbstractRenderer {

	@Override
	public String render(Object object) {
		String result = super.render(object);
		if(result!=null && result.length()>0) {
			return result;
		}
		else if(object!=null) {
			return object.toString();
		}
		return "";
	}
	
	@Override
	public String render(XmlRepresentable xmlRepr) {
		if(xmlRepr==null) {
			return ""; 
		}
		else if(xmlRepr.getTagName()==null ||  xmlRepr.getTagName().isEmpty()
				|| xmlRepr.getAttributes()==null || xmlRepr.getAttributes().isEmpty()) {
			return renderContentOnly(xmlRepr);
		}
		else {
			return renderLeafTag(xmlRepr);
		}
	}

	@Override
	public String render(HtmlRepresentable htmlRepr) {
		return "HtmlRepresentation";
	}
	
	protected String renderContentOnly(XmlRepresentable xmlRepr) {
		return xmlRepr.getContent()==null ? "" : xmlRepr.getContent();
	}
	
	protected String renderLeafTag(XmlRepresentable xmlRepr) {		
		StringBuilder sb = new StringBuilder();
		appendOpeningTag(sb, xmlRepr);
		if(!isCompactTag(xmlRepr)) {
			sb.append(renderContentOnly(xmlRepr));
			appendClosingTag(sb, xmlRepr);
		}
		return sb.toString();
	}
	
	protected void appendOpeningTag(StringBuilder sb, XmlRepresentable xmlRepr) {
		sb.append('<');
		sb.append(xmlRepr.getTagName());
		for(Entry<String, String> attributeEntry : xmlRepr.getAttributes().entrySet()) {
			sb.append(' ');
			sb.append(attributeEntry.getKey());
			sb.append("=\"");
			sb.append(attributeEntry.getValue().replaceAll("\"", "'"));
			sb.append("\"");
		}
		if(isCompactTag(xmlRepr)) {
			sb.append("/>");
		}
		else {
			sb.append('>');
		}
	}
	
	protected void appendClosingTag(StringBuilder sb, XmlRepresentable xmlRepr) {
		sb.append("</");
		sb.append(xmlRepr.getTagName());
		sb.append('>');
	}

	private boolean isCompactTag(XmlRepresentable xmlRepr) {
		return xmlRepr.getContent()==null;
	}

}
