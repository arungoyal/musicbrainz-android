package org.musicbrainz.android.api.handler;

import org.musicbrainz.android.api.data.Recording;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class RecordingLookupHandler extends MBHandler {
    
    private Recording recording = new Recording();

    public Recording getResult() {
        return recording;
    }
    
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {

        if (localName.equalsIgnoreCase("")) {

        }
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

        if (localName.equalsIgnoreCase("")) {

        }
    }

}