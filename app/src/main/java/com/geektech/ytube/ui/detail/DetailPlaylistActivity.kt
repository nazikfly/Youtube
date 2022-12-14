package com.geektech.ytube.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geektech.ytube.R
import com.geektech.ytube.base.BaseActivity
import com.geektech.ytube.core.utils.Constant
import com.geektech.ytube.databinding.ActivityDetailPlaylistBinding
import com.geektech.ytube.databinding.ActivityPlaylistsBinding

class DetailPlaylistActivity : BaseActivity<ActivityDetailPlaylistBinding>() {



    override fun inflateViewBinding(layoutInflater: LayoutInflater): ActivityDetailPlaylistBinding {
        Toast.makeText(this, intent.getStringExtra(Constant.putId),
            Toast.LENGTH_SHORT).show()
                 return ActivityDetailPlaylistBinding.inflate(layoutInflater)

    }
}



