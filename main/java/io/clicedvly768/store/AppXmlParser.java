package io.clicedvly768.store;

import android.content.Context;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AppXmlParser {
    public static List<App> parseApps(Context context) {
        List<App> apps = new ArrayList<>();

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();

            InputStream is = (InputStream) context.getResources().getXml(R.xml.apps);
            parser.setInput(is, null);

            String currentTag = null;
            App currentApp = null;
            String name = null, category = null, description = null;

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        currentTag = parser.getName();
                        if ("app".equals(currentTag)) {
                            currentApp = new App("", "", "");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if (currentTag != null) {
                            String text = parser.getText();
                            switch (currentTag) {
                                case "name":
                                    name = text;
                                    break;
                                case "category":
                                    category = text;
                                    break;
                                case "description":
                                    description = text;
                                    break;
                            }
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if ("app".equals(parser.getName()) && currentApp != null) {
                            currentApp = new App(name, category, description);
                            apps.add(currentApp);
                            currentApp = null;
                        }
                        currentTag = null;
                        break;
                }
                eventType = parser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return apps;
    }
}