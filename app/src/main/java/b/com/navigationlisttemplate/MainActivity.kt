package b.com.navigationlisttemplate

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.widget.Toast
import android.widget.ExpandableListView



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        enableExpandableList()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)



    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


       private fun enableExpandableList() {
var listDataHeader = ArrayList<String>()
 var listDataChild = HashMap<String, List<String>>()
var expListView = findViewById<View>(R.id.left_drawer) as ExpandableListView

prepareListData(listDataHeader, listDataChild)
var listAdapter = ExpandListAdapter(this, listDataHeader, listDataChild)
 // setting list adapter
    expListView.setAdapter(listAdapter)

expListView.setOnGroupClickListener(object:ExpandableListView.OnGroupClickListener {

override fun onGroupClick(parent:ExpandableListView, v:View,
groupPosition:Int, id:Long):Boolean {
 // Toast.makeText(getApplicationContext(),
            // "Group Clicked " + listDataHeader.get(groupPosition),
            // Toast.LENGTH_SHORT).show();
            return false
}
})
 // Listview Group expanded listener
    expListView.setOnGroupExpandListener(ExpandableListView.OnGroupExpandListener { groupPosition ->
        Toast.makeText(applicationContext,
                listDataHeader.get(groupPosition) + " Expanded",
                Toast.LENGTH_SHORT).show()
    })

 // Listview Group collasped listener
    expListView.setOnGroupCollapseListener(ExpandableListView.OnGroupCollapseListener { groupPosition ->
        Toast.makeText(applicationContext,
                listDataHeader.get(groupPosition) + " Collapsed",
                Toast.LENGTH_SHORT).show()
    })

 // Listview on child click listener
    expListView.setOnChildClickListener(object:ExpandableListView.OnChildClickListener {

 override fun onChildClick(parent:ExpandableListView, v:View,
groupPosition:Int, childPosition:Int, id:Long):Boolean {
 // TODO Auto-generated method stub
            // Temporary code:

            // till here
            Toast.makeText(
                    applicationContext,
                    listDataHeader.get(groupPosition)
                    + " : "
                    + listDataChild.get(
                    listDataHeader.get(groupPosition))!!.get(
                    childPosition), Toast.LENGTH_SHORT)
.show()
return false
}
})
}


    private fun prepareListData(listDataHeader: MutableList<String>, listDataChild: MutableMap<String, List<String>>) {


        // Adding child data
        listDataHeader.add("Product1")
        listDataHeader.add("product2")
        listDataHeader.add("Product3")

        // Adding child data
        val top = ArrayList<String>()
        top.add("x1")
        top.add("x2")
        top.add("x3")
        top.add("x4")
        top.add("x5")


        val mid = ArrayList<String>()
        mid.add("y1")
        mid.add("y2")
        mid.add("y3")

        val bottom = ArrayList<String>()
        bottom.add("z1")
        bottom.add("z2")
        bottom.add("z3")



        listDataChild.put(listDataHeader[0], top) // Header, Child data
        listDataChild.put(listDataHeader[1], mid)
        listDataChild.put(listDataHeader[2], bottom)
    }

}
