package hu.vr.representable.taxonomy.html.attributes;

import hu.vr.representable.taxonomy.IsAttributeDomain;

/**
 * Domain definition of valid html input element attributes.
 */
public interface InputAttribute extends HtmlAttribute {
	public enum DomainElement implements InputAttribute {
		id,
		value,
		type,
		style;
	}
	
	public enum Domain implements IsAttributeDomain<InputAttribute> {
		QUERY;
		@Override
		public InputAttribute getExactElement(String exactName) {
			return DomainElement.valueOf(exactName);
		}
	}
}