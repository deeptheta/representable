package hu.vr.representable.html.tags;

import hu.vr.representable.AnyTag;

public interface HtmlLeafTag extends AnyTag {
	/* marker interface */
	public enum Domain implements HtmlLeafTag{
		img,
		br,
		hr
	}
}
