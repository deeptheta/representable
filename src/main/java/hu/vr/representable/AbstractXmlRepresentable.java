//package hu.vr.representable;
//
//import hu.vr.representable.renderer.RendererService;
//
//public abstract class AbstractXmlRepresentable<T extends Tag, A extends Attribute> implements XmlRepresentable<T, A> {
//	
////	private final Map<A, String> attributes = new HashMap<>();
////	private final Map<? extends A, String> unmodAttributes = Collections.unmodifiableMap(attributes);
////
////	@Override
////	public final Map<? extends A, String> getAttributes() {
////		attributes.clear();
////		if(getAttributeKeys()==null) {
////			return unmodAttributes;
////		}
////		for(A key : getAttributeKeys()) {
////			setAttributeFormatted(key, getAttributeRawValue(key));
////		}
////		return unmodAttributes;
////	}
//
//	@Override
//	public String acceptRenderer(RendererService renderer) {
//		return renderer.render(this);
//	}
//	
////	private final void setAttributeFormatted(A keyAttribute, String rawValue) {
////		String formattedValue = rawValue==null ? null : rawValue.replaceAll("\"", "'");
////		attributes.put(keyAttribute, formattedValue);
////	}
//	
////	protected T inferTagFrom(String rawTag) {
////		return Tag.Domain.tagName(rawTag);
////	}
////	
////	protected A inferAttributeFrom(String rawKey) {
////		return Attribute.Domain.attrName(rawKey);
////	}
//	
////	protected abstract Set<A> getAttributeKeys();
////	protected abstract String getAttributeRawValue(A key);
//
//}
