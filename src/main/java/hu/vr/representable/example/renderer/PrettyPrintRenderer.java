package hu.vr.representable.example.renderer;

import hu.vr.representable.XmlRepresentable;
import hu.vr.representable.XmlRepresentableContainer;
import hu.vr.representable.context.RepresentableContext;
import hu.vr.representable.renderer.DefaultRenderer;
import hu.vr.representable.taxonomy.Attribute;
import hu.vr.representable.taxonomy.Tag;

/**
 * This representation renderer generates newlines and indentation for human readability.
 */
public class PrettyPrintRenderer extends DefaultRenderer {
	
	private int depth = 0;

	public PrettyPrintRenderer() {
		super();
	}

	public PrettyPrintRenderer(RepresentableContext factory) {
		super(factory);
	}

	@Override
	public String render(XmlRepresentable<? extends Tag, ? extends Attribute> xmlRepr) {
		return "\n"+indent()+super.render(xmlRepr);
	}

	@Override
	public String render(
			XmlRepresentableContainer<? extends Tag, ? extends Attribute, ? extends Tag, ? extends Attribute> xmlReprCont) {
		return "\n"+indent()+super.render(xmlReprCont);
	}
	
	@Override
	protected void appendClosingTag(StringBuilder sb, XmlRepresentable<?,?> xmlRepr) {
		sb.append("\n"+indent());
		super.appendClosingTag(sb, xmlRepr);
	}
	
	private String indent() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<depth; i++) {
			sb.append("\t");
		}
		return sb.toString();
	}

	@Override
	protected void increaseDepth() {
		depth++;
	}

	@Override
	protected void decreaseDepth() {
		depth--;
	}
	
	

}
