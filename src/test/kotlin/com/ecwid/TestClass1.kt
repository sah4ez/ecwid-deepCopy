package com.ecwid

import org.junit.Assert
import org.junit.Test
/**
 * Created by aleksandr on 14.11.16.
 */

class TestClass1 {

    @Test fun testGetPropertyName() {
        val c1 = Class1(2)
        val cu = CopyUtils<Class1>()
        val c2 = cu.copyIntProperty(c1)

        Assert.assertEquals(2, c2.property1)
        Assert.assertTrue(cu.theyAreEqual(c1, c2))
    }

}




