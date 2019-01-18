package com.yuan.helper.utils

import android.annotation.SuppressLint
import android.media.MediaCodec
import android.media.MediaCodecInfo
import android.media.MediaFormat
import com.bugtags.library.obfuscated.v
import org.voiddog.ffmpeg.FFmpegNativeBridge
import java.nio.ByteBuffer
/**
 * @author shucheng.qu
 * @date   2018/12/29
 */
object FFmpegUtils {

    init {
//        FFmpegNativeBridge.setDebug(true)
    }

    @SuppressLint("SdCardPath")
    fun zipMp4() {
//        LogUtils.logd("开始压缩视频")
//        val path = "/sdcard/DCIM/aaa.mp4"
//        val path2 = "/sdcard/DCIM/aaaa.mp4"
//        val cmd = "ffmpeg -i $path -c:v libx264 -c:a aac -preset ultrafast -b:v 1500k -b:a 96k -y -r 25 $path2"
//        FFmpegNativeBridge.runCommand(cmd.split(" ").toTypedArray())
//        LogUtils.logd("压缩视频完成")
//        ShellHelper.shell.rm("/mnt/sdcard/DCIM/aaa.mp4")
    }

}

