package com.wr.comic.adapter

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.app.common.adapter.util.ItemViewDelegate
import com.app.common.adapter.util.ViewHolder
import com.wr.comic.R
import com.wr.comic.bean.ComicBean
import com.wr.comic.bean.ComicBoyRankBean
import com.wr.comic.bean.ComicGrilRankBean
import com.wr.comic.constant.KeyConst

class MainComicSmallDelegate : ItemViewDelegate<ComicBean> {
    override fun getItemViewLayoutId(): Int {
        return R.layout.item_main_comic_small
    }

    override fun convert(holder: ViewHolder?, t: ComicBean?, position: Int, payloads: List<Any>?) {
        if (payloads != null) {
            val payload = payloads[0] as Bundle
            for (key in payload.keySet()) {
                when (key) {
                    KeyConst.MainComic.TITLE -> holder?.setText(R.id.iv_img_small_title, t?.title)
                    KeyConst.MainComic.COVER -> holder?.setImageLoad(R.id.iv_img_small_cover, t?.cover)
                    KeyConst.MainComic.DESC -> t?.describe?.let {
                        var tvDesc = holder?.getView<TextView>(R.id.iv_img_small_desc)
                        tvDesc?.visibility = View.VISIBLE
                        tvDesc?.text = t.describe
                    }
                }
            }
        } else {
            t?.let {
                holder?.let {
                    holder.setText(R.id.iv_img_small_title, t.title)
                    holder.setImageLoad(R.id.iv_img_small_cover, t.cover)
                    if (t.describe.isNotEmpty()) {
                        var tvDesc = holder.getView<TextView>(R.id.iv_img_small_desc)
                        tvDesc.visibility = View.VISIBLE
                        tvDesc.text = t.describe
                    }
                }
            }
        }
    }

    override fun isForViewType(item: ComicBean?, position: Int): Boolean {
        return item is ComicBoyRankBean || item is ComicGrilRankBean
    }

}