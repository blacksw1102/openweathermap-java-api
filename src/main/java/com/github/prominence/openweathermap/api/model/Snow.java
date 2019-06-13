/*
 * Copyright (c) 2019 Alexey Zinchenko
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

package com.github.prominence.openweathermap.api.model;

import java.util.Objects;

public class Snow {

    private double oneHourSnowLevel;
    private double threeHourSnowLevel;

    public Snow() {
    }

    public Snow(double oneHourSnowLevel, double threeHourSnowLevel) {
        this.oneHourSnowLevel = oneHourSnowLevel;
        this.threeHourSnowLevel = threeHourSnowLevel;
    }

    public double getOneHourSnowLevel() {
        return oneHourSnowLevel;
    }

    public void setOneHourSnowLevel(double oneHourSnowLevel) {
        this.oneHourSnowLevel = oneHourSnowLevel;
    }

    public double getThreeHourSnowLevel() {
        return threeHourSnowLevel;
    }

    public void setThreeHourSnowLevel(double threeHourSnowLevel) {
        this.threeHourSnowLevel = threeHourSnowLevel;
    }

    public String getUnit() {
        return "mm";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Snow)) return false;
        Snow snow = (Snow) o;
        return Double.compare(snow.oneHourSnowLevel, oneHourSnowLevel) == 0 &&
                Double.compare(snow.threeHourSnowLevel, threeHourSnowLevel) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(oneHourSnowLevel, threeHourSnowLevel);
    }

    @Override
    public String toString() {
        return "1 last hour snow level: " + oneHourSnowLevel + ' ' + getUnit() +
                ", 3 last hours snow level: " + threeHourSnowLevel + ' ' + getUnit();
    }
}
