package edu.monash.legoar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

class AppUtilities extends Activity {

    /**
     * Get the color from the hotspot image at point x-y.
     *
     */
    public static int getHotspotColor(ImageView img, int x, int y) {
        if (img == null) {
            Log.d("ImageAreasActivity", "Hot spot image not found");
            return 0;
        } else {
            img.setDrawingCacheEnabled(true);
            Drawable imgDrawable = img.getDrawable();
            Bitmap bitmap = ((BitmapDrawable) imgDrawable).getBitmap();
            //Bitmap b = Bitmap.createBitmap(img.getMeasuredWidth(),img.getMeasuredHeight(), Bitmap.Config.ALPHA_8);
            Bitmap resized = Bitmap.createScaledBitmap(bitmap, (int) (img.getMeasuredWidth()), (int) (img.getMeasuredHeight()), true);
//            Canvas canvas = new Canvas(b);
//            img.draw(canvas);
            if (resized == null) {
                Log.d("ImageAreasActivity", "Hot spot bitmap was not created");
                return 0;
            } else {
                img.setDrawingCacheEnabled(false);
                int pixel = resized.getPixel(x, y);
                int redValue = Color.red(pixel);
                int greenValue = Color.green(pixel);
                int blueValue = Color.blue(pixel);
                return resized.getPixel(x, y);
            }
        }
    }

    public static void compareColorNavigation(int touchColor, Context context){
        ColorTool ct = new ColorTool();
        int tolerance = 30;
        if (ct.closeMatch (Color.RED, touchColor, tolerance)){
            startNewActivity(context, productDetails.class);
        }
        else if (ct.closeMatch (Color.rgb(252,169,48), touchColor, tolerance)){
            startNewActivity(context, SaleLists.class);
        }
        else if (ct.closeMatch (Color.BLUE, touchColor, tolerance) || (ct.closeMatch (Color.GREEN, touchColor, tolerance))){
            startNewActivity(context, Catalog.class);
        }
        else if (ct.closeMatch (Color.rgb(211,0,255), touchColor, tolerance) || (ct.closeMatch (Color.GREEN, touchColor, tolerance))){
            startNewActivity(context, ThemeList.class);
        }
        else if (ct.closeMatch (Color.rgb(0,255,255), touchColor, tolerance)){
            startNewActivity(context, Cart.class);
        }
        else if (ct.closeMatch (Color.rgb(27,20,100), touchColor, tolerance)){
            startNewActivity(context, AccountSettings.class);
        }
        else if (ct.closeMatch (Color.rgb(128,128,128), touchColor, tolerance)){
            startNewActivity(context, Contact.class);
        }
        else if (ct.closeMatch (Color.BLACK, touchColor, tolerance) || (ct.closeMatch (Color.rgb(252,238,33), touchColor, tolerance)) ){
            startNewActivity(context, MainActivity.class);
        }
    }

    public static void startNewActivity(Context context, Class newActivity){
        Intent i = new Intent(context, newActivity);
        context.startActivity(i);
    }
}
