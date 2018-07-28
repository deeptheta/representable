package hu.vr.representable;

import hu.vr.representable.renderer.DefaultRenderer;
import hu.vr.representable.testrepresentations.SimpleXmlTag;
import hu.vr.representable.testrepresentations.SimpleXmlTagWithContent;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DefaultRendererTest extends TestCase {
    
    public DefaultRendererTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(DefaultRendererTest.class);
    }

    public void testRenderSimpleObject() {
        Object o = new Object();
        DefaultRenderer defRenderer = new DefaultRenderer();
        String result = defRenderer.render(o);
        System.out.println("simple object >> " + result);
    }
    
    public void testRenderSimpleXml() {
        XmlRepresentable xmlRepr = new SimpleXmlTag();
        DefaultRenderer defRenderer = new DefaultRenderer();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple xml    >> " + result);
    }
    
    public void testRenderSimpleXmlWithContent() {
        XmlRepresentable xmlRepr = new SimpleXmlTagWithContent();
        DefaultRenderer defRenderer = new DefaultRenderer();
        String result = defRenderer.render(xmlRepr);
        System.out.println("simple xml+Cnt>> " + result);
    }
    
}
