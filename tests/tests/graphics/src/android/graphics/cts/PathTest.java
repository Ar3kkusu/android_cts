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
import android.graphics.RectF;
import android.graphics.Matrix;
import dalvik.annotation.ToBeFixed;
import android.graphics.Path;

@TestTargetClass(Path.class)
public class PathTest extends TestCase {

    // Test constants
    private static final float LEFT = 10.0f;
    private static final float RIGHT = 50.0f;
    private static final float TOP = 10.0f;
    private static final float BOTTOM = 50.0f;
    private static final float XCOORD = 40.0f;
    private static final float YCOORD = 40.0f;

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test constructor(s) of Path.",
            method = "Path",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test constructor(s) of Path.",
            method = "Path",
            args = {android.graphics.Path.class}
        )
    })
    public void testConstructor() {

        Path path = null;
        // new the Path instance
        path = new Path();

        path = null;
        // another the Path instance with different params
        path = new Path(new Path());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addRect(RectF rect, Direction dir).",
            method = "addRect",
            args = {android.graphics.RectF.class, android.graphics.Path.Direction.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addRect(RectF rect, Direction dir).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddRect1() {

        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF rect = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        path.addRect(rect, Path.Direction.CW);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addRect(float left, float top, float right, float bottom,Direction dir).",
            method = "addRect",
            args = {float.class, float.class, float.class, float.class, android.graphics.Path.Direction.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addRect(float left, float top, float right, float bottom,Direction dir).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddRect2() {

        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.addRect(LEFT, TOP, RIGHT, BOTTOM, Path.Direction.CW);
        assertFalse(path.isEmpty());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test moveTo(float x, float y). When this method called, thecurrent point will move to the appointed coordinate, but thereis no more way to get known about whether current point is justin that coordinate correctly",
        method = "moveTo",
        args = {float.class, float.class}
    )
    @ToBeFixed(bug = "1451096", explanation = "Test moveTo(float x, float y)." +
            "When this method called, the current point will move to the" +
            "appointed coordinate, but there is no more way to get known" +
            "about whether current point is just in that coordinate correctly")
    public void testMoveTo() {
        // new the Path instance
        Path path = new Path();
        path.moveTo(10.0f, 10.0f);
//        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test set(Path src).",
            method = "set",
            args = {android.graphics.Path.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test set(Path src).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testSet() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        Path path1 = new Path();
        setPath(path1);
        path.set(path1);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test set and get FillType.",
            method = "setFillType",
            args = {android.graphics.Path.FillType.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test set and get FillType.",
            method = "getFillType",
            args = {}
        )
    })
    public void testAccessFillType() {
        // set the expected value
        Path.FillType expected1 = Path.FillType.EVEN_ODD;
        Path.FillType expected2 = Path.FillType.INVERSE_EVEN_ODD;
        Path.FillType expected3 = Path.FillType.INVERSE_WINDING;
        Path.FillType expected4 = Path.FillType.WINDING;

        // new the Path instance
        Path path = new Path();
        // set FillType by {@link Path#setFillType(FillType)}
        path.setFillType(Path.FillType.EVEN_ODD);
        assertEquals(expected1, path.getFillType());
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        assertEquals(expected2, path.getFillType());
        path.setFillType(Path.FillType.INVERSE_WINDING);
        assertEquals(expected3, path.getFillType());
        path.setFillType(Path.FillType.WINDING);
        assertEquals(expected4, path.getFillType());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test rQuadTo(float dx1, float dy1, float dx2, float dy2).",
            method = "rQuadTo",
            args = {float.class, float.class, float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test rQuadTo(float dx1, float dy1, float dx2, float dy2).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testRQuadTo() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.rQuadTo(5.0f, 5.0f, 10.0f, 10.0f);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test transform(Matrix matrix, Path dst).",
            method = "transform",
            args = {android.graphics.Matrix.class, android.graphics.Path.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test transform(Matrix matrix, Path dst).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testTransform1() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        Path dst = new Path();
        setPath(path);
        path.transform(new Matrix(), dst);
        assertFalse(dst.isEmpty());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test transform(Matrix matrix). The function of this method isalmost the same as transform(Matrix matrix, Path dst) but no dstto show if it works when called, and we can't get any informationin this method when called",
        method = "transform",
        args = {android.graphics.Matrix.class}
    )
    @ToBeFixed(bug = "1451096", explanation = "The function of this method is" +
              "almost the same as transform(Matrix matrix, Path dst) but no dst" +
              "to show if it works when called, and we can't get any information" +
              "in this method when called" )
    public void testTransform2() {
        // new the Path instance
//        Path path = new Path();
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test lineTo(float x, float y).",
            method = "lineTo",
            args = {float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test lineTo(float x, float y).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testLineTo() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.lineTo(XCOORD, YCOORD);
        assertFalse(path.isEmpty());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test close(). What does 'close' mean, clear the contour orothers? If clear, why the path is not empty when there is justone path.",
        method = "close",
        args = {}
    )
    @ToBeFixed(bug = "1451096", explanation = "What does 'close' mean, clear the " +
            "contour or others? If clear, why the path is not empty when" +
            "there is just one path.")
    public void testClose() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        setPath(path);
        path.close();
//        assertTrue(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test quadTo(float x1, float y1, float x2, float y2).",
            method = "quadTo",
            args = {float.class, float.class, float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test quadTo(float x1, float y1, float x2, float y2).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testQuadTo() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.quadTo(20.0f, 20.0f, 40.0f, 40.0f);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addCircle(float x, float y, float radius, Direction dir).",
            method = "addCircle",
            args = {float.class, float.class, float.class, android.graphics.Path.Direction.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addCircle(float x, float y, float radius, Direction dir).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddCircle() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.addCircle(XCOORD, YCOORD, 10.0f, Path.Direction.CW);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test arcTo(RectF oval, float startAngle, float sweepAngle,boolean forceMoveTo).",
            method = "arcTo",
            args = {android.graphics.RectF.class, float.class, float.class, boolean.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test arcTo(RectF oval, float startAngle, float sweepAngle,boolean forceMoveTo).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testArcTo1() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF oval = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        path.arcTo(oval, 0.0f, 30.0f, true);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test arcTo(RectF oval, float startAngle, float sweepAngle).",
            method = "arcTo",
            args = {android.graphics.RectF.class, float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test arcTo(RectF oval, float startAngle, float sweepAngle).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testArcTo2() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF oval = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        path.arcTo(oval, 0.0f, 30.0f);
        assertFalse(path.isEmpty());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test computeBounds(RectF bounds, boolean exact).",
        method = "computeBounds",
        args = {android.graphics.RectF.class, boolean.class}
    )
    public void testComputeBounds1() {

        RectF expected = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF bounds = new RectF();
        path.computeBounds(bounds, true);
        assertEquals(expected.width(), bounds.width());
        assertEquals(expected.height(), bounds.height());
        path.computeBounds(bounds, false);
        assertEquals(expected.width(), bounds.width());
        assertEquals(expected.height(), bounds.height());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test computeBounds(RectF bounds, boolean exact).",
            method = "computeBounds",
            args = {android.graphics.RectF.class, boolean.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test computeBounds(RectF bounds, boolean exact).",
            method = "addRect",
            args = {android.graphics.RectF.class, android.graphics.Path.Direction.class}
        )
    })
    public void testComputeBounds2() {

        RectF expected = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF bounds = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        path.addRect(bounds, Path.Direction.CW);
        path.computeBounds(bounds, true);
        assertEquals(expected.width(), bounds.width());
        assertEquals(expected.height(), bounds.height());
        path.computeBounds(bounds, false);
        assertEquals(expected.width(), bounds.width());
        assertEquals(expected.height(), bounds.height());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test rMoveTo(float dx, float dy). When called, the current pointwill move to the appointed coordinate, but there is no more wayto get known about whether current point is just in thatcoordinate correctly",
        method = "rMoveTo",
        args = {float.class, float.class}
    )
    @ToBeFixed(bug = "1451096", explanation = "When this method called, the current" +
            "point will move to the appointed coordinate, but there is no more" +
            "way to get known about whether current point is just in that" +
            "coordinate correctly")
    public void testRMoveTo() {
        // new the Path instance
//        Path path = new Path();
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test setLastPoint(float dx, float dy). When called, we can'tget any useful information to make sure the point has beencorrectly set",
        method = "setLastPoint",
        args = {float.class, float.class}
    )
    @ToBeFixed(bug = "1451096", explanation = "When called, we can't" +
              "get any useful information to make sure the point has been" +
              "correctly set")
    public void testSetLastPoint() {
        // new the Path instance
        Path path = new Path();
        path.setLastPoint(10.0f, 10.0f);
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test rLineTo(float dx, float dy).",
            method = "rLineTo",
            args = {float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test rLineTo(float dx, float dy).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testRLineTo() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.rLineTo(10.0f, 10.0f);
        assertFalse(path.isEmpty());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test isEmpty().",
        method = "isEmpty",
        args = {}
    )
    public void testIsEmpty() {

        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        setPath(path);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test rewind().",
            method = "rewind",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test rewind().",
            method = "isEmpty",
            args = {}
        )
    })
    public void testRewind() {

        // set the expected value
        Path.FillType expected = Path.FillType.EVEN_ODD;

        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        setPath(path);
        path.rewind();
        path.setFillType(Path.FillType.EVEN_ODD);
        assertTrue(path.isEmpty());
        assertEquals(expected, path.getFillType());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test addOval(RectF oval, Direction dir).",
        method = "addOval",
        args = {android.graphics.RectF.class, android.graphics.Path.Direction.class}
    )
    public void testAddOval() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF oval = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        path.addOval(oval, Path.Direction.CW);
        assertFalse(path.isEmpty());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test isRect(RectF rect). But what does 'specify' in the note of this method mean? The return always is false?",
        method = "isRect",
        args = {android.graphics.RectF.class}
    )
    @ToBeFixed(bug = "1451096", explanation = "what does 'specify' in the note of " +
              "this method mean? The return always is false, is it correct?")
    public void testIsRect() {

        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        setPath(path);
        RectF rectBounds = new RectF(20.0f, 20.0f, 30.0f, 30.0f);
//        assertFalse(path.isRect(rectBounds));
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test incReserve(int extraPtCount). Maybe this method has littleobvious behavior to test",
        method = "incReserve",
        args = {int.class}
    )
    @ToBeFixed(bug = "1451096", explanation = "Maybe this method has little" +
              "obvious behavior to test")
    public void testIncReserve() {
        // new the Path instance
//        Path path = new Path();
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addPath(Path src, float dx, float dy).",
            method = "addPath",
            args = {android.graphics.Path.class, float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addPath(Path src, float dx, float dy).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddPath1() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        Path src = new Path();
        setPath(src);
        path.addPath(src, 10.0f, 10.0f);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addPath(Path src).",
            method = "addPath",
            args = {android.graphics.Path.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addPath(Path src).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddPath2() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        Path src = new Path();
        setPath(src);
        path.addPath(src);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addPath(Path src, Matrix matrix).",
            method = "addPath",
            args = {android.graphics.Path.class, android.graphics.Matrix.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addPath(Path src, Matrix matrix).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddPath3() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        Path src = new Path();
        setPath(src);
        Matrix matrix = new Matrix();
        path.addPath(src, matrix);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addRoundRect(RectF rect, float rx, float ry, Direction dir).",
            method = "addRoundRect",
            args = {android.graphics.RectF.class, float.class, float.class, android.graphics.Path.Direction.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addRoundRect(RectF rect, float rx, float ry, Direction dir).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddRoundRect1() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF rect = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        path.addRoundRect(rect, XCOORD, YCOORD, Path.Direction.CW);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addRoundRect(RectF rect, float[] radii, Direction dir).",
            method = "addRoundRect",
            args = {android.graphics.RectF.class, float[].class, android.graphics.Path.Direction.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addRoundRect(RectF rect, float[] radii, Direction dir).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddRoundRect2() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF rect = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        float[] radii = new float[8];
        for (int i = 0; i < 8; i++) {
            radii[i] = 10.0f + i * 5.0f;
        }
        path.addRoundRect(rect, radii, Path.Direction.CW);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test isInverseFillType().",
            method = "isInverseFillType",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test isInverseFillType().",
            method = "setFillType",
            args = {android.graphics.Path.FillType.class}
        )
    })
    public void testIsInverseFillType() {

        // new the Path instance
        Path path = new Path();
        assertFalse(path.isInverseFillType());
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        assertTrue(path.isInverseFillType());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test offset(float dx, float dy, Path dst).",
        method = "offset",
        args = {float.class, float.class, android.graphics.Path.class}
    )
    public void testOffset1() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        setPath(path);
        Path dst = new Path();
        path.offset(XCOORD, YCOORD, dst);
        assertFalse(dst.isEmpty());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test offset(float dx, float dy). The function of this method isalmost the same as offset(float dx, float dy, Path dst) but no dstto show if it works when called, and we can't get any informationin this method when called",
        method = "offset",
        args = {float.class, float.class}
    )
    @ToBeFixed(bug = "1451096", explanation = "The function of this method is" +
              "almost the same as offset(float dx, float dy, Path dst) but no dst" +
              "to show if it works when called, and we can't get any information" +
              "in this method when called")
    public void testOffset2() {
        // new the Path instance
//        Path path = new Path();
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test cubicTo(float x1, float y1, float x2, float y2,float x3, float y3).",
            method = "cubicTo",
            args = {float.class, float.class, float.class, float.class, float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test cubicTo(float x1, float y1, float x2, float y2,float x3, float y3).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testCubicTo() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.cubicTo(10.0f, 10.0f, 20.0f, 20.0f, 30.0f, 30.0f);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test reset().",
            method = "reset",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test reset().",
            method = "addRect",
            args = {android.graphics.RectF.class, android.graphics.Path.Direction.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test reset().",
            method = "set",
            args = {android.graphics.Path.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test reset().",
            method = "isEmpty",
            args = {}
        )
    })
    public void testReset() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        Path path1 = new Path();
        setPath(path1);
        path.set(path1);
        assertFalse(path.isEmpty());
        path.reset();
        assertTrue(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test toggleInverseFillType().",
            method = "toggleInverseFillType",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test toggleInverseFillType().",
            method = "isInverseFillType",
            args = {}
        )
    })
    public void testToggleInverseFillType() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.toggleInverseFillType();
        assertTrue(path.isInverseFillType());
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test finalize().",
        method = "finalize",
        args = {}
    )
    public void testFinalize() {
        try {
            // new the Path instance
            MockPath path = new MockPath();
            path.finalize();
        } catch (Exception e) {
            fail(e.getMessage());
        } catch (Throwable t) {
            fail(t.getMessage());
        }
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addArc(RectF oval, float startAngle, float sweepAngle).",
            method = "addArc",
            args = {android.graphics.RectF.class, float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test addArc(RectF oval, float startAngle, float sweepAngle).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testAddArc() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        RectF oval = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        path.addArc(oval, 0.0f, 30.0f);
        assertFalse(path.isEmpty());
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test rCubicTo(float x1, float y1, float x2, float y2, float x3,float y3).",
            method = "rCubicTo",
            args = {float.class, float.class, float.class, float.class, float.class, float.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test rCubicTo(float x1, float y1, float x2, float y2, float x3,float y3).",
            method = "isEmpty",
            args = {}
        )
    })
    public void testRCubicTo() {
        // new the Path instance
        Path path = new Path();
        assertTrue(path.isEmpty());
        path.rCubicTo(10.0f, 10.0f, 11.0f, 11.0f, 12.0f, 12.0f);
        assertFalse(path.isEmpty());
    }

    private void setPath(Path path) {
        RectF rect = new RectF(LEFT, TOP, RIGHT, BOTTOM);
        path.addRect(rect, Path.Direction.CW);
    }

    /**
     * MockPath to test for finalize
     */
    private class MockPath extends Path {
        public void finalize() throws Throwable{
            super.finalize();
        }
    }
}

