package hu.vr.representable.taxonomy.html.attributes;

import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.IsAttributeDomain;

public interface HtmlAttribute extends Attribute {
	public enum DomainElement implements HtmlAttribute {
		id,
		value,
		type,
		href,
		src,
		width,
		height;
	}
	
	public enum Domain implements IsAttributeDomain<HtmlAttribute> {
		QUERY;
		@Override
		public HtmlAttribute getExactElement(String exactName) {
			return DomainElement.valueOf(exactName);
		}
	}
}
