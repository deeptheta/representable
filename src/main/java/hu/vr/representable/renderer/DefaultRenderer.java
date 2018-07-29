package hu.vr.representable.renderer;

import java.util.Map.Entry;

import hu.vr.representable.Attribute;
import hu.vr.representable.AttributeValue;
import hu.vr.representable.Tag;
import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;

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
	public String render(XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr) {
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
	public String render(XmlRepresentableContainer<? extends Tag, ? extends Attribute> xmlReprCont) {
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
	
	protected String renderContentOnly(XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr) {
		return xmlRepr.getContent()==null ? "" : xmlRepr.getContent().toString();
	}
	
	protected String renderTag(XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr) {		
		StringBuilder sb = new StringBuilder();
		appendOpeningTag(sb, xmlRepr);
		if(!isCompactTag(xmlRepr)) {
			sb.append(renderContentOnly(xmlRepr));
			appendClosingTag(sb, xmlRepr);
		}
		return sb.toString();
	}
	
	protected String renderTag(XmlRepresentableContainer<? extends Tag, ? extends Attribute> xmlReprCont) {		
		StringBuilder sb = new StringBuilder();
		appendOpeningTag(sb, xmlReprCont);
		if(!isCompactTag(xmlReprCont)) {
			sb.append(renderContentOnly(xmlReprCont));
			for(XmlRepresentable<? extends Tag, ? extends Attribute> child : xmlReprCont.getChildren()) {
				sb.append(child.acceptRenderer(this));
			}
			appendClosingTag(sb, xmlReprCont);
		}
		return sb.toString();
	}
	
	protected void appendOpeningTag(StringBuilder sb, XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr) {
		appendBeginningOfOpeningTag(sb, xmlRepr);
		if(isCompactTag(xmlRepr)) {
			sb.append("/>");
		}
		else {
			sb.append('>');
		}
	}
	
	protected void appendOpeningTag(StringBuilder sb, XmlRepresentableContainer<? extends Tag, ? extends Attribute> xmlRepr) {
		appendBeginningOfOpeningTag(sb, xmlRepr);
		if(isCompactTag(xmlRepr)) {
			sb.append("/>");
		}
		else {
			sb.append('>');
		}
	}
	
	protected void appendClosingTag(StringBuilder sb, XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr) {
		sb.append("</");
		sb.append(xmlRepr.getTag());
		sb.append('>');
	}
	
	private void appendBeginningOfOpeningTag(StringBuilder sb, XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr) {
		sb.append('<');
		sb.append(xmlRepr.getTag());
		if(xmlRepr.getAttributes()!=null) {
			for(Entry<? extends Attribute, AttributeValue> attributeEntry : xmlRepr.getAttributes().entrySet()) {
				sb.append(' ');
				sb.append(attributeEntry.getKey());
				sb.append("=\"");
				sb.append(attributeEntry.getValue());
				sb.append("\"");
			}
		}
	}

	private boolean isCompactTag(XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr) {
		return xmlRepr.getContent()==null;
	}
	
	private boolean isCompactTag(XmlRepresentableContainer<? extends Tag, ? extends Attribute> xmlReprCont) {
		return xmlReprCont.getContent()==null 
				&& (xmlReprCont.getChildren()==null || xmlReprCont.getChildren().isEmpty());
	}

}
