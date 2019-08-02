package monster.sasakisan.android_fast_adapter_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import monster.sasakisan.android_fast_adapter_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val itemAdapter = ItemAdapter<SampleItem>()

    private val fastAdapter = FastAdapter.with(itemAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val list = mutableListOf<SampleItem>()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = fastAdapter
        }

        for (i in 0..10) {
            list.add(SampleItem("item : $i"))
        }
        itemAdapter.add(list)
    }
}
