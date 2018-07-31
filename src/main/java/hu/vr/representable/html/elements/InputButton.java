package hu.vr.representable.html.elements;

import hu.vr.representable.taxonomy.AttributeValue;
import hu.vr.representable.taxonomy.html.attributes.InputAttribute;

/**
 * Is a button UI element.
 */
public class InputButton extends InputElement {
	
	public InputButton(String buttonText) {
		attributes.put(InputAttribute.DomainElement.type, AttributeValue.attrValue("button"));
		if(buttonText!=null) {
			attributes.put(InputAttribute.DomainElement.value, AttributeValue.attrValue(buttonText));
		}		
	}

}
