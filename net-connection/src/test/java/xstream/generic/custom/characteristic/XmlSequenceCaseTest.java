package xstream.generic.custom.characteristic;

import org.junit.Test;

public class XmlSequenceCaseTest {
    private XmlSequenceCase service = new XmlSequenceCase();

    @Test
    public void testSortsFieldOrderWithArray() {
        service.testSortsFieldOrderWithArray();
    }

    @Test
    public void testSeqFeildsByAnnotation() {
        service.fieldSeqByAnnotation();
    }

    @Test
    public void testPartialFieldSeqByAnnotation() {
        service.partialFieldSeqByAnnotation();
    }
}
