package hu.vr.representable.html.elements;

import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.html.attributes.InputAttribute;

public class InputField extends InputElement {
	
	public InputField(String defaultValue) {
		attributes.put(InputAttribute.DomainElement.type, AttributeValue.attrValue("text"));
		if(defaultValue!=null) {
			attributes.put(InputAttribute.DomainElement.value, AttributeValue.attrValue(defaultValue));
		}		
	}

}
