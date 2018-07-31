package org.user.renderer;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;
import hu.vr.representable.context.RepresentableContext;
import hu.vr.representable.renderer.DefaultRenderer;
import hu.vr.representable.taxonomy.html.tags.HtmlContainerTag;

/**
 * Can render [table] elements that contain non-[tr] elements as well.
 * Can render [tr] elements that contain non-[td] elements as well.
 */
public class AdvancedRenderer extends DefaultRenderer {
	
	public AdvancedRenderer() {
		super();
	}

	public AdvancedRenderer(RepresentableContext factory) {
		super(factory);
	}

	@Override
	public String render(XmlRepresentableContainer<?,?,?,?> container) {
		if(elementHasTag(container, HtmlContainerTag.DomainElement.table)) {
			return renderTable(container);
		}
		if(elementHasTag(container, HtmlContainerTag.DomainElement.tr)) {
			return renderRow(container);
		}
		return super.renderTag(container);
	}
	
	private String renderTable(XmlRepresentableContainer<?,?,?,?> container) {
		StringBuilder sb = new StringBuilder();
		appendOpeningTag(sb, container);
		if(!isCompactTag(container)) {
			boolean startedRow = false;
			for(XmlRepresentable<?,?> child : container.getChildren()) {
				if(elementHasTag(child, HtmlContainerTag.DomainElement.tr)) {
					if(startedRow) {
						sb.append("</tr>");
						startedRow = false;
					}
					sb.append(child.acceptRenderer(this));
				}
				else {
					if(!startedRow) {
						sb.append("<tr>");
						startedRow = true;
					}
					sb.append("<td>");
					sb.append(child.acceptRenderer(this));
					sb.append("</td>");
				}
			}
			if(startedRow) {
				sb.append("</tr>");
				startedRow = false;
			}
			appendClosingTag(sb, container);
		}
		return sb.toString();
	}
	
	private String renderRow(XmlRepresentableContainer<?,?,?,?> container) {
		StringBuilder sb = new StringBuilder();
		appendOpeningTag(sb, container);
		if(!isCompactTag(container)) {
			for(XmlRepresentable<?,?> child : container.getChildren()) {
				if(elementHasTag(child, HtmlContainerTag.DomainElement.td)) {
					sb.append(child.acceptRenderer(this));
				}
				else {
					sb.append("<td>");
					sb.append(child.acceptRenderer(this));
					sb.append("</td>");
				}
			}
			appendClosingTag(sb, container);
		}
		return sb.toString();
	}
	
}
