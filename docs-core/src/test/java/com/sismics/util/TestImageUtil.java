package com.sismics.util;

import org.junit.Assert;
import org.junit.Test;
import java.awt.image.BufferedImage;

/**
 * Test of the image utilities.
 * 
 * @author bgamard
 */
public class TestImageUtil {

    @Test
    public void computeGravatarTest() {
        Assert.assertEquals("0bc83cb571cd1c50ba6f3e8a78ef1346", ImageUtil.computeGravatar("MyEmailAddress@example.com "));
    }

    @Test
    public void testIsBlack() {
        BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);

        // Test outside image boundaries
        Assert.assertFalse(ImageUtil.isBlack(image, -1, 5));
        Assert.assertFalse(ImageUtil.isBlack(image, 5, -1));
        Assert.assertFalse(ImageUtil.isBlack(image, 15, 5));
        Assert.assertFalse(ImageUtil.isBlack(image, 5, 15));

        // Test inside image boundaries
        Assert.assertTrue(ImageUtil.isBlack(image, 5, 5));
    }
}
