package hu.vr.representable.renderer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hu.vr.representable.AbstractXmlContainer;
import hu.vr.representable.AbstractXmlElement;
import hu.vr.representable.html.AbstractHtmlContainer;
import hu.vr.representable.html.AbstractHtmlElement;
import hu.vr.representable.html.elements.InputElement;
import hu.vr.representable.html.elements.InputField;
import hu.vr.representable.testrepresentables.CompositeHtmlDeep;
import hu.vr.representable.testrepresentables.CompositeHtmlTag;
import hu.vr.representable.testrepresentables.CompositeXmlDeep;
import hu.vr.representable.testrepresentables.CompositeXmlTag;
import hu.vr.representable.testrepresentables.SimpleHtmlTag;
import hu.vr.representable.testrepresentables.SimpleHtmlText;
import hu.vr.representable.testrepresentables.SimpleTextLeaf;
import hu.vr.representable.testrepresentables.SimpleXmlTag;
import hu.vr.representable.testrepresentables.SimpleXmlTagWithContent;

public class DefaultRendererTest {
	
	DefaultRenderer defRenderer = new DefaultRenderer();

	@Test
    public void renderSimpleObject() {
        Object o = new Object();
        String result = defRenderer.render(o);
        System.out.println("simple object :    " + result);
        
        assertTrue( result.startsWith("java.lang.Object@") );
    }
    
	@Test
    public void renderSimpleXml() {
        AbstractXmlElement xmlRepr = new SimpleXmlTag();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple xml    :    " + result);

        assertTrue( result.startsWith("<simpletag ") );
        assertTrue( result.contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith("/>") );
    }
    
	@Test
    public void renderSimpleXmlWithContent() {
		AbstractXmlElement xmlRepr = new SimpleXmlTagWithContent();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple xml+txt:    " + result);

        assertTrue( result.startsWith("<simpletag ") );
        assertTrue( result.contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith(">Lorem 5 &lt; 6 ipsum...</simpletag>") );
    }
    
	@Test
    public void renderSimpleTextLeaf() {
		AbstractXmlElement xmlRepr = new SimpleTextLeaf();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple txtLeaf:    " + result);

        assertTrue( "just some text...".equals(result) );
    }
    
	@Test
    public void renderCompositeTag() {
		AbstractXmlContainer xmlReprCont = new CompositeXmlTag();
        String result = defRenderer.render(xmlReprCont);
        System.out.println("composite tag :    " + result);

        assertTrue( result.startsWith("<complextag>This is some rather complex textual content...<simpletag ") );
        assertTrue( result.contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith("/>just some text...</complextag>") );
    }
    
	@Test
    public void renderCompositeDeep() {
		AbstractXmlContainer xmlReprCont = new CompositeXmlDeep();
        String result = defRenderer.render(xmlReprCont);
        System.out.println("deep composite:    " + result);

        assertTrue( result.startsWith("<deeptag height=\"3\"><simpletag ") );
        assertTrue( result.substring(30, 83).contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.substring(30, 83).contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.substring(83, 205).equals(">Lorem 5 &lt; 6 ipsum...</simpletag>just some text..."
        		+ "<complextag>This is some rather complex textual content...<simpletag ") );
        assertTrue( result.substring(204, 257).contains(" playdoh=\"O'Reilly2018\"") );
        assertTrue( result.substring(204, 257).contains(" quickndirty=\"try 'dblquotes'\"") );
        assertTrue( result.endsWith("/>just some text...</complextag>just some text...</deeptag>") );
    }
	
	@Test
    public void renderSimpleHtmlText() {
		AbstractHtmlElement htmlRepr = new SimpleHtmlText();
        String result = defRenderer.render(htmlRepr);
        System.out.println("simple htmlTxt:    " + result);

        assertTrue( "Random html text...".equals(result) );
    }

	@Test
    public void renderSimpleHtmlTag() {
		AbstractHtmlElement htmlRepr = new SimpleHtmlTag();
        String result = defRenderer.render(htmlRepr);
        System.out.println("simple htmlTag:    " + result);

        assertTrue( "<div id=\"simple001\"/>".equals(result) );
    }
	
	@Test
    public void renderCompositeHtmlTag() {
		AbstractHtmlContainer htmlRepr = new CompositeHtmlTag();
        String result = defRenderer.render(htmlRepr);
        System.out.println("html composite:    " + result);

        assertTrue( "<div>Inside of a composite html...<div id=\"simple001\"/>Random html text...</div>"
        		.equals(result) );
    }

	@Test
    public void renderCompositeHtmlDeep() {
		AbstractHtmlContainer htmlRepr = new CompositeHtmlDeep();
        String result = defRenderer.render(htmlRepr);
        System.out.println("html deep     :    " + result);

        assertTrue( ("<div height=\"3\">Deep element starts...<div id=\"simple001\"/>Random html text..."
        		+ "<div>Inside of a composite html...<div id=\"simple001\"/>Random html text...</div>"
        		+ "Random html text...</div>")
        		.equals(result) );
    }
	
	@Test
    public void renderInputField() {
		InputElement inputField = new InputField(null);
        String result = defRenderer.render(inputField);
        System.out.println("input field   :    " + result);

        assertTrue( "<input type=\"text\"/>".equals(result) );
    }
    
}
