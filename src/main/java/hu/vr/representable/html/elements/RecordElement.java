package hu.vr.representable.html.elements;

import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.taxonomy.TextContent;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;

/**
 * Convenience class for extension: represents a [tr]...[/tr] element.
 * @author Viktor Remeli
 *
 */
public abstract class RecordElement extends AbstractHtmlContainer {

	@Override
	public final HtmlContainerTag getTag() {
		return HtmlContainerTag.DomainElement.tr;
	}

	@Override
	public final TextContent getContent() {
		return null;
	}

}
