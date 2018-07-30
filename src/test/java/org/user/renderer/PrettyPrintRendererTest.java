package org.user.renderer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hu.vr.representable.testrepresentables.CompositeHtmlDeep;

public class PrettyPrintRendererTest {
	
	private PrettyPrintRenderer ppRenderer = new PrettyPrintRenderer();
	
	@Test
    public void renderCompositeHtml() {
		CompositeHtmlDeep deepHtml = new CompositeHtmlDeep();
        String result = ppRenderer.render(deepHtml);
        System.out.println("ppCompositHtml:    " + result);
        
        assertTrue( ("\n" + 
        		"<div height=\"3\">Deep element starts...\n" + 
        		"	<div id=\"simple001\"/>\n" + 
        		"	Random html text...\n" + 
        		"	<div>Inside of a composite html...\n" + 
        		"		<div id=\"simple001\"/>\n" + 
        		"		Random html text...\n" + 
        		"	</div>\n" + 
        		"	Random html text...\n" + 
        		"</div>").equals(result) );
    }
}
