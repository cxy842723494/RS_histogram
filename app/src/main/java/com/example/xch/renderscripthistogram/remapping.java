package com.example.xch.renderscripthistogram;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;

public class remapping {

    public static Bitmap remaphandle(Bitmap bitmap, Context context) {
        RenderScript renderScript = RenderScript.create(context);
        ScriptC_histEq sketchScript = new ScriptC_histEq(renderScript);

        Allocation in = Allocation.createFromBitmap(renderScript, bitmap);
        Allocation out = Allocation.createTyped(renderScript, in.getType());

        sketchScript.forEach_remaptoRGB(in, out);
        out.copyTo(bitmap);

        renderScript.destroy();
        sketchScript.destroy();
        in.destroy();
        out.destroy();

        return bitmap;
    }
}
