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

    @Test fun tesSubClassCopy() {
        val c1 = ClassWithSubclass(ClassWithSubclass.SubClass(3, mutableListOf(11, 12, 13, 14)))
        val c2 = CopyUtils.Companion.copyProperties(c1)

        Assert.assertTrue(CopyUtils.Companion.theyAreEqual(c1, c2))
    }

    @Test fun testFalseCopyProperties() {
        val c1 = ClassProperty(1, 1, "one")
        val c2 = ClassProperty(2, 2, "two")

        Assert.assertFalse(CopyUtils.Companion.theyAreEqual(c1, c2))
    }

    @Test fun testFalseCopyPropertiesString() {
        val c1 = ClassProperty(1, 1, "one")
        val c2 = ClassProperty(1, 1, "two")

        Assert.assertFalse(CopyUtils.Companion.theyAreEqual(c1, c2))
    }

    @Test fun testTrueCopyProperties() {
        val c1 = ClassProperty(1, 1, "one")
        val c2 = ClassProperty(1, 1, "one")

        Assert.assertTrue(CopyUtils.Companion.theyAreEqual(c1, c2))
    }

    @Test fun testTrueCopyCollection() {
        val c1 = ClassCollection(mutableListOf(6, 7, 8, 9, 0))
        val c2 = ClassCollection(mutableListOf(6, 7, 8, 9, 0))

        Assert.assertTrue(CopyUtils.Companion.theyAreEqual(c1, c2))
    }
}




