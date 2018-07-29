package hu.vr.representable.renderer;

import java.util.Map.Entry;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;
import hu.vr.representable.taxonomy.AttributeValue;

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
	public String render(XmlRepresentable<?,?> xmlRepr) {
		if(xmlRepr==null) {
			return ""; 
		}
		else if(xmlRepr.getTag()==null
				|| xmlRepr.getTag().toString()==null
				|| xmlRepr.getTag().toString().isEmpty()) {
			return renderContentOnly(xmlRepr);
		}
		else {
			return renderTag(xmlRepr);
		}
	}
	
	@Override
	public String render(XmlRepresentableContainer<?,?,?,?> xmlReprCont) {
		if(xmlReprCont==null) {
			return ""; 
		}
		else if(xmlReprCont.getTag()==null 
				|| xmlReprCont.getTag().toString()==null
				|| xmlReprCont.getTag().toString().isEmpty()) {
			return renderContentOnly(xmlReprCont);
		}
		else {
			return renderTag(xmlReprCont);
		}
	}
	
	protected String renderContentOnly(XmlRepresentable<?,?> xmlRepr) {
		return xmlRepr.getContent()==null ? "" : xmlRepr.getContent().toString();
	}
	
	protected String renderTag(XmlRepresentable<?,?> xmlRepr) {		
		StringBuilder sb = new StringBuilder();
		appendOpeningTag(sb, xmlRepr);
		if(!isCompactTag(xmlRepr)) {
			sb.append(renderContentOnly(xmlRepr));
			appendClosingTag(sb, xmlRepr);
		}
		return sb.toString();
	}
	
	protected String renderTag(XmlRepresentableContainer<?,?,?,?> xmlReprCont) {		
		StringBuilder sb = new StringBuilder();
		appendOpeningTag(sb, xmlReprCont);
		if(!isCompactTag(xmlReprCont)) {
			sb.append(renderContentOnly(xmlReprCont));
			for(XmlRepresentable<?,?> child : xmlReprCont.getChildren()) {
				sb.append(child.acceptRenderer(this));
			}
			appendClosingTag(sb, xmlReprCont);
		}
		return sb.toString();
	}
	
	protected void appendOpeningTag(StringBuilder sb, XmlRepresentable<?,?> xmlRepr) {
		appendBeginningOfOpeningTag(sb, xmlRepr);
		if(isCompactTag(xmlRepr)) {
			sb.append("/>");
		}
		else {
			sb.append('>');
		}
	}
	
	protected void appendOpeningTag(StringBuilder sb, XmlRepresentableContainer<?,?,?,?> xmlRepr) {
		appendBeginningOfOpeningTag(sb, xmlRepr);
		if(isCompactTag(xmlRepr)) {
			sb.append("/>");
		}
		else {
			sb.append('>');
		}
	}
	
	protected void appendClosingTag(StringBuilder sb, XmlRepresentable<?,?> xmlRepr) {
		sb.append("</");
		sb.append(xmlRepr.getTag());
		sb.append('>');
	}
	
	private void appendBeginningOfOpeningTag(StringBuilder sb, XmlRepresentable<?,?> xmlRepr) {
		sb.append('<');
		sb.append(xmlRepr.getTag());
		if(xmlRepr.getAttributes()!=null) {
			for(Entry<?, AttributeValue> attributeEntry : xmlRepr.getAttributes().entrySet()) {
				sb.append(' ');
				sb.append(attributeEntry.getKey());
				sb.append("=\"");
				sb.append(attributeEntry.getValue());
				sb.append("\"");
			}
		}
	}

	private boolean isCompactTag(XmlRepresentable<?,?> xmlRepr) {
		return xmlRepr.getContent()==null;
	}
	
	private boolean isCompactTag(XmlRepresentableContainer<?,?,?,?> xmlReprCont) {
		return xmlReprCont.getContent()==null 
				&& (xmlReprCont.getChildren()==null || xmlReprCont.getChildren().isEmpty());
	}

}
