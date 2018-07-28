package hu.vr.representable.tag;

public interface HtmlContainerTag extends HtmlLeafTag {
	/* marker interface */
	public enum Enum implements HtmlContainerTag{
		div,
		p,
		a
	}
}
