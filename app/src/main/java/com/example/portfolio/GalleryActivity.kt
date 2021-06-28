package com.example.portfolio


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class GalleryActivity : AppCompatActivity(){


    var modalList = ArrayList<Modal>()

    var names= arrayOf(
    "image1",
    "image2",
    "image3",
    "image4",
    "image5",
    "image6",
    "image7",
    "image8",
    "image9",
    "image10",
    "image11",
    "image12",
    "image13",
    "image14",
    "image15",
    "image16",
    "image17",
    "image18",
    "image19",
    "image20",
    "image21",
    )

    public var images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
        R.drawable.image11,
        R.drawable.image12,
        R.drawable.image13,
        R.drawable.image14,
        R.drawable.image15,
        R.drawable.image16,
        R.drawable.image17,
        R.drawable.image18,
        R.drawable.image19,
        R.drawable.image20,
        R.drawable.image21)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)


        for (i in names.indices) {
            modalList.add(Modal(names[i], images[i]))
        }

        var customAdapter = CustomAdapter(modalList, this);
        val gridView: GridView = findViewById(R.id.gridView)
        gridView.adapter = customAdapter;

        gridView.setOnItemClickListener {adapterView, view, i, l ->
            var intent = Intent( this,ViewActivity::class.java)
            intent.putExtra( "data",modalList[i])
            startActivity(intent)
        }

    }

    class CustomAdapter(
        var itemModel:ArrayList<Modal>,
        var context: Context
    ) : BaseAdapter() {

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getView(position: Int,view: View?, viewGroup: ViewGroup?): View {
            var view =view;
            if (view == null) {
                view = layoutInflater.inflate(R.layout.row_items,viewGroup, false)
            }

            var tvImageName = view?.findViewById<TextView>(R.id.imageName)
            var imageView = view?.findViewById<ImageView>(R.id.imageView);

            tvImageName?.text = itemModel[position].name;
            imageView?.setImageResource(itemModel[position].image!!)

            return view!!;

        }

        override fun getItem(p0: Int): Any {
            return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }


        override fun getCount(): Int {
            return itemModel.size

        }

    }
}

