package hu.vr.representable.html.tags;

import hu.vr.representable.Tag;

public interface HtmlTag extends Tag {
	public enum Domain implements HtmlTag{
		img,
		br,
		hr;
		
		public static final Domain tagName(String tagName) {
			if(tagName==null) {
				return null;
			}
			return Domain.valueOf(tagName.replaceAll("[^a-zA-Z0-9_:.]","").replaceFirst("^[^a-zA-Z_:]*", "").toLowerCase());
		}
		
		public static final Domain tag(Tag tag) {
			return tagName(tag.toString());
		}
	}
}
