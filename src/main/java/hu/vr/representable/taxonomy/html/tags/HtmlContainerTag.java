package hu.vr.representable.taxonomy.html.tags;

import hu.vr.representable.taxonomy.IsTagDomain;

public interface HtmlContainerTag extends HtmlTag {
	public enum DomainElement implements HtmlContainerTag{
		div,
		p,
		a;
	}
	
	public enum Domain implements IsTagDomain<HtmlContainerTag> {
		QUERY;
		@Override
		public HtmlContainerTag getExactElement(String exactName) {
			return DomainElement.valueOf(exactName);
		}
	}
}
