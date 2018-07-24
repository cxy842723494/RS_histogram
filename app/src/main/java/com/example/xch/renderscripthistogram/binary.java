package com.example.xch.renderscripthistogram;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;

public class binary {
    public static Bitmap binayhandle (Context context, Bitmap bitmap, float threthold){

        RenderScript renderScript = RenderScript.create(context);
        ScriptC_binary sketchScript = new ScriptC_binary(renderScript);
        Allocation in = Allocation.createFromBitmap(renderScript, bitmap);
        Allocation out = Allocation.createTyped(renderScript, in.getType());


        sketchScript.set_threshold(threthold);
        sketchScript.forEach_root(in,out);
        out.copyTo(bitmap);

        sketchScript.destroy();
        renderScript.destroy();
        in.destroy();
        out.destroy();

        return bitmap;
    }
}
