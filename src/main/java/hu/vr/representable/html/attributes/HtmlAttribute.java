package hu.vr.representable.html.attributes;

import hu.vr.representable.Attribute;

public interface HtmlAttribute extends Attribute {
	public enum Domain implements HtmlAttribute{
		id,
		value,
		href,
		src,
		width,
		height;
		
		public static final Domain attrName(String attrName) {
			if(attrName==null) {
				return null;
			}
			return Domain.valueOf(attrName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", "").toLowerCase());
		}
		
		public static final Domain attr(Attribute attr) {
			return attrName(attr.toString());
		}
	}
}
