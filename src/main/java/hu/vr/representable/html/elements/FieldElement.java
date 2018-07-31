package hu.vr.representable.html.elements;

import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;

/**
 * Represents a [td]...[/td] field (usually found in a table).
 */
public abstract class FieldElement extends AbstractHtmlContainer {

	@Override
	public final HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.td;
	}

}
