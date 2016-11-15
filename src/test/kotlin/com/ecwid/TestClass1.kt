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

        Assert.assertEquals(2, cu.copyIntProperty(c1).property1)
    }

}




