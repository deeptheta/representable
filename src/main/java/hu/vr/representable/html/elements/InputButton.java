package hu.vr.representable.html.elements;

import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.html.attributes.InputAttribute;

public class InputButton extends InputElement {
	
	public InputButton(String buttonText) {
		attributes.put(InputAttribute.DomainElement.type, AttributeValue.attrValue("button"));
		if(buttonText!=null) {
			attributes.put(InputAttribute.DomainElement.value, AttributeValue.attrValue(buttonText));
		}		
	}

}
