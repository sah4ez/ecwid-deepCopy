package com.ecwid

import org.junit.Assert
import org.junit.Test

/**
 * Created by aleksandr on 14.11.16.
 */

class TestClass1 {

    @Test fun testCopyProperties() {
        val c1 = ClassProperty(2, 2, "two")
        val c2 = CopyUtils.Companion.copyProperties(c1)

        Assert.assertTrue(CopyUtils.Companion.theyAreEqual(c1, c2))
    }

    @Test fun testCopyCollection() {
        val c1 = ClassCollection(mutableListOf(6, 7, 8, 9, 0))
        val c2 = CopyUtils.Companion.copyProperties(c1)

        Assert.assertTrue(CopyUtils.Companion.theyAreEqual(c1, c2))
    }

    @Test fun testCopySubClass() {
        val c1 = ClassWithSubclass(2, mutableListOf(6, 7, 8, 9, 0))
        val c2 = CopyUtils.Companion.copyProperties(c1)

        Assert.assertTrue(CopyUtils.Companion.theyAreEqual(c1, c2))
    }

}




