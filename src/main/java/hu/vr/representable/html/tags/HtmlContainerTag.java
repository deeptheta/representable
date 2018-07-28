package hu.vr.representable.html.tags;

public interface HtmlContainerTag extends HtmlLeafTag {
	/* marker interface */
	public enum Domain implements HtmlContainerTag{
		div,
		p,
		a
	}
}
