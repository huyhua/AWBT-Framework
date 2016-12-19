package abtlibrary.keywords.appiumlibrary;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;


import com.applitools.eyes.Eyes;

import com.applitools.eyes.Region;


public class EyesMobile extends Eyes {
	
	public void checkRegion(final WebElement element, int matchTimeout,
                            String tag){
//		  super.checkWindowBase(
//	                new RegionProvider() {
//
//	                    public Region getRegion() {
//	                        Point p = element.getLocation();
//	                        Dimension d = element.getSize();
//	                        return new Region(p.getX(), p.getY(), d.getWidth(),
//	                                d.getHeight());
//	                    }
//
//	                    public CoordinatesType getCoordinatesType() {
//	                        // If we're given a region, it is relative to the
//	                        // frame's viewport.
//	                        return CoordinatesType.CONTEXT_RELATIVE;
//	                    }
//	                },
//	                tag,
//	                false,
//	                matchTimeout
//	        );
//	        logger.verbose("Done! trying to scroll back to original position..");
//	        regionVisibilityStrategy.returnToOriginalPosition(positionProvider);
//	        logger.verbose("Done!");
	}

}
