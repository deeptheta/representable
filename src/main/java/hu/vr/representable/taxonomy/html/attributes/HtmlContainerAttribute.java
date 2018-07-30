package hu.vr.representable.taxonomy.html.attributes;

import hu.vr.representable.taxonomy.IsAttributeDomain;

public interface HtmlContainerAttribute extends HtmlAttribute {
	public enum DomainElement implements HtmlContainerAttribute {
		id,
		width,
		height,
		style;
	}
	
	public enum Domain implements IsAttributeDomain<HtmlContainerAttribute> {
		QUERY;
		@Override
		public HtmlContainerAttribute getExactElement(String exactName) {
			return DomainElement.valueOf(exactName);
		}
	}
}
