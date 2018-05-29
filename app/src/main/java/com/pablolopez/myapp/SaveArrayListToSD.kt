
import android.content.Context
import android.content.Context.MODE_PRIVATE
import java.io.ObjectOutputStream

fun <String> SaveArrayListToSD(mContext: Context, filename: String, list: ArrayList<String>) {
    try {

        val fos = mContext.openFileOutput("$filename.dat", Context.MODE_PRIVATE)
        val oos = ObjectOutputStream(fos)
        oos.writeObject(list)
        fos.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

}

