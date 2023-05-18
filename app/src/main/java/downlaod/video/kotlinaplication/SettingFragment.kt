package downlaod.video.kotlinaplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.jetbrains.annotations.Nullable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingFragment : Fragment() {
    var viewPager: ViewPager? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_setting, container, false)
        var tab_viewpager = v.findViewById<ViewPager>(R.id.tab_viewpager)
        var tab_tablayout = v.findViewById<TabLayout>(R.id.tab_tablayout)
        setupViewPager(tab_viewpager)

        // If we dont use setupWithViewPager() method then
        // tabs are not used or shown when activity opened
        tab_tablayout.setupWithViewPager(tab_viewpager)
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setupViewPager(viewpager: ViewPager) {
        var adapter: ViewPagerAdapter = ViewPagerAdapter(requireActivity().supportFragmentManager)

        // LoginFragment is the name of Fragment and the Login
        // is a title of tab
        adapter.addFragment(GridFragment(), "Grid")
        adapter.addFragment(DetailsFragment(), "Details")

        // setting adapter to view pager.
        viewpager.setAdapter(adapter)
    }
}
class ViewPagerAdapter : FragmentPagerAdapter {

    // objects of arraylist. One is of Fragment type and
    // another one is of String type.*/
    private final var fragmentList1: ArrayList<Fragment> = ArrayList()
    private final var fragmentTitleList1: ArrayList<String> = ArrayList()

    // this is a secondary constructor of ViewPagerAdapter class.
    public constructor(supportFragmentManager: FragmentManager)
            : super(supportFragmentManager)

    // returns which item is selected from arraylist of fragments.
    override fun getItem(position: Int): Fragment {
        return fragmentList1[position]
    }

    // returns which item is selected from arraylist of titles.
    @Nullable
    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList1.get(position)
    }

    // returns the number of items present in arraylist.
    override fun getCount(): Int {
        return fragmentList1.size
    }

    // this function adds the fragment and title in 2 separate  arraylist.
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList1.add(fragment)
        fragmentTitleList1.add(title)
    }
}
