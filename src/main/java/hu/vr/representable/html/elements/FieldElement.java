package hu.vr.representable.html.elements;

import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;

/**
 * Convenience class for extension: represents a [td]...[/td] field.
 * @author Viktor Remeli
 *
 */
public abstract class FieldElement extends AbstractHtmlContainer {

	@Override
	public final HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.td;
	}

}
