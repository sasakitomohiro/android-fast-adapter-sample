package monster.sasakisan.android_fast_adapter_sample

import android.view.View
import androidx.databinding.DataBindingUtil
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import monster.sasakisan.android_fast_adapter_sample.databinding.ItemSampleBinding

open class SampleItem(private val title: String) : AbstractItem<SampleItem.ViewHolder>() {
    override val layoutRes: Int
        get() = R.layout.item_sample

    override val type: Int
        get() = R.id.sample_item_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<SampleItem>(view) {
        private val binding = DataBindingUtil.bind<ItemSampleBinding>(view)

        override fun bindView(item: SampleItem, payloads: MutableList<Any>) {
            binding?.apply {
                textView.text = item.title
            }
        }

        override fun unbindView(item: SampleItem) {
            binding?.apply {
                textView.text = null
            }
        }
    }
}