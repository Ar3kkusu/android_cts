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

package android.graphics.drawable.cts;

import com.android.cts.stub.R;

import dalvik.annotation.TestTargets;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetClass;
import dalvik.annotation.ToBeFixed;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.graphics.drawable.Drawable.Callback;
import android.test.InstrumentationTestCase;

@TestTargetClass(TransitionDrawable.class)
public class TransitionDrawableTest extends InstrumentationTestCase {
    private static final int COLOR1 = 0xff0000ff;

    private static final int COLOR0 = 0xffff0000;

    private static final int CANVAS_WIDTH = 10;

    private static final int CANVAS_HEIGHT = 10;

    private TransitionDrawable mTransitionDrawable;

    private Bitmap mBitmap;

    private Canvas mCanvas;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mTransitionDrawable = (TransitionDrawable) getInstrumentation().getTargetContext()
                .getResources().getDrawable(R.drawable.transition_test);
        mTransitionDrawable.setBounds(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        mBitmap = Bitmap.createBitmap(CANVAS_WIDTH, CANVAS_HEIGHT, Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test {@link TransitionDrawable#startTransition(int)}.",
            method = "startTransition",
            args = {int.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test {@link TransitionDrawable#startTransition(int)}.",
            method = "draw",
            args = {android.graphics.Canvas.class}
        )
    })
    @ToBeFixed(explanation = "The method should not accept negative duration.")
    public void testStartTransition() {
        MockCallBack cb = new MockCallBack();
        mTransitionDrawable.setCallback(cb);

        // start when there is no transition
        cb.reset();
        mTransitionDrawable.startTransition(2000);
        assertTrue(cb.hasCalledInvalidateDrawable());
        assertTransition(COLOR0, COLOR1, 2000);

        // start when there is a transition in progress
        makeTransitionInProgress(2000, 1000);
        cb.reset();
        mTransitionDrawable.startTransition(2000);
        assertTrue(cb.hasCalledInvalidateDrawable());
        assertTransition(COLOR0, COLOR1, 2000);

        // start when there is a reverse transition in progress
        makeReverseTransitionInProgress(2000, 1000);
        cb.reset();
        mTransitionDrawable.startTransition(2000);
        assertTrue(cb.hasCalledInvalidateDrawable());
        assertTransition(COLOR0, COLOR1, 2000);

        // should not accept negative duration
        mTransitionDrawable.startTransition(-1);
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test {@link TransitionDrawable#resetTransition()}.",
            method = "resetTransition",
            args = {}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test {@link TransitionDrawable#resetTransition()}.",
            method = "draw",
            args = {android.graphics.Canvas.class}
        )
    })
    public void testResetTransition() {
        MockCallBack cb = new MockCallBack();
        mTransitionDrawable.setCallback(cb);

        // reset when there is no transition
        cb.reset();
        mTransitionDrawable.resetTransition();
        assertTrue(cb.hasCalledInvalidateDrawable());

        // reset when there is a transition in progress
        makeTransitionInProgress(2000, 1000);
        cb.reset();
        mTransitionDrawable.resetTransition();
        assertTrue(cb.hasCalledInvalidateDrawable());
        assertTransitionStart(COLOR0);
        assertTransitionEnd(COLOR0, 2000);

        // reset when there is a reverse transition in progress
        makeReverseTransitionInProgress(2000, 1000);
        cb.reset();
        mTransitionDrawable.resetTransition();
        assertTrue(cb.hasCalledInvalidateDrawable());
        assertTransitionStart(COLOR0);
        assertTransitionEnd(COLOR0, 2000);
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test {@link TransitionDrawable#reverseTransition()}.",
            method = "reverseTransition",
            args = {int.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test {@link TransitionDrawable#reverseTransition()}.",
            method = "draw",
            args = {android.graphics.Canvas.class}
        )
    })
    @ToBeFixed(explanation = "The method should not accept negative duration.")
    public void testReverseTransition() {
        MockCallBack cb = new MockCallBack();
        mTransitionDrawable.setCallback(cb);

        // reverse when there is no transition
        cb.reset();
        mTransitionDrawable.reverseTransition(2000);
        assertTrue(cb.hasCalledInvalidateDrawable());
        assertTransition(COLOR0, COLOR1, 2000);

        // reverse after the other transition ends
        cb.reset();
        mTransitionDrawable.reverseTransition(2000);
        assertTrue(cb.hasCalledInvalidateDrawable());
        assertTransition(COLOR1, COLOR0, 2000);

        // reverse when there is a transition in progress
        makeTransitionInProgress(2000, 1000);
        cb.reset();
        mTransitionDrawable.reverseTransition(20000);
        assertFalse(cb.hasCalledInvalidateDrawable());
        int colorFrom = mBitmap.getPixel(0, 0);
        assertTransition(colorFrom, COLOR0, 1500);

        // reverse when there is a reverse transition in progress
        makeReverseTransitionInProgress(2000, 1000);
        cb.reset();
        mTransitionDrawable.reverseTransition(20000);
        assertFalse(cb.hasCalledInvalidateDrawable());
        colorFrom = mBitmap.getPixel(0, 0);
        assertTransition(colorFrom, COLOR1, 1500);

        // should not accept negative duration
        mTransitionDrawable.reverseTransition(-1);
    }

    @TestTargetNew(
        level = TestLevel.TODO,
        notes = "Test {@link TransitionDrawable#draw(Canvas)}.Test the method with null canvas. This method is tested in directly with real canvas in other tests of this case.",
        method = "draw",
        args = {android.graphics.Canvas.class}
    )
    @ToBeFixed(bug = "1417734", explanation = "should add @throws clause into javadoc of "
            + "TransitionDrawable#draw(Canvas) when param canvas is null")
    public void testDrawWithNUllCanvas() {
        try {
            mTransitionDrawable.draw(null);
            fail("The method should check whether the canvas is null.");
        } catch (NullPointerException e) {
        }
    }

    @TestTargets({
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test {@link TransitionDrawable#setCrossFadeEnabled(boolean)} and {@link TransitionDrawable#isCrossFadeEnabled()}. This boolean takes effect when the drawable is drawn and the effect can not be tested.",
            method = "setCrossFadeEnabled",
            args = {boolean.class}
        ),
        @TestTargetNew(
            level = TestLevel.TODO,
            notes = "Test {@link TransitionDrawable#setCrossFadeEnabled(boolean)} and {@link TransitionDrawable#isCrossFadeEnabled()}. This boolean takes effect when the drawable is drawn and the effect can not be tested.",
            method = "isCrossFadeEnabled",
            args = {}
        )
    })
    public void testAccessCrossFadeEnabled() {
        assertFalse(mTransitionDrawable.isCrossFadeEnabled());

        mTransitionDrawable.setCrossFadeEnabled(true);
        assertTrue(mTransitionDrawable.isCrossFadeEnabled());

        mTransitionDrawable.setCrossFadeEnabled(false);
        assertFalse(mTransitionDrawable.isCrossFadeEnabled());
    }

    private void assertTransition(int colorFrom, int colorTo, long delay) {
        assertTransitionStart(colorFrom);
        assertTransitionInProgress(colorFrom, colorTo, delay / 2);
        assertTransitionEnd(colorTo, delay);
    }

    private void assertTransitionStart(int colorFrom) {
        mBitmap.eraseColor(0x00000000);
        mTransitionDrawable.draw(mCanvas);
        assertColorFillRect(mBitmap, 0, 0, CANVAS_WIDTH, CANVAS_HEIGHT, colorFrom);
    }

    private void assertTransitionInProgress(int colorFrom, int colorTo, long delay) {
        waitUntilDrawFinish(delay);
        assertColorNotFillRect(mBitmap, 0, 0, CANVAS_WIDTH, CANVAS_HEIGHT, colorFrom);
        assertColorNotFillRect(mBitmap, 0, 0, CANVAS_WIDTH, CANVAS_HEIGHT, colorTo);
    }

    private void assertTransitionEnd(int colorTo, long delay) {
        waitUntilDrawFinish(delay);
        assertColorFillRect(mBitmap, 0, 0, CANVAS_WIDTH, CANVAS_HEIGHT, colorTo);
    }

    private void assertColorFillRect(Bitmap bmp, int x, int y, int w, int h, int color) {
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + h; j++) {
                assertEquals(color, bmp.getPixel(i, j));
            }
        }
    }

    private void assertColorNotFillRect(Bitmap bmp, int x, int y, int w, int h, int color) {
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + h; j++) {
                assertTrue(color != bmp.getPixel(i, j));
            }
        }
    }

    private void makeReverseTransitionInProgress(int duration, int delay) {
        mTransitionDrawable.resetTransition();
        mTransitionDrawable.startTransition(100);
        assertTransition(COLOR0, COLOR1, 100);
        mTransitionDrawable.reverseTransition(duration);
        assertTransitionStart(COLOR1);
        assertTransitionInProgress(COLOR1, COLOR0, delay);
    }

    private void makeTransitionInProgress(int duration, int delay) {
        mTransitionDrawable.resetTransition();
        mTransitionDrawable.startTransition(duration);
        assertTransitionStart(COLOR0);
        assertTransitionInProgress(COLOR0, COLOR1, delay);
    }

    private void waitUntilDrawFinish(long delay) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                mBitmap.eraseColor(0x00000000);
                mTransitionDrawable.draw(mCanvas);
            }
        });
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }

    private class MockCallBack implements Callback {
        private boolean mHasCalledInvalidateDrawable;

        public boolean hasCalledInvalidateDrawable() {
            return mHasCalledInvalidateDrawable;
        }
        public void reset() {
            mHasCalledInvalidateDrawable = false;
        }

        public void invalidateDrawable(Drawable who) {
            mHasCalledInvalidateDrawable = true;
        }

        public void scheduleDrawable(Drawable who, Runnable what, long when) {
        }

        public void unscheduleDrawable(Drawable who, Runnable what) {
        }
    }
}
