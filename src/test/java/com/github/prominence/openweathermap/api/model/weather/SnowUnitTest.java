/*
 * Copyright (c) 2021 Alexey Zinchenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.prominence.openweathermap.api.model.weather;

import org.junit.Assert;
import org.junit.Test;

public class SnowUnitTest {
    @Test
    public void whenCreateSnowWithValidArgs_ObjectIsCreated() {
        Snow.withValues(2222.3, 324234.3);
        Snow.withThreeHourLevelValue(213123.4);
        Snow.withOneHourLevelValue(123123.123);
    }

    @Test
    public void whenSetValues_thenTheyAreSet() {
        final Snow snow = Snow.withValues(0, 0);

        snow.setOneHourSnowLevel(33.3);
        Assert.assertEquals(33.3, snow.getOneHourSnowLevel(), 0.00001);

        snow.setThreeHourSnowLevel(55.5);
        Assert.assertEquals(55.5, snow.getThreeHourSnowLevel(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSetInvalidOneHourLevelValue_thenFail() {
        final Snow rain = Snow.withValues(0, 0);
        rain.setOneHourSnowLevel(-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenSetInvalidThreeHourLevelValue_thenFail() {
        final Snow rain = Snow.withValues(0, 0);
        rain.setThreeHourSnowLevel(-20);
    }

    @Test
    public void whenCallToString_thenAllIsFine() {
        final Snow snow = Snow.withOneHourLevelValue(33.5);

        Assert.assertNotNull(snow.toString());
        Assert.assertNotEquals("", snow.toString());

        snow.setOneHourSnowLevel(22.2);

        Assert.assertNotNull(snow.toString());
        Assert.assertNotEquals("", snow.toString());

        snow.setThreeHourSnowLevel(33.2);

        Assert.assertNotNull(snow.toString());
        Assert.assertNotEquals("", snow.toString());
    }

    @Test
    public void whenCallHashCode_thenAllIsFine() {
        final Snow first = Snow.withValues(0, 0);
        final Snow second = Snow.withValues(0, 0);

        Assert.assertEquals(first.hashCode(), second.hashCode());

        second.setThreeHourSnowLevel(11.0);

        Assert.assertNotEquals(first.hashCode(), second.hashCode());

        first.setThreeHourSnowLevel(11.0);

        Assert.assertEquals(first.hashCode(), second.hashCode());

        first.setOneHourSnowLevel(333.2);

        Assert.assertNotEquals(first.hashCode(), second.hashCode());

        second.setOneHourSnowLevel(333.2);

        Assert.assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    public void whenCheckEquality_thenAllIsFine() {
        final Snow first = Snow.withValues(0, 0);
        final Snow second = Snow.withValues(0, 0);

        Assert.assertTrue(first.equals(second));
        Assert.assertTrue(first.equals(first));
        Assert.assertFalse(first.equals(new Object()));

        first.setOneHourSnowLevel(0.34);

        Assert.assertFalse(first.equals(second));

        second.setOneHourSnowLevel(0.34);

        Assert.assertTrue(first.equals(second));

        second.setThreeHourSnowLevel(66.7);

        Assert.assertFalse(first.equals(second));

        first.setThreeHourSnowLevel(66.7);

        Assert.assertTrue(first.equals(second));
    }
}