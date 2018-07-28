package hu.vr.representable.tag;

public interface HtmlLeafTag extends AnyTag {
	/* marker interface */
	public enum Enum implements HtmlLeafTag{
		img,
		br,
		hr
	}
}
