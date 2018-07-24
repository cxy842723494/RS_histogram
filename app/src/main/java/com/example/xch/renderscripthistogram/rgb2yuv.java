package com.example.xch.renderscripthistogram;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptC;

public class rgb2yuv {
    public static Bitmap rgb2yuvhandle(Bitmap bitmap, Context context){
        RenderScript renderScript = RenderScript.create(context);
        ScriptC_histEq sketchScript = new ScriptC_histEq(renderScript);

        Allocation in = Allocation.createFromBitmap(renderScript, bitmap);
        Allocation out = Allocation.createTyped(renderScript, in.getType());

        sketchScript.forEach_root(in,out);
        out.copyTo(bitmap);

        renderScript.destroy();
        sketchScript.destroy();
        in.destroy();
        out.destroy();


        return bitmap;
    }




}
