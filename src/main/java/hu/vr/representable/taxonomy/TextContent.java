package hu.vr.representable.taxonomy;

/**
 * An arbitrary XML textual content (which appears between tags) with valid syntax.
 */
public interface TextContent {
	/**
	 * Simple domain element holder. Can only be created through factory methods that handle validation.
	 */
	public static final class DomainElement implements TextContent{
		private final String text;
		private DomainElement(String text){
			this.text = text;
		}
		@Override
		public final String toString() {
			return text;
		}
	}
	
	/**
	 * Validating TextContent factory.
	 */
	public static TextContent text(String text) {
		if(text==null) {
			return null;
		}
		return new DomainElement(text.replaceAll("<","&lt;").replaceAll(">","&gt;"));
	}
}
