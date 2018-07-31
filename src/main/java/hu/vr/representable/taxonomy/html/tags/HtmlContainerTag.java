package hu.vr.representable.taxonomy.html.tags;

import hu.vr.representable.taxonomy.IsTagDomain;

/**
 * Domain definition of valid html container tags.
 */
public interface HtmlContainerTag extends HtmlTag {
	public enum DomainElement implements HtmlContainerTag{
		div,
		table,
		tr,
		td,
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
