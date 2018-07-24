#pragma version(1)
#pragma rs java_package_name(com.example.xch.renderscripthistogram)

float threshold;

uchar4 __attribute__((kernel)) root(uchar4 in,  uint32_t x, uint32_t y) {

    float4 f4 = rsUnpackColor8888(in);

    // get the grayscale value of all the pixels
  	float Y = 0.2989f * f4.r + 0.5870f * f4.g + 0.1140f * f4.b; // here y muss a Lower case letter, otherwise show error

    // check if it is more than the threshold, if it is, set to white, else make it black
  	//Y = Y > threshold ? 1.0f : 0.0f;

  	if(Y > threshold)
  	{
  	    Y = 1.0f;
  	    //return rsPackColorTo8888(1,1,1,f4.a);
  	}
  	else
  	{
        Y = 0.0f;
        //return rsPackColorTo8888(0, 0, 0,f4.a);
  	}


  	// set the pixel values to the computed value
  	f4.r = f4.g = f4.b = Y;

    return rsPackColorTo8888(f4.r,f4.g,f4.b,f4.a);
}
