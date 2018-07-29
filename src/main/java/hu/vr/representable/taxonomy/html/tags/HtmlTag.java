package hu.vr.representable.taxonomy.html.tags;

import hu.vr.representable.taxonomy.IsTagDomain;
import hu.vr.representable.taxonomy.Tag;

public interface HtmlTag extends Tag {
	public enum DomainElement implements HtmlTag{
		input,
		img,
		br,
		hr,
		div,
		p,
		a;
	}
	
	public enum Domain implements IsTagDomain<HtmlTag> {
		QUERY;
		@Override
		public HtmlTag getExactElement(String exactName) {
			return DomainElement.valueOf(exactName);
		}
	}
}
