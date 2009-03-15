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

import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.test.AndroidTestCase;
import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargetClass;

@TestTargetClass(BlurMaskFilter.Blur.class)
public class BlurMaskFilter_BlurTest extends AndroidTestCase{

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "test method: valueOf",
        method = "valueOf",
        args = {java.lang.String.class}
    )
    public void testValueOf(){
        assertEquals(Blur.NORMAL, Blur.valueOf("NORMAL"));
        assertEquals(Blur.SOLID, Blur.valueOf("SOLID"));
        assertEquals(Blur.OUTER, Blur.valueOf("OUTER"));
        assertEquals(Blur.INNER, Blur.valueOf("INNER"));
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "test method: values and tests for the behavior of the methods where this enumeration is used as an argument",
            method = "values",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "test method: values and tests for the behavior of the methods where this enumeration is used as an argument",
            method = "BlurMaskFilter",
            args = {float.class, android.graphics.BlurMaskFilter.Blur.class}
        )
    })
    public void testValues(){
        Blur[] bulr = Blur.values();

        assertEquals(4, bulr.length);
        assertEquals(Blur.NORMAL, bulr[0]);
        assertEquals(Blur.SOLID, bulr[1]);
        assertEquals(Blur.OUTER, bulr[2]);
        assertEquals(Blur.INNER, bulr[3]);

        //Blur is used as a argument here for all the methods that use it
        assertNotNull(new BlurMaskFilter(10.24f, Blur.INNER));
        assertNotNull(new BlurMaskFilter(10.24f, Blur.NORMAL));
        assertNotNull(new BlurMaskFilter(10.24f, Blur.OUTER));
        assertNotNull(new BlurMaskFilter(10.24f, Blur.SOLID));
    }
}
