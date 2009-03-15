/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.graphics.cts;

import junit.framework.TestCase;
import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargetClass;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint;

@TestTargetClass(Paint.FontMetricsInt.class)
public class Paint_FontMetricsIntTest extends TestCase {

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test constructor(s) of FontMetricsInt.",
        method = "Paint.FontMetricsInt",
        args = {}
    )
    public void testConstructor() {
        // new the FontMetricsInt instance
    	Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test toString().",
        method = "toString",
        args = {}
    )
    public void testToString() {
        // set the expected value
        int top = 1;
        int ascent = 2;
        int descent = 3;
        int bottom = 4;
        int leading = 5;
        String expected = "FontMetricsInt: top=" + top + " ascent=" + ascent +
                    " descent=" + descent + " bottom=" + bottom +
                    " leading=" + leading;

        FontMetricsInt fontMetricsInt = new FontMetricsInt();
        fontMetricsInt.top = top;
        fontMetricsInt.ascent = ascent;
        fontMetricsInt.descent = descent;
        fontMetricsInt.bottom = bottom;
        fontMetricsInt.leading = leading;

        assertEquals(expected, fontMetricsInt.toString());
    }
}

